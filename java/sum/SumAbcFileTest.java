package sum;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SumAbcFileTest {
    public static void main(final String... args) {
        new SumAbcTest(new SumFileChecker("SumAbcFile")).run();
    }
}
