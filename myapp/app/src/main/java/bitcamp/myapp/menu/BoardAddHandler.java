package bitcamp.myapp.menu;

//게시글의 등록 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 메뉴 핸들러 규칙에 따라 클래스를 작성해야 한다.

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;


public class BoardAddHandler implements MenuHandler {


  String title;

  BoardRepository boardRepository;
  Board[] boards = boardRepository.boards;
  int length = 0;
  Prompt prompt;

  public BoardAddHandler(BoardRepository boardRepository, Prompt prompt) {
    this.boardRepository = boardRepository;
    this.prompt = prompt;
  }

  public BoardAddHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void action() {
    System.out.println("게시글 등록:");

    if (this.length == this.boards.length) {
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }

      this.boards = arr;
    }

    Board board = new Board();
    board.title = this.prompt.input("제목? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");

    this.boards[this.length++] = board;


  }
}
