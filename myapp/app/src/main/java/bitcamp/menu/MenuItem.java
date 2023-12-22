package bitcamp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 leaf 역할을 수행하는 클래스
// Leaf?
// - 하위 항목을 포함하지 않는 말단 객체
// - 예를들어 파일시스템에서 '파일'에 해당한다.
//
public class MenuItem extends AbstractMenu {

  private MenuHandler menuHandler;

  public MenuItem(String title) {
    super(title);
  }

  public MenuItem(String title, MenuHandler menuHandler) {
    this(title);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {

    //여기다가 트라이 캐치 처리하세요!! 그럼 중복 안돼잖아!!
    //이 객체지향이 너무나도 아릅답다!!!!!!!!!
    //나는 요거밖에 안배워봤는데 왤케 멋있냐?

    try {
      if (this.menuHandler != null) {
        this.menuHandler.action(this);
      }
    } catch (Exception e) {
      System.out.println("예외가 발생했음: " + e);
    }
  }
}
