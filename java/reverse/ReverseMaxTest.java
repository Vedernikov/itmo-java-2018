package reverse;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class ReverseMaxTest extends ReverseTest {
    public ReverseMaxTest(final int maxSize) {
        super("ReverseMax", maxSize);
    }

    public static void main(String... args) {
        new ReverseMaxTest(MAX_SIZE).run();
    }

    @Override
    protected int[][] transform(final int[][] ints) {
        final int[] rt = Arrays.stream(ints)
                .map(Arrays::stream)
                .map(IntStream::max)
                .mapToInt(i -> i.orElse(0))
                .toArray();
        final int[] ct = new int[Arrays.stream(ints).mapToInt(r -> r.length).max().orElse(0)];
        Arrays.fill(ct, Integer.MIN_VALUE);
        Arrays.stream(ints).forEach(row -> IntStream.range(0, row.length).forEach(i -> ct[i] = Math.max(ct[i], row[i])));
        return IntStream.range(0, ints.length)
                .mapToObj(r -> IntStream.range(0, ints[r].length).map(c -> Math.max(rt[r], ct[c])).toArray())
                .toArray(int[][]::new);
    }
}
