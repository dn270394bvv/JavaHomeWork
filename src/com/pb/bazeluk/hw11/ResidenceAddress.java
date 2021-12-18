package com.pb.bazeluk.hw11;

public class ResidenceAddress {
    private String country;
    private String town;
    private String street;
    private short nHouse;
    private String entrance;
    private short apartment;

    @Override
    public String toString() {
        return "ResidenceAddress{" +
                "country='" + country + '\'' +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", nHouse=" + nHouse +
                ", entrance='" + entrance + '\'' +
                ", apartment=" + apartment +
                "}";
    }

    public ResidenceAddress(String country, String town, String street, short nHouse, String entrance, short apartment ){
        this(country,town,street,nHouse,apartment);
        this.entrance = entrance;
    }

    public ResidenceAddress(String country,String town,String street,short nHouse,short apartment){
        this(country,town,street,nHouse);
        this.apartment = apartment;
    }

    public ResidenceAddress(String country,String town,String street,short nHouse){
        this.country= country;
        this.town = town;
        this.street = street;
        this.nHouse = nHouse;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getnHouse() {
        return nHouse;
    }

    public void setnHouse(short nHouse) {
        this.nHouse = nHouse;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public short getApartment() {
        return apartment;
    }

    public void setApartment(short apartment) {
        this.apartment = apartment;
    }


}
