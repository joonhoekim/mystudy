package com.eomcs.oop.ex02.step15;

// 사용자 정의 데이터타입 목적의 클래스

public class Score {

  // 인스턴스 변수
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }
  // Compute 메서드는 Score 데이터를 다루는 메서드.
  // 이는 Score 타입의 데이터를 다루는 '연산자'라고 부를 수 있다.
  // 즉 사용자 정의 데이터 타입에 대해서 메서드가 연산자 역할을 한다.
  // 사용자 정의 데이터 타입에 메서드를 정의하는 것은 그 데이터를 다룰 연산자를 정의하는 것과 같다.
  // 사용자 정의 데이터를 다루는 메서드는 그 데이터를 선언한 클래스에 가까이 두는 것이 유지보수에 좋다.
  // 이것은 GRASP 의 Information Expert 원칙에 해당한다.
  // 위 내용은 OOAD 라는 키워드로 스터디하면 알 수 있는 내용이다. 그래서 [객체지향 분석 및 설계]에서는 메서드를 연산자라고 부른다.
}
