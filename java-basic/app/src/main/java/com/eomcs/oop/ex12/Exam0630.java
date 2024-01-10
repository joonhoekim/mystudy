// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0630 {

  static class My {
    public static boolean test1(String value) {
      return true;
    }

    public boolean test2(String value) {
      return true;
    }

    public static boolean test3() {
      return true;
    }

    public boolean test4() {
      return true;
    }
  }

  public static void main(String[] args) {

    // Predicate<String> 인터페이스 구현체 준비하기

    // 1) 로컬 클래스로 인터페이스 구현체 만들기
    class MyPredicate<T> implements Predicate<T> {
      @Override
      public boolean test(T value) {
        return ((String) value).isEmpty();
      }
    }
    Predicate<String> p1 = new MyPredicate<>();

    // 2) 익명 클래스로 인터페이스 구현체 만들기
    Predicate<String> p2 = new Predicate<>() {
      @Override
      public boolean test(String value) {
        return value.isEmpty();
      }
    };

    // 3) 람다로 인터페이스 구현체 만들기
    Predicate<String> p3 = value -> value.isEmpty();

    // 4) 메서드 레퍼런스를 사용하여 기존 클래스의 메서드를 인터페이스 구현체로 사용하기
    // => 의미: "Predicate 인터페이스 구현체로서 String의 isEmpty()를 사용하겠다"
    Predicate<String> p4 = String::isEmpty;
    // => (String value) => {return String.isEmpty(value));
    // 이전의 방식대로 생각하면 위처럼 컴파일러가 변환할 것 같다.
    // 그러면 isEmpty() 메서드는 인스턴스 메서드가 아니기 때문에 컴파일 오류가 나야 할 것 같은데 아니다.
    // 컴파일 오류를 예상하는 이유:
    // 1. static method 가 아닌데, String이라는 클래스로 호출했다. (인스턴스가 아닌 것으로 호출했다.)
    // 2. isEmpty()는 파라미터를 받지 않기 때문에 value라는 String 값을 던져준게 문제가 된다.
    // 왜? 인터페이스의 타입 파라미터에 전달하는 클래스와 메서드 레퍼런스의 클래스가 같으면,,
    // 컴파일러는 코드를 이렇게 변경한다.
    // Predicate<String> p4 = (String value) -> { return value.siEmpty();};
    // 위에 보면 <> 안에 들어간 타입과, isEmpty()를 호출하는 녀석의 타입이 String 으로 같다.
    // 자주 사용되는 개념은 아니지만, interview에서 다뤄질 수 있다.
  }

}


