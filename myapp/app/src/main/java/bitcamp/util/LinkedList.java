package bitcamp.util;

public class LinkedList {

  Node first;
  Node last;
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
      last.next = node;
      last = node;

    }


  }

}
