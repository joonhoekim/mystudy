package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

  private MemberDao memberDao;

  //서블릿 컨테이너가 생성하므로, 기본생성자를 사용해야 한다.
  public MemberListServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");

    this.memberDao = new MemberDaoImpl(connectionPool);
  }


  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {

    servletResponse.setContentType("text/html;charset=UTF-8");
    PrintWriter out = servletResponse.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");
    out.println("<a href='/member/form.html'>새 회원</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>가입일</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");
      List<Member> list = memberDao.findAll();

      for (Member member : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/member/view?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td>  </tr>\n",
            member.getNo(),
            member.getName(),
            member.getEmail(),
            member.getCreatedDate());
      }
    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }

}
