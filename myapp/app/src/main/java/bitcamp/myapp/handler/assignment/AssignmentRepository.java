package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.vo.Assignment;

public class AssignmentRepository {

  Assignment[] assignments = new Assignment[3];
  int length = 0;

  // GRASP/InformationExpert/ 정보 가지고 있는 이 클래스에서 정보를 다루도록 함. 
  // 핸들러에게는 숨겨서 Encapsulation 적용하기

  //Assignment 타입을 반한하는 메서드를 만든다.
  public void add(Assignment assignment) {

    if (this.length == this.assignments.length) {
      //System.out.println("과제를 더이상 등록할 수 없습니다.");
      int oldSize = this.length;
      int newSize = oldSize + (oldSize / 2);

      // 이전 배열에 들어 있는 값을 새 배열에 복사
      Assignment[] arr = new Assignment[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.assignments[i];
      }

      // 새 배열을 가리키도록 배열 레퍼런스를 변경
      this.assignments = arr;
    }

    //파라미터로 받은 Assignment 객체를 배열에 더해주고 length 증가시킴.

    this.assignments[length++] = assignment;
    return;
  }

  //public void view(){} 조회는 이렇게 구현 안 한다. 원하는 인덱스까지를 주는 것. 그것이 중요하다. 출력 자체는 핸들러가 작업해도 객체지향 원칙에 어긋나지 않음..

  public Assignment remove(int index) {

    if (index < 0 || index >= this.length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return null;
    }

    Assignment deleted = this.assignments[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.assignments[i] = this.assignments[i
          + 1]; // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
    }
    this.length--;
    this.assignments[this.length] = null;

    return deleted;
  }

  public Assignment get(int index) {
    if (index < 0 || index >= length) {
      System.out.println("error: invalid index");
      return null;
    }
    return this.assignments[index];
  }

  public Assignment set(int index, Assignment assignment) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    ;

    Assignment old = this.assignments[index];
    this.assignments[index] = assignment;
    return old;
  }

  public Assignment[] toArray() {
    Assignment[] arr = new Assignment[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.assignments[i];
    }
    return arr;
  }
}
