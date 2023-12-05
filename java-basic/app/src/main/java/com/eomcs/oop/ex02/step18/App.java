package com.eomcs.oop.ex02.step18;

import com.eomcs.oop.ex02.step18.vo.Score;

// 클래스의 사용 방법
// 데이터 타입을 정의하기!
// 성적 데이터를 저장할 메모리를 새로 정의한다.
// 이것을 사용자(가) 정의(한) 데이터 타입 (User-defined data type)이라고 부른다.
// 여기서 사용자란 자바 언어를 사용하는 개발자를 말한다.

// 리팩토링
// - 메서드 추출 : System.out.printf() 는 중복이다.
// - 하나의 메서드는 하나의 기능만을 수행하도록 한다.
// - GRASP 적용하기 (일반적 책임할당 소프트웨어 패턴) (GeneralResponsibilityAssignmentSoftwarePattern)
// ㄴ Information Expert 적용하기
// - Compute()는 App 클래스가 아닌 Score 클래스와 더 관련도가 높다.
// 클래스를 역할에 따라 패키지로 분산 배치하기.
// 보통은 domain, vo, dto 라는 이름을 가진 패키지에 분류한다. 패키지가다르면 modifier 옵션에 따라 접근범위가 달라진다.
// public: 모두공개, protected: 서브클래스와 같은 패키지의 멤버는 접근 가능. (default) 생략면 default이다. 이건 같은 패키지의 멤버에게만
// 공개된다. private는 접근
// 불가다. 그 멤버가 속한 클래스의 내부에서만 접근이 가능하다.

// 마지막. 생성자의 도입
// 인스턴스를 생성할 때 값을 초기화시키는 특별한 메서드다.
// 생성자를 사용자가 정의하는 경우 초기화를 하지 않으면 컴파일러 에러를 발생시킨다. (개발자의 실수를 줄일 수 있다.)
// 생성자는 여러 개를 정의할 수 있다. 파라미터 안 받는 생성자 정의하면 기존처럼 new 명령어 사용 가능하다.
// 생성자를 사용자가 정의하지 않는 경우, 컴파일러가 파라미터 없는 기본 생성자를 자동 추가한다. (아무 행동도 하지 않는)
// 바이트 코드를 보면 public <init>()V 라고 있는 부분이 기본생성자이다.
// 생성자를 정의해서 (String, int, int, int) 파라미터를 받을 때는 바이트코드가 public init(Ljava/lang/String;III)V 로 생성되는
// 것을 볼 수 있다.


public class App {
  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 90, 85);
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80, 70, 65);
    // 생성자에서 compute()를 같이 실행하도록 변경했음.

    s2.kor = 100;
    s2.compute();
    // 값이 변경된다고 compute()가 되는 건 아니므로 다시 명시적으로 수행해야 함.


    printScore(s1);
    printScore(s2);
    printScore(s3);

  }

  // 한 메서드가 하나의 기능을 처리하도록 분리한다.


  private static void printScore(Score s) {

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}
