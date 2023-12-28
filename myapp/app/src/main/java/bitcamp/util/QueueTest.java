package bitcamp.util;

public class QueueTest {

  public static void main(String... args) {
    Queue<String> queue = new Queue<>();
    queue.offer(new String("aaa"));
    queue.offer(new String("bbb"));
    queue.offer(new String("ccc"));
    queue.offer(new String("ddd"));
    for (int i = 0; i < 100_000_000; i++) {
      queue.offer(new String("ddd"));
    }
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
//    System.out.println(stack.pop());

  }
}
