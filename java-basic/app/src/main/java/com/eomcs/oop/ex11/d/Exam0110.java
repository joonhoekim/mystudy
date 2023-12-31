// local class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.d;

class A {

  void m1() {
    // 메서드 안에 정의하는 클래스를 "local class"라 한다.
    // - 특정 메서드 안에서만 사용되는 경우 로컬 클래스로 정의한다.
    // - 쓸데없이 외부로 노출하지 않기 위함.
    // - 노출을 줄이면 유지보수에 좋다.
    // - 로컬 클래스에서 로컬 이라는 말은 '이 메서드 안에서만 사용할 수 있다'는 뜻이다.
    // - 그냥 사용 범위에 대한 제한을 가리키는 말이다.
    // - 메서드를 호출할 때 클래스가 정의된다는 뜻이 아니다.
    class X {

    }
    // 위 클래스 정의는 컴파일하고 나면 없다. 메서도 호출시에는 클래스 로딩과 관련된 부분이 없는 것이다.
    // 즉, 로컬 클래스를 쓴다고 오버헤드가 생기는 비효율은 없으니 걱정하지 마라.
    // 참고로 클래스파일 중 로컬 클래스면 외부클래스명$n내부클래스명 으로 클래스 파일이 생긴다.
    // 로컬 클래스가 생길 때마다 n <= n+1 (1에서 시작함) 이 된다.


    X obj = new X();
  }

  static void m2() {
    // 메서드 안에 정의하는 클래스를 "local class"라 한다.
    class X {

    }
    X obj = new X();
  }
}


public class Exam0110 {

  public static void main(String[] args) {
    A outer = new A();
    outer.m1();
  }

}
