package LinearAlgorithm.LinearSearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Project  algorithm
 *
 * @author LaiShuXin
 * @time 2021-08-26 8:57
 */
class LinearSearchTest {

  static Integer[] arrayGenerator(int length) {
    Integer[] arr = new Integer[length];
    for (int i = 0; i < length; i++) {
      arr[i] = i;
    }
    return arr;
  }

  @BeforeEach
  void setUp() {}

  @Test
  void linearSearch() {
    Integer[] arr = arrayGenerator(10);
    assertEquals(LinearSearch.linearSearch(arr, 100), -1);
    assertEquals(LinearSearch.linearSearch(arr, 1), 1);
    assertEquals(LinearSearch.linearSearch(arr, 0), 0);
    assertEquals(LinearSearch.linearSearch(arr, 9), 9);
    assertEquals(LinearSearch.linearSearch(arr, 5), 5);
  }
}
