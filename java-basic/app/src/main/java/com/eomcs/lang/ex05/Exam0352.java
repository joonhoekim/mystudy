package com.eomcs.lang.ex05;

// # 비트 연산자 & 를 이용하여 % 연산 구현하기 응용 I
//
public class Exam0352 {
  public static void main(String[] args) {

    double time1 = 0, time2 = 0, time3 = 0;
    // % 연산자를 이용하여 짝수/홀수 알아내기
    time1 = System.currentTimeMillis();
    System.out.println(1010101010 % 2 == 0 ? "짝수" : "홀수");
    time2 = System.currentTimeMillis();
    time3 = time2 - time1;
    System.out.printf("%05.10f\n", time3);

    // & 연산자를 이용하여 짝수/홀수 알아내기
    time1 = System.currentTimeMillis();
    System.out.println((1010101010 & 0x1) == 0 ? "짝수" : "홀수");
    time2 = System.currentTimeMillis();
    time3 = time2 - time1;
    System.out.printf("%05.10f\n", time3);

  }
}

