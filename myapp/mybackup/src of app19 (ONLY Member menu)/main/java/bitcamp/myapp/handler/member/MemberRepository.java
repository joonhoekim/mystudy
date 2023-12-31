package bitcamp.myapp.handler.member;

import bitcamp.myapp.vo.Member;

public class MemberRepository {

  Member[] members = new Member[3];
  int length = 0;

  // 리포지토리가 가져야 하는 메서드들은 다양하지만,
  // 표준이 되는 ArrayList 를 참조해서 메서드를 구현하자.

  // 먼저 add() 이다. 이전 버전과 동일하게 동작하도록, 사용자에게 입력받는 것만 추가해보자.
  public void add(Member member) {
    if (this.length == this.members.length) {
      //리파지토리 객체 내 변수(int length), 객체 내 배열의 길이를 비교해서 배열 공간 다 찼는지 확인한다.
      //만약 같다면 배열 길이를 50% 증가시킨 새 배열 만들어서 값을 복사해두고, 그 레퍼런스가 가진 주소를 받는다.
      int oldSize = this.members.length;
      int newSize = oldSize + (oldSize >> 1);

      Member[] arr = new Member[newSize];
      System.arraycopy(this.members, 0, arr, 0, oldSize);
      this.members = arr;
    }
    this.members[this.length++] = member;
  }

  // 그 다음은 삭제하고, 삭제한 걸 반환하는 remove()를 만들어보자.
  public Member remove(int index) {
    Member deleted = this.members[index];
    for (int i = index; i < this.length - 1; ++i) {
      this.members[i] = this.members[i + 1];
    }
    this.members[--this.length] = null;
    return deleted;
  }

  // 이제부터는 기존에 있던 기능이 아니다. 그러나 view, list, modify 기능을 구현하기 위해 필요한 것들이다.
  // view는 해당 인덱스의 member 인스턴스를 리턴받아서 그것을 보여주게 구현할 것이다. (보여주는 것은 핸들러의 영역)
  // ㄴ 그래서 해당 객체를 리턴해주는 get() 메서드를 만들 것이다.
  // list는 members 배열에서 빈 부분을 제거한 인스턴스를 반환하는 toArray() 메서드를 사용할 것이다.
  // ㄴ 그것을 Enhanced for loop으로 보여주면 된다.
  // modify는 핸들러에서 인덱스와 교체할 member 인스턴스를 줘서, repository에서 정보를 직접 수정하도록 할 것이다.
  // ㄴ 따라서 인덱스에 따라 인스턴스를 교체하는 set() 메서드를 만들 것이다.

  public Member get(int index) {
    //인덱스가 유효한지 검사를 해주는 것은 정보를 알고 있는 리포지토리쪽에서 해줘야 하는 일.
    if (index < 0 || index >= this.length) {
      //유효하지 않으면 null을 반환한다.
      return null;
    }
    //해당 인덱스의 인스턴스를 리턴한다.
    return this.members[index];
  }

  public Member[] toArray() {
    Member[] arr = new Member[length];

    // 배열 복사에 편리한 클래스가 있지만 직접 작성해보면서 반복문에 익숙해지자.
    for (int i = 0; i < this.length; ++i) {
      arr[i] = this.members[i];
    }

    return arr;
  }

  public Member set(int index, Member member) {

    //인덱스가 유효한지 검사를 해주는 것은 정보를 알고 있는 리포지토리쪽에서 해줘야 하는 일.
    if (index < 0 || index >= this.length) {
      //유효하지 않으면 null을 반환한다.
      return null;
    }
    Member modified = this.members[index];
    this.members[index] = member;
    return modified;
  }

}