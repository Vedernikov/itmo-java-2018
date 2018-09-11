package sum;

import base.MainChecker;

import java.util.Collections;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumChecker extends MainChecker implements SChecker {
    public SumChecker(final String className) {
        super(className);
    }

    @Override
    public void test(final Number result, final String... input) {
        checkEquals(Collections.singletonList(result.toString()), run(input));
    }
}
