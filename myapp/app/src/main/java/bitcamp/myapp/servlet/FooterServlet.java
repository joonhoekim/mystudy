package bitcamp.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/footer")
public class FooterServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    String footer = String.format(
        " <footer> <address>한국 서울시</address> <p> &copy; 2024 네이버클라우드 데브옵스 5기</p> </footer>");

    out.write(footer);
  }
}
