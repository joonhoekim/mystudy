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

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.memberRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    //이 코드는 변수 이름 바뀌면 수정을 많이 해야한다. 별로다.
//    Board oldBoard = this.boardRepository.boards[index];
//    boardRepository.boards[index].title = this.prompt.input("수정할 제목: (%s)", oldBoard.title);
//    boardRepository.boards[index].title = this.prompt.input("수정할 내용: (%s)", oldBoard.content);
//    boardRepository.boards[index].title = this.prompt.input("수정할 작성자: (%s)", oldBoard.writer);
//    boardRepository.boards[index].title = this.prompt.input("수정할 작성일: (%s)", oldBoard.createdDate);

    //코드 흐름을 완전히 이해했다면 이렇게 짜는게 낫다!! member 라는 변수 하나로 해결하게 된다.
    Member member = this.memberRepository.members[index]; //레퍼런스가 같은 주소를 공유한다.
    member.email = prompt.input("이메일 뭘로 바꿀까요? (이전:%s)",
        member.email); //input에서 이전 값을 보여주고 거기에 덮어쓴다.
    member.name = prompt.input("이름 뭘로 바꿀까요? (이전:%s)", member.name);
    member.password = prompt.input("비밀번호 뭘로 바꿀까요? (이전:%s)", member.password);

  }
}
