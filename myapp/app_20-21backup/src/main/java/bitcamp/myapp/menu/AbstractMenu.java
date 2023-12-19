package bitcamp.myapp.menu;

public abstract class AbstractMenu implements Menu {


  private String title;

  public AbstractMenu(String title) {
    this.title = title;
  }

  // 서브에서 구현하세요.
//  @Override
//  public void execute(Prompt prompt) {
//
//  }

  @Override
  public String getTitle() {
    return null;
  }
}
