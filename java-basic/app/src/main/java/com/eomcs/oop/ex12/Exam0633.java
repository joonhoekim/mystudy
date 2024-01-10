// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0633 {
  public static void main(String[] args) {

    // Predicate<String> 인터페이스 구현체 준비하기

    // 3) 람다로 인터페이스 구현체 만들기
    Predicate<String> p3 = value -> value.isEmpty();
    System.out.println(p3.test(""));
  }

}


