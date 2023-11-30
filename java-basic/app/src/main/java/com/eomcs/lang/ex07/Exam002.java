package com.eomcs.lang.ex07;

import java.util.Scanner;



// # 메서드 : 사용 전
//
public class Exam002 {

  static void printSpaces(int spaceLen) {
    // 별 앞에 공백 출력
    int spaceCnt = 1;
    while (spaceCnt <= spaceLen) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static int getSpaceLen(int len, int starLen) {
    return (len - starLen) / 2;
  }

  static void printStars(int starLen) {
    // 별 출력
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.print("*");
      starCnt++;
    }
  }

  static int promptCall(String title) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(title);
    int len = keyScan.nextInt();
    keyScan.close();
    return len;
  }


  public static void main(String[] args) {
    // 밑변의 길이를 구한다.
    int len = promptCall("밑변의 길이? ");
    // 밑변 길이에 따라 공백 및 *를 출력한 후 줄을 바꾼다. 이를 반복한다.
    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(getSpaceLen(len, starLen));
      printStars(starLen);
      // 출력 줄 바꾸기
      System.out.println();

    }
  }


}
