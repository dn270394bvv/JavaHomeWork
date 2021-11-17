package com.pb.bazeluk.hw8;


import java.util.Objects;
import java.util.regex.Pattern;

public class Auth {
    private String login, password;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException,WrongPasswordException {

        if (!Pattern.matches("[a-zA-Z0-9]{5,20}",login)) throw new WrongLoginException("Логин должен быть от 5 до 20 символов и содержать только латинские буквы и цифры!");
        if (!Pattern.matches("\\w{5,}+",password)) throw new WrongPasswordException("Пароль должен быть более 5, только латинские буквы и цифры и знак подчеркивания!");
        if (!Objects.equals(password,confirmPassword)) throw new WrongPasswordException("Ошибка подтверждения пароля!");
        this.login = login;
        this.password = password;
    };
    public void signIn(String login, String password) throws WrongPasswordException {
        if (Objects.equals(login,this.login) && Objects.equals(password,this.password)) System.out.println("Выполнен успешный вход...");
        else throw  new WrongPasswordException("Не верный логин или пароль");
    }

}
