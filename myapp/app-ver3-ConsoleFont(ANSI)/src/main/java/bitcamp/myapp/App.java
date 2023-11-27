package bitcamp.myapp;


public class App {

  public static final String black = "\u001B[30m";
  public static final String red = "\u001B[31m";
  public static final String green = "\u001B[32m";
  public static final String yellow = "\u001B[33m";
  public static final String blue = "\u001B[34m";
  public static final String purple = "\u001B[35m";
  public static final String cyan = "\u001B[36m";
  public static final String white = "\u001B[37m";
  public static final String exit = "\u001B[0m";
  public static final String bold = "\u001B[1m";

  public static void main(String[] args) {
    System.out.println("--------------------------");
    System.out.println(red + "과제관리 시스템\n" + exit);
    // \n = LF = 0xOA in UTF-8
    System.out.println("1. 과제");
    System.out.println("2. 게시글");
    System.out.println("3. 도움말");
    System.out.println("4. 종료");
    System.out.println("--------------------------");
  }
}