package com.pb.bazeluk.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auth auth = new Auth();
        String login,password, confirmPassword;
        for (int i=5; i>0;i--){
            System.out.print("Регистрация\n Login: ");
            login = scanner.nextLine();
            System.out.print("password: ");
            password = scanner.nextLine();
            System.out.print("confirmPassword: ");
            confirmPassword = scanner.nextLine();
            try {
                auth.signUp(login, password, confirmPassword);
                System.out.println("Поздравляем!\nРегистрация пользователя "+ login + " выполнена успешно!" );
                break;
            }catch (WrongLoginException|WrongPasswordException e){
                System.out.println(e.getMessage());
                System.out.println("Осталось попыток регистрации: " + i);
            }

            }
        System.out.println("=======================================================");
        for (int i=3; i>=0;i--){
            System.out.print("Вход\n Login: ");
            login = scanner.nextLine();
            System.out.print("password: ");
            password = scanner.nextLine();
            try {
                auth.signIn(login, password);
                System.out.println("Поздравляем!\nВход пользователя "+ login + " выполнена успешно!" );
                break;
            }catch (WrongPasswordException e){
                System.out.println(e.getMessage());
                System.out.println("Осталось попыток входа: " + i);
            }

        }

        }


    }
