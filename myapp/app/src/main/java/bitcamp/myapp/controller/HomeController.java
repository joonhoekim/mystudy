package bitcamp.myapp.controller;

public class HomeController {

  @RequestMapping("/home")
  public String home() //파라미터없어도되는경우
      throws Exception {
    return "/home.jsp";
  }
}
