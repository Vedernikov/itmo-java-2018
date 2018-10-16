package reverse;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class ReverseSumTest extends ReverseTest {
    public ReverseSumTest(final int maxSize) {
        super("ReverseSum", maxSize);
    }

    public static void main(String... args) {
        new ReverseSumTest(MAX_SIZE).run();
    }

    @Override
    protected int[][] transform(final int[][] ints) {
        final int[] rt = Arrays.stream(ints)
                .map(Arrays::stream)
                .mapToInt(IntStream::sum)
                .toArray();
        final int[] ct = new int[Arrays.stream(ints).mapToInt(r -> r.length).max().orElse(0)];
        Arrays.stream(ints).forEach(row -> IntStream.range(0, row.length).forEach(i -> ct[i] += row[i]));
        return IntStream.range(0, ints.length)
                .mapToObj(r -> IntStream.range(0, ints[r].length).map(c -> rt[r] + ct[c] - ints[r][c]).toArray())
                .toArray(int[][]::new);
    }
}
