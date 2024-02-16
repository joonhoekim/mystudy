package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login")
public class LoginServlet extends GenericServlet {

  MemberDao memberDao;


  public LoginServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.memberDao = new MemberDaoImpl(connectionPool);
  }


  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    try {
      //서블릿컨테이너가 service()를 호출할 때 넘겨주는 값은 HttpServletRequest, HttpServletResponse이다.
      //저스트, 서브타입들이 파라미터로 들어올 것이다. 와이? 위아 커뮤니케이팅 언더 HTTP 프로토콜.
      //쏘, 위 햅투 캐스트 도즈 파라미터즈
      //라잌 빌로 스테잇먼츠.

      String email = request.getParameter("email");
      String password = request.getParameter("password");

      out.println("<!DOCTYPE html>");
      out.println("<html lang='en'>");
      out.println("<head>");
      out.println("  <meta charset='UTF - 8'>");
      out.println("  <title>비트캠프 데브옵스 5기</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시글</h1>");
      out.println("<h1>과제 관리 시스템</h1>");
      out.println("<h2>로그인</h2>");

      Member member = memberDao.findByEmailAndPassword(email, password);
      if (member != null) {
//      prompt.setLoginUser(member);
//      prompt.setAttribute("loginUser", member);
        request.getSession().setAttribute("loginUser", member);
        out.printf("%s 님 환영합니다.\n", member.getName());
      } else {
        out.println("이메일 또는 암호가 맞지 않습니다.");
      }
    } catch (Exception e) {
      out.println("목록 오류!");
      out.println("<p> 목록 오류! </p>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
