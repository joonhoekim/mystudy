package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;
import java.util.Date;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardAddHandler extends AbstractMenuHandler {

  //private Prompt prompt;
  private ArrayList<Board> objectRepository;

  public BoardAddHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override //재정의하니까, 슈퍼클래스에서 만든 프린트메뉴하는 부분이 없어짐. 그래서 슈퍼클래스의 코드는 유지하돼 기능을 추가하는 방법이, 슈퍼클래스의 메서드를
  protected void action() {
    //super.action(menu); 매번 이래하기 힘들다! 까먹기도 쉽다!
    Board board = new Board();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    //board.setCreatedDate(this.prompt.input("작성일? "));
    board.setCreatedDate(new Date());

    objectRepository.add(board);
  }
}
