// Base64 인코딩 : 이미지 파일 --> 인코딩
package com.eomcs.net.ex10;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    File file = new File("./sample/test1.jpg");

    FileInputStream in = new FileInputStream(file);
    byte[] bytes = in.readAllBytes(); // 10000 Bytes 정도 까지는 readAllBytes()해도 괜찮다.
    in.close();

    Encoder encoder = Base64.getEncoder();
    byte[] encodedBytes = encoder.encode(bytes);
    System.out.println(new String(encodedBytes));
  }

}


