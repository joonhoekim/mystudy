package bitcamp.myapp.controller;

import org.springframework.stereotype.Component;

@Component
public class AboutController {

  public AboutController() {
    System.out.println(getClass() + "생성되었습니다.");
  }

  @RequestMapping("/about")
  public String about()
      throws Exception {
    return "/about.jsp";
  }
}
