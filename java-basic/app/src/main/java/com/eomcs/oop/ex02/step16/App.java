package com.eomcs.oop.ex02.step16;

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
//

public class App {
  public static void main(String[] args) {
    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();


    // 힙 영역에 선언된 인스턴스는 설계도대로 메모리를 준비
    // 변수는 힙영역에 생성되며 그 주소가 레퍼런스에 저장된다.
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    s1.sum = s1.kor + s1.eng + s1.math;
    s1.aver = (float) s1.sum / 3;

    // 아래 코드에 비해 메서드 추출하면 훨씬 보기 좋다.
    // System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
    // s1.aver);
    // Score.compute(s1);
    // s1.compute(s1); 라고 접근하는 것이 '가능은 한데' 인스턴스 메서드와 혼동되므로 잘못된 것이다.
    // 위 방식은 컴파일러가 인스턴스 메서드를 먼저 찾고 없으면 스태틱 메서드를 찾는다.

    s1.compute();
    // 연산자임을 더 강조하고 싶다. s1.compute(); 가 훨씬 간결하다.
    // i++; 같이 변수와 연산자라는 느낌이 더 강해진다.
    printScore(s1);


    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    s2.sum = s2.kor + s2.eng + s2.math;
    s2.aver = (float) s2.sum / 3;
    s2.compute();
    printScore(s2);


    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    s3.sum = s3.kor + s3.eng + s3.math;
    s3.aver = (float) s3.sum / 3;
    s3.compute();
    printScore(s3);

  }

  // 한 메서드가 하나의 기능을 처리하도록 분리한다.


  private static void printScore(Score s) {

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}
