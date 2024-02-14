package bitcamp.util;

import java.sql.Connection;

public interface ConnectionPool {

  public Connection getConnection() throws Exception;

  public void returnConnection(Connection con);

}