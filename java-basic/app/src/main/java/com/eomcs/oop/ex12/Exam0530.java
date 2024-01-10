// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0530 {

  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }

    int a = (int) 2.13f;
  }

  interface Calculator1 {
    double compute(int a, int b);
  }

  interface Calculator2 {
    float compute(int a, int b);
  }

  interface Calculator3 {
    short compute(int a, int b);
  }

  interface Calculator4 {
    void compute(int a, int b);
  }

  interface Calculator5 {
    Object compute(int a, int b);
  }

  interface Calculator6 {
    String compute(int a, int b);
  }

  static Object m(int a, int b) {
    return MyCalculator.plus(a, b); // Autoboxing됨. primitive -> Object 할 떄는 Autoboxing 된다.

    Integer obj = Integer.valueOf(100);
    Integer obj2 = obj;
    int a1 = obj; // 가능
    a1 = obj.intValue(); // unboxing 명시함
    Integer obj4 = a1; // autoboxing

  }

  public static void main(String[] args) {

    // 리턴 타입 int ===> double
    Calculator1 c1 = MyCalculator::plus; // OK!
    // 위 문장은 다음 문장과 같다.
    // Calculator1 c1 = new Calculator1() {
    // @Override
    // public double compute(int a, int b) {
    // return MyCalculator.plus(a, b);
    // }
    // };
    System.out.println(c1.compute(100, 200));

    // 리턴 타입 int ===> float
    Calculator2 c2 = MyCalculator::plus; // OK!
    System.out.println(c2.compute(100, 200));

    // 리턴 타입 int ===> short
    // Calculator3 c3 = MyCalculator::plus; // 컴파일 오류!
    // System.out.println(c3.compute(100, 200));
    // 위 문장은 다음과 같다.
    // Calculator3 c3 = new Calculator3() {
    // @Override
    // public short compute(int a, int b) {
    // return MyCalculator.plus(a, b); // 컴파일 오류!
    // }
    // };


    // 리턴 타입 int ===> void
    Calculator4 c4 = MyCalculator::plus; // OK!
    // => Calculator c4 (int a, int b) -> { Integer.MyCalcualtor.plus(a, b); };
    // 인터페이스에서 void로 메서드 리턴타입을 정의하면 int를 리턴하는 스태틱 메서드 레퍼런스를 가져와도 에러는 안 난다. 리턴되는 값을 무시한다.
    //
    // 위 문장은 다음과 같다.
    // Calculator4 c4 = new Calculator4() {
    // @Override
    // public void compute(int a, int b) {
    // MyCalculator.plus(a, b); // OK!
    // }
    // };
    c4.compute(100, 200); // plus() 메서드의 리턴 값은 무시한다.

    // 리턴 타입 int ===> Object
    Calculator5 c5 = MyCalculator::plus; // OK!
    // 위 문장은 다음과 같다.
    // Calculator5 c5 = new Calculator5() {
    // @Override
    // public Object compute(int a, int b) {
    // return MyCalculator.plus(a, b); // OK!
    // //이유? plus()가 리턴한 int 값이 오토박싱 되기 때문이다. Integer.valueOf()
    // }
    // };
    System.out.println(c5.compute(100, 200));

    // 리턴 타입 int ===> String
    // Calculator6 c6 = MyCalculator::plus; // 컴파일 오류!
    // 위 문장은 다음과 같다.
    // Calculator6 c6 = new Calculator6() {
    // @Override
    // public String compute(int a, int b) {
    // return MyCalculator.plus(a, b); // 컴파일 오류!
    // }
    // };


    // => 메서드 레퍼런스를 지정할 때 리턴 타입의 규칙:
    // 1) 같은 리턴 타입
    // 2) 암시적 형변환 가능한 타입
    // 3) auto-boxing 가능한 타입 (I/F 에서 Object로 리턴값 정의한 경우 등에는 오토박싱 될 수 있다. int -> Integer )
    // 4) void
    // 결론,
    // 메서드 레퍼런스가 가리키는 실제 메서드를 호출한 후
    // 그 메서드가 리턴한 값이
    // 인터페이스에 정의된 메서드의 리턴 값으로 사용할 수 있다면
    // 문제가 없다.
    //
  }
}


