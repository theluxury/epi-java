import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.IllegalFormatCodePointException;

import static org.junit.Assert.*;

/**
 * Created by theluxury o
 * n 11/12/15.
 */
public class Problem_5_4 {

    public static void main(String args[]) {
        assertTests();
    }

    public static long returnClosest(long num) {
        if (num == 0L || num == Constants.BIGGEST_NEGATIVE_LONG) {
            throw new java.lang.IllegalArgumentException("Doesn't work for 0 or biggest negative int.");
        }
        for (int i = 0; i < 64; i++) {
            int j = i + 1;
            if (((num & (1L << i)) == 0) != ((num & (1L << j)) == 0)) {
                return Problem_5_2.swapBits(num, i, j);

            }
        }
        // Should never get here
        return 0;
    }

    @Test
    public static void assertTests() {
        // This seems inelegant but nothing else worked.
        try {
            returnClosest(0);
            fail("Method didn't throw error when expected");
        } catch (IllegalArgumentException e) {
        }
        try {
            returnClosest(Constants.BIGGEST_NEGATIVE_LONG);
            fail("Method didn't throw error when expected");
        } catch (IllegalArgumentException e) {
        }

        assertEquals(2, returnClosest(1));
        assertEquals(1, returnClosest(2));
        assertEquals(13, returnClosest(11));
        assertEquals(14, returnClosest(13));
        assertEquals(26, returnClosest(28));
        assertEquals(25, returnClosest(26));
    }

}
