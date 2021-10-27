package com.pb.bazeluk.hw4;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.println("Введена строка: "+input);
        System.out.println("Преобразованная строка: "+firstToUppercase(input));
    }

    public static String firstToUppercase(String s) {

        Matcher mth = Pattern.compile("^(\\p{L})|\\s(\\p{L})").matcher(s);

        while (mth.find()) {
            s = s.replaceFirst(mth.group(), mth.group().toUpperCase());
        }
        return s;
    }
}
