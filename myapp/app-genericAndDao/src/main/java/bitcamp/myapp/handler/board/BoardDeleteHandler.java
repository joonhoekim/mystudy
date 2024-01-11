package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.util.Prompt;

public class BoardDeleteHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardDeleteHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    if (boardDao.delete(index) == 0) {
      System.out.println("삭제된 아이템 없음. 유효하지 않은 인덱스입니다.");
    } else {
      System.out.println("삭제 완료");
    }
  }
}
