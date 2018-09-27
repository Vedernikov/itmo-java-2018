package wordStat;

import base.Asserts;
import base.MainFilesChecker;
import base.Pair;
import base.Randomized;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class WordStatChecker extends MainFilesChecker {
    public static final String DASH = "-֊־‒–—―⸗⸚⸺〰゠︱︲﹘﹣－'";
    public static final String SIMPLE_DELIMITERS = " \t";
    public static final String ADVANCED_DELIMITERS = " \t!\"#$%&()*+,./0123456789:;<=>?@[\\]^_`{|}~ ¡¢£¤¥¦§¨©«¬\u00AD®¯°±²³´¶·¸¹»¼½¾¿×÷˂˃˄˅˒˓˔˕˖˗˘˙˚˛˜˝₴₵₶₷₸₹₺\u20BB\u20BC\u20BD\u20BE";

    public WordStatChecker(final String className) {
        super(className);
    }

    @SafeVarargs
    public final void test(final String[] text, final Pair<String, Integer>... expected) {
        final List<String> expectedList = Arrays.stream(expected)
                .map(p -> p.first + " " + p.second)
                .collect(Collectors.toList());
        Asserts.assertEquals("output", expectedList, runFiles(Arrays.asList(text)));
        counter.passed();
    }

    public String[] generateWords(final int wordLength, final int totalWords, final String chars) {
        return generateWords(wordLength, totalWords, chars, this);
    }

    public static String[] generateWords(final int wordLength, final int totalWords, final String chars, final Randomized randomized) {
        final String allChars = chars + chars.toUpperCase();
        final String[] words = new String[totalWords];
        for (int i = 0; i < totalWords; i++) {
            words[i] = randomized.randomString(allChars, wordLength / 2, wordLength);
        }
        return words;
    }

    public String[][] generateTest(final int lines, final String[] words, final int wordsPerLine) {
        return generateTest(lines, words, wordsPerLine, this);
    }

    public static String[][] generateTest(final int lines, final String[] words, final int wordsPerLine, final Randomized randomized) {
        final String[][] text = new String[lines][];
        for (int i = 0; i < text.length; i++) {
            text[i] = new String[randomized.randomInt(wordsPerLine / 2, wordsPerLine)];
            for (int j = 0; j < text[i].length; j++) {
                text[i][j] = randomized.randomItem(words);
            }
        }
        return text;
    }

    String[] input(final String[][] text, final String delimiters) {
        final String[] input = new String[text.length];
        for (int i = 0; i < text.length; i++) {
            String[] line = text[i];
            final StringBuilder sb = new StringBuilder(randomString(delimiters));
            for (String word : line) {
                sb.append(word).append(randomString(delimiters));
            }
            input[i] = sb.toString();
        }
        return input;
    }

    public void test(final String[][] text, final String delimiters, final Pair<String, Integer>[] answer) {
        test(input(text, delimiters), answer);
    }
}
