package bitcamp.myapp.controller;

import org.springframework.stereotype.Component;

@Component
public class HomeController {

  public HomeController() {
    System.out.println(getClass() + "생성되었습니다.");
  }

  @RequestMapping("/home")
  public String home()
      throws Exception {
    return "/home.jsp";
  }
}
