package bitcamp.myapp.servlet;

import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
      HttpServletResponse response) //HTTP 메서드와 무관하게 실행하겠다
      throws ServletException, IOException {
    //상단 컨텐츠인 Header 출력하는 역할을 하는 서블릿이다.

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.print("""
        <header>
        <img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcXg2t6gnSFsB_6PBi-S62Ca9JkWqoLS8YMTka7pJBRw&s'>
        """);

    out.print("""
        <a href="/assignment/list">과제</a>
        <a href="/board/list?category=1">게시글</a>
        <a href="/member/list">회원</a>
        <a href="/board/list?category=2">가입인사</a>
        <a href="/about.html">서비스 소개</a>
         """);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<a href='/auth/login'>로그인</a>");
    } else {
      out.printf("<span> %s 💕 </span>", loginUser.getName());
      out.println("<a href=\"/auth/logout\">로그아웃</a>\n");
    }
  }
}
