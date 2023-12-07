package bitcamp.myapp;

public class MemberMenu {

  static Member[] members = new Member[2];
  static int length = 0;

  static void printMenu() {
    System.out.println("[회원관리]");
    System.out.println("1. 회원정보 입력");
    System.out.println("2. 회원목록 조회");
    System.out.println("3. 회원정보 변경");
    System.out.println("4. 회원정보 삭제");
    System.out.println("5. 회원정보 상세조회");
    System.out.println("0. 이전");
  }


  public static void execute() {
    printMenu();
    while (true) {
      switch (Prompt.input("메인/회원관리> ")) {
        case "1":
          add();
          break;
        case "2":
          list();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          view();
          break;
        case "0":
          return;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }


  private static void add() {
    if (length == members.length) {
      System.out.println("배열 길이 초과로 기존 배열 150% 크기의 새 배열을 만듭니다.");

      int oldSize = members.length;
      //int newSize = oldSize + oldSize / 2; //int 자료형은 소수점 버림이므로 oldSize==1 인 경우는 변화 없음.
      //괄증덧곱 쉬관등비 논조대
      int newSize = oldSize + (oldSize >> 1);

      System.out.printf("old:%d  new:%d", oldSize, newSize);
      Member[] arr = new Member[newSize];
      //150% 새 배열 인스턴스를 생성

      for (int i = 0; i < oldSize; i++) {
        arr[i] = members[i];
      }
      //내용 복사

      members = arr;
      //인스턴스 전달
    }

    Member member = new Member();

    System.out.println("회원정보 등록:");
    member.name = Prompt.input("이름? ");
    member.email = Prompt.input("이메일? ");
    member.password = Prompt.input("비밀번호? ");
    member.dateSignIn = Prompt.input("가입일? ");
    members[length++] = member;

//    member.title = Prompt.input("제목? ");
//    member.content = Prompt.input("내용? ");
//    member.writer = Prompt.input("작성자? ");
//    member.createdDate = Prompt.input("작성일? ");

  }

  private static void list() {
    System.out.println("회원 목록 조회:");
    if (length == 0) {
      System.out.println("회원 정보가 없습니다.");
      return;
    }
    System.out.printf("%-20s\t%30s\t%s\n", "이메일", "이름", "가입일");
    for (int i = 0; i < length; i++) {
      System.out.printf("%-20s\t%30s\t%s\n", members[i].email, members[i].name,
          members[i].dateSignIn);
    }
    System.out.println("----------------------");

  }

  private static void view() {
    System.out.println("회원 정보 조회:");
    int index = Integer.parseInt(Prompt.input("조회할 회원의 인덱스?: "));
    if (index < 0 || index >= length) {
      System.out.println("부적절한 인덱스 번호입니다.");

      return;
    }
    if (length == 0) {
      System.out.println("회원 정보가 없습니다.");
      return;
    }
    for (int i = 0; i < length; i++) {
      System.out.printf("%-20s\t%10s\t%s\n", members[i].email, members[i].name,
          members[i].dateSignIn);
    }
    System.out.println("----------------------");

  }

  private static void modify() {
    System.out.println("회원정보 변경:");

    //예외처리: 회원이 없는 경우
    if (length == 0) {
      System.out.println("return: 현재 회원이 없음");
      return;
    }

    //인덱스를 받는다.
    int index = Integer.parseInt(Prompt.input("수정할 인덱스?: "));

    //예외처리: 마지막 회원 인덱스보다 더 큰 값을 입력한 경우
    if (length <= index) {
      System.out.println("return: 마지막 회원보다 큰 인덱스임");
      return;
    }

    System.out.println("회원정보 등록:");

    //인스턴스에 값을 넣어준다.
    Member member = new Member();
    member.name = Prompt.input("새 이름?");
    member.email = Prompt.input("새 이메일?");
    member.password = Prompt.input("새 암호?");
    member.dateSignIn = Prompt.input("새 가입일?");

    members[index] = member; //인스턴스 주소를 건네준다.
    //기존에 members[index]가 가리키고 있던 인스턴스는 가비지가 된다.

  }

  private static void delete() {
    //삭제 구현?
    /*
     * check if there are something to delete.
     * use Prompt.input to get a index. assign it to int var.
     * arr[index] = arr[index+1] until the arr[final-1] = arr[final]
     * arr[final] = null
     * --length
     * */
    System.out.println("회원 삭제: ");

    if (length == 0) {
      System.out.println("return: 삭제할 것이 없습니다.");
      return;
    }
    int index = Integer.parseInt(Prompt.input("삭제할 인덱스?:"));
    for (int i = index; i < length - 1; i++) {
      members[i] = members[i + 1];
      System.out.printf("i=%d, index=%d, length-1=%d\n", i, index, length - 1);
    }

    members[--length] = null;
    System.out.printf("현재 length: %d\n", length);

  }


}
