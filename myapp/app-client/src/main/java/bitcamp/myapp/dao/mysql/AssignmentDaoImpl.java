package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Assignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDaoImpl implements AssignmentDao {

  Connection con;
  private PreparedStatement pstmt;

  public AssignmentDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Assignment assignment) {
    try {
      PreparedStatement pstmt = con.prepareStatement(
          "INSERT INTO assignments(title,content,deadline) VALUES(?, ?, ?)"
      );
      pstmt.setString(1, assignment.getTitle());
      pstmt.setString(2, assignment.getContent());
      pstmt.setDate(3, assignment.getDeadline());

      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new DaoException("데이터 쓰기 예외", e);
    }

  }

  @Override
  public int delete(int no) {
    try {
      PreparedStatement pstmt = con.prepareStatement(
          "DELETE FROM assignments WHERE assignment_no = ?"
      );

      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("삭제 예외 발생", e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "SELECT * FROM assignments ORDER BY assignment_no DESC");
        ResultSet rs = pstmt.executeQuery();) {

      ArrayList<Assignment> list = new ArrayList<>();

      while (rs.next() == true) {
        Assignment assignment = new Assignment();
        assignment.setNo(rs.getInt("assignment_no"));
        assignment.setTitle(rs.getString("title"));
        assignment.setContent(rs.getString("content"));
        assignment.setDeadline(rs.getDate("deadline"));

        list.add(assignment);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("조회 예외 발생", e);
    }
  }

  @Override
  public Assignment findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "SELECT * FROM assignments WHERE assignment_no = ?", no);) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery();) {

        if (rs.next() == true) {
          Assignment assignment = new Assignment();
          assignment.setNo(rs.getInt("assignment_no"));
          assignment.setTitle(rs.getString("title"));
          assignment.setContent(rs.getString("content"));
          assignment.setDeadline(rs.getDate("deadline"));
          return assignment;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("조회 예외 발생", e);
    }
  }

  @Override
  public int update(Assignment assignment) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "UPDATE assignments SET title=?, content=?, deadline=? WHERE assignment_no=?")) {
      pstmt.setString(1, assignment.getTitle());
      pstmt.setString(2, assignment.getContent());
      pstmt.setDate(3, assignment.getDeadline());
      pstmt.setInt(4, assignment.getNo());

      return pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
