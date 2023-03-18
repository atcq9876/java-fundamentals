package wordgame;

import java.util.ArrayList;

public class Game {
  // Consider making these instance variables private
  Integer remainingAttempts = 10;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();
  String wordToGuess;
  Masker masker;
  
  Game(WordGenerator wordGenerator, Masker masker) {
    this.wordToGuess = wordGenerator.getRandomWordFromDictionary();
    this.masker = masker;
  }

  public String getWordToGuess() {
    String hiddenWord = masker.getHiddenWord(wordToGuess, guessedLetters);
    return hiddenWord;
  }

  public Integer getRemainingAttempts() {
    return this.remainingAttempts;
  }

  public Boolean isGameWon() {
    return getWordToGuess().indexOf("_") == -1;
  }

  public Boolean isGameLost() {
    return remainingAttempts == 0;
  }

  public Boolean guessLetter(Character guess) {
    // Add some error checking for input, e.g., don't allow user to enter empty string
    // Error checking: only take one character
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
