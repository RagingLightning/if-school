package de.r13g.lib.console;

public class ArrayConsole {
  
  /**
   * Gibt ein Array formatiert aus
   * 
   * @param name   Der name des Arrays im Tabellenkopf
   * @param array  Das auszugebende Array
   */
  
  public static void printDoubleArray(String name, double[] array) {
    int digits = (String.valueOf(array.length-1)).length();
    for (int i = digits; i > 0 ; i--) {
      System.out.print(" ");
    }
    System.out.println(" | " + name);
    for (int i = 0; i < digits+3+name.length(); i++) {
      System.out.print("-");
    }
    System.out.println();
    
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < digits - (String.valueOf(i)).length(); j++) {
        System.out.print(" ");
      }
      System.out.println(i + " | " + array[i]);
    }
  }
  
  public static void printIntArray(String name, int[] array) {
    int digits = (String.valueOf(array.length-1)).length();
    for (int i = digits; i > 0 ; i--) {
      System.out.print(" ");
    }
    System.out.println(" | " + name);
    for (int i = 0; i < digits+3+name.length(); i++) {
      System.out.print("-");
    }
    System.out.println();
    
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < digits - (String.valueOf(i)).length(); j++) {
        System.out.print(" ");
      }
      System.out.println(i + " | " + array[i]);
    }
  }
  
  public static void printFloatArray(String name, float[] array) {
    int digits = (String.valueOf(array.length-1)).length();
    for (int i = digits; i > 0 ; i--) {
      System.out.print(" ");
    }
    System.out.println(" | " + name);
    for (int i = 0; i < digits+3+name.length(); i++) {
      System.out.print("-");
    }
    System.out.println();
    
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < digits - (String.valueOf(i)).length(); j++) {
        System.out.print(" ");
      }
      System.out.println(i + " | " + array[i]);
    }
  }
  
    
  
}
