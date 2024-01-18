package com.eomcs.io.ex01;

import java.io.File;

public class PracticeRecursionTree {
  public static void main(String[] args) {
    File dir = new File("temp/printList");
    printList(dir);

    System.out.println("Welldone");
  }

  static void printList(File dir) {
    int level = 0;
    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isDirectory()) {
        System.out.println(file.getName());
        printList(file);
      } else {
        System.out.println(file.getName());
      }
    }


  }
}
