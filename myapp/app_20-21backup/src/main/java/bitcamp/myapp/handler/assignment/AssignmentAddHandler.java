package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

  private AssignmentRepository assignmentRepository;
  private Prompt prompt;

  public AssignmentAddHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  public void action(Menu menu) {
    //Define BoardAddHandle's action()
    System.out.printf("[%s]:",
        menu.getTitle()); //getTitle()은 인터페이스에서 약속되어 있고, menuItem 클래스에서 구현되어 있다.

    if (this.assignmentRepository.length == this.assignmentRepository.assignments.length) {
      //리파지토리 객체 내 변수(int length), 객체 내 배열의 길이를 비교해서 배열 공간 다 찼는지 확인한다.
      //만약 같다면 배열 길이를 50% 증가시킨 새 배열 만들어서 값을 복사해두고, 그 레퍼런스가 가진 주소를 받는다.
      int oldSize = this.assignmentRepository.assignments.length;
      int newSize = oldSize + (oldSize >> 1);

      Assignment[] arr = new Assignment[newSize];
      System.arraycopy(this.assignmentRepository.assignments, 0, arr, 0, oldSize);

      this.assignmentRepository.assignments = arr;
    }

    Assignment assignment = new Assignment();
    assignment.setTitle(this.prompt.input("제목? "));
    assignment.content = this.prompt.input("내용? ");
    assignment.deadline = this.prompt.input("마감일? ");

    this.assignmentRepository.assignments[this.assignmentRepository.length++] = assignment;
  }


}
