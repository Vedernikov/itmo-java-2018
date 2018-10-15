package reverse;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class ReverseMinTest extends ReverseTest {
    public ReverseMinTest(final int maxSize) {
        super("ReverseMin", maxSize);
    }

    public static void main(String... args) {
        new ReverseMinTest(MAX_SIZE).run();
    }

    @Override
    protected int[][] transform(final int[][] ints) {
        final int[] rt = Arrays.stream(ints)
                .map(Arrays::stream)
                .map(IntStream::min)
                .mapToInt(i -> i.orElse(0))
                .toArray();
        final int[] ct = new int[Arrays.stream(ints).mapToInt(r -> r.length).max().orElse(0)];
        Arrays.fill(ct, Integer.MAX_VALUE);
        Arrays.stream(ints).forEach(row -> IntStream.range(0, row.length).forEach(i -> ct[i] = Math.min(ct[i], row[i])));
        return IntStream.range(0, ints.length)
                .mapToObj(r -> IntStream.range(0, ints[r].length).map(c -> Math.min(rt[r], ct[c])).toArray())
                .toArray(int[][]::new);
    }
}
