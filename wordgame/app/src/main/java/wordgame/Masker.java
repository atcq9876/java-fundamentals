package wordgame;

import java.util.ArrayList;

public class Masker {
  public String getHiddenWord(String wordToGuess, ArrayList<Character> guessedLetters) {
    StringBuilder hiddenWordSB = new StringBuilder();
    for (int i = 0; i < wordToGuess.length(); i++) {
      if (i == 0) {
        hiddenWordSB.append(wordToGuess.charAt(0));
      } else if (guessedLetters.contains(wordToGuess.charAt(i))) {
        hiddenWordSB.append(wordToGuess.charAt(i));
      } else {
        hiddenWordSB.append("_");
      }
    }
    return hiddenWordSB.toString();
  }
}
