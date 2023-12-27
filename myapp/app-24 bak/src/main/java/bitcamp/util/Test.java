package bitcamp.util;

public class Test {

  public static void main(String... args) {
    LinkedList list = new LinkedList();
    list.add(new String("a"));
    list.add(new String("B"));
    list.add(new String("ca"));
    list.add(new String("D"));
    list.add(0, new String("xxx"));
    list.add(5, new String("hihi"));

    list.add(5, new String("1111"));

    list.add(5, new String("222"));

    list.add(5, new String("333"));
    list.add(5, new String("InsertedtTo5"));

//    System.out.println(list.get(0));
//    System.out.println(list.get(1));
//    System.out.println(list.get(2));
//    System.out.println(list.get(3));
//    System.out.println(list.get(4));

    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.printf("%s, ", value);
    }

    System.out.print("\n");
    list.remove(0);
    list.remove(1);
    list.remove(2);
    list.remove(0);
    list.remove(0);
    list.remove(0);
    list.remove(0);
    list.remove(0);
    list.remove(0);

    Object[] arrAfterRemove = list.toArray();
    for (Object value : arrAfterRemove) {
      System.out.printf("%s, ", value);
    }
  }

}
