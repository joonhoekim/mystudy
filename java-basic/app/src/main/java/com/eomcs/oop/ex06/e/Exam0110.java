// final 사용법: 상속 불가!
package com.eomcs.oop.ex06.e;

// 클래스에 final 을 붙이면 이 클래스의 서브 클래스를 만들 수 없다.
// - 서브 클래스의 생성을 방지하여
// 기존 클래스를 대체하지 못하도록 할 때 사용한다.
// - 예)
// java.lang.String
//
class 단팥빵 {
}
// final class 로 선언하면 서브클래스 생성 자체를 못한다!


class 크림단팥빵 extends 단팥빵 {

}


// final 클래스를 상속 받을 수 없다.
public class Exam0110 // extends A
{
  public static void main(String[] args) {
    먹기(new 단팥빵());
    먹기(new 크림단팥빵());
    // 파라미터에 선언된 클래스로 만든 객체 대신 그의 서브클래스를 아규먼트로 쓸 수 있는데, 이걸 못하게 하고 싶을 때.
  }

  static void 먹기(단팥빵 obj) {

  }
}
