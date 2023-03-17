/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wordgame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(new WordGenerator());
        Integer remainingAttempts = 10;
        System.out.println("Welcome! Today the word to guess is:");
        while (remainingAttempts > 0) {
            System.out.println(game.getWordToGuess());
            System.out.println("Enter a letter to make a guess:");
            Character guess = (scanner.nextLine()).charAt(0);
            System.out.println(game.guessLetter(guess));
            remainingAttempts = game.getRemainingAttempts();
        }
        scanner.close();
    }
}
