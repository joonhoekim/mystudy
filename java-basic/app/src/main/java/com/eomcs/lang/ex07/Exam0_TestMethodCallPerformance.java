package com.eomcs.lang.ex07;

public class Exam0_TestMethodCallPerformance {
  public static void main(String[] args) {
    long startTime = System.nanoTime();

    // (int i = 0; i < 1_000_000_000; i++) {
    for (int i = 0; i < 100; i++) {
      simpleMethod();
    }

    long endTime = System.nanoTime();
    long duration = (endTime - startTime); // 단위는 나노

    System.out.println("Elapsed Time: " + duration + " nanoseconds");
    long msduration = duration / 1_000_000;
    System.out.println("Elapsed Time: " + msduration + " milliseconds");

  }

  public static void simpleMethod() {
    // 아무 동작도 수행하지 않는 간단한 메서드
  }
}

// nano는 1E-9를 나타내는 단위이다.
// milli는 1E-3 이므로
// ms변환은 ns * 10^6

// 1billion 번 메서드 호출하는 것에 겨우 3 밀리세컨드 걸린다
// 리팩터링을 성능때매 안한다는 건 미친짓이다.
