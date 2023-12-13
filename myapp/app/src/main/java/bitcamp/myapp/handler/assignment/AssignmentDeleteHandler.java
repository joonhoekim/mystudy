package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;


  public AssignmentDeleteHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    //assignmentRepository.remove(index); //이렇게만 해도 되지만..
    if (assignmentRepository.remove(index) == null) {
      System.out.println("유효하지 않은 인덱스");
    }
  }
}
