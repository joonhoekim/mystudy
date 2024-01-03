// anonymous class - 수퍼 클래스의 메서드 오버라이딩 하기
package com.eomcs.oop.ex11.e;

public class Exam0310 {

  static class A {
    public void print() {
      System.out.println("반갑습니다!");
    }
  }

  public static void main(final String[] args) {
    A obj = new A() {
      @Override
      public void print() {
        System.out.println("정말 반갑습니다!");
      }
    };
    obj.print();
    // 컴파일 단계에서는 A 인터페이스에 있는 메서드인지를 검사한다.
    // 실행 단계에서는 실제 인스턴스인 익명 클래스의 오버라이드된 메서드를 실행한다.
  }
}
