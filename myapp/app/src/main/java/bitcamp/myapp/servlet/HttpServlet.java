package bitcamp.myapp.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpServlet extends GenericServlet {

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    //this에 저장된 인스턴스의 클래스부터 service() 메서드를 찾아 올라간다.
    //현재 클래스(HttpServlet)을 가리키는 것이 아님. 호출한 인스턴스가 될 것임.
    //호출한 인스턴스에 service()가 있으면 그걸 호출할 것임
    //이전 강의에서 이 내용을 java-basic 통해서 강의했던 때가 있었음!!
    this.service(request, response);
  }

  protected void service(HttpServletRequest request, HttpServletResponse response) {

  }


}
