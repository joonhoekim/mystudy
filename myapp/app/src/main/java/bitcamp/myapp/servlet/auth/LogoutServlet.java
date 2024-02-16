package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.servlet.HttpServlet;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) {

    try {
      PrintWriter out = response.getWriter();
      prompt.getSession().invalidate();

      out.println("<!DOCTYPE html>");
      out.println("<html lang='en'>");
      out.println("<head>");
      out.println("  <meta charset='UTF - 8'>");
      out.println("  <title>비트캠프 데브옵스 5기</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시글</h1>");
      out.println("<h1>과제 관리 시스템</h1>");
      out.println("<h2>로그아웃 완료</h2>");
    } catch
  }
}
