package code.sem1;

import de.r13g.lib.AdvancedString;
import de.r13g.lib.console.ConsoleExt;

@SuppressWarnings("unused")
public class StringSpass {

  public static void main(String[] args) {
    sort();
  }

  private static void length() {
    String s = ConsoleExt.getInputString("String");
    System.out.println(s.length());
  }

  private static void chars() {
    String s = ConsoleExt.getInputString("String");
    System.out.println("2: " + s.charAt(1) + ", 4:" + s.charAt(3) + ", 9:" + s.charAt(8));
  }

  private static void replace() {
    String s = ConsoleExt.getInputString("String");
    AdvancedString a = AdvancedString.fromString(s)
            .replaceCharAt(6, 'x')
            .replaceCharAt(0, 'o');
    System.out.println(a);
  }

  private static void repeat() {
    String s = ConsoleExt.getInputString("String");
    AdvancedString.fromString(s).repeat(2);
  }

  private static void equal() {
    String s1 = ConsoleExt.getInputString("String1");
    String s2 = ConsoleExt.getInputString("String2");
    System.out.println(s1.equals(s2));
  }

  private static void sort() {
    String s1 = ConsoleExt.getInputString("String1");
    String s2 = ConsoleExt.getInputString("String2");
    int diff = s1.compareTo(s2);
    if(diff==0) { System.out.println(s1 + "==" + s2);
    } else if (diff < 0) { System.out.println(s1 + "-+" + Math.abs(diff) + "->" + s2);
    } else { System.out.println(s2 + "-+" + diff + "-> + s1"); }
  }
}
