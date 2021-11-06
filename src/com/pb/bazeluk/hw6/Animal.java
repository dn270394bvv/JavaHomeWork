package com.pb.bazeluk.hw6;

import java.util.Locale;

public class Animal {
   private String food;
    private Locale location;

    public Animal( String food){
        this.food = food;
        this.location = Locale.getDefault();
    }

    public Animal( String food,Locale location){
        this(food);
        if (location.getCountry().isEmpty()){
            this.location = Locale.getDefault();
        }else{
            this.location = location;
        }
        if (location.getDisplayLanguage().isEmpty()){
            this.location = Locale.getDefault();
        }else{
            this.location = location;
        }
    }

    public Animal() {
    }

    //функциональные методы класса "животное"
    public void makeNoise(){
        System.out.println("Животное шумит в месте под названием " + this.location.getDisplayCountry() + " на языке " + this.location.getDisplayLanguage());

    }
    public void eat(){
        System.out.println("Животное ест " + this.food);
    }
    public void sleep(){
        System.out.println("Животное спит в месте под названием " + this.location.getDisplayCountry());
    }

    //Сеттеры
    public void setFood(String food){
        this.food=food;
    }
    public void setLocation(Locale location) {
        this.location = location;
    }
    //геттери
    public String getFood() {
        return food;
    }
    public Locale getLocation() {
        return location;
    }
}
