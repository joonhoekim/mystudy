package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Iterator;
import bitcamp.util.List;
import bitcamp.util.Prompt;

// 게시글의 '목록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardListHandler extends AbstractMenuHandler {

  private List<Board> objectRepository;

  public BoardListHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    Iterator<Board> iterator = this.objectRepository.iterator();
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    while (iterator.hasNext()) {
      Board board = iterator.next();
      System.out.printf("%-20s\t%10s\t%3$tY-%3$tm-%3$td\n",
          board.getTitle(),
          board.getWriter(),
          board.getCreatedDate());
    }

//    Iterator Pattern 적용 전
//    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");
//
//    Board[] boards = this.objectRepository.toArray(new Board[0]);
//
//    for (Board board : boards) {
//      System.out.printf("%-20s\t%10s\t%3$tY-%3$tm-%3$td\n",
//          board.getTitle(),
//          board.getWriter(),
//          board.getCreatedDate());
//    }
  }
}