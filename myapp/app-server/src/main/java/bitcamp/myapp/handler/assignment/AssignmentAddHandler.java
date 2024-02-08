package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentAddHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;


  public AssignmentAddHandler(AssignmentDao assignmentDao) {
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Assignment assignment = new Assignment();
    assignment.setTitle(prompt.input("과제명? "));
    assignment.setContent(prompt.input("내용? "));
    assignment.setDeadline(prompt.inputDate("제출 마감일?(예: 2023-12-25) "));

    assignmentDao.add(assignment);
  }
}

