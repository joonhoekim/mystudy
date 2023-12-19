package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.util.Prompt;

public class MemberRemoveHandler implements MenuHandler {

  Prompt prompt;
  MemberRepository memberRepository;

  public MemberRemoveHandler(Prompt prompt, MemberRepository memberRepository) {
    this.prompt = prompt;
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 삭제:", menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    this.memberRepository.remove(index);
  }
}
