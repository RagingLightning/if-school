package code.sem1;

import de.r13g.lib.Tools;
import de.r13g.lib.console.ConsoleExt;

public class RunLengthEncoding {

  public static void main(String[] args) {
    String s = ConsoleExt.getInputString("String");
    System.out.println(Tools.runLengthEncoding(s, 1));
  }
}
