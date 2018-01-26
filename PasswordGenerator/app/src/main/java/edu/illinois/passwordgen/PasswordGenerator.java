package edu.illinois.passwordgen;

import java.util.Random;

/**
 * This class generates a random password given specific requirements.
 * Created by fia on 10/25/17.
 */

public class PasswordGenerator {

    private Random random = new Random();

    private static final String CAPITALLETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTERS = CAPITALLETTERS + CAPITALLETTERS.toLowerCase();

    private static final String NUMBERS = "0123456789";
    private static final String NUMLETTERS = LETTERS + NUMBERS;

    public char getRandomNumber() {
        return NUMBERS.charAt(random.nextInt(NUMBERS.length()));
    }

    public char getRandomSymbol() {
        char temp = (char) (random.nextInt(94) + 33);
        while (NUMLETTERS.indexOf(temp) >= 0) {
            temp = (char) (random.nextInt(94) + 33);
        }
        return temp;
    }

    public char getRandomSymbolOrLetter() {
        int next = random.nextInt(94) + 33;
        while (next <= 57 && next >= 48) {
            next = random.nextInt(94) + 33;
        }
        return (char) next;
    }

    public char getRandomSymbolOrNumber() {
        int next = random.nextInt(94) + 33;
        while (LETTERS.indexOf((char) next) >= 0) {
            next = random.nextInt(94) + 33;
        }
        return (char) next;
    }

    public String getPassword(int length, int numLength, int symLength) {

        if (length <= 0 || numLength <= 0 || symLength <= 0) {
            return "";
        }

        StringBuilder randomString = new StringBuilder();
        int numCount = 0;
        int symCount = 0;

        for (int i = 0; i < length; i++) {
            if (symCount == symLength) {
                if (numCount == numLength) {
                    //Pure letter password
                    randomString.append(LETTERS.charAt(random.nextInt(LETTERS.length())));

                } else {
                    //Number letter password
                    if (numLength - numCount == length - i) { //to reach desired numCount
                        randomString.append(getRandomNumber());
                        numCount++;
                    } else {
                        char next = NUMLETTERS.charAt(random.nextInt(NUMLETTERS.length()));
                        if ((int) next <= 57 && (int) next >= 48) {
                            // next is a number
                            numCount++;
                        }
                        randomString.append(next);
                    }
                }

            } else {
                if (numCount == numLength) {
                    //symbol letter password
                    if (symLength - symCount == length - i) { //to reach desired numCount
                        randomString.append(getRandomSymbol());
                        symCount++;
                    } else {
                        char next = getRandomSymbolOrLetter();
                        if (LETTERS.indexOf(next) < 0) {
                            // next is a symbol
                            symCount++;
                        }
                        randomString.append(next);
                    }

                } else {
                    //password with symbols & numbers & letters, generate using ascii code
                    char next = ' ';
                    if (symLength - symCount + numLength - numCount == length - i) {
                        next = getRandomSymbolOrNumber();
                    } else if (symLength - symCount == length - i) {
                        next = getRandomSymbol();
                    } else if (numLength - numCount == length - i) {
                        next = getRandomNumber();
                    } else {
                        next = (char) (random.nextInt(94) + 33);
                    }
                    if ((int) next <= 57 && next >= 48) {
                        numCount++;
                    } else if (LETTERS.indexOf(next) < 0) {
                        // next is a symbol
                        symCount++;
                    }
                    randomString.append(next);
                }
            }
        }

        //Shuffle the password to avoid number/symbol clustering at the end
        for (int i = 0; i < randomString.length(); i++) {
            int j = random.nextInt(randomString.length() - i) + i;
            char temp = randomString.charAt(j);
            randomString.deleteCharAt(j);
            randomString.insert(i, temp);
        }

        return randomString.toString();
    }
}
