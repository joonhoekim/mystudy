package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    String[] test = new String[3];
    System.out.println(list.first.value);
    System.out.println(list.first.next.value);
    System.out.println(list.first.next.next.value);
    System.out.println(list.last.value);


  }
}
