package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Board;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

  int category;
  Connection con;

  public BoardDaoImpl(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void add(Board board) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format( //받아올 결과물이 없는 경우 executeQuery가 아닌 executeUpdate
          "INSERT INTO boards(title,content,writer,category) VALUES('%s','%s','%s',%d)",
          board.getTitle(), board.getContent(), board.getWriter(), category));

    } catch (
        Exception e) {
      e.printStackTrace();
      throw new DaoException("데이터 가져오기 오류", e);

    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format( //받아올 결과물이 없는 경우 executeQuery가 아닌 executeUpdate
          "DELETE FROM boards WHERE board_no=%d", no));
    } catch (
        Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }

  @Override
  public List<Board> findAll() {
    try {

      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from boards WHERE category=" + this.category);
      ArrayList<Board> list = new ArrayList<>();

      while (rs.next() == true) {
        //stmt.executeQuery();
        int boardNo = rs.getInt("board_no");
        String title = rs.getString("title");
        String content = rs.getString("content");
        String writer = rs.getString("writer");
        Date createdDate = rs.getDate("created_date");

        Board board = new Board();
        board.setNo(boardNo);
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        board.setCreatedDate(createdDate);

        list.add(board);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);

    }
  }

  @Override
  public Board findBy(int no) {
    try {

      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from boards where board_no = " + no);

      if (rs.next() == true) {
        //stmt.executeQuery();
        int boardNo = rs.getInt("board_no");
        String title = rs.getString("content");
        String content = rs.getString("content");
        String writer = rs.getString("writer");
        Date createdDate = rs.getDate("created_date");

        Board board = new Board();
        board.setNo(boardNo);
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);
        board.setCreatedDate(createdDate);

        return board;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);

    }
  }

  @Override
  public int update(Board board) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format( //받아올 결과물이 없는 경우 executeQuery가 아닌 executeUpdate
          "UPDATE boards SET title='%s', content='%s', writer='%s' where board_no=%d",
          board.getTitle(), board.getContent(), board.getWriter(), board.getNo()));
    } catch (
        Exception e) {
      throw new DaoException("데이터 변경 오류", e);

    }
  }
}
