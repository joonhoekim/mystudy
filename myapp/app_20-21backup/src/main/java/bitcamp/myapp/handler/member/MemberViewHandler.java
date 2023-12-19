package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class MemberViewHandler implements MenuHandler {

  private Prompt prompt;
  private ObjectRepository memberRepository;

  public MemberViewHandler(Prompt prompt, ObjectRepository memberRepository) {
    this.prompt = prompt;
    this.memberRepository = memberRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 조회:", menu.getTitle());
    int index = this.prompt.inputInt("번호? ");

    //get에서는 유효성 검사를 하고 있다. 유효하지 않으면 null을 반환한다.
    Member member = this.memberRepository.get(index);
    if (member == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    //레퍼런스가 갖고 있떤 인스턴스 주소를 할당 받아왔으니 그걸 보여주면 된다.
    member = this.memberRepository.members[index];
    System.out.printf("제목: %s\n", member.email);
    System.out.printf("내용: %s\n", member.name);
    System.out.printf("작성자: %s\n", member.createdDate);
  }
}
