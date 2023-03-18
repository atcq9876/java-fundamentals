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

  @Test public void testOneIncorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("LIGHT");
    Game game = new Game(mockedWordGenerator);
    assertEquals(game.guessLetter('A'), false);
  }
  
  @Test public void testTwoIncorrectGuessLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("SHOWER");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('A');
    assertEquals(game.guessLetter('B'), false);
  }

  @Test public void testOneCorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BELT");
    Game game = new Game(mockedWordGenerator);
    assertEquals(game.guessLetter('B'), true);
  }

  @Test public void testLowerCaseCorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BELT");
    Game game = new Game(mockedWordGenerator);
    assertEquals(game.guessLetter('e'), true);
  }

  @Test public void testIncorrectAndCorrectGuessLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("HOUSE");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('C');
    assertEquals(game.guessLetter('U'), true);
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

  @Test public void testIsGameLostFalse() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("TEST");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('A');
    assertEquals(game.isGameLost(), false);
  }

  @Test public void testIsGameLostTrue() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("TEST");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('A');
    game.guessLetter('B');
    game.guessLetter('C');
    game.guessLetter('D');
    game.guessLetter('A');
    game.guessLetter('B');
    game.guessLetter('C');
    game.guessLetter('D');
    game.guessLetter('A');
    game.guessLetter('B');
    assertEquals(game.isGameLost(), true);
  }

  @Test public void testIsGameWonFalse() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BLAH");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('A');
    assertEquals(game.isGameWon(), false);
  }

  @Test public void testIsGameWonTrue() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BLAH");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('B');
    game.guessLetter('L');
    game.guessLetter('A');
    game.guessLetter('H');
    assertEquals(game.isGameWon(), true);
  }

  @Test public void testIsGameWonTrueRepeatedLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("LONDON");
    Game game = new Game(mockedWordGenerator);
    game.guessLetter('L');
    game.guessLetter('O');
    game.guessLetter('N');
    game.guessLetter('D');
    assertEquals(game.isGameWon(), true);
  }
}
