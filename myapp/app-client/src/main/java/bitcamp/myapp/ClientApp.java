package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoProxyGenerator;
import bitcamp.myapp.dao.MemberDao;
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
import bitcamp.util.Prompt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  BoardDao boardDao;
  BoardDao greetingDao;
  AssignmentDao assignmentDao;
  MemberDao memberDao;

  MenuGroup mainMenu;

  Socket socket;
  DataInputStream in;
  DataOutputStream out;

  ClientApp() {
    prepareNetwork();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[과제관리 시스템]");
    new ClientApp().run();
  }

  void prepareNetwork() {
    try {
      this.socket = new Socket("localhost", 8888);
      System.out.println("서버와 연결되었음!");

      this.in = new DataInputStream(socket.getInputStream());
      this.out = new DataOutputStream(socket.getOutputStream());

      // 네트워크 DAO 구현체 준비
//      boardDao = new BoardDaoImpl("board", in, out);
//      greetingDao = new BoardDaoImpl("greeting", in, out);
//      assignmentDao = new AssignmentDaoImpl("assignment", in, out);
//      memberDao = new MemberDaoImpl("member", in, out);

      // 개별 DAO 구현체를 대체하는 ProxyGenerator 적용
      DaoProxyGenerator daoProxyGenerator = new DaoProxyGenerator(in, out);
      boardDao = daoProxyGenerator.create(BoardDao.class, "board");
      greetingDao = daoProxyGenerator.create(BoardDao.class, "greeting");
      assignmentDao = daoProxyGenerator.create(AssignmentDao.class, "assignment");
      memberDao = daoProxyGenerator.create(MemberDao.class, "member");

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentDao, prompt));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentDao, prompt));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentDao, prompt));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentDao, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentDao, prompt));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(boardDao, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(boardDao, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(boardDao, prompt));
    boardMenu.addItem("삭제", new BoardDeleteHandler(boardDao, prompt));
    boardMenu.addItem("목록", new BoardListHandler(boardDao, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingDao, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingDao, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingDao, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingDao, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingDao, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);

        //서버와 연결을 끊고 종료하기
        prompt.close();
        close();

        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }

  void close() {
    try (Socket socket = this.socket;
        DataInputStream in = this.in;
        DataOutputStream out = this.out;) {
      out.writeUTF("quit");
      System.out.println("종료 요청함");
      System.out.println("서버 응답: " + in.readUTF());
    } catch (Exception e) {
      e.printStackTrace();
      //서버와 연결이 끊어진 경우에 발생한 예외는 따로 처리할 것이 없다.
    }
  }

}
