package wordgame;

import java.util.Random;

public class WordGenerator {
  static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

  public String getRandomWordFromDictionary() {
    Random rand = new Random();
    Integer randomInt = rand.nextInt(DICTIONARY.length);
    return DICTIONARY[randomInt];
  }
}
