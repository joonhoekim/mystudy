package com.eomcs.oop.ex02.test;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입 << Step05
// 6) 인스턴스 메서드 활용
// 7) 패키지 멤버 클래스로 분리
// 8) 클래스를 역할에 따라 패키지로 분류하기


public class Step05 {

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 인스턴스 변수 사용하도록 변경했으니 new 명령어로 인스턴스 생성해야 함.

    Step05Calculator c1 = new Step05Calculator();
    Step05Calculator c2 = new Step05Calculator();

    c1.result = Step05Calculator.plus(c1, 2);
    c1.result = Step05Calculator.plus(c1, 3);
    // 중간에 c2 계산을 해도 둘이 다른 인스턴스 변수를 사용하니 결과가 동일하다.
    c2.result = Step05Calculator.plus(c2, 2);
    c2.result = Step05Calculator.plus(c2, 3);
    c2.result = Step05Calculator.minus(c2, 1);
    c2.result = Step05Calculator.multiple(c2, 7);
    c2.result = Step05Calculator.divide(c2, 3);
    // 중간에 c2 계산을 해도 둘이 다른 인스턴스 변수를 사용하니 결과가 동일하다.
    c1.result = Step05Calculator.minus(c1, 1);
    c1.result = Step05Calculator.multiple(c1, 7);
    c1.result = Step05Calculator.divide(c1, 3);

    // 레퍼런스를 사용하니 클래스 변수를 쓸 때보다 코드도 간결하다.
    // Step04Calculator.result = Step04Calculator.minus(Step04Calculator.result, 1);


    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);

  }


}
