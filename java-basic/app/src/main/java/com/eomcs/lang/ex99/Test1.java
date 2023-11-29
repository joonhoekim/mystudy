package com.eomcs.lang.ex99;

// import 는 JVM이 어떻게 처리하나? 프로그램 구동시에 어떤 메모리 영역에 가져오는건가?
// import 는 위치만을 알려주는 것인가!

import java.io.InputStream;
import java.util.Scanner;
// Scanner.nextLine()이 없었다면....
// 반복문으로 글자를 다 받은 다음에 유니코드로 하나하나 다 바꿔준 다음에 그걸 String 객체에 반복문으로 넣어줘야한다.
//

public class Test1 {
  public static void main(String[] args) throws Exception {
    InputStream in = System.in;

    // 생성하는 것만으로는 사용할 수 없다..
    new Scanner(in);
    // 레퍼런스가 없으면 인스턴스를 어떻게 닫아주나!!

    String str1;
    System.out.println(str1 = new java.util.Scanner(java.lang.System.in).nextLine());



    // 사용하기 위해 keyIn 이라는 레퍼런스에 인스턴스의 메모리주소를 저장한다.
    java.util.Scanner keyIn = new java.util.Scanner(in);

    //만약 import 하지 않았다면?
    new java.util.Scanner(in); // 매번 위치를 전부 다 알려줘야 한다.

    // 써보자.
    String str = keyIn.nextLine(); // 여기서 실행이 blocking 된다.
    // 라인을 나누는 기준? 0x0D0A CRLF 혹은 0x0A LF 가 입력스트림에 있을 때 blocking이 끝난다.
    System.out.println(str);

    // 다 썼으면 잠궈준다.
    // 프로그램이 종료되면 자동으로 메모리도 회수되나, 클로즈하는 걸 습관화해라.
    // 24시간 365일 내내 실행될 프로그램을 만들 것 아니냐.
    // 다른 프로그램이 키보드같은 자원들을 쓸 수 있도록, 이런 습관이 중요하다.
    keyIn.close();


  }
  // main 코드블럭이 끝나면 JVM이 종료된다.
  // 다만 다른 작업중인 작업자가 있다면 프로그램이 종료되지 않는다.
  // 이 때 다른 작업자를 스레드(thread)라고 부른다. 프로세스의 작업 단위
}
