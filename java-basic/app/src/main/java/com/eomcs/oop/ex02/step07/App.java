package com.eomcs.oop.ex02.step07;

import com.eomcs.oop.ex02.step07.util.Calculator;
// import. com.eomcs.oop.* 같이 와일드카드 쓸 수 있지만!


// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 패키지 멤버 클래스로 분리
// 8) 클래스를 역할에 따라 패키지로 분류하기
//
public class App {

  // Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 패키지로 분류한다.
  // - com.eomcs.oop.ex02.util 패키지를 만들어 분류한다.
  // - import 를 이용하여 클래스의 패키지 정보를 지정한다.

  public static void main(String[] args) {
    // 다음 두 개의 식을 분리하여 계산해 보자!
    // - 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    // import를 안하면 이렇게 해야 한다. 가독성 나쁜 게 느껴지지 않는가?
    com.eomcs.oop.ex02.step07.util.Calculator c1 = new com.eomcs.oop.ex02.step07.util.Calculator();
    // 식1의 계산 결과를 보관할 인스턴스를 준비하여 레퍼런스에 주소 저장 (위 아래)
    Calculator c2 = new Calculator(); // 식2의 계산 결과를 보관할 메모리 준비

    // 계산을 수행할 때 계산 결과를 보관할 메모리를 메서드 호출 앞에서 전달하라!
    // - 인스턴스 메서드를 사용하면 파라미터로 메모리 주소를 전달할 필요가 없다.
    c1.plus(2); // + 2
    c2.plus(3); // + 3

    c1.plus(3); // + 2 + 3
    c2.multiple(2); // + 3 * 2

    c1.minus(1); // + 2 + 3 - 1
    c2.plus(7); // + 3 * 2 + 7

    c1.multiple(7); // + 2 + 3 - 1 * 7
    c2.divide(4); // + 3 * 2 + 7 / 4

    c1.divide(3); // + 2 + 3 - 1 * 7 / 3 = ?
    c2.minus(5); // + 3 * 2 + 7 / 4 - 5 = ?

    System.out.printf("c1.result = %d\n", c1.result);
    System.out.printf("c2.result = %d\n", c2.result);
  }
}

