package wordStat;

import base.Pair;
import base.Randomized;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class WordStatInputTest {
    private final WordStatChecker checker;

    public WordStatInputTest(final String className) {
        checker = new WordStatChecker(className);
    }

    public static void main(final String... args) {
        new WordStatInputTest("WordStatInput").run();
    }

    protected void run() {
        test();
        checker.printStatus();
    }

    protected void test() {
        test(
                "To be, or not to be, that is the question:"
        );
        test(
                "Monday's child is fair of face.",
                "Tuesday's child is full of grace."
        );
        test(
                "Шалтай-Болтай",
                "Сидел на стене.",
                "Шалтай-Болтай",
                "Свалился во сне."
        );
        test(
                "10 октября — Всемирный день психического здоровья",
                "Тема 2017 года: Психическое здоровье на рабочем месте"
        );

        randomTest(3, 10, 10, 3, Randomized.ENGLISH, WordStatChecker.SIMPLE_DELIMITERS);
        randomTest(10, 3, 5, 5, Randomized.RUSSIAN, WordStatChecker.SIMPLE_DELIMITERS);
        randomTest(3, 10, 10, 3, Randomized.GREEK, WordStatChecker.SIMPLE_DELIMITERS);
        randomTest(3, 10, 10, 3, WordStatChecker.DASH, WordStatChecker.SIMPLE_DELIMITERS);
        randomTest(3, 10, 10, 3, Randomized.ENGLISH, WordStatChecker.ADVANCED_DELIMITERS);
        randomTest(10, 3, 5, 5, Randomized.RUSSIAN, WordStatChecker.ADVANCED_DELIMITERS);
        randomTest(3, 10, 10, 3, Randomized.GREEK, WordStatChecker.ADVANCED_DELIMITERS);
        randomTest(3, 10, 10, 3, WordStatChecker.DASH, WordStatChecker.ADVANCED_DELIMITERS);
        randomTest(100, 1000, 100, 1000, Randomized.RUSSIAN + Randomized.ENGLISH + Randomized.GREEK + WordStatChecker.DASH, WordStatChecker.ADVANCED_DELIMITERS);
    }

    private void randomTest(final int wordLength, final int totalWords, final int wordsPerLine, final int lines, final String chars, final String delimiters) {
        final String[] words = checker.generateWords(wordLength, totalWords, chars);
        final String[][] text = checker.generateTest(lines, words, wordsPerLine);
        checker.test(checker.input(text, delimiters), answer(text));
    }

    public void test(final String... text) {
        checker.test(text, answer(Arrays.stream(text).map(s -> s.split("[ ,.:0-9]+")).toArray(String[][]::new)));
    }

    // Stream "magic" code. You do not expected to understand it
    @SuppressWarnings("unchecked")
    protected Pair<String, Integer>[] answer(final String[][] text) {
        return answer(Arrays.stream(text).flatMap(Arrays::stream).filter(s -> !s.isEmpty()))
                .toArray(i -> (Pair<String, Integer>[]) new Pair[i]);
    }

    // Stream "magic" code. You do not expected to understand it
    protected Stream<Pair<String, Integer>> answer(final Stream<String> input) {
        return input
                .collect(Collectors.toMap(String::toLowerCase, v -> 1, Integer::sum, LinkedHashMap::new)).entrySet().stream()
                .map(Pair::of);
    }
}
