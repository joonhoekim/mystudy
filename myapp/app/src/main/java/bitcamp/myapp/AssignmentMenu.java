package bitcamp.myapp;

public class AssignmentMenu {

  static Assignment[] assignments = new Assignment[3];
  static int length = 0;
  //레퍼런스의 배열만 생성된 상태. 인스턴스는 아직 탄생 전.


  static void printMenu() {
    System.out.println("[과제]");
    System.out.println("1. 등록");
    System.out.println("2. 상세조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/과제> ");

      switch (input) {
        case "1":
          add();
          break;
        case "2":
          //상세조회
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          //목록
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

  static void add() {

    System.out.println("과제 등록:");

    if (length == assignments.length) {
      //System.out.println("용량 초과로 과제 더 이상 입력 불가함");
      //배열 크기 부족하면, 크기 50% 증가시킨 새 배열 만들어서 옮기기
      int oldSize = assignments.length;
      int newSize = oldSize + oldSize / 2;
      Assignment[] arr = new Assignment[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = assignments[i];
      }
      assignments = arr;
      //여기서 레퍼런스가 assignments가 가리키던 기존의 배열(인스턴스)는 가비지가 된다.
    }
    
    Assignment assignment = new Assignment();
    assignment.title = Prompt.input("과제명? ");
    assignment.content = Prompt.input("내용? ");
    assignment.deadline = Prompt.input("제출 마감일? ");

    assignments[length] = assignment;
    length++;
    //ArrayIndexOutOfBoundsException 발생 가능!

  }

  static void view() {
    System.out.println("과제 상세조회:");
    int index = Integer.parseInt(Prompt.input("번호?: "));
    if (index >= length || index < 0) {
      System.out.println("해당 과제번호는 유효하지 않음");
      return;
    }

    Assignment assignment = assignments[index];
    System.out.printf("과제명: %s\n", assignment.title);
    System.out.printf("내용: %s\n", assignment.content);
    System.out.printf("제출 마감일: %s\n", assignment.deadline);

  }

  static void list() {
    System.out.println("과제 목록 조회:");
    System.out.printf("%-20s\t%s\n", "과제명 ", "제출 마감일 ");
    for (int i = 0; i < length; i++) {
      //아래 코드는 변수를 하나 더 추가하는, 아주 작은 메모리 손해가 있다.
      Assignment assignment = assignments[i];
      //그러나 아래의 기존 코드를 수정하지 않아도 되고, 가독성에서도 유리한 편이다.
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
// 조회를 좀 더 편하게 하게 아래에서 위로 변경
//      System.out.printf("과제명: %s\n", assignment.title);
//      System.out.printf("내용: %s\n", assignment.content);
//      System.out.printf("제출 마감일: %s\n", assignment.deadline);

    }

  }

  static void modify() {
    System.out.println("과제 변경:");
    int index = Integer.parseInt(Prompt.input("번호?: "));
    if (index < 0 || length <= index) {
      System.out.println("해당 과제번호는 유효하지 않음");
      return;
    }

    Assignment assignment = assignments[index];
    assignment.title = Prompt.input("과제명(%s)? ", assignment.title);
    assignment.content = Prompt.input("내용(%s)? ", assignment.content);
    assignment.deadline = Prompt.input("제출 마감일(%s)? ", assignment.deadline);

  }

  static void delete() {
    System.out.println("과제 삭제:");
    int index = Integer.parseInt(Prompt.input("번호?: "));
    if (length > index || index >= 0) {
      System.out.println("해당 과제번호는 유효하지 않음");
      return;
    }
    for (int i = index; i < (length - 1); i++) {
      assignments[i] = assignments[i + 1];
    }
    --length;
    assignments[length] = null;
    //java 는 가비지에 대한 책임이 개발자에게 아예 주지 않는다.

    // 중간 걸 삭제하면 뒤에 걸 땡겨줘야 한다. 복잡해서 나중에!
//    assignment.title = "";
//    assignment.content = "";
//    assignment.deadline = "";

  }
}
