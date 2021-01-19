package code.sem2;

import de.r13g.lib.console.ArrayConsole;
import de.r13g.lib.console.ConsoleExt;

public class Comeback {

  double K_0, P, K_n[];
  int Years;
  boolean Iter;

  private void Input() {
    K_0 = ConsoleExt.getInputDouble("Startkapital");
    P = ConsoleExt.getInputDouble("Zinssatz");
    Years = ConsoleExt.getInputInt("Laufzeit in Jahren");
    Iter = ConsoleExt.getInputChar("Iterative Berechnung? (y/n)")=='y';
  }

  Comeback() {
    Input();
    ArrayConsole.MultiColumn multi = ArrayConsole.newMultiColumn();
    for (int m = 1; m <= 5; m++) {
      int run = Years+((int)(Math.random()*10));
      K_n = new double[run+1];
      K_n[0] = K_0;
      if (Iter) {
        for (int i = 1; i <= run; i++) {
          K_n[i] = K_n[i - 1] * (1 + P*m / 100);
        }
        System.out.println(K_n[Years]);
      } else {
        System.out.println(CalcK_n(Years));
      }
      multi.addDoubleArray("p=" + (P * m), K_n, 5);
    }
    //ArrayConsole.printDoubleArray("K_n", K_n);
    multi.print();
  }

  private double CalcK_n(int y) {
    double k = y > 0 ? CalcK_n(y-1) * (1 + P / 100) : K_0;
    K_n[y] = k;
    return k;
  }

  public static void main(String[] args) {
    new Comeback();
  }

}
