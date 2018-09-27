package sum;

import base.MainFilesChecker;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumFileChecker extends MainFilesChecker implements SChecker {
    public SumFileChecker(final String className) {
        super(className);
    }

    public void test(final Number result, final String... input) {
        checkEquals(Collections.singletonList(result.toString()), runFiles(Arrays.asList(input)));
    }
}
