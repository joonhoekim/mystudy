package com.eomcs.oop.ex02.test;

public class Step03Calculator {

  // GRASP - High cohesion (information expert)
  // 계산 결과를 담을 변수를 준비한다.
  static int result = 0;

  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }

  static int divide(int a, int b) {
    return a / b;
  }
}
