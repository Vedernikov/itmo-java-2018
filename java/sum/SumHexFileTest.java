package sum;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumHexFileTest extends SumHexTest {
    public SumHexFileTest(final SChecker checker) {
        super(checker);
    }

    public static void main(final String... args) {
        new SumHexTest(new SumFileChecker("SumHexFile")).run();
    }
}
