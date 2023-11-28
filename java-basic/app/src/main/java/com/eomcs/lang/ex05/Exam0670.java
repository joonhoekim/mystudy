package com.eomcs.lang.ex05;

//# 증감 연산자 : 전위(pre-fix) 증감 연산자 응용 I
//
public class Exam0670 {
  public static void main(String[] args) {
    int a = 5;
    int r = ++a;
    // 위의 문장은 다음 두 문장으로 변경된다.
    // a = a + 1;
    // int r = a;

    System.out.printf("%d, %d\n", a, r);
    // r = ++a 연산 순서
    // 1) ++a 연산을 먼저 수행 => a 변수의 값을 1 증가시킨다.
    // 2) a 값을 리턴한다. => r = 6;
    // 3) = 연산자 수행 => r 변수에 6 값을 넣는다.
    // 결론!
    // => 전위 연산자는 먼저 변수의 값을 -- 하거나 ++ 한 후에
    //    그 자리에 변수의 값을 놓는다.


    r = a = a + 1;
    System.out.printf("%d, %d\n", a, r);

    // 아래는 안된다. L-value에 변수가 아닌 값을 리턴하는 표현식이 들어가기 때문이다.
    // r = a = a + 1 = a + 2;


    // 항상 L-value로 변수가 와야 하므로 같은 값으로 여러 변수를 설정하는 경우가 아니면 사용할 일이 없겠으나
    // 이렇게 할당연산자를 중복으로 쓰는 것도 가능하다.
    int i = 1;
    int j = 0;
    int k = 0;
    int m = 0;
    m = k = j = i;
    // 1) j=i 처리 시작(j 변수에 r-value 할당, k=j 문의 r-value가 j 변수의 값이 됨)
    // 2) k=j 처리 시작(k 변수에 r-value 할당, m=k 문의 r-value가 k 변수의 값이 됨)
    // 3) m=k 처리 시작(m 변수에 r-value 할당)
    System.out.println(i);
    System.out.println(j);
    System.out.println(k);
    System.out.println(m);
  }
}
