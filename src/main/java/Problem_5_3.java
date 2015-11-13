import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by theluxury on 11/12/15.
 */
public class Problem_5_3 {

    public static void main(String args[]) {
        testAssertions();
    }

    public static long reverseBits(long number) {
        for (int i = 0; i < 64 / 2; i++) {
            number = Problem_5_2.swapBits(number, i, 63 - i);
        }
        return number;
    }

    @Test
    public static void testAssertions() {
        assertEquals(0, reverseBits(0));
        assertEquals((long) (-(Math.pow(2, 63))), reverseBits(1));
        // 24 = 8 + 16 has bits at 3 and 4
        // so opposite should have bits at 60 and 59
        assertEquals((long) (Math.pow(2, 59) + Math.pow(2, 60)), reverseBits(24));
    }
}
