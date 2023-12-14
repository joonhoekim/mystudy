package bitcamp.myapp;

import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentRepository;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardRemoveHandler;
import bitcamp.myapp.handler.board.BoardRepository;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.help.HelpHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.myapp.menu.MenuGroup;
import bitcamp.myapp.menu.MenuItem;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class App {

  //핸들러 사용으로 전환

  public static void main(String[] args) {

    //기본적으로 필요한 프롬프트 객체 먼저 생성한다.
    Prompt prompt = new Prompt(System.in);

    //new MainMenu(prompt).execute();
    //이젠 위 주석처럼 하지 말고, 메뉴 그룹 객체들을 인스턴스로 생성해서 메뉴와 App의 결합을 느슨하게 하자.

    //정보를 저장할 객체는 MainGroup.add()에서 받는 파라미터이니 만들어준다.
    BoardRepository boardRepository = new BoardRepository();

    //메뉴를 여기서 직접 만든다. (이게 가장 낫다고 검증되었기에 쓰는 거다. 컴포지트 패턴.)

    //MainGroup => 메인, 게시판, 과제, 가입인사들같이 메뉴를 포함하는 메뉴 그룹 객체들을 여기서 만든다.
    //App과 강하게 결합된 OOOMenu 클래스가 싫기 때문에 사람들이 고민해서 만든 것이다!!
    //결합이 왜 싫나? 뭔가 변경이 생기면 이 클래스, 저 클래스 다 뜯어고쳐야 하는 게 싫은거다.
    //기능 하나를 고치는 거면 그 기능에 관련된 클래스들, 가능하면 딱 하나만 고치고 싶은거다.
    //이걸 줄여말하면 '유지보수 편하게 하고 싶다'
    MenuGroup mainMenu = new MenuGroup("메인");
    //아래 위 왔다갔다 읽지 않고 바로 편하게 일도록, 밑에 하위 메뉴들을 작성해주자.
    //mainMenu.add(여기에는 MenuItem 객체가 들어간다.);

    MenuGroup boardMenu = new MenuGroup("게시판");
    //메뉴그룹.add()<-메뉴아이템(타이틀 및 핸들러)<-핸들러가 받을 리포주소 및 프롬프트
    BoardAddHandler boardAddHandler = new BoardAddHandler(boardRepository, prompt);
    MenuItem boardAddMenu = new MenuItem("등록", boardAddHandler);
    boardMenu.add(boardAddMenu);
    //이 메뉴 정의는 다시 참조하지 않는, 단 한번 쓰는 인스턴스들로 작성되므로 아래처럼 줄일 수 있다.\
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("수정", new BoardModifyHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("삭제", new BoardRemoveHandler(prompt, boardRepository)));
    //boardMenu가 전부 정의되면 mainMenu에 추가해준다.
    mainMenu.add(boardMenu);

    AssignmentRepository assignmentRepository = new AssignmentRepository();
    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository)));
    assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("수정", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("삭제", new AssignmentAddHandler(assignmentRepository, prompt)));
    mainMenu.add(assignmentMenu);

    ObjectRepository memberRepository = new ObjectRepository();
    MenuGroup memberMenu = new MenuGroup("과제");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("수정", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("삭제", new MemberAddHandler(memberRepository, prompt)));
    mainMenu.add(memberMenu);

    BoardRepository greetingBoardRepository = new BoardRepository();
    MenuGroup greetingBoardMenu = new MenuGroup("가입인사 게시판");
    //메뉴그룹.add()<-메뉴아이템(타이틀 및 핸들러)<-핸들러가 받을 리포주소 및 프롬프트

    greetingBoardMenu.add(greetingBoardMenu);
    //BoardAddHandler boardAddHandler = new BoardAddHandler(boardRepository, prompt);
    //MenuItem boardAddMenu = new MenuItem("등록", boardAddHandler);
    //ㄴ 한문장으로 처리하지 않으면 재사용시 변수명도 다시 잡아줘야한다!! 한문장이 더 낫다!!
    greetingBoardMenu.add(new MenuItem("등록", new BoardAddHandler(greetingBoardRepository, prompt)));
    greetingBoardMenu.add(new MenuItem("목록", new BoardListHandler(greetingBoardRepository)));
    greetingBoardMenu.add(
        new MenuItem("조회", new BoardViewHandler(prompt, greetingBoardRepository)));
    greetingBoardMenu.add(
        new MenuItem("수정", new BoardModifyHandler(prompt, greetingBoardRepository)));
    greetingBoardMenu.add(
        new MenuItem("삭제", new BoardRemoveHandler(prompt, greetingBoardRepository)));
    //boardMenu가 전부 정의되면 mainMenu에 추가해준다.
    mainMenu.add(greetingBoardMenu);

    MenuItem helpMenu = new MenuItem("도움말", new HelpHandler());
    mainMenu.add(helpMenu);

    //실행한다.
    mainMenu.execute(prompt);

    prompt.close();
  }
}
