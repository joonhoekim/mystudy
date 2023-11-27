package bitcamp.myapp;

public class App {


  public static void main(String[] args) {
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
  }
}