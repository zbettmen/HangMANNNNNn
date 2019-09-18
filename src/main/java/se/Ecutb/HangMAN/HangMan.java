package se.Ecutb.HangMAN;

import java.util.Arrays;
import java.util.Random;

public class HangMan {
    Random random = new Random();

    private String[] words = { "Tauren", "Alliance", "Horde","wow","Classic" };
    private String randomWord = words[random.nextInt(words.length)].toLowerCase();
    private char[] wordsArray;
    private StringBuilder guesses;
    private int numbOfGuesses;
    private int maxNumbOfGuesses = 8;

    public HangMan() {

        this.wordsArray = new char[randomWord.length()];
        this.guesses = new StringBuilder();
        this.numbOfGuesses = 0;

    }

    public HangMan(String försök) {

        this.randomWord = försök;
        this.wordsArray = new char[randomWord.length()];
        this.guesses = new StringBuilder();
        this.numbOfGuesses = 0;

        for (int i = 0; i < wordsArray.length; i++) {
            wordsArray[i] = '_';
        }
    }

    public String guessMade(String guess) {

        

        if (guess.length() == 1) {
            return guessedLetter(guess.charAt(0));
        } else {
            if (guess.length() > 1) {
                return guessedWord(guess).toUpperCase();
            }
        }

        return "Försök igen!";
    }

    public String guessedLetter(char letter) {

        if (checkLetter(letter)) {
            return "du har redan gissat: " + letter;

        }
        else if (checkIfLetterWord(letter)) {
            numbOfGuesses++;
            return " " + letter + " !";

        }
        else if (!checkIfLetterWord(letter)) {
            guesses.append(letter);
            numbOfGuesses++;
            return "Försök igen : " + letter + " är inte ordet";
        }

        return "";
    }

    public String guessedWord(String word) {

        if (checkIflsWord(word)) {
            numbOfGuesses++;
            return "Ordet är : " + word;
        }

        if (!checkIflsWord(word)) {
            numbOfGuesses++;
            guesses.append(word);
            return word + " är inte ordet";
        }

        return "r";
    }

    public boolean checkIfLetterWord(char letter) {

        boolean isInWord = false;

        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == letter) {
                wordsArray[i] = letter;
                isInWord = true;
            }
        }

        return isInWord;
    }

    public boolean checkIflsWord(String word) {

        boolean Words = false;

        if (randomWord.equals(word)) {
            wordsArray = randomWord.toCharArray();
            Words = true;
        }

        return Words;
    }

    public boolean checkLetter(char letter) {

        boolean alreadyEnterd = false;

        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i] == letter) {
                alreadyEnterd = true;
            }
        }

        for (int i = 0; i < guesses.length(); i++) {
            if (guesses.charAt(i) == letter) {
                alreadyEnterd = true;
            }
        }

        return alreadyEnterd;
    }

    public boolean Winner() {

        boolean wordIsComplete = String.valueOf(wordsArray).equals(randomWord);

        return wordIsComplete;

    }

    public String getRandomWord() {
        return this.randomWord;
    }

    public char[] getWordsArray() {
        return wordsArray;
    }

    public String getGuesses() {
        return guesses.toString();
    }

    public int getNumbOfGuesses() {
        return numbOfGuesses;
    }

    public int getMaxNumbOfGuesses() {
        return maxNumbOfGuesses;
    }

}


