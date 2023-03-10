package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordGeneratorTest {
  @Test public void testDictionaryContents() {
    WordGenerator wordGenerator = new WordGenerator();
    String[] dictionary = wordGenerator.DICTIONARY;
    String[] expectedValues = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};
    assertArrayEquals(dictionary, expectedValues);
  }
}
