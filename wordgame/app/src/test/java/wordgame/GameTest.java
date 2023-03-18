package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class GameTest {
  @Test public void testGetsRemainingAttempts() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    assertEquals("Game begins with 10 attempts remaining", Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test public void testGetsRandomWord() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("RANDOM");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    assertEquals(game.wordToGuess, "RANDOM");
  }

  @Test public void testOneIncorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("LIGHT");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    assertEquals(game.guessLetter("A"), false);
  }
  
  @Test public void testTwoIncorrectGuessLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("SHOWER");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("A");
    assertEquals(game.guessLetter("B"), false);
  }

  @Test public void testOneCorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BELT");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    assertEquals(game.guessLetter("B"), true);
  }

  @Test public void testLowerCaseCorrectGuessLetter() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BELT");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    assertEquals(game.guessLetter("e"), true);
  }

  @Test public void testIncorrectAndCorrectGuessLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("HOUSE");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("C");
    assertEquals(game.guessLetter("U"), true);
  }

  @Test public void testGuessedLettersAreStored() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("ALPHABET");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("A");
    game.guessLetter("C");
    ArrayList<Character> expectedChars = new ArrayList<Character>();
    expectedChars.add('A');
    expectedChars.add('C');
    assertEquals(game.guessedLetters, expectedChars);
  }

  @Test public void testIsGameLostFalse() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("TEST");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("A");
    assertEquals(game.isGameLost(), false);
  }

  @Test public void testIsGameLostTrue() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("TEST");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("A");
    game.guessLetter("B");
    game.guessLetter("C");
    game.guessLetter("D");
    game.guessLetter("A");
    game.guessLetter("B");
    game.guessLetter("C");
    game.guessLetter("D");
    game.guessLetter("A");
    game.guessLetter("B");
    assertEquals(game.isGameLost(), true);
  }

  @Test public void testIsGameWonFalse() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BLAH");
    Masker mockedMasker = mock(Masker.class);
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('A');
    when(mockedMasker.getHiddenWord("BLAH", guessedLetters)).thenReturn("B_A_");
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("A");
    assertEquals(game.isGameWon(), false);
  }

  @Test public void testIsGameWonTrue() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("BLAH");
    Masker mockedMasker = mock(Masker.class);
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('B');
    guessedLetters.add('L');
    guessedLetters.add('A');
    guessedLetters.add('H');
    when(mockedMasker.getHiddenWord("BLAH", guessedLetters)).thenReturn("BLAH");
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("B");
    game.guessLetter("L");
    game.guessLetter("A");
    game.guessLetter("H");
    assertEquals(game.isGameWon(), true);
  }

  @Test public void testIsGameWonTrueRepeatedLetters() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("LONDON");
    Masker mockedMasker = mock(Masker.class);
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('L');
    guessedLetters.add('O');
    guessedLetters.add('N');
    guessedLetters.add('E');
    guessedLetters.add('D');
    when(mockedMasker.getHiddenWord("LONDON", guessedLetters)).thenReturn("LONDON");
    Game game = new Game(mockedWordGenerator, mockedMasker);
    game.guessLetter("L");
    game.guessLetter("O");
    game.guessLetter("N");
    game.guessLetter("E");
    game.guessLetter("D");
    assertEquals(game.isGameWon(), true);
  }

  @Test public void throwExceptionIfGuessedCharacterIsNumber() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("TEST");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      game.guessLetter("1");
    });

    String expectedMessage = "Please only enter letters";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test public void throwExceptionIfGuessedCharacterIsPunctuation() {
    WordGenerator mockedWordGenerator = mock(WordGenerator.class);
    when(mockedWordGenerator.getRandomWordFromDictionary()).thenReturn("TEST");
    Masker mockedMasker = mock(Masker.class);
    Game game = new Game(mockedWordGenerator, mockedMasker);
    
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      game.guessLetter(",");
    });

    String expectedMessage = "Please only enter letters";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
