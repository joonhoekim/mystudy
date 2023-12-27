package bitcamp.util;

public class LinkedList {

  private Node first;
  private Node last;
  private int size;
//  Node next;

  public void add(Object value) {
    Node node = new Node();
    node.value = value;

    if (last == null) {
      //last 인스턴스가 없는 경우 빈 것이므로 만든다.
      this.first = this.last = node;
    } else {
      //기존 노드객체 있을 때,
      //마지막 노드의 다음 노드로, 새로 만든 노드 인스턴스를 연결해준다.
      this.last.next = node;
      this.last = node;
    }
    ++size;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node node = first;
//    for (int i = 0; i < size; ++i) {
//      arr[i] = node.value;
//      node = node.next;
//    }
    int index = 0;

    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }

    return arr;
  }

  public Object get(int index) throws IndexOutOfBoundsException /*SKIP ABLE*/ {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid Index"); //RuntimeException:Unchecked Exception.
    }
    int cursor = 0;
    Node node = first;
    while (cursor++ < index) {
      node = node.next;
    }
    return node.value;
  }

}
