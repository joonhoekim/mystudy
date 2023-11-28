import java.밥.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


class Instance {
  public static void main(String args) {
    밥 a = new 밥(쌀);
    밥그릇 b = new 밥그릇(밥);
    밥그릇.먹자("달걀");

    // 메모리주소.연산자(피연산자)
    // 레퍼런스.오퍼레이터(오퍼랜드)
    // 스태틱은 클래스 이름이 있음



    // 많은 방법이 있는데, 그걸 많이 암기할 수록 능력있는 사람이 되어간다고 생각하면 된다.
    // 많은 걸 배우거나 암기하기 싫다는 생각을 버려야지 성공할 수 있는 세계이다.
    // 마음에 벽을 깨야된다. 벽을 꺠라 벽을 벽을 깨라!!!!
    File file = new File("test.txt");
    //OutputStream output = System.out;
    OutputStream output = new FileOutputStream("test.txt");
    // OutputStream output = new FileOutputStream("test.txt");
    PrintStream output2 = new PrintStream(output);
    output2.println("HELLO!");
    output2.println("hi");

  }
}

