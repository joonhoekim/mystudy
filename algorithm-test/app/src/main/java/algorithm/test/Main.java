package algorithm.test;

import java.util.Scanner;

public class Main {

  static void set2dArrIncr(int[][] arr2d) {
    int n=arr2d.length;
    int m=arr2d[0].length;
    int count=1;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        arr2d[i][j]=count++;
      }
    }
  }

  static void set2dArrScan(int[][] arr2d) {
    Scanner sc = new Scanner(System.in);
    int n=arr2d.length;
    int m=arr2d[0].length;
    int count=1;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        arr2d[i][j]=sc.nextInt();
      }
    }
    sc.close();
  }

  static void print2dArr(int[][] arr2d) {
    int n=arr2d.length;
    int m=arr2d[0].length;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        System.out.print(arr2d[i][j]+" ");
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //int n=sc.nextInt();
    //int m=sc.nextInt();
    int n=3, m=3;
    int[][] arr2dA=new int[n][m];
    int[][] arr2dB=new int[n][m];
    int[][] arr2dAns=new int[n][m];

    set2dArrScan(arr2dA);
    set2dArrScan(arr2dB);

    //multiply
    for(int i=0;i<n;i++) {
      for(int j=0;j<m;j++) {
        arr2dAns[i][j]=arr2dA[i][j] * arr2dB[i][j];
      }
    }

    print2dArr(arr2dAns);

  }
}