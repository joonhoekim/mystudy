package com.eomcs.oop.ex02.test;

public class Step06Calculator {

  // GRASP - High cohesion (information expert)
  // 계산 결과를 담을 변수를 준비한다.
  int result = 0;

  // static 명령어를 제거하여 인스턴스 메서드로 변경한다.
  // 인스턴스 메서드는 this라는 내장변수(built-in variable)가 있으므로
  // 인스턴스의 레퍼런스를 파라미터로 요구하지 않아도 된다.

  // 이 클래스에서 변수를 관리하므로 계산할 때마다 return할 필요 없다.
  void plus(int b) {
    this.result += b;
  }

  void minus(int b) {
    this.result -= b;
  }

  void multiple(int b) {
    this.result *= b;
  }

  void divide(int b) {
    this.result /= b;
  }
}
