package se.Ecutb.HangMAN;

public class HangMan {

    private String[] words = { "Tauren", "Alliance", "Horde","wow","Classic" };
    private String randomWord = words[(int) (Math.random() * words.length)];
    private char[] wordsArray;
    private StringBuilder guesses;
    private int numbOfGuesses;
    private int maxNumbOfGuesses = 8;

    public HangMan() {

        this.wordsArray = new char[randomWord.length()];
        this.guesses = new StringBuilder();
        this.numbOfGuesses = 0;

        for (int i = 0; i < wordsArray.length; i++) {
            wordsArray[i] = '_';
        }
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

        guess = guess.trim();

        if (guess.length() == 1) {
            return guessedLetterMade(guess.charAt(0));
        } else {
            if (guess.length() > 1) {
                return guessedWordMade(guess).toUpperCase();
            }
        }

        return "Försök igen!";
    }

    public String guessedLetterMade(char letter) {

        if (checkIfLetterAlreadyHaveBeenEnterd(letter)) {
            return "du har redan gissat: " + letter;

        }
        else if (checkIfLetterIsInWord(letter)) {
            numbOfGuesses++;
            return " " + letter + " !";

        }
        else if (!checkIfLetterIsInWord(letter)) {
            guesses.append(letter);
            numbOfGuesses++;
            return "Försök igen : " + letter + " är inte ordet";
        }

        return "";
    }

    public String guessedWordMade(String word) {

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

    public boolean checkIfLetterIsInWord(char letter) {

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

    public boolean checkIfLetterAlreadyHaveBeenEnterd(char letter) {

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

    public boolean isWinner() {

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
