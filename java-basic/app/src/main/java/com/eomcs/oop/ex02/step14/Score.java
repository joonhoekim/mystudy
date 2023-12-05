package com.eomcs.oop.ex02.step14;

// 사용자 정의 데이터타입을 만드려는 클래스이다.
// - 특정 유형의 데이터를 담을 전용 메모리(변수)를 설계하는 것이다.
// - 학생 데이터를 묶음으로 다룰 수 있도록 변수 그룹을 정의한다.

public class Score {

  // 데이터를 개별적으로 다룰 예정이므로 인스턴스 변수로 선언한다.
  // 아래 메모리는 new 명령어로 Heap 영역에 생성되는 메모리이다.
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
}
