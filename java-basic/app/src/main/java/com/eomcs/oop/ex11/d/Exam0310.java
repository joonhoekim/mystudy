// local class에서 바깥 메서드의 로컬 변수 접근
package com.eomcs.oop.ex11.d;

// 계산기 사용법을 정의한다.
interface Calculator {
  double compute(int money);
}


class CalculatorFactory {

  static Calculator create1(float interest) {

    class CalculatorImpl implements Calculator {
      float interest;

      CalculatorImpl(float interest) {
        this.interest = interest;
      }

      @Override
      public double compute(int money) {
        return money + (money * interest);
      }
    }
    // CalculatorImpl 객체에서 interest 파라미터를 쓰고싶다면 생성자를 통해 전달해야 한다.
    // 왜? create1 메서드 호출이 끝나면 create()1 의 로컬 변수는 제거되기 때문이다.

    return new CalculatorImpl(interest);
  }

  static Calculator create2(float interest) {

    // 로컬클래스에서 메서드의 파라미터값을 사용한다면,
    // 컴파일러는 로컬 클래스를 컴파일할 때
    // 파라미터의 값을 저장할 수 있도록 관련 코드를 암시적으로[자동으로] 추가한다.
    // 따라서 create1() 의 경우처럼 개발자가 직접 코드를 추가할 필요가 없다.
    class CalculatorImpl implements Calculator {

      // 아래 코드가 자동으로 생기는거다.
      // float interest;
      // CalculatorImpl(float interest) {
      // this.interest = interest;
      // }

      @Override
      public double compute(int money) {
        return money + (money * interest);
        // interest는 create() 함수의 로컬 변수이다.
        // CalculatorImpl 객체를 생성하여 리턴한 후에는 interest 로컬 변수는 스택에서 사라진 상태일 것이다.
        // 나중에 compute()를 호출할 때 interest 변수는 없을텐데, 어떻게 된 것인가?
        // => 로컬 클래스에서 메서드의 로컬 변수를 사용한다면
        // 컴파일러는 로컬 클래스에 바깥 메서드의 로컬 변수 값을 저장할 필드를 추가한다.
        // 또한 로컬 클래스의 객체를 생성할 때 생성자에 로컬 변수의 값을 넘겨 줄 것이다.
      }
    }

    return new CalculatorImpl();
    // 컴파일러가 위 코드를 자동으로..
    // return new CalculatorImpl(interest);
    // 파라미터 변수를 사용할 수 있도록 만들어준다는 거다...
    // 매번 똑같은 내용을 작성하기 힘드니 이런 편의를 지원하는 것인데
    // 초보 때는 이해하기 어려우니 지양하는게 맞을 것 같다.
    // 근데 자바스크립트의 클로저도 이거랑 똑같이 동작하니
    // 익숙해지고 편안해져야 한다.
  }
}


public class Exam0310 {

  public static void main(String[] args) {
    Calculator c1 = CalculatorFactory.create1(0.02f);
    Calculator c2 = CalculatorFactory.create2(0.08f);

    System.out.printf("%.2f\n", c1.compute(1235_0000));
    System.out.printf("%.2f\n", c2.compute(1235_0000));
  }

}
