package bitcamp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ThreadConnection {

  // 개별 스레드용 DB 커넥션 저장소
  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
  // 스레드로컬 클래스를 이용하여 풀링 기법을 구현함.
  private String jdbcUrl;
  private String username;
  private String password;

  public ThreadConnection(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection get() throws Exception {
    //현재 스레드에 보관중인 Connection 객체를 꺼내본다.
    Connection con = connectionThreadLocal.get();
    if (con == null) { //보관중인 Connectino 객체가 없는 경우 새로 만든다.
      con = DriverManager.getConnection(jdbcUrl, username, password);
      //현재 스레드에서 커넥션을 나중에 또 사용할 수 있도록 만든 것을 보관한다.
      connectionThreadLocal.set(con);
      System.out.printf("%s: DB 커넥션 생성\n", Thread.currentThread().getName());
    } else {
      System.out.printf("%s: 기존에 보관했던 DB 커넥션을 사용합니다.", Thread.currentThread().getName());
    }
    return con;
  }//You can do it.

  public void remove() {
    Connection con = connectionThreadLocal.get();
    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
      }
      connectionThreadLocal.remove();
      System.out.printf("%s: DB 커넥션 제거\n", Thread.currentThread().getName());
    }

  }
}
