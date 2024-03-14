package bitcamp.web.app;

import bitcamp.dao.BoardDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 프론트 컨트롤러(DispatcherServlet)가 실행할 페이지 컨트롤러는
// 다음과 같이 @Controller 애노테이션을 붙여야 한다.
@Controller
public class HelloController {
  private static Log log = LogFactory.getLog(HelloController.class);

  public HelloController() {
    log.debug(this.getClass() + " 호출됐어요!");

  }

  // 클라이언트 요청이 들어왔을 때 호출될 메서드(request handler)를
  // 표시하려면 다음과 같이 @RequestMapping 애노테이션을 붙여야 한다.
  //    @RequestMapping(요청URL)
  // => 예)
  //    @RequestMapping(value="/hello")
  //    @RequestMapping("/hello")
  //    @RequestMapping(path="/hello")
  @RequestMapping({"/hello", "/hello2", "/okok"})
  //@RequestMapping(value={"/hello", "/hello2", "/okok"})
  //속성의 이름이 value 이므로 생략할 수 있으며, 속성이 단 하나인 경우 중괄호{}를 생략할 수 있다.

  // 리턴하는 String 값이 뷰 컴포넌트(예: JSP)의 URL이 아닌 경우
  // 애노테이션으로 표시한다.
  // => @ResponseBody : 리턴하는 문자열이 클라이언트에게 보낼 콘텐트임을 표시한다.
  // => 이 애노테이션이 붙어 있으면,
  //    프론트 컨트롤러는 리턴 값을 클라이언트에게 그대로 전송한다.
  @ResponseBody
  public String hello() throws Exception {
    return "<html><body><h1>Hello!</h1></body></html>";
  }
}
