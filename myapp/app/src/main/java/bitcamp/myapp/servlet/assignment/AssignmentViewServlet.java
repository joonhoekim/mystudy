package bitcamp.myapp.servlet.assignment;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/view")
public class AssignmentViewServlet extends HttpServlet {

  private AssignmentDao assignmentDao;

  @Override
  public void init() {
    assignmentDao = (AssignmentDao) this.getServletContext().getAttribute("assignmentDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Assignment assignment = assignmentDao.findBy(no);
      if (assignment == null) {
        throw new Exception("과제 번호가 유효하지 않습니다.");
      }
      //왜 jsp에서 contentType 설정하는게 안먹히지?
      //여기서 설정해서 보내면 먹히고.. 이해가 안되네.
      //jsp 파일을 동작 잘 되는거 확인된 코드를 복붙해도 헤더에 contentType이 안붙어
      response.setContentType("text/html; charset=UTF-8");
      request.setAttribute("assignment", assignment);
      request.getRequestDispatcher("/assignment/view.jsp").include(request, response);

    } catch (Exception e) {
      request.setAttribute("message", "조회 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }

}
