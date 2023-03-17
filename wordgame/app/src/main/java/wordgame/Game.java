package wordgame;

import java.util.ArrayList;

public class Game {
  // Consider making these instance variables private
  Integer remainingAttempts = 10;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();
  String wordToGuess;
  
  Game(WordGenerator wordGenerator) {
    this.wordToGuess = wordGenerator.getRandomWordFromDictionary();
  }

  public static void main(String[] args) {}

public String getWordToGuess() {
  StringBuilder hiddenWordSB = new StringBuilder();
  for (int i = 0; i < this.wordToGuess.length(); i++) {
    if (i == 0) {
      hiddenWordSB.append(wordToGuess.charAt(0));
    } else if (this.guessedLetters.contains(this.wordToGuess.charAt(i))) {
      hiddenWordSB.append(wordToGuess.charAt(i));
    } else {
      hiddenWordSB.append("_");
    }
  }
  return hiddenWordSB.toString();
}

  public Integer getRemainingAttempts() {
    return this.remainingAttempts;
  }

  public Boolean guessLetter(Character guess) {
    // Add some errot checking for input, e.g., don't allow user to enter empty string
    // Could do this in a separate error checking function
    guess = Character.toUpperCase(guess);
    if (wordToGuess.indexOf(guess) >= 0) {
      this.guessedLetters.add(guess);
      return true;
    } else {
      this.guessedLetters.add(guess);
      this.remainingAttempts--;
      return false;
    }
  }
}
