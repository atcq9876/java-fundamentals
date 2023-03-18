package wordgame;

import java.util.ArrayList;

public class Game {
  private Masker masker;
  private String wordToGuess;
  private Integer remainingAttempts = 10;
  private ArrayList<Character> guessedLetters = new ArrayList<Character>();
  
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
    Character charGuess = this.validateGuessedLetter(guess);
    if (wordToGuess.indexOf(charGuess) >= 0) {
      this.guessedLetters.add(charGuess);
      return true;
    } else {
      this.guessedLetters.add(charGuess);
      this.remainingAttempts--;
      return false;
    }
  }

  public ArrayList<Character> getGuessedLetters() {
    return this.guessedLetters;
  }

  private Character validateGuessedLetter(String guess) {
    if (guess == "" || guess == null) { throw new IllegalArgumentException("You must enter a letter when making a guess"); }
    if (guess.length() > 1) { throw new IllegalArgumentException("Please only enter one letter"); }
    Character charGuess = guess.charAt(0);
    if (!Character.isLetter(charGuess)) { throw new IllegalArgumentException("Please only enter letters"); }
    return Character.toUpperCase(charGuess);
  }
}
