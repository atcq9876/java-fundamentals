package wordgame;

public class Game {
  Integer remainingAttempts = 10;
  String wordToGuess;
  Game(WordGenerator wordGenerator) {
    wordToGuess = wordGenerator.getRandomWordFromDictionary();
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
    return remainingAttempts;
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
