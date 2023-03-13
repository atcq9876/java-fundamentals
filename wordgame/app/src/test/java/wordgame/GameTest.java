package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class GameTest {
  @Test public void testGetsRemainingAttempts() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    Game game = new Game(mockedWordGenerator);
    assertEquals("Game begins with 10 attempts remaining", Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test public void testGetsRandomWord() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("RANDOM");
    Game game = new Game(mockedWordGenerator);
    assertEquals(game.wordToGuess, "RANDOM");
  }

  @Test public void testGetsWordToGuess() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("RANDOM");
    Game game = new Game(mockedWordGenerator);
    assertEquals(game.getWordToGuess(), "R_____");
  }

  @Test public void testOneIncorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("LIGHT");
    Game game = new Game(mockedWordGenerator);
    assertEquals(game.guessLetter('A'), "Unlucky, you have 9 attempts remaining, try again");
  }
  
  @Test public void testTwoIncorrectGuessLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("SHOWER");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('A');
    assertEquals(game.guessLetter('B'), "Unlucky, you have 8 attempts remaining, try again");
  }

  @Test public void testOneCorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BELT");
    Game game = new Game(mockedWordGenerator);
    assertEquals(game.guessLetter('B'), "The word contains that letter! You have 10 attempts remaining");
  }

  @Test public void testIncorrectAndCorrectGuessLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("HOUSE");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('C');
    assertEquals(game.guessLetter('U'), "The word contains that letter! You have 9 attempts remaining");
  }

  @Test public void testGuessedLettersAreStored() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("ALPHABET");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('A');
    game.guessLetter('C');
    ArrayList<Character> expectedChars = new ArrayList<Character>();
    expectedChars.add('A');
    expectedChars.add('C');
    assertEquals(game.guessedLetters, expectedChars);
  }

  @Test public void testRepeatedGuessedWords() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("ALPHABET");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('A');
    ArrayList<Character> expectedChars = new ArrayList<Character>();
    expectedChars.add('A');
    assertEquals(game.guessLetter('A'), "You've already guessed that letter, try another");
    assertEquals(game.guessedLetters, expectedChars);
  }
}
