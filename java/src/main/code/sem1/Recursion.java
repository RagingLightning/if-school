package code.sem1;

public class Recursion {

  public static void main(String[] args) {
    new Recursion();
  }

  public Recursion() {
    System.out.println(stepAnalysis(50));
  }

  public long stepAnalysis(int remains) {
    long n = 0;
    if (remains == 0) return 1;
    if (remains >= 2) n += stepAnalysis(remains-2);
    if (remains >= 1) n += stepAnalysis(remains-1);
    return n;
  }

}
