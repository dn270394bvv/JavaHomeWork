package com.pb.bazeluk.hw11;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

public class User implements Serializable {
    private final static long serialVersionUID = 42;
    private String fio;
    private LocalDate bDay;
    private HashMap<PhoneType,String> phones;
    private ResidenceAddress address;
    private Timestamp change;

    public User (String fio,LocalDate bDay, HashMap<PhoneType, String>  phones, ResidenceAddress address){
        this.fio = fio;
        this.bDay = bDay;
        this.phones  = phones;
        this.address = address;
        this.change = new Timestamp(new Date().getTime());
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
        this.change = new Timestamp(new Date().getTime());
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
        this.change = new Timestamp(new Date().getTime());
    }

    public HashMap<PhoneType, String> getPhones() {
        return phones;
    }

    public void setPhones(HashMap<PhoneType, String> phones) {
        this.phones = phones;
        this.change = new Timestamp(new Date().getTime());
    }

    public ResidenceAddress getAddress() {
        return address;
    }

    public void setAddress(ResidenceAddress address) {
        this.address = address;
        this.change = new Timestamp(new Date().getTime());
    }

    public Timestamp getChange() {
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
}
