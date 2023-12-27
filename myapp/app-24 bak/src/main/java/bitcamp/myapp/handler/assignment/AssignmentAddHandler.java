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

    try {
//    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
      //AbstractMenuHandler에 선언된 action() 추상 메서드를 구현한다.
      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명? "));
      assignment.setContent(this.prompt.input("내용? "));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일? (YYYY-MM-DD): "));

      this.objectRepository.add(assignment);

    }
    // 예외 처리를 얼마나 자세히 할 것인지는 선택의 문제.
    catch (NumberFormatException e) {
      //ArrayList Exception
      //throw new RuntimeException(e);
      System.out.println("숫자를 입력하세요.");
      return;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("유효한 번호가 아니에요.");
      return;
    } catch (IllegalArgumentException e) {
      System.out.println("날짜를 맞게 입력해주세요.");
    } catch (Exception e) {
      //위에서 예외를 캐치하지 못한 경우
      System.out.println("처리에 실패했습니다. 다시 시도해주세요.");
      System.out.println(e);
    }

  }
}
