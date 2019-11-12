package de.r13g.lib;

public class ArrayTools {

  public static int min(int[] array) {
    int min = Integer.MAX_VALUE;
    for (int x : array) {
      min = x < min ? x : min;
    }
    return min;
  }

  public static int max(int[] array) {
    int max = Integer.MIN_VALUE;
    for(int x : array) {
      max = x > max ? x : max;
    }
    return max;
  }

  public static int sum(int[] array) {
    int sum = 0;
    for (int x : array) {
      sum += x;
    }
    return sum;
  }

  public static double avg(int[] array) {
    int sum = sum(array);
    return sum*1.0 / array.length;
  }

  public static int[] reverse(int[] array) {
    int[] reversed = new int[array.length];

    for (int i = 0; i < array.length; i++)
    {
      reversed[array.length-1-i] = array[i];
    }

    return reversed;
  }

}
