// 변수 초기화 문장(variable initializer) - 변수 초기화 문장
package com.eomcs.oop.ex03;

public class Exam0810 {

  static class A {
    int a;
    int b;
    int c;

    public A() {
      a = 100; // 기본 생성자로 초기화 문장이 옮겨간다
      b = 200;
    }
    // 인스턴스 필드 초기화 문장은
    // 생성자의 앞 부분에 삽입된다.
    //
    // 생성자가 없으면,
    // - 기본 생성자가 생성되어 앞 부분에 삽입된다.
    // - 바이트코드(Exam0810$A.class)를 확인해 보라!
    //

  }

  public static void main(String[] args) {
    A obj1 = new A();
    System.out.printf("a=%d, b=%d, c=%d\n", obj1.a, obj1.b, obj1.c);
  }
}


