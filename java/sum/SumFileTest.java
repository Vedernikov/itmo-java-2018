package sum;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumFileTest {
    public static void main(final String... args) {
        new SumTest(new SumFileChecker("SumFile")).run();
    }
}
