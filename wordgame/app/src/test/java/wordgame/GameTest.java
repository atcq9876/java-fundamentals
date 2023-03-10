package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {
  // @Test public void testGetsWordToGuess() {
  //   Game game = new Game("MAKERS");
  //   assertEquals(game.getWordToGuess(), "M_____");
  // }

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
}
