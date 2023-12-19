package bitcamp.myapp.handler.board;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;

public class BoardListHandler implements MenuHandler {

  //  Prompt prompt;
  private BoardRepository boardRepository;

  public BoardListHandler(BoardRepository boardRepository) {
    //this.prompt = prompt;
    this.boardRepository = boardRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s:\n", menu.getTitle());
    System.out.printf("%-20s | %10s | %15s\n", "TITLE", "WRITER", "DATE");
//    for (Board board : this.boardRepository.boards) {
//      System.out.printf("%-20s | %10s | %15s\n", board.title, board.writer, board.createdDate);
//    }
    // 여기서 Enhanced for Loop 못 쓴다!! Enhanced for Loop은 배열 전체를 다 돈다!!
    // 내용 채워넣지 않은 부분이 있는 배열은 어디까지 돌지를 수동 설정하여 반복문 돌려야 한다!!
    for (int i = 0; i < this.boardRepository.length; i++) {
      Board board = this.boardRepository.boards[i];
      System.out.printf("%-20s | %10s | %15s\n", board.title, board.writer, board.createdDate);
    }
  }
}
