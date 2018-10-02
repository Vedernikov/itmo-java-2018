package wordStat;

import base.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class WordStatWordsTest extends WordStatInputTest {
    private static final WordStatChecker CHECKER = new WordStatChecker("WordStatWords");

    public WordStatWordsTest(final String className) {
        super(className);
    }

    public static void main(final String... args) {
        new WordStatWordsTest("WordStatWords").run();
    }

    // Stream "magic" code. You do not expected to understand it
    protected Stream<Pair<String, Integer>> answer(final Stream<String> input) {
        return input
                .collect(Collectors.toMap(String::toLowerCase, v -> 1, Integer::sum)).entrySet().stream()
                .map(Pair::of)
                .sorted(Comparator.comparing(Pair::getFirst));
    }
}
