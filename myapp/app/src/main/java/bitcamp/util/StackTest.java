package bitcamp.util;

public class StackTest {

  public static void main(String... args) {
    Stack<String> stack = new Stack<>();
    stack.push(new String("aaa"));
    stack.push(new String("bbb"));
    stack.push(new String("ccc"));
    stack.push(new String("ddd"));
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
//    System.out.println(stack.pop());

  }
}
