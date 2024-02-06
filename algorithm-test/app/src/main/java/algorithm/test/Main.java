package algorithm.test;

import java.util.Scanner;
public class Main {
  class InputNumber {
    int count;
    int number;
  }
  public static void main(String[] args) {
    //배열 1000개 만들어서 쓰는게 구현이 쉽다.
    //메모리를 N개만큼만 쓰는 것도 구현해보자.
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // 객체로 풀어보자.
    InputNumber[] inputNumbers = new InputNumber[n];
    for(int i=0;i<n;i++){
      inputNumbers[i].number=sc.nextInt();
    }

    int max=Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if(inputNumbers[i]>max) {
        max = inputNumbers.
      }
    }



  }
}