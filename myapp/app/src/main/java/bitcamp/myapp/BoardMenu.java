package bitcamp.myapp;

public class BoardMenu {

  static Board[] boards = new Board[2];
  static int length = 0;


  static void printMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();
    while (true) {
      String input = Prompt.input("메인/게시글> ");

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

  static void add() {
    if (length == boards.length) {
      System.out.println("배열초과로 기존 배열 150% 크기의 새 배열을 만듭니다.");

      int oldSize = boards.length;
      int newSize = oldSize + oldSize / 2; //int 자료형은 소수점 버림이므로 oldSize==1 인 경우는 변화 없음.
      Board[] arr = new Board[newSize];
      //150% 새 배열 인스턴스를 생성

      for (int i = 0; i < oldSize; i++) {
        arr[i] = boards[i];
      }
      //내용 복사

      boards = arr;
      //인스턴스 전달
    }

    Board board = new Board();

    System.out.println("게시글 등록:");
    String temp = Prompt.input("[테스트용 일괄입력] 내용? ");
    board.title = temp;
    board.content = temp;
    board.writer = temp;
    board.createdDate = temp;
    boards[length] = board;
    length++;

//    board.title = Prompt.input("제목? ");
//    board.content = Prompt.input("내용? ");
//    board.writer = Prompt.input("작성자? ");
//    board.createdDate = Prompt.input("작성일? ");

  }

  static void view() {
    System.out.println("게시글 조회:");
    if (length == 0) {
      System.out.println("게시글이 없습니다.");
      return;
    }

    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      System.out.print("---------------\n");
      System.out.printf("제목: %s\n", board.title);
      System.out.printf("내용: %s\n", board.content);
      System.out.printf("작성자: %s\n", board.writer);
      System.out.printf("작성일: %s\n", board.createdDate);
    }
  }

  static void modify() {
    System.out.println("게시글 변경:");

    int index = Integer.parseInt(Prompt.input("번호? "));

    if (index < 0 || index >= length) {
      System.out.println("return: 마지막 게시글 인덱스보다 큰 번호임");
      return;
    }
    Board board = new Board();
    board.title = Prompt.input("제목(%s)? ", board.title);
    board.content = Prompt.input("내용(%s)? ", board.content);
    board.writer = Prompt.input("작성자(%s)? ", board.writer);
    board.createdDate = Prompt.input("작성일(%s)? ", board.createdDate);

    boards[index] = board;
  }

  static void delete() {
    System.out.println("게시글 삭제:");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index >= length || length < 0) {
      System.out.println("return: 마지막 게시글 인덱스보다 큰 번호임");
      return;
    }

    if (index == length - 1) {
      boards[index] = null;
      return;
    }

    for (int i = index; index < length - 1; i++) {
      boards[i] = boards[i + 1];
    }

    boards[--length] = null;
    //이 배열 삭제의 표현은 국밥 중의 국밥이다.
    //계쏙 반복해서 작성해봐라.
  }

}
