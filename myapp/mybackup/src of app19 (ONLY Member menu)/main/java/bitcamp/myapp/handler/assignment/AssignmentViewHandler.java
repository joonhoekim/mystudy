package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentViewHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;

  public AssignmentViewHandler(Prompt prompt, AssignmentRepository assignmentRepository) {
    this.prompt = prompt;
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 조회:", menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.assignmentRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = this.assignmentRepository.assignments[index];
    System.out.printf("제목: %s\n", assignment.title);
    System.out.printf("내용: %s\n", assignment.content);
    System.out.printf("작성자: %s\n", assignment.deadline);
  }
}
