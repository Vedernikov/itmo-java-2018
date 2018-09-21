package reverse;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class ReverseTest {
    public static final int MAX_SIZE = 10_000;
    private final ReverseChecker checker;
    private final int maxSize;

    public  ReverseTest(final int maxSize) {
        this("Reverse", maxSize);
    }

    protected ReverseTest(final String className, final int maxSize) {
        checker = new ReverseChecker(className);
        this.maxSize = maxSize;
    }

    public static void main(String... args) {
        new ReverseTest("Reverse", MAX_SIZE).run();
    }

    protected void run() {
        test(new int[][]{
                {1}
        });
        test(new int[][]{
                {1, 2},
                {3}
        });
        test(new int[][]{
                {1, 2, 3},
                {4, 5},
                {6}
        });
        test(new int[][]{
                {1, 2, 3},
                {},
                {4, 5},
                {6}
        });
        test(new int[][]{
                {1, 2, 3},
                {-4, -5},
                {6}
        });
        test(new int[][]{
                {1, -2, 3},
                {},
                {4, -5},
                {6}
        });
        test(new int[][]{
                {1, -2, 3},
                {},
                {-4, -5},
                {6}
        });
        test(new int[][]{
                {},
        });
        test(new int[][]{
                {},
                {},
                {},
        });
        testRandom(tweakProfile(constProfile(10, 10), new int[][]{}));
        testRandom(tweakProfile(constProfile(100, 100), new int[][]{}));
        testRandom(randomProfile(100, maxSize));
        testRandom(randomProfile(maxSize / 10, maxSize));
        testRandom(randomProfile(maxSize, maxSize));
        testRandom(tweakProfile(constProfile(maxSize, 0), new int[][]{new int[]{maxSize, 0}}));
        testRandom(tweakProfile(randomProfile(maxSize, maxSize), new int[][]{new int[]{maxSize, 0}}));
        testRandom(tweakProfile(constProfile(maxSize, 0), new int[][]{new int[]{maxSize / 2, maxSize / 2 - 1}}));
        testRandom(tweakProfile(constProfile(maxSize, 1), new int[][]{new int[]{maxSize / 3, maxSize / 3, maxSize * 2 / 3}}));
        checker.printStatus();
    }

    protected int[] randomProfile(final int length, final int values) {
        final int[] profile = new int[length];
        for (int i = 0; i < values; i++) {
            profile[checker.randomInt(0, length - 1)]++;
        }
        return profile;
    }

    protected void testRandom(final int[] profile) {
        test(checker.random(profile));
    }

    public static int[] constProfile(final int length, final int value) {
        final int[] profile = new int[length];
        Arrays.fill(profile, value);
        return profile;
    }

    public static int[] tweakProfile(final int[] profile, final int[][] mods) {
        for (int[] mod : mods) {
            Arrays.stream(mod).skip(1).forEach(i -> profile[i] = mod[0]);
        }
        return profile;
    }

    protected void test(final int[][] ints) {
        checker.test(ints, transform(ints));
    }

    protected int[][] transform(final int[][] ints) {
        return IntStream.range(1, ints.length + 1)
                .mapToObj(i -> ints[ints.length - i])
                .map(is -> IntStream.range(1, is.length + 1).map(i -> is[is.length - i]).toArray())
                .toArray(int[][]::new);
    }
}
