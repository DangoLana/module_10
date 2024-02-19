package org.example;

import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        CorrectNumber correctNumber = new CorrectNumber();
        correctNumber.correctPhoneNumber();
        UserJson userJson = new UserJson();
        userJson.createUserJson();
        WordFrequencyCounter wordFrequencyCounter = new WordFrequencyCounter();
        wordFrequencyCounter.sortWordFrequency("src/main/java/org/example/word.txt");


    }
}