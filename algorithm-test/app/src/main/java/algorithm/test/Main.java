package algorithm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i <= T; i++) {
      String theCase = br.readLine();
      //streak 을 판단하는 변수를 하나 더 두자.
      int streak = 0;
      int score = 0;
      for (int j = 0; j < theCase.length(); j++) {
        if (theCase.charAt(j) == 'O') {
          score += ++streak;
        } else {
          streak = 0;
        }
      }
      System.out.println(score);
    }
  }
}