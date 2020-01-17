package de.r13g.lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TSearch {

  private static int[] array1;

  static {
    array1 = new int[2000];
    for(int i = 1; i <= array1.length; i++) array1[i-1] = 2*i;
  }


  @Test
  public void testBinarySearch1() {
    assertEquals(250, Search.binarySearch(array1, 502));
  }

  @Test
  public void testBinarySearch2() {
    assertEquals(-1, Search.binarySearch(array1, 1));
  }

  @Test
  public void testBinarySearch3() {
    assertEquals(249, Search.binarySearch(array1, 500));
  }

  @Test
  public void testBinarySearch4() {
    assertEquals(127, Search.binarySearch(array1, 256));
  }

  @Test
  public void testBinarySearch5() {
    assertEquals(110, Search.binarySearch(array1, 222));
  }

  @Test
  public void testBinarySearch6() {
    assertEquals(221, Search.binarySearch(array1, 444));
  }



}
