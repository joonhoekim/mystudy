package com.eomcs.oop.ex02.test;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입 <<Step03
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 패키지 멤버 클래스로 분리
// 8) 클래스를 역할에 따라 패키지로 분류하기


public class Step04 {

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 클래스 변수를 사용했다
    Step04Calculator.result = Step04Calculator.plus(2, 3);
    Step04Calculator.result = Step04Calculator.minus(Step04Calculator.result, 1);
    Step04Calculator.result = Step04Calculator.multiple(Step04Calculator.result, 7);
    Step04Calculator.result = Step04Calculator.divide(Step04Calculator.result, 3);

    System.out.printf("result = %d\n", Step03Calculator.result);

    Step04Calculator.result = Step04Calculator.plus(2, 3);
    Step04Calculator.result = Step04Calculator.minus(Step04Calculator.result, 1);
    Step04Calculator.result = Step04Calculator.multiple(Step04Calculator.result, 7);
    Step04Calculator.result = Step04Calculator.divide(Step04Calculator.result, 3);

    System.out.printf("result = %d\n", Step03Calculator.result);
    // 하나의 클래스 변수만 사용하므로 한 계산이 모두 끝나야 다음 계산을 할 수 있다.


  }


}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


