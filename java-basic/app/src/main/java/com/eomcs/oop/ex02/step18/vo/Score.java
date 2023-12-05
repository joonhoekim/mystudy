package com.eomcs.oop.ex02.step18.vo;

// 사용자 정의 데이터타입 목적의 클래스
// public modifier로 다른 패키지에서 접근가능하도록 명령
public class Score {
  // public Score() {}

  // 데이터를 표현하는 경우 DTO 라고 한다.?
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  // 이런식으로 초기 세팅을 메서드로 하다보니 생성자라는 문법이 도입된다.
  public void init(String name, int kor, int eng, int math) {
    this.name = name; // 여기서 this 가 없으면 파라미터의 name 만이 대상이 된다.
    this.kor = kor; // 파라미터를 name 이 아닌 다른 이름으로 지으면 생략해도 this를 컴파일러가 자동으로 붙여준다.
    this.eng = eng; // 당연히 생성자는 가독성이 좋게 this 명시하고 파라미터와 동일 변수명을 쓰는 게 좋다.
    this.math = math;
    this.compute();
  }

  // 생성자는클래스이름과 같아야하며, 리턴타입은 없으며, new 명령을 실행할 때문 호출할 수 있다. 나중에 따로 호출 불가)
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }
  // 사용자가 생성자 정의하지 않으면 public Score(){} 와 같이 파라미터 없고 하는 행동도 없는 생성자가 추가된다.(컴파일러가 추가)

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
  // this가 생략되면 로컬변수가 없을 때 자동으로 붙여준다.
  // 근데 좋은 습관은 아니다. 이게 this 내장변수에 대한 것인지, 클래스의 로컬 변수에 대한 것인지 파악해야 하니까.

  // Compute 메서드는 Score 데이터를 다루는 메서드.
  // 이는 Score 타입의 데이터를 다루는 '연산자'라고 부를 수 있다.
  // 즉 사용자 정의 데이터 타입에 대해서 메서드가 연산자 역할을 한다.
  // 사용자 정의 데이터 타입에 메서드를 정의하는 것은 그 데이터를 다룰 연산자를 정의하는 것과 같다.
  // 사용자 정의 데이터를 다루는 메서드는 그 데이터를 선언한 클래스에 가까이 두는 것이 유지보수에 좋다.
  // 이것은 GRASP 의 Information Expert 원칙에 해당한다.
  // 위 내용은 OOAD 라는 키워드로 스터디하면 알 수 있는 내용이다. 그래서 [객체지향 분석 및 설계]에서는 메서드를 연산자라고 부른다.
}
