package com.pb.bazeluk.hw2;
import java.util.Scanner;

/*
Создайте класс Interval в пакете hw2.
Предложите пользователю ввести целое число и сохраните его в переменную с произвольным именем.
Программа должна выяснить в какой промежуток попадает введенное число [0 -14] [15 - 35] [36 - 50] [51 - 100].
Вывести на экран сообщение с подходящим промежутком.
Если введенное число не попадает в один из имеющихся промежутков, то вывести соответствующее сообщение.
* */
public class Interval {
    public static void main(String[] args) {
        int a;
        Scanner scan = new Scanner(System.in);
        System.out.print("Число а = ");
        a = scan.nextInt();
        if (a>=0 && a<=14){
            System.out.println("Число в интервале [0 -14]");
        }else if (a>=15 && a<=35){
            System.out.println("Число в интервале [15 -35]");
        }else if (a>=36 && a<=50){
            System.out.println("Число в интервале [36 -50]");
        }else if (a>=51 && a<=100){
            System.out.println("Число в интервале [51 -100]");
        }else{
            System.out.println("Не известный интервал!");
        }
    }
}
