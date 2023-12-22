package bitcamp.util;

import java.io.InputStream;
import java.sql.Date;
import java.util.Scanner;


public class Prompt {

  private Scanner keyIn;

  public Prompt(InputStream in) {

    keyIn = new Scanner(in);
  }

  public String input(String title, Object... args) {
    System.out.print(String.format(title, args));
    return this.keyIn.nextLine();
  }

  public int inputInt(String title, Object... args) {
    return Integer.parseInt(this.input(title, args));
  }

  public float inputFloat(String title, Object... args) {
    return Float.parseFloat(this.input(title, args));
    //여기서 트라이캐치하면 문제가, 리턴값인 정수값으로 뭘 알려주기가 힘들다.
    //그리고 어떤 오류가 발생했는지는 이 Prompt 를 사용하는 메서드에서 결정해야 할 일이다.
  }

  public boolean inputBoolean(String title, Object... args) {
    return Boolean.parseBoolean(input(title, args));
  }

  public Date inputDate(String title, Object... args) {
    return Date.valueOf(input(title, args));
  }

  public void close() {
    this.keyIn.close();
  }
}
