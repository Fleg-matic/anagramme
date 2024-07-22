package com.winside.craft.utils;

import com.winside.craft.beans.Words;

import java.util.*;

public class AnagrammeUtils {

    private final Words word = new Words();

    private boolean isAnagram(String firstWord, String secondWord) {
        firstWord = word.getFirstWord();
        secondWord = word.getSecondWord();
        char[] firstWordByLetterTab = firstWord.toCharArray();
        char[] secondWordByLetterTab = secondWord.toCharArray();
        int firstWordSize = firstWord.length();
        int secondWordSize = secondWord.length();

        if (firstWordSize != secondWordSize) {
            return false;
        }

        Map<Character, Integer> firstWordMap = new HashMap<>();
        for (char c : firstWordByLetterTab) {
            firstWordMap.put(c, firstWordMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> secondWordMap = new HashMap<>();
        for (char c : secondWordByLetterTab) {
            secondWordMap.put(c, secondWordMap.getOrDefault(c, 0) + 1);
        }
        return firstWordMap.equals(secondWordMap);
    }

    public void makeResult() {
        System.out.println("Veuillez saisir un premier mot : ");
        Scanner scan = new Scanner(System.in);
        String firstEntered = scan.nextLine();
        word.setFirstWord(firstEntered);
        System.out.println("Veuillez saisir un second mot : ");

        String secondEntered = scan.nextLine();
        word.setSecondWord(secondEntered);
        System.out.println("Les mots choisis sont : " + firstEntered + " et " + secondEntered);

        if (isAnagram(word.getFirstWord(), word.getSecondWord())) {
            System.out.print(word.getFirstWord() + " et " + word.getSecondWord() + " forment un anagramme.");
        }
        else {
            System.out.print(word.getFirstWord() + " et " + word.getSecondWord() + " ne forment pas d'anagramme.");
        }
    }
}
