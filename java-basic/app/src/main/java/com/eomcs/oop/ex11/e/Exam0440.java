// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;

public class Exam0440 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  static void m1(A obj) {
    obj.print();
  }

  // 인터페이스를 이렇게 활용하는 것이 앞으로 자주 있을 것

  public static void main(String[] args) {

    // 1) 로컬 클래스 만들기
    class X implements A {
      @Override
      public void print() {
        System.out.println("XXXXX");
      }
    }
    m1(new X());

    // 2) 익명 클래스 만들기
    A obj = new A() {
      @Override
      public void print() {
        System.out.println("익명 클래스!!!");
      }
    };
    m1(obj);

    // 3) 익명 클래스를 파라미터 자리에 바로 삽입
    m1(new A() {
      @Override
      public void print() {
        System.out.println("안녕!!!");
      }
    });


    // 3번 방법을 실무에서 자주 쓴다.
    // 위 코드는 컴파일러가 다음 코드와 유사하게 바꿀 것이다.
    // class Exam0440$2 implements A {
    // @Override
    // public void print() {
    // System.out.println("안녕!!!");
    // }
    // }
    // A temp = new Exam0440$2();
    // m1(temp);

    // m1 에 아규먼트로 넣어주는 건 익명 클래스를 객체로 만들고 그 주소를 넣어준 것이다.
    // 생성연산자 new 에 생성자 넣어주면 항상 인스턴스 주소 반환하는 것과 같다.

  }
}
