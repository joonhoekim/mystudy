package bitcamp.myapp;

import java.io.InputStream;
import java.util.Scanner;

public class App {

  //java.util.Scanner inSt = new Scanner(System.in);


  public static void main(String[] args) {
    InputStream in = System.in;
    Scanner keyScan = new Scanner(in);

    //ANSI Escape Code !!
    final String ANSI_CLEAR = "\033[0m";
    final String ANSI_BOLD_RED = "\033[1;31m";
    final String ANSI_RED = "\033[31m";

    String appTitle = "[과제관리 시스템]\n";
    String line1 = "--------------------------------";
    String menu1 = "1. 과제",
        menu2 = "2. 게시글",
        menu3 = "3. 도움말",
        menu4 = "4. 종료";
    //이처럼 변수를 활용하면 메모리를 사용하므로 성능상은 아주 조금의 손해가 있을 수 있다.
    //그러나 하드웨어 성능은 겁나게 좋아지고 있고, 개발자 인건비는 겁나게 늘어나고 있다.
    //그래서 Refactoring에서 가장 중요한 것 중 하나가 가독성 향상 + 샏산성 향상이다.
    System.out.println(line1);
    System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
    // \n = LF = 0xOA in UTF-8
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(ANSI_RED + menu4 + ANSI_CLEAR);
    System.out.println(line1);

    String menuString;
    int menuNumber = 0;

    for (; ; ) {
      //여기서 변수를 생성해도 JVM이 똑똑해서 변수를 반복할 때마다 만들지는 않는다.
      System.out.print("> ");
      menuString = keyScan.nextLine();

      if (menuString.equals("menu")) {
        System.out.println(line1);
        System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
        // \n = LF = 0xOA in UTF-8
        System.out.println(menu1);
        System.out.println(menu2);
        System.out.println(menu3);
        System.out.println(ANSI_RED + menu4 + ANSI_CLEAR);
        System.out.println(line1);
      } else {
        menuNumber = Integer.valueOf(menuString);

        if (menuNumber == 1) {
          System.out.println("과제입니다.");
        } else if (menuNumber == 2) {
          System.out.println("게시글입니다.");
        } else if (menuNumber == 3) {
          System.out.println("도움말입니다.");
        } else if (menuNumber == 4) {
          System.out.println("종료입니다.");
          break;
        } else {
          System.out.println("옳지 않은 번호입니다.");
        }
      }
    }
    keyScan.close(); //close가 있는 도구(메서드)도 있고 없는 것도 있다.
  }
}