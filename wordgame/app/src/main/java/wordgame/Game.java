package wordgame;

public class Game {
  String wordToGuess;
  Game(String word) {
    wordToGuess = word;
  }

  public String getWordToGuess() {
    StringBuilder hiddenWord = new StringBuilder();
    for (int i = 0; i < wordToGuess.length(); i++) {
      if (i == 0) {
        hiddenWord.append(wordToGuess.charAt(0));
      } else {
        hiddenWord.append("_");
      }
    }
    return hiddenWord.toString();
  }

  public static void main(String[] args) {
  }
}
