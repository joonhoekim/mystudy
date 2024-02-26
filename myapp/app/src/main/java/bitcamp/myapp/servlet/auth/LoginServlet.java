package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

  MemberDao memberDao;

  @Override
  public void init() {
    this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.write("<!DOCTYPE html>");
    out.write("<html lang='en'>");
    out.write("<head>");
    out.write("<meta charset='UTF-8'>");
    out.write("<title>비트캠프 데브옵스 5기</title>");
    out.write("</head>");
    out.write("<body>");

    req.getRequestDispatcher("/header").include(req, resp);

    out.write("<h2>로그인</h2>");
    out.write("<form action='/auth/login' method='post'>");
    out.write("<div>");
    out.write("이메일: <input name='email' type='text'>");
    out.write("</div>");
    out.write("<div>");
    out.write("암호: <input name='password' type='password'>");
    out.write("</div>");
    out.write("<button>로그인</button>");
    out.write("</form>");

    req.getRequestDispatcher("/footer").include(req, resp);

    out.write("</body>");
    out.write("</html>");

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>과제 관리 시스템</h1>");
    out.println("<h2>로그인</h2>");

    try {
      Member member = memberDao.findByEmailAndPassword(email, password);
      if (member != null) {
        request.getSession().setAttribute("loginUser", member);
        out.printf("<p>%s 님 환영합니다.</p>\n", member.getName());
        response.setHeader("Refresh", "1;url=/index.html");
      } else {
        out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");
        response.setHeader("Refresh", "1;url=/auth/login");

      }
    } catch (Exception e) {
      out.println("<p>로그인 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
