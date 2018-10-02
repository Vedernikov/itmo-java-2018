package sum;

import java.util.stream.Collectors;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumAbcTest extends SumTest {
    public SumAbcTest(final SChecker checker) {
        super(checker);
    }

    public static void main(final String... args) {
        new SumAbcTest(new SumChecker("SumAbc")).run();
    }

    @Override
    protected void test() {
        test(1, "b");
        test(6, "b", "C", "d");
        test(1, " b");
        test(1, "b ");
        test(1, "\tb\t");
        test(12345, "\tabcdef\t");
        test(1368, " abcd efg hij ");
        test(60, "Aba", "acA", "aDa");

        test(12345678, "bcdefghi");
        test(20541014, "CafeBabe");
        test(34031445, "DeadBeef");

        test(-1, "-b");
        test(-6, "-b", "-c", "-d");
        test(-12345, "\t-abCDef\t");
        test(-60, " -ABA -aca -ADA ");
        test(1, "+b");
        test(6, "+b", "+c", "+d");
        test(12345, "\t+abCDef\t");
        test(60, " +ABA +aca +ADA ");
        test(0);
        test(0, " ");
        test(Integer.MAX_VALUE, toString(Integer.MAX_VALUE));
        test(Integer.MIN_VALUE, toString(Integer.MIN_VALUE));

        randomTest(10, 100);
        randomTest(10, Integer.MAX_VALUE);
        randomTest(100, Integer.MAX_VALUE);
    }

    @Override
    protected String toString(final Number number) {
        return number.toString().chars()
                .map("+-0123456789"::indexOf)
                .map("+-abcdefghij"::charAt)
                .mapToObj(ch -> "" + (char) ch)
                .collect(Collectors.joining());
    }
}
