package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
  @Test public void testGetsWordToGuess() {
    Game game = new Game("MAKERS");
    assertEquals(game.getWordToGuess(), "M_____");
  }

  @Test public void testGetsRemainingAttempts() {
    Game game = new Game("TEST");
    assertEquals("Game begins with 10 attempts remaining", Integer.valueOf(10), game.getRemainingAttempts());
  }
}
