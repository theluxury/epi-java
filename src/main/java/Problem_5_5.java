import com.google.common.collect.Sets;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by theluxury on 11/12/15.
 */
public class Problem_5_5 {

    public static void main(String[] args) {
        MyTests.assertTests();
    }

    public static void getPowerSet(Set<?> elements) {
        String bitString = "";
        for (int i = 0; i < elements.size(); i++) {
            bitString += "1";
        }
        BigInteger bigInt = new BigInteger(bitString, 2);
        BigInteger loopInt = new BigInteger("");
        bigInt.toByteArray();

        while (loopInt.compareTo(bigInt) <= 0) {
            loopInt.add(new BigInteger("1"));
        }

        for (loopInt; i < bigInt; i++) {

        }

    }

    public static class MyTests {

        @Rule
        public static SystemOutRule systemOutRule = new SystemOutRule().enableLog();

        @Test
        public static void assertTests() {
            // This might not work. let's see!
            assertError();
            assertEmpty();
            assertNumbers();

        }

        @Test
        public static void assertError() {
            try {
                getPowerSet(null);
                fail("Null set should have raised error.")
            } catch (NullPointerException e) {
            }
        }

        @Test
        public static void assertEmpty() {
            Set<String> emptySet = new HashSet<>();
            getPowerSet(emptySet);
            assertEquals("", systemOutRule.getLog());
        }

        @Test
        public static void assertNumbers() {
            Set<Integer> intSet = Sets.newHashSet(1, 2, 3);
            getPowerSet(intSet);
            assertEquals(" \n1\n2\n1,2", systemOutRule.getLog());
        }

    }
}
