package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;


  public AssignmentDeleteHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    //System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    try {
      int index = this.prompt.inputInt("번호? ");

      //? 여기 왜 삭제 구현이 안돼어있어?
      //TODO - make deleteHandler()
      this.objectRepository.remove(index);
      //위에 문장이 원래 예외처리를 하는 문장이었는데 가독성이 떨어져서 바꿈
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
