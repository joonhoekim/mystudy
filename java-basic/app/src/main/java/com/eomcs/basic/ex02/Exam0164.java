// String - mutable vs immutable 객체

// StringBuilder StringBuffer 면접에서 나와서 학습!
// StringBuffer vs StringBuilder

// ThreadBuffer는 한번에 하나의 스레드만 다루게 한다. 그래서 쓰레드 세이프 하다. 대신 그 쓰레드 세이프를 구현하기 위해 성능산의 손해가 있다.



package com.eomcs.basic.ex02;

public class Exam0164 {
  public static void main(String[] args) throws InterruptedException {

    StringBuilder buffer = new StringBuilder();
    // StringBuilder builder = new StringBuilder();
    Worker w1 = new Worker(buffer, "11111111111111111111111111111111111111111111111111");
    Worker w2 = new Worker(buffer, "22222222222222222222222222222222222222222222222222");
    Worker w3 = new Worker(buffer, "33333333333333333333333333333333333333333333333333");
    Worker w4 = new Worker(buffer, "44444444444444444444444444444444444444444444444444");
    Worker w5 = new Worker(buffer, "55555555555555555555555555555555555555555555555555");


    // => Thread 객체의 start를 호출하면 작업 지시를 내린 후 즉시 리턴한다.
    // => Thread 객체에 대해 start()를 호출하면 run() 메서드를 실행시키고 즉시 리턴한다.
    // => 즉 run() 메서드의 작업이 끝날 때 까지 기다리지 않는다.
    w1.start();
    w2.start();
    w3.start();
    w4.start();
    w5.start();

    // 이전에 실행시킨 작업이 끝날때까지
    // 2초정도 기다렸다가 다음 명령을 실행한다.
    Thread.currentThread().sleep(2000);

    System.out.println("실행 끝");
    System.out.println(buffer);

  }


  // 하는 일: 주어진 메세지를 버퍼에 100번 담는 일을 한다.

  static class Worker extends Thread {
    StringBuffer buffer;
    String message;

    public Worker(StringBuilder buffer, String message) {
      this.buffer = buffer;
      this.message = message;

    }

    @Override
    public void run() {
      for (int i = 0; i < 100; ++i) {
        buffer.append(message + "\n");
      }
      System.out.printf("[%s] 메세지 저장 끝\n", message);
    }



  }

}


