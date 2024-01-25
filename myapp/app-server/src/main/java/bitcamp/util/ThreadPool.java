package bitcamp.util;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool implements Pooling<WorkerThread> {

  List<WorkerThread> list = new ArrayList<>();


  //워커(스레드) 주세요
  @Override
  public WorkerThread get() {
    if (list.size() > 0) {
      System.out.printf("Thread [%s] 꺼내짐", Thread.currentThread().getName());
      return list.remove(0);
    }
    WorkerThread thread = new WorkerThread(this);
    thread.start(); //바로 wait() 부터 한다.
    return thread;
  }

  @Override  //워커(스레드)가 할일을 다 했으니 돌려보냅니다.
  public void revert(WorkerThread thread) {
    list.add(thread);
  }
}
