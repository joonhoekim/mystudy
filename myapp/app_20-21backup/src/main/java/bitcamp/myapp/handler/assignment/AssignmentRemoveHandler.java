package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.util.Prompt;

public class AssignmentRemoveHandler implements MenuHandler {

  private Prompt prompt;
  private AssignmentRepository assignmentRepository;

  public AssignmentRemoveHandler(Prompt prompt, AssignmentRepository assignmentRepository) {
    this.prompt = prompt;
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 삭제:", menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    //인덱스 유효성 체크하는 건 동일함. 이것도 반복사용되니 추출해야 하는 걸로 느껴진다.
    if (index < 0 || index >= this.assignmentRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    //삭제는 인덱스 번호부터 마지막 전까지 앞으로 떙겨와야 함
    for (int i = index; i < this.assignmentRepository.length - 1; i++) {
      this.assignmentRepository.assignments[i] = this.assignmentRepository.assignments[i + 1];
    }

    //마지막 인덱스 처리해줘야 함
    this.assignmentRepository.length--;
    this.assignmentRepository.assignments[assignmentRepository.length] = null;
    //위 코드는 --boardRepository.length로 줄일 수 있으나 이해를 위해 풀었음.
  }
}
