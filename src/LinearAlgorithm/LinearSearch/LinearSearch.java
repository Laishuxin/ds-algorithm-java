package LinearAlgorithm.LinearSearch;

/**
 * Project  algorithm
 *
 * @author LaiShuXin
 * @time 2021-08-26 0:40
 */
public class LinearSearch {

  private LinearSearch() {}

  public static <T> int linearSearch(T[] arr, T target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(target)) return i;
    }
    return -1;
  }
}
