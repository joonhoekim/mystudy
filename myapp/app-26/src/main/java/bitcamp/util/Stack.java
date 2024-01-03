package bitcamp.util;

public class Stack<E> extends LinkedList<E> {

  private Node<E> first;
  private Node<E> last;

  public E push(E value) {
    this.add(value);
    return value;
  }

  public E peek() {
    return this.get(this.size() - 1);
    //메서드로 접근하건 protected 변수에 직접접근하건 동일하나 메서드로 접근하는 습관이 있으면 변수명 바뀌어도 그대로 쓸 수 있음
  }

  public E pop() {
    return this.remove(this.size() - 1);
  }

  public boolean empty() {
    if (this.size() == 0) {
      return true;
    }

    return false;
  }


  private static class Node<E> {

    E value;
    Node<E> next;
  }

}
