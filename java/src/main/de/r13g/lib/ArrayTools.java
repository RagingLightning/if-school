package de.r13g.lib;

public class ArrayTools {

  /**
   * determines the lowest value inside the given Array
   *
   * @param array the array to be analyzed
   * @return      the lowest value inside the array
   */
  public static int min(Integer[] array) {
    int min = Integer.MAX_VALUE;
    for (int x : array) {
      min = x < min ? x : min;
    }
    return min;
  }

  /**
   * determines the index of the lowest value inside the array
   *
   * @param array the array to be anayzed
   * @return      the array index with the lowest value
   */
  public static int minIndex(Integer[] array) {
    int minIdx = 0;
    for (int i = 0; i < array.length; i++) {
      minIdx = array[i] < array[minIdx] ? i : minIdx;
    }
    return minIdx;
  }

  /**
   * determines the highest value inside the given array
   *
   * @param array the array to be analyzed
   * @return      the highest value in the array
   */
  public static int max(Integer[] array) {
    int max = Integer.MIN_VALUE;
    for(int x : array) {
      max = x > max ? x : max;
    }
    return max;
  }

  /**
   * determines the index with the lowest value in the given array
   *
   * @param array the array to be analyzed
   * @return      the array index with the highest value
   */
  public static int maxIndex(Integer[] array) {
    int maxIdx = 0;
    for (int i = 0; i < array.length; i++) {
      maxIdx = array[i] > array[maxIdx] ? i : maxIdx;
    }
    return maxIdx;
  }

  /**
   * calculates the sum of all values in the given array
   *
   * @param array the array of values that get summed up
   * @return      the sum of all values
   */
  public static int sum(Integer[] array) {
    int sum = 0;
    for (int x : array) {
      sum += x;
    }
    return sum;
  }

  /**
   * calculates the average of all values in a given array
   *
   * @param array the array with values to be averaged
   * @return      the average of all values
   */
  public static double avg(Integer[] array) {
    int sum = sum(array);
    return sum*1.0 / array.length;
  }

  /**
   * reverses a given array
   *
   * @param array array to be reversed
   * @return      reversed array
   */
  public static int[] reverse(Integer[] array) {
    int[] reversed = new int[array.length];

    for (int i = 0; i < array.length; i++)
    {
      reversed[array.length-1-i] = array[i];
    }

    return reversed;
  }

}
