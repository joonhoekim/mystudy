// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0640 {

  static class My {
    public boolean test() {
      return true;
    }

    public boolean m() {
      return true;
    }
  }



  public static void main(String[] args) {



    // 아래는 두 문제가 있다.
    // 1)스태틱메서드가 아닌데 정적 영역에 끼우려고 했다.
    // 2)인터페이스(Predicate)에서 메서드에 파라미터를 못받는다.
    Predicate<String> p1 = My::test;


    // 아래는 한 가지 문제가 있다. 끼우려는 메서드는 받는 파라미터가 없다.
    My obj = new My();
    Predicate<String> p2 = obj::test;

    // 아래는 문제가 있어야 한다. 그런데 된다.
    Predicate<My> p3 = My::m;

    // 예외적으로 이렇게 변경된다.

    // => Predicate<My> p3 = (My value) -> { return value.m();};
    // => Predicate<My> p3 = (My value) -> { return value.m();};


    Predicate<String> pp1 = String::isEmpty;
    Predicate<String> pp2 = (String value) -> {
      return value.isEmpty();
    };

    System.out.println(p1.test(""));
    System.out.println(p1.test("Hello"));
    // String s1 = "";

  }

}


