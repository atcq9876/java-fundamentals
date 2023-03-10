package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordGeneratorTest {
  @Test public void testDictionaryContents() {
    String[] dictionary = WordGenerator.DICTIONARY;
    String[] expectedValues = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};
    assertArrayEquals(dictionary, expectedValues);
  }
}
