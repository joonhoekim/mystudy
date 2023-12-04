package com.eomcs.oop.ex02.step05;

public class Calculator {

  // ## 클래스 변수 사용
  // - 메서드들의 작업 결과를 보관할 때 사용할 변수이다.
  // - 변수 선언에 static을 붙이다.
  // - "스태틱 변수"라고도 부른다.
  // - 클래스 변수는 new 명령으로 생성하지 않는다.
  // - 클래스가 메모리에 로딩될 때 자동으로 "Method Area" 영역에 생성된다.

  int result = 0;

  static void plus(Calculator instance, int value) {
    // result = result + value;
    instance.result += value;
  }

  static void minus(Calculator instance, int value) {
    instance.result -= value;
  }

  static void multiple(Calculator instance, int value) {
    instance.result *= value;
  }

  static void divide(Calculator instance, int value) {
    instance.result /= value;
  }

  // 이 메서드는 인스턴스를 활용하지 않는다. 단순연산/반환이다.
  // 인스턴스변수인 result를 사용하지 않으므로 인스턴스 주소 파라미터가 필요하지 않다.
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
