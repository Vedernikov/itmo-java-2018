package sum;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumBigIntegerTest extends SumTest {
    public SumBigIntegerTest(final SChecker checker) {
        super(checker);
    }

    public static void main(final String... args) {
        new SumBigIntegerTest(new SumChecker("SumBigInteger")).run();
    }

    @Override
    protected void test() {
        test(1, "1");
        test(6, "1", "2", "3");
        test(1, " 1");
        test(1, "1 ");
        test(1, "\t1\t");
        test(12345, "\t12345\t");
        test(1368, " 123 456 789 ");
        test(60, "010", "020", "030");
        test(-1, "-1");
        test(-6, "-1", "-2", "-3");
        test(-12345, "\t-12345\t");
        test(-1368, " -123 -456 -789 ");
        test(1, "+1");
        test(6, "+1", "+2", "+3");
        test(12345, "\t+12345\t");
        test(1368, " +123 +456 +789 ");
        test(0);
        test(0, " ");
        test(0, "10000000000000000000000000000000000000000 -10000000000000000000000000000000000000000");
        randomTest(10, 10);
        randomTest(10, 100);
        randomTest(10, 1000);
        randomTest(10, 10000);
        randomTest(1000, 10000);
    }

    @Override
    protected Number sum(final Number[] values) {
        return Arrays.stream(values).map(v -> (BigInteger) v).reduce(BigInteger.ZERO, BigInteger::add);
    }

    @Override
    protected Number randomValue(final Number max, final Random random) {
        BigInteger v = new BigInteger(max.intValue(), random);
        if (random.nextBoolean()) {
            v = v.negate();
        }
        return v;
    }
}
