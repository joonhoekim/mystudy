package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardViewHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;

  public BoardViewHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    //System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    //super.action(menu);
    //위 문장은, 슈퍼클래스의 기능을 유지한 채로 (앞에서 수행한 다음에) 밑에 기능을 추가한다는 의미
    //근데, 이 조차도 중복됨...!! 매번 super.action(menu);를 적어야 함.
    //깜빡했을 때, 그리고 수정할 때 모든 코드를 수정해야 하는 문제가 발생한다!

    int index = this.prompt.inputInt("번호? ");
    Board board = this.objectRepository.get(index);
    if (board == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("작성일: %tY-%1$tm-%1$td\n",
        board.getCreatedDate()
    );
  }
}
