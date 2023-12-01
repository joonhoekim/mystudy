package bitcamp.myapp;

import java.util.Scanner;

public class AssignmentMenu {

  static void onAssignment(String title, Scanner keyIn) {

    final String[] MENUS_MAIN_ASSIGNMENT = {
        "[과제]",
        "1. 등록",
        "2. 조회",
        "3. 변경",
        "4. 삭제",
        "0. 이전",
    };

    PrintMenu.printMenu(MENUS_MAIN_ASSIGNMENT);
    while (true) {
      String input = App.prompt("메인/과제", keyIn);
      switch (input) {
        case "1":
          System.out.println("1.등록");
          break;
        case "2":
          System.out.println("2.조회");
          break;
        case "3":
          System.out.println("3.변경");
          break;
        case "4":
          System.out.println("4.삭제");
          break;
        case "0":
          return;
        case "menu":
          // 코드를 기능 단위로 묶어 메서드로 정의하면
          // 메서드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋다.
          PrintMenu.printMenu(MENUS_MAIN_ASSIGNMENT);
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }

    }

  }
}
