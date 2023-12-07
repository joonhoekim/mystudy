package bitcamp.myapp;

import bitcamp.myapp.menu.MainMenu;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    //이 prompt는 dependency 임

    new MainMenu(prompt).execute();
    prompt.close();
  }
}
