package algorithm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputNM = br.readLine().split(" ");
    int N = Integer.parseInt(inputNM[0]);
    int M = Integer.parseInt(inputNM[1]);
    int numOfCase = (N - 7) * (M - 7);

    //브루트포스 말고 더 좋은 접근법이 있나?
    //첨엔 문자 하나하나 데이터를 뽑았는데 아래가 더 빠르고 작성도 쉬운 것 같다.
    String[] answer = {
        "WBWBWBWB\nBWBWBWBW\nWBWBWBWB\nBWBWBWBW\nWBWBWBWB\nBWBWBWBW\nWBWBWBWB\nBWBWBWBW\n",
        "BWBWBWBW\nWBWBWBWB\nBWBWBWBW\nWBWBWBWB\nBWBWBWBW\nWBWBWBWB\nBWBWBWBW\nWBWBWBWB\n"};

//    System.out.println(answer[0]);
//    System.out.println(answer[1]);

  }
}