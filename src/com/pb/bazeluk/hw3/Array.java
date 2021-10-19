package com.pb.bazeluk.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        //Иннициализация переменных
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        int[] arraySort;
        int sum = 0;
        int posEl = 0;
        int buffer;
        boolean sorted = false;

        // Считывание массива
        System.out.println("Введите 10 чисел");
        for(int i=0;i<array.length;i++){
            System.out.print("array["+i+"]: ");
            array[i]= scanner.nextInt();
            sum +=array[i];
            if (array[i] > 0) posEl++;
        }
        arraySort = array.clone(); //копирование массива для сортировки

        //Соритровка пузырьком
        while (!sorted){
            sorted = true;
            for (int i=0;i<arraySort.length-1;i++){
                if (arraySort[i]>arraySort[i+1]){ // выбор направления сортировки массива
                    sorted =false;
                    buffer = arraySort[i+1];
                    arraySort[i+1]=arraySort[i];
                    arraySort[i] = buffer;
                }
            }
        }
        // вывод введенного массива
        System.out.print("Исходный массив: ");
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();// переход на новую строку
        System.out.println("Сумма всех елементов: "+sum);
        System.out.println("Количество положительных чисел: "+posEl);
        // вывод сортированного массива
        System.out.print("Отсортированный массив: ");
        for (int anArray : arraySort) {
            System.out.print(anArray + " ");
        }
    }
}
