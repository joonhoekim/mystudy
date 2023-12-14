package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import bitcamp.util.ObjectRepository;

public class MemberAddHandler implements MenuHandler {

  ObjectRepository objectRepository;
  Prompt prompt;

  public MemberAddHandler(ObjectRepository objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  public void action(Menu menu) {
    //Define BoardAddHandle's action()
    System.out.printf("[%s]:", menu.getTitle());
    //getTitle()은 인터페이스에서 약속되어 있고, menuItem 클래스에서 구현되어 있다.

    //처리는 정보를 가진 리포지토리에 맡기자. 호출만 하도록 하라.
    Member member = new Member();
    member.email = prompt.input("이메일? ");
    member.name = prompt.input("이름? ");
    member.createdDate = prompt.input("가입일? ");
    this.objectRepository.add(member);
  }
}
