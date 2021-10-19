package com.pb.bazeluk.hw3;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Random random = new Random();
        int count = 0;
        int bingo = random.nextInt(101);
        Scanner scanner = new Scanner(System.in);
        String attempt;
        int attemptNumber;
        System.out.println("Я загадал чило от 0 до 100. Отгадай если сможешь!");
        while (true){
            System.out.print("Твоё число:");
            attempt = scanner.next();
            if (attempt.equals("exit"))  break;
            try {
                attemptNumber = Integer.parseInt(attempt);
            } catch(NumberFormatException e){
                System.out.println("Вы ввели не верную команду! Для выхода введи команду \"exit\"!");
                continue;
            }
            count ++;
        if ( attemptNumber!= bingo) {
            if (attemptNumber<bingo){
                System.out.println("Число "+attemptNumber+" меньше загаданного! Попробуйте еще! \n Для выхода введи команду \"exit\"!");
            }else{
                System.out.println("Число "+attemptNumber+" больше загаданного! Попробуйте еще! \n Для выхода введи команду \"exit\"!");
            }
            continue;
        }

            System.out.println("Поздравляем вы отгадали число "+bingo+" с "+count+" попыток.");
        break;
        }
        System.out.println("Игра завершена!");
    }
}
