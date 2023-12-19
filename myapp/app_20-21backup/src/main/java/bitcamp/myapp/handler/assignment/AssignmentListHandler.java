package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;

public class AssignmentListHandler implements MenuHandler {

  //  Prompt prompt;
  private AssignmentRepository assignmentRepository;

  public AssignmentListHandler(AssignmentRepository assignmentRepository) {
    //this.prompt = prompt;
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 목록:", menu.getTitle());

    System.out.printf("%-20s | %10s | %15s\n", "TITLE", "WRITER", "DATE");
    for (Assignment assignment : this.assignmentRepository.assignments) {
      System.out.printf("%-20s | %10s | %15s\n", assignment.title, assignment.content,
          assignment.deadline);
    }
  }
}
