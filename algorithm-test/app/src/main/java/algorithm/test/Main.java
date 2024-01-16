package algorithm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    //브루트포스 말고 더 나은 방법이 없을까..?

    //0. 초기값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputNM = br.readLine().split(" ");
    int N = Integer.parseInt(inputNM[0]);
    int M = Integer.parseInt(inputNM[1]);

    //1. 정답세팅 (개행문자없이 정답문자열 1차원 배열로 만들기)
    StringBuilder wb = new StringBuilder();
    StringBuilder bw = new StringBuilder();
    for (int j = 0; j < 4; j++) {
      wb.append("WBWBWBWBBWBWBWBW");
    }
    for (int j = 0; j < 4; j++) {
      bw.append("BWBWBWBWWBWBWBWB");
    }
    String answerWB = wb.toString();
    String answerBW = bw.toString();

    //2. 정답과 비교할 문장 만들기
    // - 그 라인에서 8*8 을 1차원 배열로 받기
    String[] inputlines = new String[N];
    for (int i = 0; i < N; i++) {
      inputlines[i] = br.readLine();
    }

    // - 받아온 라인을 잘라서 테스트케이스 배열에 나눠담을 것. 케이스는 (N-7)(M-7) 개 있음
    StringBuilder[][] testcase = new StringBuilder[N - 7][M - 7];
    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        testcase[i][j] = new StringBuilder();
      }
    }

    // - 이제 StringBuilder.append()를 이용해서 테스트케이스를 채우자.
    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        for (int k = i; k < i + 8; k++) {
          testcase[i][j].append(inputlines[k].substring(j, j + 8));
        }
      }
    }

    //3. 정답과 테스트케이스를 비교한다.
    int[][] errors = new int[N - 7][M - 7];

    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        int errorWB = 0;
        int errorBW = 0;
        for (int k = 0; k < 64; k++) {
          if (testcase[i][j].toString().charAt(k) != answerWB.charAt(k)) {
            errorWB++;
          }
          if (testcase[i][j].toString().charAt(k) != answerBW.charAt(k)) {
            errorBW++;
          }
        }
        errors[i][j] = Math.min(errorWB, errorBW);
      }
    }

    //4. 2차원 배열에서 최소값을 찾는다.
    int min = errors[0][0];
    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        if (errors[i][j] < min) {
          min = errors[i][j];
        }
      }
    }

    //5. 답을 출력한다.
    System.out.println(min);
  }
}