package com.eomcs.oop.ex02.step07.util;

public class Calculator {

  // ## 클래스 변수 사용
  // - 메서드들의 작업 결과를 보관할 때 사용할 변수이다.
  // - 변수 선언에 static을 붙이다.
  // - "스태틱 변수"라고도 부른다.
  // - 클래스 변수는 new 명령으로 생성하지 않는다.
  // - 클래스가 메모리에 로딩될 때 자동으로 "Method Area" 영역에 생성된다.

  // 인스턴스 메서드는 메서드를 호출할 때 앞에서 전달한 인스턴스의 주소를 받을 수 있도록
  // this 라는 이름의 내장변수(Built-in Variable)를 갖고 있다.


  public int result = 0;

  // public 키워드는 뭔가?
  // 다른 패키지에서도 인스턴스의 메서드나 변수를 접근할 수 있게 해주는 키워드이다.
  public void plus(int value) {
    // result = result + value;
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

  // 이 메서드는 인스턴스를 활용하지 않는다. 단순연산/반환이다.
  // 인스턴스변수인 result를 사용하지 않으므로 인스턴스 주소 파라미터가 필요하지 않다.
  // static 메서드는 this라는 내장변수가 없다.
  static int abs(int a) {
    //
    // if (a >= 0)
    // return a;
    // else
    // return a * -1;
    //
    return a >= 0 ? a : a * -1;
  }
}
