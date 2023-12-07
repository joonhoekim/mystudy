package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  //지금 당장은 필요하지 않지만 확장성을 위해 Methoad Area -> Heap 영역으로 보낸다. 즉 인스턴스필드, 인스턴스메서드로 전환한다.
  //System.in이 아니어도 사용가능하도록 변경한다.
  Scanner keyIn;

  public Prompt(InputStream in) {
    this.keyIn = new Scanner(in);
  }

  public void close() {
    keyIn.close();
  }

  public String input(String title, Object... args) {
    System.out.print(String.format(title, args));
    return this.keyIn.nextLine();
  }

  int inputInt(String title, Object... args) {
    String str = input(title, args);
    return Integer.parseInt(str);
  }

  float inputFloat(String title, Object... args) {
    String str = input(title, args);
    return Float.parseFloat(str);
  }

  boolean inputBoolean(String title, Object... args) {
    String str = input(title, args);
    return Boolean.parseBoolean(str);
  }


}
