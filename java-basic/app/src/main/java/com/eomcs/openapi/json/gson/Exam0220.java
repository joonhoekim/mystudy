// JSON 문자열 --> 객체 : 배열 다루기
package com.eomcs.openapi.json.gson;

import com.google.gson.Gson;

public class Exam0220 {
  public static void main(String[] args) {

    String jsonStr =
        "[{\"no\":101,\"name\":\"홍길동\"},{\"no\":102,\"name\":\"임꺽정\"},{\"no\":103,\"name\":\"안창호\"}]";

    // 넣을 때 클래스에 필드는 있는데 JSON은 데이터가 없는 경우 null로 둔다.
    Member[] members = new Gson().fromJson(jsonStr, Member[].class);

    for (Member m : members) {
      System.out.println(m);
    }
  }
}


