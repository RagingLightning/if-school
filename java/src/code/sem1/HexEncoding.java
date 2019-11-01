package code.sem1;

import de.r13g.lib.console.ConsoleExt;

import java.util.ArrayList;
import java.util.HashMap;

public class HexEncoding {

  public static void main(String[] args) {
    HashMap<Integer, String> prefixes = setPrefixes();
    System.out.println("*** Zahlenencoder ***");
    int num = ConsoleExt.getInputInt("Dezimalzahl");
    int base = ConsoleExt.getInputInt("Basis (2,3,8,16)");

    StringBuilder result = new StringBuilder();

    while (num >  0) {
      int rest = num % base;
      num = num / base;
      switch (rest) {
        case 0:
          result.insert(0,0);
          break;
        case 1:
          result.insert(0,1);
          break;
        case 2:
          result.insert(0,2);
          break;
        case 3:
          result.insert(0,3);
          break;
        case 4:
          result.insert(0,4);
          break;
        case 5:
          result.insert(0,5);
          break;
        case 6:
          result.insert(0,6);
          break;
        case 7:
          result.insert(0,7);
          break;
        case 8:
          result.insert(0,8);
          break;
        case 9:
          result.insert(0,9);
          break;
        case 10:
          result.insert(0,"A");
          break;
        case 11:
          result.insert(0,"B");
          break;
        case 12:
          result.insert(0,"C");
          break;
        case 13:
          result.insert(0,"D");
          break;
        case 14:
          result.insert(0,"E");
          break;
        case 15:
          result.insert(0,"F");
          break;
      }
    }
    result.insert(0, prefixes.get(base));
    System.out.println(result);
  }

  static HashMap<Integer, String> setPrefixes() {
    HashMap<Integer, String> prefixes = new HashMap<>();
    prefixes.put(2, "0b");
    prefixes.put(3, "0t");
    prefixes.put(8, "0o");
    prefixes.put(16, "0x");
    return prefixes;
  }
}
