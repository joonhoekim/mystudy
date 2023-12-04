package com.eomcs.oop.ex02.test;

public class Step05Calculator {

  // GRASP - High cohesion (information expert)
  // 계산 결과를 담을 변수를 준비한다.
  int result = 0;

  static int plus(Step05Calculator Instance, int b) {
    return Instance.result + b;
  }

  static int minus(Step05Calculator Instance, int b) {
    return Instance.result - b;
  }

  static int multiple(Step05Calculator Instance, int b) {
    return Instance.result * b;
  }

  static int divide(Step05Calculator Instance, int b) {
    return Instance.result / b;
  }
}
