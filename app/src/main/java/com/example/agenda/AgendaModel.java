package com.example.agenda;

import java.util.Date;

public class AgendaModel {

    // Déclaration des variables
    private int id;
    private String name;
    private String surname;
    private String adress;
    private int cp;
    private String city;
    private int phone;
    private String gender;
    private String birthday;
    private String place;

    // Constructeur
    public AgendaModel(int id, String name, String surname, String adress, int cp, String city, int phone, String gender, String birthday, String place) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.cp = cp;
        this.city = city;
        this.phone = phone;
        this.gender = gender;
        this.birthday = birthday;
        this.place = place;
    }

    //toString() est nécéssaire pour afficher le contenu d'une classe
    @Override
    public String toString() {
        return "AgendaModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", adress='" + adress + '\'' +
                ", cp=" + cp +
                ", city='" + city + '\'' +
                ", phone=" + phone +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", place='" + place + '\'' +
                '}';
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() { return birthday; }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
