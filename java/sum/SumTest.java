package sum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumTest {
    protected final SChecker checker;

    protected SumTest(final SChecker checker) {
        this.checker = checker;
    }

    public static void main(final String... args) {
        new SumTest(new SumChecker("Sum")).run();
    }

    public void run() {
        test();
        checker.printStatus();
    }

    protected void test() {
        test(1, "1");
        test(6, "1", "2", "3");
        test(1, " 1");
        test(1, "1 ");
        test(1, "\t1\t");
        test(12345, "\t12345\t");
        test(60, "010", "020", "030");
        test(1368, " 123 456 789 ");
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
        randomTest(10, 100);
        randomTest(10, Integer.MAX_VALUE);
        randomTest(100, Integer.MAX_VALUE);
    }

    protected void test(final Number result, final String... input) {
        checker.test(result, input);
    }

    protected void randomTest(final int numbers, final Number max) {
        Number[] values = new Number[numbers];
        for (int i = 0; i < values.length; i++) {
            values[i] = randomValue(max, checker.getRandom());
        }
        testRandom(sum(values), values);
    }

    protected void testRandom(final Number result, final Number[] args) {
        final List<String> spaced = Arrays.stream(args)
                .map(this::toString)
                .map(value -> randomSpace() + value + randomSpace())
                .collect(Collectors.toList());
        final List<String> argsList = new ArrayList<>();
        for (final Iterator<String> i = spaced.listIterator(); i.hasNext(); ) {
            StringBuilder next = new StringBuilder(i.next());
            while (i.hasNext() && checker.getRandom().nextBoolean()) {
                next.append(randomSpace()).append(i.next());
            }
            argsList.add(next.toString());
        }
        test(result, argsList.toArray(new String[0]));
    }

    private String randomSpace() {
        return checker.randomString(getSpaces());
    }

    protected String getSpaces() {
        return " \t\n\u000B\u2029\f";
    }

    protected String toString(Number number) {
        return number.toString();
    }

    protected Number sum(Number[] values) {
        return Arrays.stream(values).mapToInt(Number::intValue).sum();
    }

    protected Number randomValue(final Number max, final Random random) {
        return random.nextInt() % max.intValue();
    }
}
