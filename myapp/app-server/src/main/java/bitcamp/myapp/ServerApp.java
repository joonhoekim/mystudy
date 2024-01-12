package bitcamp.myapp;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.json.AssignmentDaoImpl;
import bitcamp.myapp.dao.json.BoardDaoImpl;
import bitcamp.myapp.dao.json.MemberDaoImpl;
import bitcamp.util.Prompt;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  Prompt prompt = new Prompt(System.in);

  BoardDao boardDao = new BoardDaoImpl("board.json");
  BoardDao greetingDao = new BoardDaoImpl("greeting.json");
  AssignmentDao assignmentDao = new AssignmentDaoImpl("assignment.json");
  MemberDao memberDao = new MemberDaoImpl("member.json");

  public static void main(String[] args) {
    System.out.println(new File(".").getAbsolutePath());
    new ServerApp().run();
  }

  void run() {
    System.out.println("[과제관리 서버 시스템]");

    try {
      // 1) 네크워크 연결을 위해서, 랜카드의 연결 정보를 객체로 만들어서 준비한다.
      // => 랜카드를 통해 네트워크와 연결되는 작업을 수행하는 것은 OS이다.
      // => JVM은 OS가 작업하여 연결된 결과를 가져오는 것이다.
      // 이는 new Server(portNumber) 형태인데, 포트 번호는 랜카드를 통해 데이터를 들여올 때 고유한 번호이다.

      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("서버 실행 중...");

      System.out.println("클라이언트 연결을 기다리는 중");
      Socket socket = serverSocket.accept();
      System.out.println("대기목록에서 클라이언트 연결정보를 꺼냈음!");

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      System.out.println("IO Stream Ready!");

//      System.out.println("Waiting 10 sec");
//      Thread.sleep(10000);

      System.out.println("Client가 보낸 데이터 읽기 시작");
      String dateName = in.readUTF();
      String command = in.readUTF();
      String value = in.readUTF();
      System.out.printf("%s\n%s\n%s", dateName, command, value);

//      System.out.println("10초 동안 잠시 기다립니다.");
//      Thread.sleep(10000);

      String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
          .toJson(boardDao.findAll());

      out.writeUTF(json);
      System.out.println("클라이언트에게 데이터를 전송했습니다.");

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("통신 예외발생 ");

    }
  }

}
