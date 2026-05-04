package control;

import java.util.Vector;

public class Single {
  /**
   * This method is used to calculate the sum of the first n natural numbers.
   * n exclusive
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers.
   */
  public static int sumRange(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += i;
    }
    return sum;
  }

  /**
   * This method calculates the maximum value in an array of integers.
   *
   * @param arr The array of integers. Must be non-null and non-empty.
   * @return The maximum value in the array.
   * @throws NullPointerException     if {@code arr} is null.
   * @throws IllegalArgumentException if {@code arr} is empty.
   */
  public static int maxArray(int[] arr) {
    // Bug fix: previously seeded the running max with 0, which silently
    // returned 0 for any all-negative input (e.g. maxArray([-3,-2,-1])
    // returned 0 instead of -1 — a value not present in the array).
    // Seed from the first element instead, so all subsequent values
    // (including negatives) are compared against a real array element.
    // Empty input now fails fast rather than returning a meaningless 0.
    if (arr == null) {
      throw new NullPointerException("arr must not be null");
    }
    if (arr.length == 0) {
      throw new IllegalArgumentException(
          "maxArray requires a non-empty array");
    }
    int max = arr[0];
    for (int idx = 1; idx < arr.length; idx++) {
      if (arr[idx] > max) {
        max = arr[idx];
      }
    }
    return max;
  }

  /**
   * This method calculates the sum of the first n natural numbers, modulo m.
   *
   * @param n The number of natural numbers to sum.
   * @param m The modulus.
   */
  public static int sumModulus(int n, int m) {
    Vector<Integer> multiples = new Vector<Integer>();
    for (int i = 0; i < n; i++) {
      if (i % m == 0) {
        multiples.add(i);
      }
    }

    return multiples.stream().mapToInt(Integer::valueOf).sum();
  }
}