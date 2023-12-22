
public class LogicalOperator {
  public static void main(String[] args) {
    int x = 10;
    int y = 5;

    System.out.println((x > 7) && (y <= 5));
    System.out.println((x % 3 == 2) || (y % 2 != 1));

    int randomInt = (int) (Math.random() * 6) + 1;
    System.out.println(randomInt);

    labenName: for (int i = 0; i < 10; ++i) {
      randomInt = (int) (Math.random() * 6) + 1;
      System.out.println(randomInt);
    }

    String grade = "B";
    int score = switch (grade) {
      case "A" -> 100;
      case "B" -> {
        int result = 100 - 20;
        yield result;
      }
      default -> 60;
    };
    System.out.println(score);

    String a = new String("Hello");



  }
}
