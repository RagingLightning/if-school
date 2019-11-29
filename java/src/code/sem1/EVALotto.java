package code.sem1;

import de.r13g.lib.Tools;
import de.r13g.lib.console.ArrayConsole;
import de.r13g.lib.console.ConsoleExt;

import java.util.Arrays;

public class EVALotto {

  private int[] random = new int[6];
  private int[] user = new int[6];

  public static void main(String[] args) {
    new EVALotto();
  }

  private EVALotto() {
    while (true) {
      int mode = ConsoleExt.getInputInt("Einzelne Ziehung(1) oder mehrere Ziehungen(2)?");
      if (mode == 1) {
        userInput();
        randomGeneration();
        int right = compareNumbers();

        printArrays();
        System.out.println(right);

        if (ConsoleExt.getInputInt("Nochmal ?(1/0)") == 0)
          break;
      } else if (mode == 2) {
        int nRuns = ConsoleExt.getInputInt("Anzahl der Ziehungen");

        compareRuns(nRuns);

        if (ConsoleExt.getInputInt("Nochmal ?(1/0)") == 0)
          break;
      } else {
        System.out.println("Ungültige Eingabe");
      }
      compareRuns((int) Math.pow(10, 10));
    }
  }

  private void userInput()
  {
    for (int i = 0; i < user.length; i++)
    {
      user[i] = ConsoleExt.getInputInt("Lottozahl " + (i+1));
    }
    System.out.println();
  }

  private void randomGeneration()
  {
    for (int i = 0; i < random.length; i++)
    {
      int num = Tools.randomInt(1,49);
      while (Arrays.asList(random).contains(num))
      {
        num = Tools.randomInt(1,49);
      }
      random[i] = num;
    }
  }

  private void printArrays()
  {
    ArrayConsole.printIntArray("Usereingabe", user);
    ArrayConsole.printIntArray("Generiert", random);
  }

  private int compareNumbers()
  {
    int right = 0;
    for (int i : user)
    {
      for (int j : random)
      {
        if (i == j) right++;
      }
    }
    return right;
  }

  private void compareRuns(int nRuns)
  {
    int[] cOfNumRight = new int[7];
    userInput();
    for (int i = 0; i < nRuns; i++)
    {
      randomGeneration();
      int cRight = compareNumbers();
      cOfNumRight[cRight]++;
      if(i%1000000==0) System.out.println(i);
    }
    ArrayConsole.printIntArray("Ergebnisse", cOfNumRight);
  }

}
