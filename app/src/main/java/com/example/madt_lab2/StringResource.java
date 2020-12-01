package com.example.madt_lab2;

public class StringResource {

    public static int numWords(String str) {
        int wordCount = 0;

        boolean isWord = false;
        int endOfLine = str.length() - 1;
        char[] characters = str.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfLine) {
                isWord = true;
            } else if (!Character.isLetter(characters[i]) && isWord) {
                wordCount++;
                isWord = false;
            } else if (Character.isLetter(characters[i]) && i == endOfLine) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public static int numChars(String str) {
        return str.length();
    }

}
