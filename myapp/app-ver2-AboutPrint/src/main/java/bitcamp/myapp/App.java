package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    System.out.println("--------------------------");
    System.out.println("과제관리 시스템\n");
    // \n = LF = 0xOA in UTF-8
    System.out.print("1. 과제\n");
    System.out.print("2. 게시글" + "\n");
    System.out.print('\n');
    System.out.printf("%d. 도움말\n", 3);
    System.out.printf("4. %s\n", "종료");
    System.out.println("--------------------------");
    System.out.print(0);
  }
}