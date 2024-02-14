package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardModifyHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");

      Board oldBoard = boardDao.findBy(no);
      if (oldBoard == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      }

      Board board = new Board();
      board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
      board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
      board.setCreatedDate(oldBoard.getCreatedDate());

      while (true) {
        //매번 사용자에게 현재 첨부파일 목록을 알려준다.
        List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
        printAttachedFiles(prompt, no, files);

        //첨부파일 삭제
        String input = prompt.input("[선택사항] 첨부파일 삭제(번호입력): ", no);

        //유효성검사1. 숫자가 아니거나 빈 문자열을 받은 경우: 나간다.
        if (!input.chars().allMatch(Character::isDigit)) {
          break;
        } else if (input.isEmpty()) {
          break;
        }
        // 유효성검사2. 현재 게시글의 첨부파일 번호가 아닌 경우: 알려주고 나간다.
        int targetNo = Integer.parseInt(input);
        boolean isIn = false;
        for (AttachedFile file : files) {
          if (targetNo == file.getNo()) {
            isIn = true;
            break;
          }
        }
        if (!isIn) {
          prompt.printf("<작업중단> [%d]은 유효한 첨부파일 번호가 아닙니다.\n", targetNo);
          break;
        }

        //문제없는 경우 삭제함
        attachedFileDao.delete(targetNo);
      }

      while (true) {
        //매번 사용자에게 현재 첨부파일 목록을 알려준다.
        List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
        printAttachedFiles(prompt, no, files);

        //파일 경로를 입력받는다.
        String filePath = prompt.input("[선택사항] 첨부파일 추가(파일경로): ", no);
        if (filePath.isEmpty()) {
          break;
        }

        //첨부파일을 DAO를 이용해 추가한다.
        AttachedFile file = new AttachedFile();
        file.filePath(filePath);
        file.setBoardNo(board.getNo());
        attachedFileDao.add(file);
      }

      //마지막에 게시물을 수정한다.
      boardDao.update(board);

      //트랜잭션이 종료된다.
      prompt.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      prompt.println("변경 오류!");
    }
  }

  private void printAttachedFiles(Prompt prompt, int no, List<AttachedFile> files) {
    prompt.println("-------------------------------");
    prompt.println(" 첨부파일 번호 | 첨부파일 이름 ");
    prompt.println("-------------------------------");
    for (AttachedFile file : files) {
      prompt.printf("%13s  |  %s\n", file.getNo(), file.getFilePath());
    }
    prompt.println("-------------------------------");
  }
}
