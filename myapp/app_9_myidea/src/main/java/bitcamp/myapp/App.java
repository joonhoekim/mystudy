package bitcamp.myapp;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    PrintMenu.printMenu(MainMenu.MENUS_MAIN);

    loop:
    while (true) {
      String input = prompt("메인", keyIn);

      switch (input) {
        case "1":
          AssignmentMenu.onAssignment("메뉴 > 과제 ", keyIn);
          break;
        case "2":
          BoardMenu.onBoard("메뉴 > 게시판 ", keyIn);
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          // 코드를 기능 단위로 묶어 메서드로 정의하면
          // 메서드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋다.
          PrintMenu.printMenu(MainMenu.MENUS_MAIN);
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }

    keyIn.close();
  }


  static String prompt(String title, Scanner keyIn) {
    System.out.printf("%s > ", title);
    return keyIn.nextLine();
  }

}
