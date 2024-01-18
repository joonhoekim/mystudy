// Byte Stream - 바이트 단위로 읽기 II
package com.eomcs.io.ex02;

import java.io.FileReader;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("temp/test1.data"); // 41 42 EA B0 80 EA B0 81

    int ch;

    while ((ch = in.read()) != -1) {
      System.out.printf("%04X ", ch); // x 혹은 X 하면 대소문자로 바꿀 수 있다.
      // 0041 0042 AC00 AC01
      // UTF-16 BE 로 바뀌었다.
    }

    in.close();
  }

}
