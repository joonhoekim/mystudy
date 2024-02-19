package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {

  private MemberDao memberDao;

  public MemberViewServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123"
    );
    memberDao = new MemberDaoImpl(connectionPool);
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("회원 번호가 유효하지 않습니다!");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='/member/update'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", member.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  이메일: <input name='email' type='text' value='%s'>\n", member.getEmail());
      out.println("</div>");
      out.println("<div>");
      out.printf("  이름: <input name='name' type='text' value='%s'>\n", member.getName());
      out.println("<div>");
      out.printf("  비밀번호: <input name='password' type='password' value='%s'>\n",
          member.getPassword());
      out.println("</div>");
      out.println("</div>");
      out.println("<div>");
      out.printf("  가입일: <input readonly type='createdDate' value='%s'>\n",
          member.getCreatedDate());
      out.println("</div>");
      out.println("  <button>변경</button>");
      out.printf("  <a href='/member/delete?no=%d'>[회원탈퇴]</a>", no);
      out.println("</div>");
      out.println("</form>");

    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
