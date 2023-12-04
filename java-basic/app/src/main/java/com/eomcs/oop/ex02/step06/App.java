package com.eomcs.oop.ex02.step06;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
//
public class App {

  // static class Calculator {
  // // 인스턴스 변수(= non-static 변수)
  // // - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
  // // - 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
  // // - new 명령을 사용해서 만들어야 한다.
  // // - 변수 선언 앞에 static이 붙지 않는다.
  // int result = 0;
  //
  // static void plus(Calculator obj, int value) {
  // // 인스턴스 변수를 다루는 메서드는 작업을 수행할 때 그 인스턴스 주소를 받아야 한다.
  // // result 는 더이상 클래스 변수가 아니기 때문에 직접 접근할 수 없다.
  // // 오직 인스턴스 주소를 통해서만 접근 할 수 있다.
  // obj.result += value;
  // }
  //
  // static void minus(Calculator obj, int value) {
  // obj.result -= value;
  // }
  //
  // static void multiple(Calculator obj, int value) {
  // obj.result *= value;
  // }
  //
  // static void divide(Calculator obj, int value) {
  // obj.result /= value;
  // }
  //
  // // 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.
  // static int abs(int a) {
  // return a >= 0 ? a : a * -1;
  // }
  // }

  public static void main(String[] args) {


    Calculator c1 = new Calculator(); // 식1의 계산 결과를 보관할 메모리 준비
    Calculator c2 = new Calculator(); // 식2의 계산 결과를 보관할 메모리 준비

    // 인스턴스 메서드의 사
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

    // 식1의 계산 결과는 c1 인스턴스의 result 변수에 들어 있고,
    // 식2의 계산 결과는 c2 인스턴스의 result 변수에 들어 있다.
    System.out.printf("c1.result = %d\n", c1.result);
    System.out.printf("c2.result = %d\n", c2.result);
  }
}

