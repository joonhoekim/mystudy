package bitcamp.myapp;

import bitcamp.util.Prompt;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);
//
//  BoardDao boardDao;
//  BoardDao greetingDao;
//  AssignmentDao assignmentDao;
//  MemberDao memberDao;
//
//  MenuGroup mainMenu;
//
//  ClientApp() {
//    prepareDatabase();
//    prepareMenu();
//  }
//
//  public static void main(String[] args) {
//    System.out.println("[과제관리 시스템]");
//    new ClientApp().run();
//  }
//
//  void prepareDatabase() {
//    try {
//      // JVM이 JDBC 드라이버 파일(.jar)에 설정된대로 자동으로 처리한다.
////      Driver driver = new com.mysql.cj.jdbc.Driver();
////      DriverManager.registerDriver(driver);
//
//      Connection con = DriverManager.getConnection(
//          //"jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
//          "jdbc:mysql://db-ld26e-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");
//      //위 하드코딩은 ONLY FOR 공부용이다! 그래도 GIT에 노출되니 ACL 인바운드 설정함...
//      boardDao = new BoardDaoImpl(con, 1);
//      greetingDao = new BoardDaoImpl(con, 2);
//      assignmentDao = new AssignmentDaoImpl(con);
//      memberDao = new MemberDaoImpl(con);
//
//    } catch (Exception e) {
//      System.out.println("통신 오류!");
//      e.printStackTrace();
//    }
//  }
//
//  void prepareMenu() {
//    mainMenu = MenuGroup.getInstance("메인");
//
//    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
//    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentDao, prompt));
//    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentDao, prompt));
//    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentDao, prompt));
//    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentDao, prompt));
//    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentDao, prompt));
//
//    MenuGroup boardMenu = mainMenu.addGroup("게시글");
//    boardMenu.addItem("등록", new BoardAddHandler(boardDao, prompt));
//    boardMenu.addItem("조회", new BoardViewHandler(boardDao, prompt));
//    boardMenu.addItem("변경", new BoardModifyHandler(boardDao, prompt));
//    boardMenu.addItem("삭제", new BoardDeleteHandler(boardDao, prompt));
//    boardMenu.addItem("목록", new BoardListHandler(boardDao, prompt));
//
//    MenuGroup memberMenu = mainMenu.addGroup("회원");
//    memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
//    memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
//    memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
//    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
//    memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt));
//
//    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
//    greetingMenu.addItem("등록", new BoardAddHandler(greetingDao, prompt));
//    greetingMenu.addItem("조회", new BoardViewHandler(greetingDao, prompt));
//    greetingMenu.addItem("변경", new BoardModifyHandler(greetingDao, prompt));
//    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingDao, prompt));
//    greetingMenu.addItem("목록", new BoardListHandler(greetingDao, prompt));
//
//    mainMenu.addItem("도움말", new HelpHandler(prompt));
//  }


  //서버로 뜯기 위해 추가
  String serverAddress;
  int port;

  void server(String serverAddress) {
    this.serverAddress = serverAddress;
  }

  void setPort(int port) {
    this.port = port;
  }


  void run() {
//    while (true) {
//      try {
//        mainMenu.execute(prompt);
//        prompt.close();
//        break;
//      } catch (Exception e) {
//        System.out.println("예외 발생!");
//      }
//    }
  }

}
