package bitcamp.myapp;

// ANSI 코드와 App 제목, 메뉴를 저장한 변수를 메서드 안에 두는 대신에
// 클래스 블록 안에 두면
// printMenu()를 호출할 때마다 변수를 만들기 않기 때문에 실행 속도나 메모리 부분에서
// 훨씬 효율적이다.
// 보통 메서드 호출될 때 마다 값이 바뀌는 변수가 아니라 고정 값을 갖는 변수인 경우
// 메서드 밖에 두는 것이 좋다.
public class MainMenu {


  // 애플리케이션 클래스 App을 실행할 때 다음 변수를 미리 준비해 둔다.
  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String[] MENUS_MAIN = {
      ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR,
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      ANSI_RED + "4. 종료" + ANSI_CLEAR
  };
}
