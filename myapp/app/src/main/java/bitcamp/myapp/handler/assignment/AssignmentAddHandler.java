package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;


  public AssignmentAddHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    //메뉴출력
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    Assignment assignment = new Assignment();
    assignment.title = prompt.input("제목? ");
    assignment.content = prompt.input("내용? ");
    assignment.deadline = prompt.input("마감기한?: ");
    assignmentRepository.add(assignment);
  }
}
