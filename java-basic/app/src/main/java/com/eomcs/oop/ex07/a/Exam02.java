// 추상 클래스와 추상 메서드
package com.eomcs.oop.ex07.a;

// 추상 클래스
abstract class A2 {

  // 추상 메서드
  // - 메서드 선언부에 abstract를 붙인다.
  // - 메서드 몸체(body)가 없다.
  // - 추상 클래스나 인터페이스에서만 선언할 수 있다.
  //
  // 추상 메서드의 용도
  // - 서브 클래스 마다 구현이 다를 수 있는 경우에 사용한다.
  // - 서브 클래스가 반드시 구현해야 하는 메서드가 있다면 추상 메서드로 선언하라!
  // - 추상 메서드를 상속 받은 서브 클래스는 반드시 추상 메서드를 구현해야 한다.
  // 만약 구현하지 않으면 서브 클래스도 추상 클래스가 되어야 한다.
  // 왜?
  // 추상 메서드를 갖는 클래스는 오직 추상 클래스만이 가능하기 때문이다.
  //
  public abstract void m1();

  // 추상 메서드는 구현할 수 없다.
  // public abstract void m2() {} // 컴파일 오류!
}


// 일반 클래스(concrete class)
class A2Sub extends A2 {
  @Override
  public void m1() {
    // 서브 클래스에서 추상 메서드를 구현해야 한다.
  }
}


public abstract class Exam02 extends A2 {
  // 서브 클래스에서 추상 메서드를 구현하지 않는다면,
  // 추상 메서드인 채로 남아 있기 때문에
  // 추상 클래스가 되어야 한다.
}
