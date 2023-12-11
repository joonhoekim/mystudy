package bitcamp.menu;

//메뉴를 실행시킬 때 작업을 수행하는
public interface MenuHandler {

  //의존 객체 Prompt는 필수는 아니게 하자.
  // MenuItem 객체를 다음 규칙에 따라 메서드를 호출할 것이다.
  public abstract void action();

}
