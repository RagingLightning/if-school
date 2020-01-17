package de.r13g.lib;

public class Search {

  public static int linearSearch(int[] array, int key) {
    for (int i = 0; i < array.length; i++) {
      if (array[i]==key) return i;
    }
    return -1;
  }

  public static int oldBinarySearch(int[] array, int key) {
    int i = array.length/2;
    int step = i;
    do {
      step /= 2;
      i = array[i] < key ? i+step : i-step;
      if (array[i]==key) return i;
    } while (step>1);
    return -1;
  }

  public static int binarySearch(int[] array, int key) {
    int i = array.length/2;
    int previ = 0;
    do {
      if (array[i]==key) return i;

    } while (previ!=i);
    return -1;
  }

}
