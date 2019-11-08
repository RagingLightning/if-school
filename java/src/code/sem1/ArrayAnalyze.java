package code.sem1;

import de.r13g.lib.Tools;
import de.r13g.lib.console.ConsoleExt;

public class ArrayAnalyze {

  public static void main(String[] args) {
    int length = ConsoleExt.getInputInt("Anzahl der Werte");
    int[] werte = new int[length];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int sum = 0;
    System.out.print("Array: ");
    for (int i = 0; i < length; i++) {
      werte[i] = Tools.randomInt(-999,999);
      min = werte[i] < min ? werte[i] : min;
      max = werte[i] > max ? werte[i] : max;
      sum += werte[i];
      System.out.print(werte[i] + (i+1<length?", ":"\n"));
    }
    double avg = sum*1.0 / length;
    System.out.printf("Min: %s%nMax: %s%nSum: %s%nAvg: %s" + "%n", min, max, sum, avg);
  }

}
