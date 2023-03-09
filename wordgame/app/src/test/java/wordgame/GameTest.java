package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
  @Test public void testGetsWordToGuess() {
    Game game = new Game();
    assertEquals(game.getWordToGuess(), "B____");
  }
}
