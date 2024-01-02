// inner class : import 사용
package com.eomcs.oop.ex11.c;

// 중첩 클래스를 직접 import 할 수 있다.
// => import 가 하는 일은 클래스를 로딩하는 것이 아니다! 성능 상관 없음!!
// => 컴파일러에게 클래스의 위치를 알려주는 것이다.
// import com.eomcs.oop.ex11.c.D.X;
// import com.eomcs.oop.ex11.c.sub.M;
// import com.eomcs.oop.ex11.c.sub.M.Y;

class D {
  class X {
    void test() {
      System.out.println("test()");
    }
  }
}


public class Exam0410 {

  public static void main(String[] args) {

    D outer = new D();
    // X obj = outer.new X();
    // import 하면 위처럼 외부 클래스를 명시하지 않아도 안다.
    // import 안하면 아래처럼 외부 클래스를 명시해줘야 한다.
    D.X obj = outer.new X();
    obj.test();

    // 아예 다른 패키지라면
    com.eomcs.oop.ex11.c.sub.M outer2 = new M();
    com.eomcs.oop.ex11.c.sub.M.Y obj2 = outer2.new Y();
    obj2.test();
  }

}
