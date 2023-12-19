package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ObjectRepository;

public class MemberListHandler implements MenuHandler {

  //  Prompt prompt;
  private ObjectRepository memberRepository;

  public MemberListHandler(ObjectRepository memberRepository) {
    //this.prompt = prompt;
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 목록:", menu.getTitle());

    //빈 부분을 제거한 배열을 받는다.
    Member[] members = this.memberRepository.toArray();

    //빈 부분이 없다면 null 체크를 하지 않는 Enhanced for Loop 쓸 수 있다.
    System.out.printf("%-20s | %10s | %15s\n", "EMAIL", "NAME", "SIGN-IN DATE");
    for (Member member : members) {
      System.out.printf("%-20s | %10s | %15s\n", member.getEmail(), member.getName(),
          member.getCreatedDate());
    }
  }
}
