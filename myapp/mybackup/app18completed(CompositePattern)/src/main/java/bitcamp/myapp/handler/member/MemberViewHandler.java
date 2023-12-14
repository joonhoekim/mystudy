package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberViewHandler implements MenuHandler {

  Prompt prompt;
  MemberRepository memberRepository;

  public MemberViewHandler(Prompt prompt, MemberRepository memberRepository) {
    this.prompt = prompt;
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 조회:", menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.memberRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Member member = this.memberRepository.members[index];
    System.out.printf("제목: %s\n", member.email);
    System.out.printf("내용: %s\n", member.name);
    System.out.printf("작성자: %s\n", member.createdDate);
  }
}
