package bitcamp.util;

import java.util.Arrays;

public class ArrayList_O<E> extends AbstractList<E> {

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
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>(); //여기서 자동으로 생성자에 this 넘어간다. (외부클래스 주소로 this$0 이다.)
//  }
//
//  private class IteratorImpl<E> implements Iterator<E> {
//    //궁금한 점. 여기는 이런 '공통적 변수'를 추상 메서드로 뽑지 않는지? 나중에 리팩토링 대상이 되는건지?
//    //어레이리스트에서만 적용되는 내용이라 추상메서드를 안 쓴 것 같네.
//
//    //ArrayList this$0; 자동으로 만든다. non static nested class
//    //this$0 라고 사용하지 않고 바깥 클래스의 이름을 쓰고 거기에 this 붙이면 된다.
//    int cursor;
//
//    //아래 생성자로 받아올 필요도 없다. non-static
////    public IteratorImpl(ArrayList<E> list) {
////      this.list = list;
////    }
//  @Override
//  public boolean hasNext() {
//    return cursor >= 0 && cursor < ArrayList.this.size();
////      return false;
//  }
//
//  @Override
//  public E next() {
//    return (E) ArrayList.this.get(cursor++);
//  }
//}

  //  4) Local Class - 로컬 클래스
  // 특정 메서드 안에
//  public Iterator<E> iterator() {
//    /*private*/
//    class IteratorImpl<E> implements Iterator<E> { //로컬클래스는 private modifier 불가
//
//      int cursor;
//
//      @Override
//      public boolean hasNext() {
//        return false;
//      }
//
//      @Override
//      public E next() {
//        return null;
//      }
//
//    }
//
//    return new IteratorImpl<>(); //여기서 자동으로 생성자에 this 넘어간다. (외부클래스 주소로 this$0 이다.)
//  }

  //5) 로컬클래스 -> 익명 클래스로 만들기
//  public Iterator<E> iterator() {
//    /*private*/
//    Iterator<E> obj = new Iterator<E>() { //익명클래스는 이름이 없기 때문에, 정의하는 즉시 인스턴스를 생성해야 한다. class, implements 같은 키워드도 사용 불가
//      //이터레이터 인터페이스를 구현한 클래스를 즉시 인스턴스화한다. 생성자는 슈퍼클래스를 쓰겠다. 라는 의미다.
//      //중괄호 내부가 상속받은 익명클래스의 내용이다.
//      //익명클래스를 즉시 new로 만들고
//      //레퍼런스 변수인 obj에 넣고
//      //그걸 return 하는 것이 로컬클래스 - 익명클래스로 간결하게 사용한 것
//
//      int cursor;
//
//      @Override
//      public boolean hasNext() {
//        return false;
//      }
//
//      @Override
//      public E next() {
//        return null;
//      }
//
//    };
//
//    return obj; //여기서 자동으로 생성자에 this 넘어간다. (외부클래스 주소로 this$0 이다.)
//  }

  //6) 더... 더.. 간결하게 표현하기
  public Iterator<E> iterator() {
    /*private*/
    return new Iterator<E>() { //익명클래스는 이름이 없기 때문에, 정의하는 즉시 인스턴스를 생성해야 한다. class, implements 같은 키워드도 사용 불가
      //이터레이터 인터페이스를 구현한 클래스를 즉시 인스턴스화한다. 생성자는 슈퍼클래스를 쓰겠다. 라는 의미다.
      //중괄호 내부가 상속받은 익명클래스의 내용이다.
      //익명클래스를 즉시 new로 만들고
      //레퍼런스 변수인 obj에 넣고
      //그걸 return 하는 것이 로컬클래스 - 익명클래스로 간결하게 사용한 것

      int cursor;

      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public E next() {
        return null;
      }

    };

  }


}
