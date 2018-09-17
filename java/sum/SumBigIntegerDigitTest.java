package sum;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumBigIntegerDigitTest extends SumBigIntegerTest {
    public SumBigIntegerDigitTest(final SChecker checker) {
        super(checker);
    }

    public static void main(final String... args) {
        new SumBigIntegerDigitTest(new SumChecker("SumBigInteger")).run();
    }

    @Override
    protected void test() {
        test(1, "1");
        test(6, "1", "2", "3");
        test(1, " 1");
        test(1, "1 ");
        test(1, "\u00a01\u00a0");
        test(12345, "\u00a012345\u00a0");
        test(1368, " 123 456 789 ");
        test(60, "010", "020", "030");
        test(-1, "-1");
        test(-6, "-1", "-2", "-3");
        test(-12345, "\u00a0-12345\u00a0");
        test(-1368, " -123 -456 -789 ");
        test(1, "+1");
        test(6, "+1", "+2", "+3");
        test(12345, "\u00a0+12345\u00a0");
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
    protected String getSpaces() {
        return " abc\u2000\u2001\u2002\u2003\u00A0\u2007\u202F\u2382";
    }
}
