package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class AssignmentListHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public AssignmentListHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    //여긴 예외 뜰 것이 없어보임!
    //System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    Assignment[] assignments = new Assignment[this.objectRepository.size()];
    this.objectRepository.toArray(assignments);

    for (Assignment assignment : assignments) {
      System.out.printf("%-20s\t%2$tY-%2$tm-%2$td\n", assignment.getTitle(),
          assignment.getDeadline());
    }
  }
}
