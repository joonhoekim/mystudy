package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

  Prompt prompt;
  MemberRepository memberRepository;

  public MemberModifyHandler(Prompt prompt, MemberRepository memberRepository) {
    this.prompt = prompt;
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 수정:", menu.getTitle());

    //Information Expert 적용해서 이렇게 바꿀거다.
    //1. 인덱스를 받는다. 2. 인덱스의 유효성을 검사한다.
    //3. 수정할 정보를 받는다. 4. set()으로 수정을 요청한다.

    //1. 인덱스 받기
    int index = this.prompt.inputInt("번호? ");

    //2. 유효성 검사 (여기서도 리포지토리 내의 변수에 직접접근을 하지 마라!!)
    Member member = this.memberRepository.get(index);
    if (member == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    //3. 수정할 정보 받기
    //input에서 이전 값을 보여주고 거기에 덮어쓴다.
    member.email = prompt.input("이메일 뭘로 바꿀까요? (이전:%s)", member.email);
    member.name = prompt.input("이름 뭘로 바꿀까요? (이전:%s)", member.name);
    member.password = prompt.input("비밀번호 뭘로 바꿀까요? (이전:%s)", member.password);

    //4. Set으로 수정하기
    this.memberRepository.set(index, member);
  }
}
