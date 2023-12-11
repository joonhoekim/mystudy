package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.menu.BoardAddHandler;
import bitcamp.myapp.menu.BoardDeleteHandler;
import bitcamp.myapp.menu.BoardListHandler;
import bitcamp.myapp.menu.BoardMenuHandler;
import bitcamp.myapp.menu.BoardModifyHandler;
import bitcamp.myapp.menu.BoardRepository;
import bitcamp.myapp.menu.BoardViewHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();
    //아래는 컴포지트 패턴을 적용한 결과이다.
    //기존코드를 손대지 않고 기능을 추가할 수 있게 된 것이다.
    //SOLID->OpenClosed Principle

    BoardRepository boardRepository = new BoardRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
//    MenuItem assignmentAddMenu = new MenuItem("등록");
//    assignmentMenu.add(assignmentAddMenu);
    assignmentMenu.add(new MenuItem("등록"));
    assignmentMenu.add(new MenuItem("조회"));
    assignmentMenu.add(new MenuItem("변경"));
    assignmentMenu.add(new MenuItem("삭제"));
    assignmentMenu.add(new MenuItem("목록"));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    mainMenu.add(boardMenu);

    // 사욪ㅇ자로부터 게시글 입력 받아서 배열에 저장하는 일을 한다.
    MenuHandler boardAddHander = new BoardMenuHandler();
    // 등록이라는 메뉴를 선택했을 때 boardaddhandler를 실행시키는 일을 한ㄷ.ㅏ
    MenuItem boardAddMenu = new MenuItem("등록", boardAddHander);
    //게시글 등록을 처맇하는 메뉴를 게시글 메뉴에 추가한ㄷ.
    boardMenu.add(boardAddMenu);
    //위 3라인을 한 라인으로 줄이면 아래가 된다.

    boardMenu.add(new MenuItem("등록", new BoardAddHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler()));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler()));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler()));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenu.add(memberMenu);
    memberMenu.add(new MenuItem("등록"));
    memberMenu.add(new MenuItem("조회"));
    memberMenu.add(new MenuItem("변경"));
    memberMenu.add(new MenuItem("삭제"));
    memberMenu.add(new MenuItem("목록"));

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    mainMenu.add(greetingMenu);
    greetingMenu.add(new MenuItem("등록"));
    greetingMenu.add(new MenuItem("조회"));
    greetingMenu.add(new MenuItem("변경"));
    greetingMenu.add(new MenuItem("삭제"));
    greetingMenu.add(new MenuItem("목록"));

    MenuGroup helpMenu = new MenuGroup("도움말");
    mainMenu.add(helpMenu);

    mainMenu.execute(prompt);

    prompt.close();
  }
}
