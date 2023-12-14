package bitcamp.myapp.handler.board;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardAddHandler implements MenuHandler {

  BoardRepository boardRepository;
  Prompt prompt;

  public BoardAddHandler(BoardRepository boardRepository, Prompt prompt) {
    this.boardRepository = boardRepository;
    this.prompt = prompt;
  }

  public void action(Menu menu) {
    //Define BoardAddHandle's action()
    System.out.printf("[%s]:",
        menu.getTitle()); //getTitle()은 인터페이스에서 약속되어 있고, menuItem 클래스에서 구현되어 있다.

    if (this.boardRepository.length == this.boardRepository.boards.length) {
      //리파지토리 객체 내 변수(int length), 객체 내 배열의 길이를 비교해서 배열 공간 다 찼는지 확인한다.
      //만약 같다면 배열 길이를 50% 증가시킨 새 배열 만들어서 값을 복사해두고, 그 레퍼런스가 가진 주소를 받는다.
      int oldSize = this.boardRepository.boards.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      System.arraycopy(this.boardRepository.boards, 0, arr, 0, oldSize);

      this.boardRepository.boards = arr;
    }

    Board board = new Board();
    board.title = this.prompt.input("제목? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");

    this.boardRepository.boards[this.boardRepository.length++] = board;
  }


}
