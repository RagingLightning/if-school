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
        int num = Tools.randomInt(1,49);
      }
      random[i] = num;
    }
  }

  private void printArrays() {

  }

  private int compareNumbers() {

  }

  private int[] compareRuns(int nRuns) {

  }

}
