package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    MainMenu.execute();
    Prompt.close();
    //Prompt.keyIn.close(); 으로 하지 말자. 어떤 자원인지 App은 모른다고 가정하자.
    //Information Expert 원칙을 지키자.
    //구체적인 지시를 내려야 한다는 것은 잘못된 것이다. 왜냐? 지시를 받는 쪽이 전문가이기 때문에. 책임을 갖기 때문에.
    //자원의 해제 책임도 그 자원을 가지고 있는 클래스의 책임이다.
    //만약 이렇게 안하면,
    //keyIn 이라는 스캐너 객체(정확히는 레퍼런스) 이름이 바뀌면 App도 다 바꿔야 하는데
    //이런 게 누적되면 유지보수가 어려워진다.

  }
}
