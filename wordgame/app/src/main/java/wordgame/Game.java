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

  public Boolean guessLetter(String guess) {
    if (guess == "" || guess == null) { throw new IllegalArgumentException("You must enter a letter when making a guess"); }
    if (guess.length() > 1) { throw new IllegalArgumentException("Please only enter one letter"); }
    Character charGuess = guess.charAt(0);
    if (!Character.isLetter(charGuess)) { throw new IllegalArgumentException("Please only enter letters"); }
    // Could move error checking to a separate error checking function

    charGuess = Character.toUpperCase(charGuess);
    if (wordToGuess.indexOf(charGuess) >= 0) {
      this.guessedLetters.add(charGuess);
      return true;
    } else {
      this.guessedLetters.add(charGuess);
      this.remainingAttempts--;
      return false;
    }
  }
}
