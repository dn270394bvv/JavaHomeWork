package com.pb.bazeluk.hw4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите оригинальную строку:");
        String input = scanner.nextLine();
        System.out.print("Введите анаграмму прошлой строки:");
        String inputAnagram = scanner.nextLine();
        System.out.println(anagram(input,inputAnagram)?"Строки анаграмаммы!":"Строки не анаграммы!");
    }

    public static boolean anagram(String original, String anagram) {
        Pattern reg = Pattern.compile("[^\\p{L}]");
        char[] originalArr = sort(original.replaceAll(reg.pattern(), "").toLowerCase().toCharArray());
        char[] anagramArr = sort(anagram.replaceAll(reg.pattern(), "").toLowerCase().toCharArray());
        return Arrays.equals(originalArr,anagramArr);
    }

    public static char[] sort(char[] array) {
        boolean sorted = false;
        char buffer;
        //Соритровка пузырьком
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) { // выбор направления сортировки массива
                    sorted = false;
                    buffer = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buffer;
                }
            }
        }
        return array;
    }
}
