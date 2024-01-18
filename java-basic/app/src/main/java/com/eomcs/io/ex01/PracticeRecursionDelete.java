package com.eomcs.io.ex01;

import java.io.File;
import java.io.IOException;

public class PracticeRecursionDelete {

  public static void main(String[] args) throws IOException {

    File dir = new File("temp/temp1");
    System.out.println(deleteDir(dir));

  }

  // 문제! 경로를 받아서 해당 경로의 하위 경로와 파일을 모두 삭제하는 코드를 작성해보세요.
  // 힌트: File 클래스의 delete() 메서드를 쓰면 되는데,
  // 경로의 경우 포함하는 하위 파일/경로가 없어야만 가능합니다.
  static boolean deleteDir(File dir) throws IOException {

    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File file : files) {
        file.delete();
      }
    }


    return dir.delete();
  }
}
