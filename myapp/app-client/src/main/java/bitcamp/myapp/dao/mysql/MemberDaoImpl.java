package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  Connection con;

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Member member) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "INSERT INTO members(email,name,password) VALUES(?,?,?)");) {
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getPassword());
      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("DB쓰기 예외", e);

    }

  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "DELETE FROM members WHERE member_no = ?");) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("삭제 중 예외 발생", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM members");
        ResultSet rs = pstmt.executeQuery();) {
      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setCreatedDate(rs.getDate("created_date"));

        list.add(member);
      }

      return list;
    } catch (Exception e) {
      throw new DaoException("조회 예외 발생", e);
    }

  }

  @Override
  public Member findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "SELECT * FROM members WHERE member_no = ?");
    ) {
      pstmt.setInt(1, no);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next() == true) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setCreatedDate(rs.getDate("created_date"));

        return member;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("조회 예외 발생", e);
    }

  }

  @Override
  public int update(Member member) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "UPDATE members SET email=?,name=?,password=sha(?,256) WHERE member_no =?");) {
      pstmt.setString(1, member.getEmail());
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getPassword());
      pstmt.setInt(4, member.getNo());

      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("수정 예외 발생", e);
    }
  }
}
