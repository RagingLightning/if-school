package code.jg11.krypto;

import de.r13g.lib.console.ConsoleExt;

public class Caesar {

  private static int key = 3;
  private static int mode = 1;
  private static int iterations = 5;
  
  public static void main(String[] args) {
    if (args.length >= 2) {
      key = Integer.parseInt(args[1]);
      mode = args[0]=="enc" ? 0 : 1;
      if(args.length==3) {
        iterations = Integer.parseInt(args[2]);
      }
    }/* else {
      key = ConsoleExt.getInputInt("Key");
      mode = ConsoleExt.getInputInt("Mode");
      iterations = ConsoleExt.getInputInt("Iterations");
    }*/

    String input = ConsoleExt.getInputString("Nachricht");
    String result = "";

    switch (mode) {
    case 0:
      for (int i = 0; i < iterations; i++) {
        result = "";
        for (char c : input.toCharArray()) {
          result += (char) ((c+key) % 256);
        }
        input = result;
      }

      System.out.println("Verschlüsselt: " + result);
      break;
    case 1:
      for (int i = 0; i < iterations; i++) {
        result = "";
        for (char c : input.toCharArray()) {
          result += (char) ((c-key) % 256);
        }
        input = result;
      }

      System.out.println("Entschlüsselt: " + result);
      break;
    }

  }

}
