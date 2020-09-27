/**
 * The package of different sort algorithms
 * @author chanboshuo
 * @version 0.1
 * @date 2020-9-26
 */
// import java.util.*;


public final class Sort {

  public static void selectionSort(int[] a) {
    for (int ordered = 0; ordered < a.length; ++ordered) {
      int min_index = ordered;
      for (int i = ordered; i < a.length; ++i) {
        if (a[i] < a[min_index]) {
          min_index = i;
        }
      }
      swap(a, ordered, min_index);
    }
  }

  private static void swap(int[] l, int i, int j) {
    int temp = l[i];
    l[i] = l[j];
    l[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = { 45, 32, 67, 54, 34, 32, 21, 25, 67, 98 };

    for (int i = 0; i < 10; ++i) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    selectionSort(a);

    for (int i = 0; i < 10; ++i) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

  }
}
