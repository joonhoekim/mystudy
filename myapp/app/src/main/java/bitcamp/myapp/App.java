package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.handler.HelpHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) throws Exception {

    float f = 9_000_000_000_000_000_000L; //9 * 10^18 ... 2^63
    int i = 1_000_000_000; // 2.147 * 10^9 ... 2^31

    Prompt prompt = new Prompt(System.in);

    ArrayList<Board> boardRepository = new ArrayList<>();
    ArrayList<Assignment> assignmentRepository = new ArrayList<>();
    ArrayList<Member> memberRepository = new ArrayList<>();
    ArrayList<Board> greetingRepository = new ArrayList<>();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository, prompt)));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository, prompt)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("변경", new MemberModifyHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository, prompt)));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem("등록", new BoardAddHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("조회", new BoardViewHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("변경", new BoardModifyHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("삭제", new BoardDeleteHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("목록", new BoardListHandler(greetingRepository, prompt)));
    mainMenu.add(greetingMenu);

    mainMenu.add(new MenuItem("도움말", new HelpHandler(prompt)));

    //프로그램을 실행하다가 어느 지점에서 예외가 발생하면 해당 지점에서 적절한 조치를 취하는게 맞다.
    //다만 혹시라도 적절한 조치를 받지 못하는 예외가 있을 경우 그 예외가 JVM에게 가지 않도록 하기 위해 main()에서도 예외를 처리해줘야 한다.
    //main()에서도 막지 않으면 JVM에게 보고될 것이고
    //JVM은 개발자나 알아볼 메세지를 출력하며 종료할 것이고
    //그러면 클라이언트들은 화가 많이 날 것이다.
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
      } catch (Exception e) {
        System.out.println("예외가 발생하였습니다. 잠시 후 다시 시도하시기 바랍니다.");
      }
    }

  }
}
