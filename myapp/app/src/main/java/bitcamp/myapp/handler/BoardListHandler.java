package bitcamp.myapp.handler;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;

public class BoardListHandler implements MenuHandler {

  //  Prompt prompt;
  BoardRepository boardRepository;

  public BoardListHandler(BoardRepository boardRepository) {
    //this.prompt = prompt;
    this.boardRepository = boardRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 목록:", menu.getTitle());

    System.out.printf("%-20s | %10s | %15s\n", "TITLE", "WRITER", "DATE");
    for (Board board : this.boardRepository.boards) {
      System.out.printf("%-20s | %10s | %15s\n", board.title, board.writer, board.createdDate);
    }
  }
}
