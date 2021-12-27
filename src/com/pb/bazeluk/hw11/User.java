package com.pb.bazeluk.hw11;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class User{
    private String fio;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate bDay;
    private List<String> phones = new ArrayList<>();
    private ResidenceAddress address;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime change;
    public User(){

    };

    public User (String fio,LocalDate bDay, ResidenceAddress address, List<String>  phones){
        this.fio = fio;
        this.bDay = bDay;
        this.phones  = phones;
        this.address = address;
        this.change = LocalDateTime.now();
    }




    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
        this.change = LocalDateTime.now();
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
        this.change = LocalDateTime.now();
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List< String> phones) {
        this.phones = phones;
        this.change = LocalDateTime.now();
    }

    public ResidenceAddress getAddress() {
        return address;
    }

    public void setAddress(ResidenceAddress address) {
        this.address = address;
        this.change = LocalDateTime.now();
    }

    public LocalDateTime getChange() {
        return change;
    }


    @Override
    public String toString() {
        return "User{\n" +
                "fio='" + fio + '\'' + ",\n"+
                "bDay=" + bDay.getYear()+"-"+bDay.getMonth()+'-'+bDay.getDayOfMonth() + ",\n"+
                "phones=" + phones + ",\n"+
                "address=" + address + ",\n"+
                "change=" + change + ",\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return fio.equals(user.fio) && bDay.equals(user.bDay) && phones.equals(user.phones) && address.equals(user.address) && change.equals(user.change);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, bDay, phones, address, change);
    }
}
