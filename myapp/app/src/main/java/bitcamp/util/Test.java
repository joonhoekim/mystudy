package bitcamp.util;

public class Test {

  public static void main(String... args) {
    LinkedList list = new LinkedList();
    list.add(new String("a"));
    list.add(new String("B"));
    list.add(new String("ca"));
    list.add(new String("D"));

    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.println(value);
    }
  }

}
