package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class WordGeneratorTest {
  @Test public void testDictionaryContents() {
    String[] dictionary = WordGenerator.DICTIONARY;
    String[] expectedValues = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};
    assertArrayEquals(dictionary, expectedValues);
  }

  @Test public void testRandomWordGenerator() {
    WordGenerator wordGenerator = new WordGenerator();
    String randomWord = wordGenerator.getRandomWordFromDictionary();
    assertTrue(Arrays.asList(WordGenerator.DICTIONARY).contains(randomWord));
  }
}
