package com.eomcs.lang.ex07;

import java.util.Scanner;

// # 메서드 : 사용 전
//
public class Exam001 {

  static void printSpaces(int spaceLen/* argument */) {
    // 별 앞에 공백 출력
    int spaceCnt = 1;
    while (spaceCnt <= spaceLen) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStars(int starLen) {
    // 별 출력
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.print("*");
      starCnt++;
    }
  }

  static int computeSpaceLength(int len, int starLen) {
    return (len - starLen) / 2;
  }

  static int promptInt(String title) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(title);
    int len = keyScan.nextInt();
    keyScan.close();
    return len;
  }

  public static void main(String[] args) {


    int len = promptInt("밑변의 길이? ");
    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(computeSpaceLength(len, starLen)/* parameter */);
      printStars(starLen);
      System.out.println();
    }
    // 메서드 호출하는 건 쿼리
    // 파라미터를 던져줄 때도 쿼리를 만들어주는 메서드를 만드는 것이리팩터링기법중하나

  }

  // 출력 줄 바꾸기

}
