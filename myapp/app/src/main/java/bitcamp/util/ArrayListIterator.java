package bitcamp.util;

public class ArrayListIterator<E> implements Iterator<E> {
  //궁금한 점. 여기는 이런 '공통적 변수'를 추상 메서드로 뽑지 않는지? 나중에 리팩토링 대상이 되는건지?
  //어레이리스트에서만 적용되는 내용이라 추상메서드를 안 쓴 것 같네.

  ArrayList<E> list;
  int cursor;

  public ArrayListIterator(ArrayList<E> list) {
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
