package bitcamp.myapp.handler.board;

import bitcamp.myapp.vo.Object;

// 게시글 데이터를 보관하는 일을 한다.
//
public class BoardRepository {

  // 목록에 관련된 코드를 외부에서 볼 수 없게 감춘다.
  private Object[] boards = new Object[3];
  private int length = 0;

  // 대신 목록에 값을 추가하거나, 꺼내거나 삭제하려면
  // 메서드를 통해 수행하도록 유도한다.
  // => 캡슐화

  public void add(Object board) {
    if (this.length == this.boards.length) {
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize >> 1);

      Object[] arr = new Object[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }

      this.boards = arr;
    }

    this.boards[this.length++] = board;
  }

  public Object remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    // 배열에서 삭제하기 전에 임시 보관해 둔다.
    Object deleted = this.boards[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.boards[i] = this.boards[i + 1];
    }
    this.boards[--this.length] = null;

    // 삭제한 객체를 리턴한다.
    // 받아서 쓰던가 말던가 호출하는 쪽에서 알아서 할 일이다.
    return deleted;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return this.boards[index];
  }

  public Object set(int index, Object board) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object old = this.boards[index];
    this.boards[index] = board;

    // 새 객체로 교체하기 전에 이전 객체를 리턴한다.
    // 호출하는 쪽에서 받아 쓰거나 말거나 알아서 하라고!
    return old;
  }
}
