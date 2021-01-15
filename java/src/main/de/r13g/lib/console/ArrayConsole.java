package de.r13g.lib.console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ArrayConsole {

  public static MultiColumn newMultiColumn() {
    return new MultiColumn();
  }
  /**
   * Gibt ein Double Array formatiert aus
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

  /**
   * Gibt ein Integer Array formatiert aus
   *
   * @param name   Der name des Arrays im Tabellenkopf
   * @param array  Das auszugebende Array
   */
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

  /**
   * Gibt ein Float Array formatiert aus
   *
   * @param name   Der name des Arrays im Tabellenkopf
   * @param array  Das auszugebende Array
   */
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
  
  public static class MultiColumn {

    LinkedHashMap<String, Integer> colWidth = new LinkedHashMap<>();
    LinkedHashMap<String, String[]> arrays = new LinkedHashMap<>();
    int maxIndex = 0;

    public void print() {
      for (int i = 0; i < String.valueOf(maxIndex).length(); i++) {
        System.out.print(" ");
      }
      for (String name : arrays.keySet()) {
        System.out.print(" │ ");
        StringBuilder longName = new StringBuilder(name);
        while (longName.length() < colWidth.get(name)) {
          longName.append(" ");
        }
        System.out.print(longName);
      }
      System.out.println();

      //header line
      for (int i = 0; i < String.valueOf(maxIndex).length(); i++) {
        System.out.print("─");
      }
      for (String name : arrays.keySet()) {
        System.out.print("─┼─ ");
        for (int i = 0; i < colWidth.get(name); i++) {
          System.out.print("─");
        }
      }
      System.out.println();

      //data

    }

    public void addIntArray(String name, int[] array, int maxLength) {
      name = name.trim();
      String[] values = new String[array.length];
      for (int i = 0; i < array.length; i++) {
        values[i] = String.valueOf(array[i]);
        if (maxLength != -1) values[i] = values[i].substring(0,maxLength-1);
        colWidth.put(name, Math.max(values[i].length(), colWidth.getOrDefault(name, 0));
      }
      arrays.put(name, values);
      maxIndex = Math.max(maxIndex, array.length);
    }

    public void addIntArray(String name, int[] array) {
      addIntArray(name, array, -1);
    }

  }
  
}
