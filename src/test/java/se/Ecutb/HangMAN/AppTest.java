package se.Ecutb.HangMAN;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AppTest {
    private String[] wordss;
    private int testar;
    private String testar2;
    private HangMan hangmannen = new HangMan();

    @Before
    public void testar() {
        hangmannen = new HangMan("testar");
    }

    @Test
    public void enterletter() {
        String testing = "r";
        hangmannen.guessedWord(testing);
        String expected = "r";
        Assert.assertEquals(expected, hangmannen.getGuesses().toString());
    }

    @Test
    //testar tauren i mina Swords
    public void test_method() {
        String expected = "tauren";
        hangmannen.checkIflsWord(expected);
        boolean test = true;
        Assert.assertEquals(true, test);

    }
    @Test
    public void test_booleaninword(){
        boolean actual = hangmannen.checkIfLetterWord('r');
        Assert.assertEquals(true,actual);


    }
    @Test
    public void test_Winner(){
        boolean actual = hangmannen.Winner();
        Assert.assertEquals(false,actual);


    }
    @Test
    public void test_word(){
        String actual = hangmannen.guessMade("rh");
        boolean expected = hangmannen.checkIflsWord(actual);
        Assert.assertEquals(false, expected);

    }


       //@Test
    //public void test_swords() {
           //char[] expected = {'_', '_', '_', '_', '_', '_'};
           //Assert.assertArrayEquals(expected, hangmannen.getWordsArray());


    //}
}


