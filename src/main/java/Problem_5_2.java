import com.google.common.primitives.Longs;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by theluxury on 11/12/15.
 */
public class Problem_5_2 {

    public static void main(String[] args) {
        testAssertions();
    }

    public static long swapBits(long number, int i, int j) {
        if (i < 0 || i > 63 || j < 0 || j > 63 || i == j) {
            throw new java.lang.IllegalArgumentException("Improper index.");
        }

        if (((number >>> i) & 1) != ((number >>> j) & 1)) {
            number ^= (1L << i) | (1L << j);
        }

        return number;
    }

    @Test
    public static void testAssertions() {
        assertEquals(8, swapBits(8, 0, 1));
        assertEquals(6, swapBits(5, 0, 1));
        assertEquals(1, swapBits((long) (-Math.pow(2, 63)), 63, 0));
    }

}
