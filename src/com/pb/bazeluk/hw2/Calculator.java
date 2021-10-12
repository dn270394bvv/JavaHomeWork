/*
1) Создайте класс Calculator в пакете hw2.
Создайте две целочисленных переменные с именами operand1 и operand2.
Предложите ввести значения operand1 и operand2 пользователю.
Также предложите пользователю ввести знак арифметической операции и поместите его в строковую переменную sign.
Пусть калькулятор может только складывать, отнимать, умножать и делить.
Для организации выбора алгоритма вычислительного процесса, используйте переключатель switch.
Выведите на экран результат выполнения арифметической операции.
В случае использования операции деления, организуйте проверку попытки деления на ноль.
И если таковая имеется, то отмените выполнение арифметической операции и уведомите об ошибке пользователя.
* */
package com.pb.bazeluk.hw2;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        int a,b;
        String sign;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число а: ");
        a = scan.nextInt();
        System.out.print("Введите число b: ");
        b = scan.nextInt();
        System.out.print("Выберите операцию: ");
        sign = scan.next();
        switch (sign){
            case "+" :
                System.out.println("Результат: "+ (a+b));
                break;
            case "-" :
                System.out.println("Результат: "+ (a-b));
                break;
            case "*" :
                System.out.println("Результат: "+ (a*b));
                break;
            case "/" :
                if (b == 0) {
                    System.out.println("Операция деления на ноль запрещена!");
                }else {
                    System.out.println("Результат: " + (a / b));
                }
                break;

            default:
                System.out.println("Не понятная операция!");
        }


    }
}
