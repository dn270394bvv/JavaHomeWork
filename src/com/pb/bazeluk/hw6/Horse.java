package com.pb.bazeluk.hw6;


import java.util.Locale;
import java.util.Objects;

public class Horse extends Animal {
    private boolean horseshoe;
    private String rider;

    public Horse (String food){
        super(food);
    }
    public Horse (String food,Locale locale){
        super(food,locale);
    }
    public Horse (String food,Locale locale,String rider){
        super(food,locale);
        this.rider = rider;
    }


    //переопределенные методы класса "Animal"
    @Override
    public void makeNoise(){
        System.out.println("Конь шумит в " + this.getLocation().getDisplayCountry() + " на языке " + this.getLocation().getDisplayLanguage());

    }
    @Override
    public void eat(){
        System.out.println("Конь ест " + this.getFood());
    }
    @Override
    public void sleep(){
        System.out.println("Конь спит в " + this.getLocation().getDisplayCountry());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return    Objects.equals(getFood(),horse.getFood())
                && Objects.equals(getLocation(),horse.getLocation())
                && Objects.equals(rider, horse.rider)
                && horseshoe==horse.horseshoe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rider,horseshoe,getFood(),getLocation());
    }

    @Override
    public String toString() {
        return "horse {" +
                "rider='" + rider + '\'' +
                ", horseshoe=" + horseshoe + '\'' +
                ", food=" + getFood() + '\'' +
                ", location=" + getLocation()  +
                '}';
    }



    // геттеры и сеттеры
    public Boolean getHorseshoe() {
        return horseshoe;
    }

    public void setHorseshoe(Boolean horseshoe) {
        this.horseshoe = horseshoe;
    }

    public String getRider() {
        return rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }
}
