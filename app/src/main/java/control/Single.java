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
   * <p><b>Bug history:</b> earlier revisions seeded the running maximum with
   * {@code 0}, which silently returned {@code 0} for any all-negative input
   * (e.g. {@code maxArray(new int[]{-3,-2,-1})} returned {@code 0} instead of
   * {@code -1} — a value not even present in the input array). The fix is to
   * seed the running maximum with {@link Integer#MIN_VALUE} so every real
   * array element strictly improves on the seed.
   *
   * @param arr The array of integers.
   * @return The maximum value in the array, or {@link Integer#MIN_VALUE} if
   *         {@code arr} is empty.
   * @throws NullPointerException if {@code arr} is null.
   */
  public static int maxArray(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i > max) {
        max = i;
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