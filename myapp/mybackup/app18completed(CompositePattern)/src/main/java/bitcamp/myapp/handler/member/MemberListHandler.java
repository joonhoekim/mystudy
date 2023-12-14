package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;

public class MemberListHandler implements MenuHandler {

  //  Prompt prompt;
  MemberRepository memberRepository;

  public MemberListHandler(MemberRepository memberRepository) {
    //this.prompt = prompt;
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 목록:", menu.getTitle());

    System.out.printf("%-20s | %10s | %15s\n", "EMAIL", "NAME", "SIGN-IN DATE");
    for (Member member : this.memberRepository.members) {
      System.out.printf("%-20s | %10s | %15s\n", member.email, member.name,
          member.createdDate);
    }
  }
}
