package bitcamp.menu;

import bitcamp.util.LinkedList;
import bitcamp.util.Prompt;

// Composite 패턴에서 '복합 객체(composite object)' 역할을 하는 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup extends AbstractMenu {

  private LinkedList<Menu> menus = new LinkedList<>();
  private int menuSize;

  public MenuGroup(String title) {
    super(title);
  }

  @Override // 인터페이스나 수퍼 클래스의 메서드를 정의하겠다고 컴파일러에게 알린다.
  public void execute(Prompt prompt) {
    this.printMenu();

    while (true) {
      String input = prompt.input("%s> ", this.getTitle());

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      int menuNo = 0;
      try {
        menuNo = Integer.parseInt(input);
        if (menuNo < 1 || menuNo > this.menuSize) {
          System.out.println("메뉴 번호가 옳지 않습니다.");
          continue;
        }
      } catch (NumberFormatException e) {
        //throw new RuntimeException(e);
        System.out.println("오류: " + e);
      }

      this.menus[menuNo - 1].execute(prompt);
    }
  }

  private void printMenu() {
    System.out.printf("[%s]\n", this.getTitle());

    for (int i = 0; i < this.menuSize; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
    }

    System.out.printf("0. %s\n", "이전");
  }

  public void add(Menu menu) {
    this.menus.add(menu);
  }

  public void remove(Menu menu) {
    this.menus.remove(menu.);
  }

}
