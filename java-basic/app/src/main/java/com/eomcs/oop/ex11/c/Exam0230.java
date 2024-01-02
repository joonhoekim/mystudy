// inner class : 바깥 클래스의 인스턴스 멤버 접근하기 II
package com.eomcs.oop.ex11.c;

class B3 {

  // 인스턴스 멤버
  int v1 = 10;

  class X {
    // Non-static nested class는 바깥 클래스의 인스턴스 주소를 저장할 변수를 가지고 있다.
    // 바이트코드에서는 this$0라고 보이며 이를 접근하려면 [바깥클래스의명.this] 라고 하면 된다.
    // 디버깅할 때 this$0 은 바깥 클래스의 인스턴스 주소를 담은 레퍼런스 변수를 말한다.
    int v1 = 100;

    // 위 내용은 생성자에 컴파일러가 코들르 추가함으로 가능해진다.
    // X(B3 obj) { this$0 = obj } 가 자동으로 들어가는 것이다.

    void test() {
      int v1 = 1000;

      System.out.printf("v1 = %d\n", v1); // 로컬 변수
      System.out.printf("this.v1 = %d\n", this.v1); // 인스턴스 변수
      System.out.printf("B3.this.v1 = %d\n", B3.this.v1); // 바깥 객체의 인스턴스 변수
      // 붙이는게 직관적이다! 생략하는 경우가 많지만 생략하지 말자.
    }
  }
}


public class Exam0230 {

  public static void main(String[] args) {
    B3 outer = new B3();
    outer.v1 = 11;

    B3.X x1 = outer.new X();
    x1.test();
    System.out.println("--------------------");

    B3.X x2 = outer.new X();
    x2.test();
    System.out.println("--------------------");

    B3 outer2 = new B3();
    outer2.v1 = 22;

    B3.X x3 = outer2.new X();
    x3.test();
    System.out.println("--------------------");
  }

}
