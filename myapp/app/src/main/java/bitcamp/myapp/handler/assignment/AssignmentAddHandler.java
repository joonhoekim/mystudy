package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class AssignmentAddHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;


  public AssignmentAddHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
//    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    //AbstractMenuHandler에 선언된 action() 추상 메서드를 구현한다.
    Assignment assignment = new Assignment();
    assignment.setTitle(this.prompt.input("과제명? "));
    assignment.setContent(this.prompt.input("내용? "));
    assignment.setDeadline(this.prompt.input("제출 마감일? "));

    this.objectRepository.add(assignment);
  }
}
