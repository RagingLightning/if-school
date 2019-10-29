package de.r13g.lib;

public class StringTools {

  public static String replaceCharAt(String string, int position, char replacement) {
    char[] array = string.toCharArray();
    array[position] = replacement;
    return new String(array);
  }

}
