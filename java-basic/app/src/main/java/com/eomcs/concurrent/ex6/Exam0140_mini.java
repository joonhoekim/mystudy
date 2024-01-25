// 스레드 재사용 - 4단계) wait()/notify() 사용
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0140_mini {

  public static void main(String[] args) {

    class MyThread extends Thread {

      int count;

      synchronized void setCount(int count) {
        this.count = count;
        this.notify();
      }

      @Override
      public void run() {

        System.out.println("스레드 시작했음!");
        try {
          while (true) {
            this.wait();
            System.out.println("스레드 대기중...");
            System.out.println("카운트 시작!");
            for (int i = this.count; i > 0; i--) {
              System.out.println("==> " + i);
            }

          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    MyThread t = new MyThread();
    t.start(); // 이 스레드는 main 스레드가 실행하라고 신호를 줄 때까지 기다린다

    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      int count = keyScan.nextInt();
      t.setCount(count);
      if (count == -1) {
        break;
      }

    }

    System.out.println("main 스레드 종료!");
    keyScan.close();
  }
}

