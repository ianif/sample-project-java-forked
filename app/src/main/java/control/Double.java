package control;

public class Double {
  /**
   * Sums all values squared from 0 to n
   *
   * @param n The number of natural numbers to sum.
   * @return The sum of the first n natural numbers squared.
   */
public static int sumSquare(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + i * i;
    }
    return sum;
  }

  /**
   * Sums all triangular numbers from T(1) to T(n)
   *
   * @param n The number of triangular numbers to sum.
   * @return The sum of the first n triangular numbers.
   */
  public static int sumTriangle(int n) {
    int sum = 0;
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < i; j++) {
        sum = sum + j;
      }
    }
    return sum;
  }

  /**
   * Counts the number of pairs in an array
   *
   * A pair is any value that is repeated exactly twice in the array.
   *
   * @param arr The array of integers.
   * @return The number of pairs in the array.
   */
  public static int countPairs(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int nDuplicates = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          nDuplicates++;
        }
      }
      if (nDuplicates == 2) {
        count++;
      }
    }
    return count / 2;
  }

  /**
   * Counts the number of instances where the values at the same index are equal
   *
   * @param arr0 The first array of integers.
   * @param arr1 The second array of integers.
   * @return The number of instances where the values at the same index are
   *         equal.
   */
  public static int countDuplicates(int[] arr0, int[] arr1) {
    int count = 0;
    for (int i = 0; i < arr0.length; i++) {
      for (int j = 0; j < arr1.length; j++) {
        if (i == j && arr0[i] == arr1[j]) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Sums all values in a 2D array
   *
   * note: dimensions must be equal
   *
   * @param arr The 2D array of integers.
   * @return The sum of all values in the 2D array.
   */
  public static int sumMatrix(int[][] arr) {
    int sum = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }
}