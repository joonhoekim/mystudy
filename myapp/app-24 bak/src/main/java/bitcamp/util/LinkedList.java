package bitcamp.util;

public class LinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  public int size() {
    return size;
  }

  //  Node next;

  public void add(E value) {
    Node<E> node = new Node<E>();
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
    Node<E> node = first;
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

  public E get(int index) throws IndexOutOfBoundsException /*SKIP ABLE*/ {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid Index"); //RuntimeException:Unchecked Exception.
    }
    int cursor = 0;
    Node<E> node = first;
    while (cursor++ < index) {
      node = node.next;
    }
    return node.value;
  }

  public E set(int index, Object value) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    int cursor = 0;
    Node<E> node = first;
    while (cursor++ < index) {
      node = node.next;
    }
    E old = node.value;
    node.value = value;

    return old;
  }

  public void add(int index, Object value) {
    if (index > size || index < 0) { //here, size==index is valid! new 'last'
      throw new IndexOutOfBoundsException();
    }

    Node<E> node = new Node<>();
    node.value = value;

    if (index == 0) {
      if (first == null) {
        first = last = node;
        return;
      }
      node.next = first;
      first = node;
    } else if (index == size) {
      last.next = node;
      last = node;
    } else {
      Node currNode = first;
      int cursor = 0;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }
    //size
    ++size;
  }
  //아래는 내가 처음 작성했던 것... 위가 아주 깔-끔하다..
  //index==0
//    if (index == 0) {
//      Node tempNode = first;
//      this.first = node;
//      first.next = tempNode;
//      if (this.last == null) {
//        this.last = this.first;
//      }
//    }

//    //0<index<size
//    if (index < size) {
//      //Move to the index
//      Node moveNode = first;
//      int cursor = 0;
//      while (cursor++ < index) {
//        moveNode = moveNode.next;
//      }
//      Node tempNode = moveNode;
//      moveNode.next = node;
//
//    }
//
//    //index==size
//    if (index == size) {
//      this.last.next = node;
//      this.last = node;
//    }


  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid Index");
    }

    E deleted;

    //index==0
    if (index == 0) {
      if (first.next == null) {
        deleted = first.value;
        first = last = null;
      } else {
        deleted = first.value;
        first = first.next;
      }
    } else if (index == size - 1) {
      int cursor = 0;
      Node currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      deleted = last;
      last = currNode;
    } else { //index != 0 || index != size-1
      int cursor = 0;
      Node currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      deleted = currNode.next.value;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode; //아 이 부분 주요관전포인트네 이거 빼먹나 안빼먹나
      }
    }

    --size;
    return deleted;
  }

  public boolean remove(E value) {
    Node node = first;
    for (int i = 0; i < size; i++) {
      if (node.value.equals(value)) {
        remove(i);
        break;
      }

    }


  }

  private static class Node<E> { //이 클래스에서 소속된 클래스이다. (중첩클래스라서 !!)

    E value; //모든 값 담기 가능. Assignment, Board, Member....
    Node<E> next; //레퍼런스 변수
  }


}
