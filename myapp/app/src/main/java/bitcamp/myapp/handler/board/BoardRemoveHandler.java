package bitcamp.myapp.handler.board;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.util.Prompt;

public class BoardRemoveHandler implements MenuHandler {

  Prompt prompt;
  BoardRepository boardRepository;

  public BoardRemoveHandler(Prompt prompt, BoardRepository boardRepository) {
    this.prompt = prompt;
    this.boardRepository = boardRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf("%s 삭제:", menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    //인덱스 유효성 체크하는 건 동일함. 이것도 반복사용되니 추출해야 하는 걸로 느껴진다.
    if (index < 0 || index >= this.boardRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    //삭제는 인덱스 번호부터 마지막 전까지 앞으로 떙겨와야 함
    for (int i = index; i < this.boardRepository.length - 1; i++) {
      this.boardRepository.boards[i] = this.boardRepository.boards[i + 1];
    }

    //마지막 인덱스 처리해줘야 함
    this.boardRepository.length--;
    this.boardRepository.boards[boardRepository.length] = null;
    //위 코드는 --boardRepository.length로 줄일 수 있으나 이해를 위해 풀었음.
  }
}
