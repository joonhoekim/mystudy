package com.eomcs.oop.ex02.step04;

// Exam0240 읽고 올 것
// 클래스 변수의 한계는 동시에 여러 개의 식을 계산할 수 없다.

public class App {

  public static void main(String[] args) {

    Calculator.result = 0;
    Calculator.plus(2);
    Calculator.plus(3);
    Calculator.minus(1);
    Calculator.multiple(7);
    Calculator.divide(3);

    System.out.printf("result = %d\n", Calculator.result);
  }
}

