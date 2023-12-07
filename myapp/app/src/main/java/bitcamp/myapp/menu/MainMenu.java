package bitcamp.myapp.menu;

import static bitcamp.util.AnsiEscape.ANSI_BOLD_RED;
import static bitcamp.util.AnsiEscape.ANSI_CLEAR;
import static bitcamp.util.AnsiEscape.ANSI_RED;

import bitcamp.util.Prompt;

public class MainMenu {

  static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 가입인사",
      "4. 회원",
      "5. 도움말",
      ANSI_RED + "0. 종료" + ANSI_CLEAR
  };
  Prompt prompt;

  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  void printMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  public void execute() {
    printMenu();

    BoardMenu boardMenu = new BoardMenu("게시글", prompt);
    BoardMenu greetingBoardMenu = new BoardMenu("가입인사", prompt);
    AssignmentMenu assignmentMenu = new AssignmentMenu("과제-일반", prompt);
    MemberMenu memberMenu = new MemberMenu("회원-일반", prompt);

    while (true) {
      String input = prompt.input("메인> ");

      switch (input) {
        case "1":
          assignmentMenu.execute();
          break;
        case "2":
          boardMenu.execute();
          break;
        case "3":
          greetingBoardMenu.execute();
          break;
        case "4":
          memberMenu.execute();
          break;
        case "5":
          System.out.println("도움말입니다.");
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
