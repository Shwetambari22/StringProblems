/*
Problem Definition: Given a String of length S, reverse the whole string without reversing the individual words in it.
Words are separated by dots.

Example Input: i.like.this.program.very.much

Expected Output: much.very.program.this.like.i
 */

package com.example.stringproblems;

import java.util.ArrayList;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String testString = "i.love.this.program";
        //String testString = "i love this program";
        //String testString = "";
        reverseWordsInStringApproach1(testString);
        reverseWordsInStringApproach2(testString);
    }

    //using String split()
    public static void reverseWordsInStringApproach1(String stringForReversal) {
        if (stringForReversal.isEmpty()) {
            System.out.println("Invalid String");
        }

        String[] strArray = stringForReversal.split("\\.");
        int strArrayLength = strArray.length;
        System.out.println("Output from Approach 1");
        for (int i = strArrayLength - 1; i >= 0; i--) {
            System.out.print(strArray[i]);
            if (i != 0) {
                System.out.print(".");
            }
        }
    }

    //used implemented split functionality
    public static void reverseWordsInStringApproach2(String stringForReversal) {
        if (stringForReversal.isEmpty()) {
            System.out.println("Invalid String");
        }

        char delimeter = '.';
        ArrayList<String> wordsList = splitString(stringForReversal, delimeter);
        int listSize = wordsList.size();
        System.out.println("\nOutput from Approach 2");
        for (int i = listSize - 1; i >= 0; i--) {
            System.out.print(wordsList.get(i));
            if (i != 0) {
                System.out.print(".");
            }
        }
    }

    private static ArrayList<String> splitString(String stringForSplit, char splitCharacter) {
        ArrayList<String> wordsList = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        int stringLength = stringForSplit.length();
        char testChar;

        for (int i = 0; i < stringLength; i++) {
            testChar = stringForSplit.charAt(i);
            if (testChar == splitCharacter) {
                wordsList.add(word.toString());
                word = new StringBuilder();
            } else {
                word = word.append(testChar);
            }
        }
        wordsList.add(word.toString());
        return wordsList;
    }
}
