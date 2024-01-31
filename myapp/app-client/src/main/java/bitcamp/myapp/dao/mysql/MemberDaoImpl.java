package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  Connection con;

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Member member) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "INSERT INTO members(email,name,password) VALUES('%s','%s','%s')",
          member.getEmail(), member.getName(), member.getPassword()
      ));

    } catch (Exception e) {
      throw new DaoException("DB쓰기 예외", e);
    }

  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "DELETE FROM members WHERE member_no = %d", no
      ));
    } catch (Exception e) {
      throw new DaoException("삭제 중 예외 발생", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(String.format(
          "SELECT * FROM members"
      ));
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
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(String.format(
          "SELECT * FROM members WHERE member_no = %d", no
      ));

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
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "UPDATE members SET email='%s',name='%s',password=sha('%s',256) WHERE member_no = %d",
          member.getEmail(), member.getName(), member.getPassword(), member.getNo()));
    } catch (Exception e) {
      throw new DaoException("수정 예외 발생", e);
    }
  }
}
