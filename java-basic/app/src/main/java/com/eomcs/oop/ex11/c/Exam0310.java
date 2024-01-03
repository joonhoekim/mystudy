// inner class : 다른 멤버가 중첩 클래스 사용하기
package com.eomcs.oop.ex11.c;

class C {

  static void m1() {
    // this. 가 생략된 경우다. 스태틱은 this 못쓰니 이런 거 불가
    // this. 가 생략된다는 걸 모르면 암기해야 하는 고통이 생긴다!!!!
    // X x = new X();
    // X x = this.new X();


    // 스태틱 멤버는 인스턴스 멤버를 사용할 수 없다.
    //
    X obj; // 레퍼런스 선언은 가능!

    // obj = new X(); // 컴파일 오류! 인스턴스 생성 불가능!

    // 이유?
    // - 인스턴스 멤버를 사용하려면 인스턴스 주소가 있어야 한다.
    // - 스태틱 메서드는 인스턴스 주소를 담고 있는 this 변수가 존재하지 않는다.
  }

  void m2() {
    // 인스턴스 메서드는 인스턴스 주소를 담고 있는 this 변수가 있다.
    // 그래서 inner class 를 사용할 수 있다.
    X obj = this.new X(); // X obj = new X(this); 라는 코드로 컴파일러가 변경한다.
    // 혹은 생성자에 자동으로 넣어주는 게 아니라 자동으로 생성한 레퍼런스 변수에 바깥클래스 객체 주소를 넣어줄 수도 있다.
    // 그리고 바깥 클래스의 객체 주소를 받는 this$0 변수도 자동으로 생긴다.
    // 자동으로 생성자에 this 받도록 넣어준다고 해도 그걸 명시적으로 사용하면 안된다.
    // X obj = this.new X(this) 라고 생성자 아규먼트에 명시적으로 넣어주면 안된다.
    // 왜? 컴파일러 구현은 구현체마다 다를 수 있으니까... 그래서 컴파일러 문법 검사에선 오류로 처리한다.
    // Java Specification does not define how to implement those!

    obj.test();

    // X obj2 = new X(); // 인스턴스 필드나 메서드와 마찬가지로 this를 생략할 수 있다.
    X obj2 = this.new X(); // 인스턴스 필드나 메서드와 마찬가지로 this를 생략할 수 있다.
    obj2.test();
  }

  class X {
    void test() {
      System.out.println("X.test()");
    }
  }
}


public class Exam0310 {

  public static void main(String[] args) {
    C.m1();

    C outer = new C();
    outer.m2();

  }

}
