package bitcamp.myapp.handler.board;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardModifyHandler implements MenuHandler {

  private Prompt prompt;
  private BoardRepository boardRepository;

  public BoardModifyHandler(Prompt prompt, BoardRepository boardRepository) {
    this.prompt = prompt;
    this.boardRepository = boardRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 수정:", menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.boardRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    //이 코드는 변수 이름 바뀌면 수정을 많이 해야한다. 별로다.
//    Board oldBoard = this.boardRepository.boards[index];
//    boardRepository.boards[index].title = this.prompt.input("수정할 제목: (%s)", oldBoard.title);
//    boardRepository.boards[index].title = this.prompt.input("수정할 내용: (%s)", oldBoard.content);
//    boardRepository.boards[index].title = this.prompt.input("수정할 작성자: (%s)", oldBoard.writer);
//    boardRepository.boards[index].title = this.prompt.input("수정할 작성일: (%s)", oldBoard.createdDate);

    //코드 흐름을 완전히 이해했다면 이렇게 짜는게 낫다!! board 라는 변수 하나로 해결하게 된다.
    Board board = this.boardRepository.boards[index]; //레퍼런스가 같은 주소를 공유한다.
    board.title = prompt.input("제목 뭘로 바꿀까요? (이전:%s)", board.title); //input에서 이전 값을 보여주고 거기에 덮어쓴다.
    board.content = prompt.input("내용 뭘로 바꿀까요? (이전:%s)", board.content);
    board.writer = prompt.input("작성자 누구로 바꿀까요? (이전:%s)", board.writer);
    board.createdDate = prompt.input("작성일 언제로 바꿀까요? (이전:%s)", board.createdDate);

  }
}
