package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.step07util.Step07Calculator;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용 << Step06
// 7) 패키지 멤버 클래스로 분리
// 8) 클래스를 역할에 따라 패키지로 분류하기


public class Step07 {

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 인스턴스 메서드 그 문법을 쓰지 않아도 레퍼런스를 통해 동일한 결과를 얻을 수 있다.
    // 더 편하고 가독성이 좋기 때문에 배우고 쓰는 것이다.
    // 인스턴스 변수, 메서드 사용하도록 변경했으니 new 명령어로 인스턴스 생성해야 함.
    Step07Calculator c1 = new Step07Calculator();
    Step07Calculator c2 = new Step07Calculator();

    c1.plus(2);
    c1.plus(3);
    // 중간에 c2 계산을 해도 둘이 다른 인스턴스 변수를 사용하니 결과가 동일하다.
    c2.plus(2);
    c2.plus(3);
    c2.minus(1);
    c2.multiple(7);
    c2.divide(3);
    // 중간에 c2 계산을 해도 둘이 다른 인스턴스 변수를 사용하니 결과가 동일하다.
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    // 인스턴스 메서드가 얼마나 가독성에서 이득이 있는지 아래와 비교해보자.
    // 인스턴스 메서드를 활용하지 않는 경우 매번 클래스를

    // c1.result = Step05Calculator.plus(c1, 2);
    // c1.result = Step05Calculator.plus(c1, 3);
    // // 중간에 c2 계산을 해도 둘이 다른 인스턴스 변수를 사용하니 결과가 동일하다.
    // c2.result = Step05Calculator.plus(c2, 2);
    // c2.result = Step05Calculator.plus(c2, 3);
    // c2.result = Step05Calculator.minus(c2, 1);
    // c2.result = Step05Calculator.multiple(c2, 7);
    // c2.result = Step05Calculator.divide(c2, 3);
    // // 중간에 c2 계산을 해도 둘이 다른 인스턴스 변수를 사용하니 결과가 동일하다.
    // c1.result = Step05Calculator.minus(c1, 1);
    // c1.result = Step05Calculator.multiple(c1, 7);
    // c1.result = Step05Calculator.divide(c1, 3);


    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);

  }


}
