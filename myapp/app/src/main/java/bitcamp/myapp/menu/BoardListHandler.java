package bitcamp.myapp.menu;

//게시글의 등록 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 메뉴 핸들러 규칙에 따라 클래스를 작성해야 한다.

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardListHandler implements MenuHandler {

  BoardRepository boardRepository;
  Prompt prompt;

  public BoardListHandler(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  public void action() {
    System.out.println("게시글 목록:");
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < boardRepository.length; i++) {
      Board board = boardRepository.boards[i];
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }

  }
}
