package bitcamp.myapp;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class App {

  //ANSI Escape Code !!
  final static String ANSI_CLEAR = "\033[0m";
  final static String ANSI_BOLD_RED = "\033[1;31m";
  final static String ANSI_RED = "\033[31m";
  final static String CONSOLE_CLEAR = "\\033[H\\033[2J";
  //배열을 활용해보자.
  final static String[] STRING_MENU = {
      "--------------------------------",
      ANSI_BOLD_RED + "[과제관리 시스템]\n" + ANSI_CLEAR,
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      "4. 종료",
      "--------------------------------",
  };
  final static String[] STRING_MENU_WORK = {
      "--------------------------------",
      ANSI_BOLD_RED + "[과제]" + ANSI_CLEAR,
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전",
      "--------------------------------",
  };

  static void clearConsole() {
    System.out.println(CONSOLE_CLEAR);
  }

  static void printMenu(String[] STRING_MENU) {
    for (String line : STRING_MENU) {
      System.out.println(line);
    }

  }

  static String getPrompt() {
    InputStream in = System.in;
    Scanner keyScan = new Scanner(in);
    //keyScan.close(); //close가 있는 도구(메서드)도 있고 없는 것도 있다.
    return keyScan.nextLine();
  }

  static void checkPromptNumber(String prompt) {
    System.out.print("메인 > ");
    if (Objects.equals(prompt, "menu")) {
      printMenu(STRING_MENU_WORK);
    } else if (Objects.equals(prompt, "1")) {
      for (; ; ) {
        System.out.print("메인 > 과제 > ");
        prompt = getPrompt();
        if (Objects.equals(prompt, "1")) {
          System.out.println("과제 등록입니다.");
        } else if (Objects.equals(prompt, "2")) {
          System.out.println("과제 조회입니다.");
        } else if (Objects.equals(prompt, "3")) {
          System.out.println("과제 변경입니다.");
        } else if (Objects.equals(prompt, "4")) {
          System.out.println("과제 삭제입니다.");
        } else if (Objects.equals(prompt, "0")) {
          break;
        }
      }
    } else if (Objects.equals(prompt, "2")) {
      System.out.println("게시글");
    } else if (Objects.equals(prompt, "3")) {
      System.out.println("도움말");
    } else if (Objects.equals(prompt, "4")) {
      System.out.println("시스템을 종료합니다.");

    } else {
      System.out.println("잘못된 명령을 입력하셨습니다.");
    }
  }

  //java.util.Scanner inSt = new Scanner(System.in);

  public static void main(String[] args) {
    printMenu(STRING_MENU);

//    String strtest = "menu";
//    String strtestp = getPrompt();
//    System.out.println(Objects.equals(strtest, strtestp));

    int promptNumber = Integer.parseInt(getPrompt());

    for (; ; ) {
      printMenu(STRING_MENU);
      checkPromptNumber(getPrompt());
      if (promptNumber == 4) {
        break;
      }

    }
  }

}

