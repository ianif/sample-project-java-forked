package control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SingleTest {
  @Test
  public void testSumRange() {
    assertEquals(0, Single.sumRange(0));
    assertEquals(0, Single.sumRange(1));
    assertEquals(1, Single.sumRange(2));
    assertEquals(3, Single.sumRange(3));
    assertEquals(6, Single.sumRange(4));
    assertEquals(45, Single.sumRange(10));
  }

  @Test
  public void testMaxArray() {
    assertEquals(0, Single.maxArray(new int[] { 0 }));
    assertEquals(5, Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
    assertEquals(1, Single.maxArray(new int[] { 1, 1, 1, 1, 0 }));
    assertEquals(0, Single.maxArray(new int[] { -1, -1, -1, -1, 0 }));
  }

  /**
   * Regression test for the seed-to-zero bug: previously {@code maxArray}
   * initialised its running max to {@code 0}, so any array containing only
   * negative numbers silently returned {@code 0} (a value not present in the
   * input) instead of the true maximum. The fix seeds with
   * {@link Integer#MIN_VALUE} so any real array element strictly improves on
   * the seed.
   */
  @Test
  public void testMaxArrayAllNegative() {
    assertEquals(-1, Single.maxArray(new int[] { -1 }));
    assertEquals(-1, Single.maxArray(new int[] { -3, -2, -1 }));
    assertEquals(-1, Single.maxArray(new int[] { -1, -2, -3 }));
    assertEquals(-5, Single.maxArray(new int[] { -5, -5, -5 }));
    assertEquals(-1, Single.maxArray(new int[] { -100, -50, -1, -200 }));
  }

  @Test
  public void testMaxArrayMixedSigns() {
    // Confirms the max is picked correctly even when negatives dominate.
    assertEquals(2, Single.maxArray(new int[] { -10, -5, 2, -1 }));
    assertEquals(-1, Single.maxArray(new int[] { -10, -5, -1, -100 }));
    assertEquals(100, Single.maxArray(new int[] { -1000, 100, -1 }));
  }

  @Test
  public void testMaxArrayMinValueOnly() {
    // The most extreme negative-only case.
    assertEquals(Integer.MIN_VALUE,
        Single.maxArray(new int[] { Integer.MIN_VALUE }));
    assertEquals(Integer.MIN_VALUE,
        Single.maxArray(new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE }));
    // A single element greater than MIN_VALUE must still be picked correctly,
    // confirming the MIN_VALUE seed never accidentally "wins".
    assertEquals(Integer.MIN_VALUE + 1,
        Single.maxArray(new int[] { Integer.MIN_VALUE + 1 }));
  }

  @Test
  public void testMaxArrayMaxValue() {
    // Defensive: ensure the seed never overshoots a real maximum.
    assertEquals(Integer.MAX_VALUE,
        Single.maxArray(new int[] { 0, Integer.MAX_VALUE, -1 }));
  }

  @Test
  public void testMaxArraySingleElement() {
    // The seed must never be returned in place of a real single element.
    assertEquals(7, Single.maxArray(new int[] { 7 }));
    assertEquals(-7, Single.maxArray(new int[] { -7 }));
  }

  @Test
  public void testSumModulus() {
    assertEquals(0, Single.sumModulus(0, 1));
    assertEquals(0, Single.sumModulus(1, 2));
    assertEquals(0, Single.sumModulus(2, 2));
    assertEquals(2, Single.sumModulus(3, 2));
    assertEquals(2, Single.sumModulus(4, 2));
    assertEquals(20, Single.sumModulus(10, 2));
    assertEquals(18, Single.sumModulus(10, 3));
    assertEquals(12, Single.sumModulus(10, 4));
  }
}