package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Assignment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDaoImpl implements AssignmentDao {

  Connection con;

  public AssignmentDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Assignment assignment) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "INSERT INTO assignments(title,content,deadline) VALUES('%s', '%s', '%s')",
          assignment.getTitle(),
          assignment.getContent(),
          assignment.getDeadline())
      );
    } catch (SQLException e) {
      e.printStackTrace();
      throw new DaoException("데이터 쓰기 예외", e);
    }

  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "DELETE FROM assignments WHERE assignment_no = + %d", no));
    } catch (Exception e) {
      throw new DaoException("삭제 예외 발생", e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          "SELECT * FROM assignments"
      );
      ArrayList<Assignment> list = new ArrayList<>();

      while (rs.next() == true) {
        int assignmentNo = rs.getInt("assignment_no");
        String title = rs.getString("title");
        String content = rs.getString("content");
        Date deadline = rs.getDate("deadline");

        Assignment assignment = new Assignment();
        assignment.setTitle(title);
        assignment.setContent(content);
        assignment.setDeadline(deadline);

        list.add(assignment);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("조회 예외 발생", e);
    }
  }

  @Override
  public Assignment findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          String.format("SELECT * FROM assignments WHERE assignment_no = %d", no)
      );

      if (rs.next() == true) {
        int assignmentNo = rs.getInt("assignment_no");
        String title = rs.getString("title");
        String content = rs.getString("content");
        Date deadline = rs.getDate("deadline");

        Assignment assignment = new Assignment();
        assignment.setTitle(title);
        assignment.setContent(content);
        assignment.setDeadline(deadline);

        return assignment;

      }
    } catch (Exception e) {
      throw new DaoException("조회 예외 발생", e);
    }
    return null;
  }

  @Override
  public int update(Assignment assignment) {
    return 0;
  }
}
