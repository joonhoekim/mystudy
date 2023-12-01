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

    //배열을 활용해보자.
    String[] menuStrings = {
        "--------------------------------",
        ANSI_BOLD_RED + "[과제관리 시스템]\n" + ANSI_CLEAR,
        "1. 과제",
        "2. 게시글",
        "3. 도움말",
        "4. 종료",
        "--------------------------------",
    };

    //배열을 활용해 메뉴를 출력해보자.
    for (String str : menuStrings) {
      System.out.println(str);
    }

    String menuString;

    loop:
    for (; ; ) {
      //여기서 변수를 생성해도 JVM이 똑똑해서 변수를 반복할 때마다 만들지는 않는다.
      System.out.print("> ");
      menuString = keyScan.nextLine();
      switch (menuString) {
        case "1":
          System.out.println("과제입니다.");
          break;
        case "2":
          System.out.println("게시글입니다.");
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료입니다.");
          break loop;
        case "menu": {
          for (String str : menuStrings) {
            System.out.println(str);
          }
          break;
        }
        default:
          System.out.println("옳지 않은 번호입니다.");
          break;
      }
    }
    keyScan.close(); //close가 있는 도구(메서드)도 있고 없는 것도 있다.

  }
}
