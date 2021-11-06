package com.pb.bazeluk.hw6;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Dog extends Animal{
    private String nickname;
    private boolean trained;
    //констрктори класса Dog
    public Dog(String food) {
        super(food);
    }

    public Dog(String food,Locale location) {
        super(food,location);
    }

    public Dog(String food,Locale location,String nickname) {
        super(food,location);
        this.nickname = nickname;
    }


    //переопределенные методы класса "Animal"
    @Override
    public void makeNoise(){
        System.out.println("Собака шумит в " + this.getLocation().getDisplayCountry() + " на языке " + this.getLocation().getDisplayLanguage());

    }
    @Override
    public void eat(){
        System.out.println("Собака ест " + this.getFood());
    }
    @Override
    public void sleep(){
        System.out.println("Собака спит в " + this.getLocation().getDisplayCountry());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return    Objects.equals(getFood(),dog.getFood())
                && Objects.equals(getLocation(),dog.getLocation())
                && Objects.equals(nickname, dog.nickname)
                && trained == dog.trained;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname,trained,getFood(),getLocation());
    }

    @Override
    public String toString() {
        return "dog {" +
                "nickname='" + nickname + '\'' +
                ", trained=" + trained + '\'' +
                ", food=" + getFood() + '\'' +
                ", location=" + getLocation()  +
                '}';
    }




    //новый метод тренировки класса Dog
    public void training(){
        if (this.trained) {
            System.out.println("Собака"+ ((this.nickname != null && !this.nickname.isEmpty())?" по кличке " + '"'+this.nickname+'"':"") + " уже дрессирована!");
        }else {
        System.out.println("Начинаю дрессировку...");
        if (this.nickname != null && !this.nickname.isEmpty()) {
            this.trained = true;
        }else {
            System.out.println("Для начала дресировки дайте собаке кличку  \ninfo - для отмены дресировки нажмите Enter, без ввода клички");
            System.out.print("Кличка собаки: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                this.nickname = input;
                this.trained = true;
            }

        }
            System.out.println("Дресировка " + (trained?'"'+this.nickname+'"'+" успешна!":"не успешна!"));
    }
    }

    //геттеры и сеттеры

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }
}
