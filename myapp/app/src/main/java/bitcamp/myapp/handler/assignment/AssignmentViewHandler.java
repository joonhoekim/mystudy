package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class AssignmentViewHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;


  public AssignmentViewHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    //System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    try {
      int index = this.prompt.inputInt("번호? ");
      Assignment assignment = this.objectRepository.get(index);
      if (assignment == null) {
        System.out.println("과제 번호가 유효하지 않습니다.");
        return;
      }
      System.out.printf("과제명: %s\n", assignment.getTitle());
      System.out.printf("내용: %s\n", assignment.getContent());
      System.out.printf("제출 마감일: %s\n", assignment.getDeadline());

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
