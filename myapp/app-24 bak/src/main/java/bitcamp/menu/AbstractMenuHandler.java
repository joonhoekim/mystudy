package bitcamp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler {

  protected Prompt prompt;
  protected Menu menu;

  protected AbstractMenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    this.printMenuTitle(menu.getTitle());
    //서브클래스에서 menu 객체를 필요로 할 수 있으므로 보관한다.
    this.menu = menu;

    this.action();
  }

  private void printMenuTitle(String title) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);

  }

  //서브 클래스가 구현해야 할 메서드!
  //슈퍼클래스의 action(Menu)를 통해 호출되는 메서드이다. 직접적으로 호출되지 않는다.
  //그래서 접근범위를 제한할 것이다. 추상 메서드는 일단 상속은 되어야 하니까, protected 쓰자.
  //문서들을 보면 protected 접근제어자를 쓰는 추상클래스들을 쉽게 찾아볼 수 있을 것이다.
  protected abstract void action();

  //메서드와 추상 메서드가 오버로딩 되어 있다!
  //오버로딩 안해도, 슈퍼클래스의 코드가 먼저 실행되도록 작성 가능하지만
  //오버로딩을 통해서 통일성을 부여할 수 있다.


}
