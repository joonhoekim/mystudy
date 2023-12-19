package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class BoardDeleteHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;

  public BoardDeleteHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    //이제 추상클래스로 아래 공통 코드의 중복을 해소했음.
    //System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    //    super.action(menu);
    //근데 이것도 문제 생기기 쉽다! 그래서 추상 클래스에서 오버로딩을 이용한다.

    int index = this.prompt.inputInt("번호? ");
    if (this.objectRepository.remove(index) == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    }
  }
}
