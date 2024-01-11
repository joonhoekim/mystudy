package algorithm.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = 0, s = 1, t = 1, i;
        for (i = 0; i < 10; i++) {
            q = s + t;
            t = s;
            s = q;
            System.out.print(q+" ");
        }
    }
}