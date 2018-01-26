package edu.illinois.passwordgen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fia on 10/25/17.
 */
public class PasswordGeneratorTest {

    private PasswordGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new PasswordGenerator();
    }

    @Test
    public void getNumberTest() throws Exception {
        int number = Character.getNumericValue(generator.getRandomNumber());
        assertTrue(number >= 0 || number <= 9);
    }

    @Test
    public void getSymbolTest() throws Exception {
        int symbolAscii = (int) generator.getRandomSymbol();
        assertTrue((symbolAscii >= 33 && symbolAscii <= 47) || (symbolAscii >= 58 && symbolAscii <= 64)
                || (symbolAscii >= 91 && symbolAscii <= 96) || (symbolAscii >= 123 && symbolAscii <= 126));
    }

    @Test
    public void getSymbolLetterTest() throws Exception {
        int ascii = (int) generator.getRandomSymbolOrLetter();
        assertTrue((ascii >= 33 && ascii <= 47) || (ascii >= 58 && ascii <= 126));
    }

    @Test
    public void getSymbolNumberTest() throws Exception {
        int ascii = (int) generator.getRandomSymbolOrNumber();
        assertTrue((ascii >= 33 && ascii <= 64) || (ascii >= 91 && ascii <= 96)
                || (ascii >= 123 && ascii <= 126));
    }

    @Test
    public void getPasswordTest() throws Exception {
        String password = generator.getPassword(10, 5, 2);
        String numSym = password.replaceAll("[a-zA-Z]", "");
        String sym = numSym.replaceAll("[0-9]", "");

        assertEquals(10, password.length());
        assertEquals(5, numSym.length() - sym.length());
        assertEquals(2, sym.length());

    }

    @Test
    public void getPasswordEmptyTest() throws Exception {
        String password = generator.getPassword(0, 0, 0);
        assertEquals("", password);

    }

}