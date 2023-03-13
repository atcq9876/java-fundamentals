package wordgame;

import java.util.ArrayList;

public class Game {
  Integer remainingAttempts = 10;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();
  String wordToGuess;
  
  Game(WordGenerator wordGenerator) {
    this.wordToGuess = wordGenerator.getRandomWordFromDictionary();
  }

  public static void main(String[] args) {}

  public String getWordToGuess() {
    StringBuilder hiddenWordSB = new StringBuilder(wordToGuess);
    for (int i = 1; i < wordToGuess.length(); i++) {
      hiddenWordSB.replace(i, hiddenWordSB.length(), "_");
    }
    return hiddenWordSB.toString();
  }

  public Integer getRemainingAttempts() {
    return this.remainingAttempts;
  }

  public String guessLetter(Character guess) {
    // If word contains the guessed character
    if (this.guessedLetters.contains(guess)) {
      return "You've already guessed that letter, try another";
    } else if (wordToGuess.indexOf(guess) >= 0) {
      this.guessedLetters.add(guess);
      return "The word contains that letter! You have " + this.remainingAttempts + " attempts remaining";
    } else {
      this.guessedLetters.add(guess);
      this.remainingAttempts--;
      return "Unlucky, you have " + this.remainingAttempts + " attempts remaining, try again";
    }
  }
}


// ALTERNATIVE GETWORDTOGUESS METHOD:
// public String getWordToGuess() {
//   StringBuilder hiddenWordSB = new StringBuilder();
//   for (int i = 0; i < wordToGuess.length(); i++) {
//     if (i == 0) {
//       hiddenWordSB.append(wordToGuess.charAt(0));
//     } else {
//       hiddenWordSB.append("_");
//     }
//   }
//   return hiddenWordSB.toString();
// }
