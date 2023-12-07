package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberMenu {

  Member[] members = new Member[3];
  String title;
  int length = 0;
  //dependency
  Prompt prompt;

  public MemberMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void add() {
    System.out.println("회원 등록:");
    //[OK] TODO: ArrayIndexOutOfBoundException: 인덱스 크기 자동 증가하게 변경
    if (length == members.length) {
      int oldSize = length;
      int newSize = length + (length >> 1);
      Member[] arr = new Member[newSize];
      //Copy the values of members's instances
      for (int i = 0; i < length; i++) {
        arr[i] = members[i];
      }
      //instance 주소 대입
      members = arr;
    }

    Member member = new Member();
    member.email = prompt.input("이메일 주소? ");
    member.name = prompt.input("이름? ");
    member.password = prompt.input("암호? ");
    member.dateSignIn = prompt.input("가입일? ");

    members[length++] = member;

  }

  void view() {
    System.out.println("회원 조회:");
    System.out.printf("%-10s | %-20s | %10s\n", "E-Mail", "Name", "dateSignIn");

    for (int i = 0; i < length; i++) {
      System.out.printf("%-10s | %-20s | %10s\n", members[i].email, members[i].name,
          members[i].dateSignIn);
    }
    System.out.println("--------------------------");
  }

  void modify() {
    System.out.println("회원 수정:");
    int index = Integer.parseInt(prompt.input("수정할 회원의 인덱스?: "));
    //TODO: 인덱스 예외처리

    Member member = new Member();
    member.email = prompt.input("변경할 이메일 주소?");
    member.name = prompt.input("변경할 이름?");
    member.password = prompt.input("변경할 비밀번호?");
    member.dateSignIn = prompt.input("변경할 가입일?");

    members[index] = member;
  }

  void delete() {
    System.out.println("회원 삭제:");
    int index = Integer.parseInt(prompt.input("삭제할 회원의 인덱스?: "));
    //TODO: 예외처리

    for (int i = index; i < length - 1; i++) {
      members[i] = members[i + 1];
    }
    members[--length] = null;
  }

  void printMenu() {
    System.out.printf("[%s]\n", title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  void execute() {
    printMenu();

    while (true) {
      String input = prompt.input("메인/회원> ");

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
          break;

      }
    }

  }

}
