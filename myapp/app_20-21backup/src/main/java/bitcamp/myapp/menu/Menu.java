package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

public interface Menu {

  void execute(Prompt prompt);

  String getTitle();

  //MenuItem 이 메뉴 인터페이스에 따라 정보를 받는다.
}
