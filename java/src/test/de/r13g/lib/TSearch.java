package de.r13g.lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TSearch {

  private static int[] array1, array2;

  static {
    array1 = new int[2000];
    for(int i = 1; i <= array1.length; i++) array1[i-1] = 2*i;
    array2 = new int[1857];
    for(int i = 1; i <= array2.length; i++) array2[i-1] = i;
  }


  @Test
  public void testBinarySearch() {
    assertEquals(250, Search.binarySearch(array1, 502));
    assertEquals(-1, Search.binarySearch(array1, 1));
    assertEquals(249, Search.binarySearch(array1, 500));
    assertEquals(127, Search.binarySearch(array1, 256));
    assertEquals(110, Search.binarySearch(array1, 222));
    assertEquals(221, Search.binarySearch(array1, 444));

    assertEquals(249, Search.binarySearch(array2, 250));
    assertEquals(-1, Search.binarySearch(array2, 2563));
    assertEquals(-1, Search.binarySearch(array2, -12));
    assertEquals(1597, Search.binarySearch(array2, 1598));
    assertEquals(234, Search.binarySearch(array2, 235));
    assertEquals(998, Search.binarySearch(array2, 999));
  }

  @Test
  public void testLinearSearch() {
    assertEquals(250, Search.linearSearch(array1, 502));
    assertEquals(-1, Search.linearSearch(array1, 1));
    assertEquals(249, Search.linearSearch(array1, 500));
    assertEquals(127, Search.linearSearch(array1, 256));
    assertEquals(110, Search.linearSearch(array1, 222));
    assertEquals(221, Search.linearSearch(array1, 444));

    assertEquals(249, Search.linearSearch(array2, 250));
    assertEquals(-1, Search.linearSearch(array2, 2563));
    assertEquals(-1, Search.linearSearch(array2, -12));
    assertEquals(1597, Search.linearSearch(array2, 1598));
    assertEquals(234, Search.linearSearch(array2, 235));
    assertEquals(998, Search.linearSearch(array2, 999));
  }



}
