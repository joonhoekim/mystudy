package com.eomcs.oop.ex02.test02.vo;

public class Score {

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }
  // this = 나를 호출한 인스턴스 주소를 지칭한다.

  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float avg;

  public void printScore() {
    System.out.printf("%s, %d, %d, %d, %d, %.2f\n", name, kor, eng, math, sum, avg);
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.avg = this.sum / 3f;
  }
}
