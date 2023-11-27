public class OperandStudy {
  public static int PostFixPlus(int i) {
    int temp = i;
    i = i + 1;
    return temp;
  } // 후위 증감 연산자 공부할 때 확인

  public static void main(String[] args) {
    // 연산자 공부 - 전위, 후위 연산자

    // 주입해서 암기해야 할 사항
    int i = 1;

    ++i;
    i = i + 1;
    // 위 두 줄은 완전히 같은 동작을 한다.

    i++;
    PostFixPlus(i);
    // 위 두 줄은 완전히 같은 동작을 한다.

    System.out.println("i = " + ++i);
    // 전위 연산자는 i=i+1; 의 축약어다. 그 라인에서 먼저 처리되어 반영된다.
    // 전위, 후외 연산자는 다른 어떤 연산자보다 먼저 처리된다.

    System.out.println("i = " + i);
    System.out.println(i++);
    System.out.println(i);
    System.out.println("i++ = " + i++ + ", Re-Accessed i = " + i);
    System.out.println("i++ = " + PostFixPlus(i) + ", Re-Accessed i = " + i);
    // 후위 연산자는 해당 라인에서 원래 값을 가진 임시값을 반환한다.
    // 이 라인에서 i=i+1이 된 것이 맞다.
    // 근데 이 라인에서 i 가 아니라 temp 값을 쓰니까 그런거다.
    // 다음 변수 i에 접근할 때는 temp가 아닌 i에 접근한다.

    System.out.println("i = " + i);
    ++i;
    System.out.println("i = " + i);
    System.out.println("++i = " + ++i);
    System.out.println("i++ = (i=i+1) = " + (i = i + 1));
    // (i=i+1) 은 i에 1을 더한 다음 그것을 반환하는 것. 컴파일러는 이를 ++i와 동일하게 컴파일한다.

    // 골 때리는 코드
    System.out.println("골 떄리는 코드 1: " + i);
    i = i++;
    System.out.println("골 떄리는 코드 2: " + i);
    i = PostFixPlus(i);
    System.out.println("골 떄리는 코드 3: " + i);

    // 무슨 일이 일어났나?
    // temp에 i 값 저장됨.
    // i는 1이 증가함.
    // i에 temp 값이 할당됨
    // 그래서 값이 변했다가 다시 돌아온 것

    // 여기가 종합판이다.
    i = 3;
    int j = ++i + ++i * ++i;
    System.out.println("j = " + j);
    // 컴파일러가 어떤 순서로 컴파일을 하는지를 알아야 한다.
    // 우선 전위, 후위 연산자가 항상 먼저 계산된다.
    // 전위, 후위 증감 연산자간 우선순위는 동등하므로 '순서대로' 처리된다.
    // 전위, 후위 증감 연산자 처리된 값으로 나머지 코드가 실행된다.

    i = 3;
    j = (i = i + 1) + (i = i + 1) * (i = i + 1);
    int t1, t2, t3;

    i = 3;
    j = (t1 = i = i + 1) + (t2 = i = i + 1) * (t3 = i = i + 1);
    System.out.println("t1 = " + t1);
    System.out.println("t2 = " + t2);
    System.out.println("t3 = " + t3);
    System.out.println("j = " + j);
    // 위 코드 출력을 확인해보면 된다.

    // 전위, 후위 증감 연산자를 같이 쓸 수 없다.
    // ++i++;
    // (++i)++;
    // ++(++i);
    // ++(i++);
    // ++++i;
    // i++++;

  }

}
