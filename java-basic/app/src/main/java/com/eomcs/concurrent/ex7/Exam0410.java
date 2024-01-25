// Executors 태스크 프레임워크 - 스레드풀 종료 : shutdown()
package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Exam0410 {

  static class MyRunnable implements Runnable {
    int millisec;

    public MyRunnable(int millisec) {
      this.millisec = millisec;
    }

    @Override
    public void run() {
      try {
        System.out.printf("[%d] %s 스레드 실행 중...\n", this.millisec, Thread.currentThread().getName());

        Thread.sleep(millisec);

        System.out.printf("[%d] %s 스레드 종료!\n", this.millisec, Thread.currentThread().getName());

      } catch (Exception e) {
        System.out.printf("[%d] %s 스레드 실행 중 오류 발생!\n", this.millisec,
            Thread.currentThread().getName());
      }
    }
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    ThreadPoolExecutor tp = new ThreadPoolExecutor();

    executorService.execute(new MyRunnable(6000));
    executorService.execute(new MyRunnable(2000));
    executorService.execute(new MyRunnable(4000));
    executorService.execute(new MyRunnable(4000));
    executorService.execute(new MyRunnable(4000));
    executorService.execute(new MyRunnable(4000));

    // => 더이상 작업 요청을 받지 말고
    // 이전에 요청한 작업(대기하고 있는 작업)들이 완료되면
    // 스레드를 종료하도록 예약한다.
    // => 작업 중인 스레드가 Not Runnable 상태가 아니라면
    // 작업이 끝날 때까지 기다린다.
    executorService.shutdown();

    // 작업 요청을 거절한다.
    // => 예외 발생!
    // main thread 가 종료되고, jvm은 다른 스레드가 있으므로 기다린다.
    // printStackTrace() 호출되지 않아도 jvm이 예외를 받긴 했으니까 콘솔에 던져준다.
    executorService.execute(new MyRunnable(4000));


    System.out.println("main() 종료!");
  }
}

