// 오버라이딩(overriding) - 준비
package com.eomcs.oop.ex06.c;

public class Exam0431 {

  static class A {
    String name = "A";
    boolean working = true;

    void print() {
      System.out.println("A.print():");
      System.out.printf("  => this.name(%s)\n", this.name);
      System.out.printf("  => this.working(%s)\n", this.working);
    }

    void m1() {
      System.out.println("A.m1()");
    }
  }

  static class A2 extends A {
    String name = "A2";
    int age = 20;

    @Override
    void print() {
      System.out.println("A2.print():");
      System.out.printf("  => this.name(%s), super.name(%s)\n", this.name, super.name);
      System.out.printf("  => this.working(%s), super.working(%s)\n", this.working, super.working);
      System.out.printf("  => this.age(%s), super.age(컴파일 오류!) \n", this.age /* , super.age */);
      super.m1();
      this.m1();
    }

    @Override
    void m1() {
      System.out.println("A2.m1()");
    }
  }

  static class A3 extends A2 {
    String name = "A3";
    boolean working = false;


    @Override
    void m1() {
      System.out.println("A3.m1()");
    }

  }


  public static void main(String[] args) {
    A obj = new A3();
    obj.print();

    // 필드는 this하면 현재 소속의 메서드부터 찾음.
    // 필드는 super하면 현재 소속된 메서드의 슈퍼클래스부터 찾음.
    // super는 같은데 this는 실제 인스턴스부터(메서드) 찾거나 그 변수를 찾은 메서드를 기준으로 찾음(필드)
    // 그래서 필드는 이해하는데 복잡도를 증가시킴
  }
}
