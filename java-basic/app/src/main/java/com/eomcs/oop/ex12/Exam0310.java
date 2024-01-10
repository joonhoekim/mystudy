// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0310 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  public static void main(String[] args) {
    // 로컬 클래스
    // class MyPlayer implements Player {
    // @Override
    // public void play() {
    // System.out.println("실행!");
    // }
    // }
    //
    // testPlayer(new MyPlayer());

    // 이렇게 객체를 하나만 쓸거면 로컬 클래스로 만들어주어야 할 필요가 없다.
    // 익명 클래스로 만들면, 이 클래스는 여기서만 사용된다는 '의도'가 명확히 전달된다.

    // 연습. 로컬클래스 -> 익명클래스 -> 람다식
    // class MyPlayer implements Player {
    // @Override
    // public void play() {
    // System.out.println("실행!");
    // }
    // }

    // 연습.
    testPlayer(() -> {
      System.out.println("Anonymous Class");
    });

    testPlayer(() -> System.out.println("대박주차"));
    testPlayer(() -> System.out.println("element"));
    testPlayer(() -> System.out.println("This is Lambda"));

    // 반대로

    testPlayer(new Player() {
      @Override
      public void play() {
        System.out.println("Hi");
      }
    });

    class Player {
      public void play() {
        System.out.println("Hello");
      }
    }

    Player p = new Player();
    testPlayer(new Player());


  }
}


