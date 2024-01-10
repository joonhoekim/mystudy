// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0632 {
  public static void main(String[] args) {

    // Predicate<String> 인터페이스 구현체 준비하기

    // 3) 람다로 인터페이스 구현체 만들기
    Predicate<String> p3 = value -> value.isEmpty();

    // 4) 메서드 레퍼런스를 사용하여 기존 클래스의 메서드를 인터페이스 구현체로 사용하기
    // => 의미: "Predicate 인터페이스 구현체로서 String의 isEmpty()를 사용하겠다"
    Predicate<String> p4 = String::isEmpty;

    // => (String value) => {return String.isEmpty( ));
  }

}


