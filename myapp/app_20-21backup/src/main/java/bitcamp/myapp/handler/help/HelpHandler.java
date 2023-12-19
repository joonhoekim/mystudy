package bitcamp.myapp.handler.help;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;

public class HelpHandler implements MenuHandler {

  @Override
  public void action(Menu menu) {
    System.out.println("도움말입니다.");
  }
}
