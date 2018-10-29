package wordStat;

import base.Pair;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class WordStatLineIndexTest extends WordStatIndexTest {
    public WordStatLineIndexTest(final String className) {
        super(className);
    }

    public static void main(String[] args) {
        new WordStatLineIndexTest("WordStatLineIndex").run();
    }

    @Override
    protected List<Pair<String, String>> answer(final String[][] text) {
        return IntStream.range(0, text.length).boxed()
                .flatMap(
                        r -> IntStream.range(0, text[r].length)
                                .mapToObj(c -> Pair.of(text[r][c].toLowerCase(), (r + 1) + ":" + (c + 1)))
                ).collect(Collectors.toMap(Pair::getFirst, p -> Collections.singletonList(p.getSecond()), WordStatIndexTest::concat, TreeMap::new)).entrySet().stream()
                .map(e -> Pair.of(e.getKey(), e.getValue().size() + " " + e.getValue().stream().map(Object::toString).collect(Collectors.joining(" "))))
                .collect(Collectors.toList());
    }
}
