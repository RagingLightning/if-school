package code.sem1.einstieg;

import de.r13g.lib.console.ConsoleExt;

public class ModuloRechner {

  public static void main(String[] args) {
    System.out.println("*** Modulo-Rechner ***");
    int dividend = ConsoleExt.getInputInt("Dividend [int]");
    int divisor = ConsoleExt.getInputInt("Divisor [int]");

    int quotient = dividend / divisor;
    int rest = dividend - quotient * divisor;

    System.out.println("-----------------");
    System.out.println("Rest: " + rest);
  }
}
