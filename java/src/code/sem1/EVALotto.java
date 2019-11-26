package code.sem1;

import de.r13g.lib.Tools;
import de.r13g.lib.console.ConsoleExt;

import java.util.Arrays;

public class EVALotto {

  private int[] random = new int[6];
  private int[] user = new int[6];

  public static void main(String[] args) {
    new EVALotto();
  }

  private EVALotto() {

  }

  private void userInput() {
    for (int i = 0; i < user.length; i++) {
      user[i] = ConsoleExt.getInputInt("Lottozahl " + (i+1));
    }
    System.out.println();
  }

  private void randomGeneration() {
    for (int i = 0; i < random.length; i++) {
      int num = Tools.randomInt(1,49);
      while (Arrays.asList(random).contains(num)) {
        num = Tools.randomInt(1,49);
      }
      random[i] = num;
    }
  }

  private void printArrays() {
    System.out.println("-- Zufallszahlen --");
    System.out.println("-------------------");
    for (int i = 0; i < random.length; i++) {
      System.out.println("" + (i+1) + ": " + random[i]);
    }
    System.out.println();

    System.out.println("-- Eingabe --");
    System.out.println("-------------");
    for (int i = 0; i < user.length; i++) {
      System.out.println("" + (i+1) + ": " + user[i]);
    }
  }

  private int compareNumbers() {
    int cnt = 0;
    for (int n : user) {
      cnt += Arrays.asList(random).contains(n) ? 1 : 0;
    }
    return cnt;
  }

  private int[] compareRuns(int nRuns) {
    int[] results = new int[7];
    for (int i = 0; i < nRuns; i++) {
      randomGeneration();
      results[compareNumbers()] += 1;
    }
    return results;
  }

}
