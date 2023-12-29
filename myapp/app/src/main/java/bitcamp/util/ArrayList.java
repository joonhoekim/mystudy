package bitcamp.util;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {

  private Object[] objects = new Object[3];

  public void add(E object) {
    if (this.size == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);
      this.objects = Arrays.copyOf(this.objects, newSize);
    }

    this.objects[this.size++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object deleted = this.objects[index];

    System.arraycopy(this.objects, index + 1, this.objects, index, this.size - (index + 1));

    this.objects[--this.size] = null;

    return (E) deleted;
  }

  public boolean remove(E value) {
    for (int i = 0; i < this.size; i++) {
      if (this.objects[i].equals(value)) {
        this.remove(i);
        return true;
      }
    }
    return false;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.objects, this.size);
  }

  public E[] toArray(E[] arr) {
    if (arr.length >= this.size) {
      System.arraycopy(this.objects, 0, arr, 0, this.size);
      return arr;
    }
    return (E[]) Arrays.copyOf(this.objects, this.size, arr.getClass());
  }

  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    return (E) old;
  }

  //1) 외부에서 구현한 패키지 멤버 클래스를 사용하는 경우의 코드이다.
//  @Override
//  public Iterator<E> iterator() {
//    return new ArrayListIterator<E>(this); //this 에 익숙해지자 어렵다고 생각하지 말고!
//  }

  //2) static 중첩 클래스를 사용한 경우
  //ArrayList 클래스만을 위한 이터레이터 클래스라면 중첩클래스를 사용하는게 더 직관적이며 유지보수에 더 유리하다.
  //이것이 중첩 클래스 문법을 사용하는 이유이다.
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>(this); //this 에 익숙해지자 어렵다고 생각하지 말고!
//  }
//
//  private static class IteratorImpl<E> implements Iterator<E> {
//    //궁금한 점. 여기는 이런 '공통적 변수'를 추상 메서드로 뽑지 않는지? 나중에 리팩토링 대상이 되는건지?
//    //어레이리스트에서만 적용되는 내용이라 추상메서드를 안 쓴 것 같네.
//
//    ArrayList<E> list;
//    int cursor;
//
//    public IteratorImpl(ArrayList<E> list) {
//      this.list = list;
//    }
//
//
//    @Override
//    public boolean hasNext() {
//      return cursor >= 0 && cursor < list.size();
//    }
//
//    @Override
//    public E next() {
//      return list.get(cursor++);
//    }
//  }


  //3) non-static iterator (nested class)
  public Iterator<E> iterator() {
    return new IteratorImpl<>(this); //this 에 익숙해지자 어렵다고 생각하지 말고!
  }

  private static class IteratorImpl<E> implements Iterator<E> {
    //궁금한 점. 여기는 이런 '공통적 변수'를 추상 메서드로 뽑지 않는지? 나중에 리팩토링 대상이 되는건지?
    //어레이리스트에서만 적용되는 내용이라 추상메서드를 안 쓴 것 같네.

    ArrayList<E> list;
    int cursor;

    public IteratorImpl(ArrayList<E> list) {
      this.list = list;
    }


    @Override
    public boolean hasNext() {
      return cursor >= 0 && cursor < list.size();
    }

    @Override
    public E next() {
      return list.get(cursor++);
    }
  }


}
