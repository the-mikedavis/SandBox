public class InfLoop {
  public static void main (String[] args) {
    int x = -1;
    for (int i = 0; i >= 0; i++) {
      x = i + 1;
      System.out.println(i);
    }
  }
}
