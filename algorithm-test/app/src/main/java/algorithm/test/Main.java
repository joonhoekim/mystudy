package algorithm.test;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    String[] croatians2 = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
    String croatian3 = "dz=";
    int toMinus = 0;

    sb.append(sc.nextLine());

    for (int i = 0; i < sb.length() - 2; i++) {
      if (sb.substring(i, i + 3).equals(croatian3)) {
        toMinus += 2;
        sb.replace(i, i + 3, "xxx");
      }
    }

    for (int i = 0; i < sb.length() - 1; i++) {
      for (int j = 0; j < croatians2.length; j++) {
        if (sb.substring(i, i + 2).equals(croatians2[j])) {
          toMinus += 1;
        }
      }
    }

    System.out.print(sb.length() - toMinus);

  }
}