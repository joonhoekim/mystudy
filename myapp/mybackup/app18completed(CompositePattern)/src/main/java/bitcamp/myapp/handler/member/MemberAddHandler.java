package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberAddHandler implements MenuHandler {

  MemberRepository memberRepository;
  Prompt prompt;

  public MemberAddHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  public void action(Menu menu) {
    //Define BoardAddHandle's action()
    System.out.printf("[%s]:",
        menu.getTitle()); //getTitle()은 인터페이스에서 약속되어 있고, menuItem 클래스에서 구현되어 있다.

    if (this.memberRepository.length == this.memberRepository.members.length) {
      //리파지토리 객체 내 변수(int length), 객체 내 배열의 길이를 비교해서 배열 공간 다 찼는지 확인한다.
      //만약 같다면 배열 길이를 50% 증가시킨 새 배열 만들어서 값을 복사해두고, 그 레퍼런스가 가진 주소를 받는다.
      int oldSize = this.memberRepository.members.length;
      int newSize = oldSize + (oldSize >> 1);

      Member[] arr = new Member[newSize];
      System.arraycopy(this.memberRepository.members, 0, arr, 0, oldSize);

      this.memberRepository.members = arr;
    }

    Member member = new Member();
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.createdDate = this.prompt.input("가입일? ");

    this.memberRepository.members[this.memberRepository.length++] = member;
  }


}
