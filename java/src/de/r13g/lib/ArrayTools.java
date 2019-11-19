package de.r13g.lib;

public class ArrayTools {

  public static int min(Integer[] array) {
    int min = Integer.MAX_VALUE;
    for (int x : array) {
      min = x < min ? x : min;
    }
    return min;
  }

  public static int minIndex(Integer[] array) {
    int minIdx = 0;
    for (int i = 0; i < array.length; i++) {
      minIdx = array[i] < array[minIdx] ? i : minIdx;
    }
    return minIdx;
  }

  public static int max(Integer[] array) {
    int max = Integer.MIN_VALUE;
    for(int x : array) {
      max = x > max ? x : max;
    }
    return max;
  }

  public static int maxIndex(Integer[] array) {
    int maxIdx = 0;
    for (int i = 0; i < array.length; i++) {
      maxIdx = array[i] > array[maxIdx] ? i : maxIdx;
    }
    return maxIdx;
  }

  public static int sum(Integer[] array) {
    int sum = 0;
    for (int x : array) {
      sum += x;
    }
    return sum;
  }

  public static double avg(Integer[] array) {
    int sum = sum(array);
    return sum*1.0 / array.length;
  }

  public static int[] reverse(Integer[] array) {
    int[] reversed = new int[array.length];

    for (int i = 0; i < array.length; i++)
    {
      reversed[array.length-1-i] = array[i];
    }

    return reversed;
  }

}
