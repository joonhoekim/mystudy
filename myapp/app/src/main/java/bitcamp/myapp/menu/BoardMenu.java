package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardMenu {

  //dependency
  Prompt prompt;

  String title;
  Board[] boards = new Board[3];
  int length = 0;

  public BoardMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void printMenu() {
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  void execute() {
    printMenu();
    while (true) {

      String input = prompt.input("메인/%s> ", title);

      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  void add() {
    System.out.printf("%s 등록: ", title);

    if (this.length == this.boards.length) {
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }

      this.boards = arr;
    }

    Board board = new Board();
    board.title = prompt.input("제목? ");
    board.content = prompt.input("내용? ");
    board.writer = prompt.input("작성자? ");
    board.createdDate = prompt.input("작성일? ");

    this.boards[this.length++] = board;
  }

  void list() {
    System.out.printf("%s 목록: ", title);
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }

  void view() {
    System.out.printf("%s 조회: ", title);

    int index = Integer.parseInt(prompt.input("번호? "));
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.", title);
      return;
    }

    Board board = this.boards[index];
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);
  }

  void modify() {
    System.out.printf("%s 변경: ", title);

    int index = Integer.parseInt(prompt.input("번호? "));
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.", title);
      return;
    }

    Board board = this.boards[index];
    board.title = prompt.input("제목(%s)? ", board.title);
    board.content = prompt.input("내용(%s)? ", board.content);
    board.writer = prompt.input("작성자(%s)? ", board.writer);
    board.createdDate = prompt.input("작성일(%s)? ", board.createdDate);
  }

  void delete() {
    System.out.printf("%s 삭제: ", title);

    int index = Integer.parseInt(prompt.input("번호? "));
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.", title);
      return;
    }

    for (int i = index; i < (this.length - 1); i++) {
      this.boards[i] = this.boards[i + 1];
    }
    this.boards[--this.length] = null;
  }
}
