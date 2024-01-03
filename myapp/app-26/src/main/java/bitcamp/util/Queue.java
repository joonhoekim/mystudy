package bitcamp.util;

public class Queue<E> extends LinkedList<E> {

  public E offer(E value) {
    this.add(this.size(), value);
    return value;
  }

  public E poll() {
    if (this.empty()) {
      return null;
    }
    return remove(0);
  }

  public E peek() {
    if (this.empty()) {
      return null;
    }
    return get(this.size() - 1);
  }

  public boolean empty() {
    if (this.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}
