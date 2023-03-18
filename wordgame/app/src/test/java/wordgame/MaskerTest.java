package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MaskerTest {
  @Test public void testOnlyShowsFirstLetter() {
    Masker masker = new Masker();
    String word = "TEST";
    ArrayList<Character> guessedLetters = new ArrayList<Character>();

    assertEquals(masker.getHiddenWord(word, guessedLetters), "T___");
  }

  @Test public void testShowsCorrectlyGuessedLetters() {
    Masker masker = new Masker();
    String word = "ANOTHER";
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('O');
    guessedLetters.add('T');

    assertEquals(masker.getHiddenWord(word, guessedLetters), "A_OT___");
  }
}
