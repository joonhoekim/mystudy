// DataBufferedFileInputStream으로 객체 읽기
package com.eomcs.io.ex07;

import java.io.FileInputStream;
import com.eomcs.io.ex08.DataInputStream;
import com.eomcs.io.ex09.step2.BufferedInputStream;

public class Exam0220 {

  public static void main(String[] args) throws Exception {
    DataBufferedFileInputStream in = new DataBufferedFileInputStream("temp/members.data");

    DataInputStream in1 =
        new DataInputStream(new BufferedInputStream(new FileInputStream("temp/members.data")));
    // 이러고 만약에 readUTF()를 한다? DIS는 BIS를 품고, BIS는 FIS를 품고, FIS는 IS 인터페이스를 구현함
    // DIS에서 readUTF()는 IS 인터페이스의 read()를 호출함. 이것은 BIS의

    Member member = null;

    long start = System.currentTimeMillis();

    for (int i = 0; i < 1000000; i++) {
      member = new Member();
      member.name = in.readUTF();
      member.age = in.readInt();
      member.gender = in.readBoolean();
    }

    long end = System.currentTimeMillis();

    in.close();

    System.out.println("읽기 완료!");
    System.out.printf("경과된 시간: %d\n", end - start);
  }
}


