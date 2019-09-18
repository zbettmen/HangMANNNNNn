
package se.Ecutb.HangMAN;

import java.util.Scanner;

public class App {

    private HangMan game;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        App app = new App();

        boolean q = false;

        while (!q) {
            System.out.println("Vill du spela? j/n");

            switch (scan.nextLine().toLowerCase()) {
                case "n":
                    q = true;
                    System.out.println("Hej då!");
                    break;
                default:
                    app.play();
            }
        }
    }

   private void play() {

        game = new HangMan();
        System.out.println("Hangman!");

        while (!game.Winner() && game.getNumbOfGuesses() != game.getMaxNumbOfGuesses()) {
            System.out.println("ord: " + game.getNumbOfGuesses() + " of 8.");
            rightLettersGuessed();
            System.out.println(game.getGuesses());

            System.out.println("Gissa rätt ord eller boskstav!");
            String guess = scan.nextLine();
            String message = game.guessMade(guess);
            System.out.println(message);
        }
        if (game.Winner()) {
            rightLettersGuessed();
            System.out.println("ordet var : " + game.getRandomWord());
        } else {
            if (game.getNumbOfGuesses() == game.getMaxNumbOfGuesses()) {
                rightLettersGuessed();
                System.out.println("Du förlorade!: " + game.getRandomWord());
            }
        }
    }

    private void rightLettersGuessed() {

        for (char letter : game.getWordsArray()) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }


}

