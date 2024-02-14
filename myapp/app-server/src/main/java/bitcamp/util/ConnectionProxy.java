package bitcamp.util;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.ShardingKey;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

//프록시의 핵심은 구현체나 프록시나 같은 인터페이스를 사용한다는 것이다.
public class ConnectionProxy implements Connection {
  // 이 인터페이스를 구현한다고 선언하고나서, IDE의 생성기능(Alt+Ins) 하고 Delegate Method 하면 된다.

  //포함된 객체
  private Connection origianl;
  private DBConnectionPool connectionPool;

  public ConnectionProxy(Connection origianl, DBConnectionPool connectionPool) {
    this.origianl = origianl;
    this.connectionPool = connectionPool;
  }

  //Proxy 만든 이유. 기존 객체를 변경하지 않고 close() 기능을 변경하려고.
  //왜 변경? 풀에 반납을 여기서 해결하려고
  @Override
  public void close() throws SQLException {
    if (origianl.getAutoCommit()) {
      // return this connection to DB Connection Pool  (DBCP)
      connectionPool.returnConnection(this); //프록시를 보낸다.
    }

    origianl.close();
  }


  @Override
  public Statement createStatement() throws SQLException {
    return origianl.createStatement();
  }

  @Override
  public PreparedStatement prepareStatement(String sql) throws SQLException {
    return origianl.prepareStatement(sql);
  }

  @Override
  public CallableStatement prepareCall(String sql) throws SQLException {
    return origianl.prepareCall(sql);
  }

  @Override
  public String nativeSQL(String sql) throws SQLException {
    return origianl.nativeSQL(sql);
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    return origianl.getAutoCommit();
  }

  @Override
  public void setAutoCommit(boolean autoCommit) throws SQLException {
    origianl.setAutoCommit(autoCommit);
  }

  @Override
  public void commit() throws SQLException {
    origianl.commit();
  }

  @Override
  public void rollback() throws SQLException {
    origianl.rollback();
  }


  @Override
  public boolean isClosed() throws SQLException {
    return origianl.isClosed();
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    return origianl.getMetaData();
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    return origianl.isReadOnly();
  }

  @Override
  public void setReadOnly(boolean readOnly) throws SQLException {
    origianl.setReadOnly(readOnly);
  }

  @Override
  public String getCatalog() throws SQLException {
    return origianl.getCatalog();
  }

  @Override
  public void setCatalog(String catalog) throws SQLException {
    origianl.setCatalog(catalog);
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    return origianl.getTransactionIsolation();
  }

  @Override
  public void setTransactionIsolation(int level) throws SQLException {
    origianl.setTransactionIsolation(level);
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return origianl.getWarnings();
  }

  @Override
  public void clearWarnings() throws SQLException {
    origianl.clearWarnings();
  }

  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return origianl.createStatement(resultSetType, resultSetConcurrency);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return origianl.prepareStatement(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return origianl.prepareCall(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    return origianl.getTypeMap();
  }

  @Override
  public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
    origianl.setTypeMap(map);
  }

  @Override
  public int getHoldability() throws SQLException {
    return origianl.getHoldability();
  }

  @Override
  public void setHoldability(int holdability) throws SQLException {
    origianl.setHoldability(holdability);
  }

  @Override
  public Savepoint setSavepoint() throws SQLException {
    return origianl.setSavepoint();
  }

  @Override
  public Savepoint setSavepoint(String name) throws SQLException {
    return origianl.setSavepoint(name);
  }

  @Override
  public void rollback(Savepoint savepoint) throws SQLException {
    origianl.rollback(savepoint);
  }

  @Override
  public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    origianl.releaseSavepoint(savepoint);
  }

  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return origianl.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return origianl.prepareStatement(sql, resultSetType, resultSetConcurrency,
        resultSetHoldability);
  }

  @Override
  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return origianl.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    return origianl.prepareStatement(sql, autoGeneratedKeys);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    return origianl.prepareStatement(sql, columnIndexes);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
    return origianl.prepareStatement(sql, columnNames);
  }

  @Override
  public Clob createClob() throws SQLException {
    return origianl.createClob();
  }

  @Override
  public Blob createBlob() throws SQLException {
    return origianl.createBlob();
  }

  @Override
  public NClob createNClob() throws SQLException {
    return origianl.createNClob();
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    return origianl.createSQLXML();
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    return origianl.isValid(timeout);
  }

  @Override
  public void setClientInfo(String name, String value) throws SQLClientInfoException {
    origianl.setClientInfo(name, value);
  }

  @Override
  public String getClientInfo(String name) throws SQLException {
    return origianl.getClientInfo(name);
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    return origianl.getClientInfo();
  }

  @Override
  public void setClientInfo(Properties properties) throws SQLClientInfoException {
    origianl.setClientInfo(properties);
  }

  @Override
  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    return origianl.createArrayOf(typeName, elements);
  }

  @Override
  public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    return origianl.createStruct(typeName, attributes);
  }

  @Override
  public String getSchema() throws SQLException {
    return origianl.getSchema();
  }

  @Override
  public void setSchema(String schema) throws SQLException {
    origianl.setSchema(schema);
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    origianl.abort(executor);
  }

  @Override
  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    origianl.setNetworkTimeout(executor, milliseconds);
  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    return origianl.getNetworkTimeout();
  }

  @Override
  public void beginRequest() throws SQLException {
    origianl.beginRequest();
  }

  @Override
  public void endRequest() throws SQLException {
    origianl.endRequest();
  }

  @Override
  public boolean setShardingKeyIfValid(ShardingKey shardingKey, ShardingKey superShardingKey,
      int timeout) throws SQLException {
    return origianl.setShardingKeyIfValid(shardingKey, superShardingKey, timeout);
  }

  @Override
  public boolean setShardingKeyIfValid(ShardingKey shardingKey, int timeout) throws SQLException {
    return origianl.setShardingKeyIfValid(shardingKey, timeout);
  }

  @Override
  public void setShardingKey(ShardingKey shardingKey, ShardingKey superShardingKey)
      throws SQLException {
    origianl.setShardingKey(shardingKey, superShardingKey);
  }

  @Override
  public void setShardingKey(ShardingKey shardingKey) throws SQLException {
    origianl.setShardingKey(shardingKey);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return origianl.unwrap(iface);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return origianl.isWrapperFor(iface);
  }
}
