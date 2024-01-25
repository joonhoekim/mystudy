package bitcamp.util;

public class WorkerThread extends Thread {

  Pooling<WorkerThread> pool;
  Worker worker;

  public WorkerThread(ThreadPool pool) {
    this.pool = pool;
  }

  synchronized public void setWorker(Worker worker) {
    this.worker = worker;
    this.notify();
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (this) {
          this.wait();
          //예외발생시 스레드를 더이상 사용불가하므로 catch로 나가서 while문 나감.
        }

        try {
          worker.play();
        } catch (Exception e) {
          // throw new RuntimeException(e);
          e.printStackTrace();
          //play()에서 문제가 발생하는 경우는 스레드를 계속 사용할 수 있으므로 다시 while문으로 들어감
        }

        //작업 다 했으면 pool로 돌아가기
        pool.revert(this);
        //상호참조(쌍방참조)해버렸다. 나뿐짓이야.. 유지보수에 굉장히 안좋다. 연결을 끊어야 한다.
        //연결 끊는 방법? I/F 만들고 그 인터페이스로 연결 끊기

      }
    } catch (InterruptedException e) {
      // throw new RuntimeException(e);
      e.printStackTrace();
    }


  }

}