package algorithm.test;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int given = sc.nextInt();
    int classroom = 0; //per 2days
    int corridor = 0; //per 3days
    int bathroom = -1; //per 12days, when we use residue for check, day0 is always bathroom cleaning day.

    for (int i = 0; i <= given; i++) {
      if (i % 12 == 0) {
        bathroom++;
      } else if (i % 3 == 0) {
        corridor++;
      } else if (i % 2 == 0) {
        classroom++;
      }
    }

    System.out.printf("%d %d %d", classroom, corridor, bathroom);


  }
}