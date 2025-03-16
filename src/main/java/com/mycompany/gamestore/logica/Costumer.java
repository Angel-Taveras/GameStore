package com.mycompany.gamestore.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_costumer;
    private String firstName;
    private String lastName;
    private String emailAddress;

    private String phoneNumber;

    public Costumer() {
    }

    public Costumer(String firstName, String lastName, String emailAddress, int id_costumer, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.id_costumer = id_costumer;
        this.phoneNumber = phoneNumber;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int id_costumer(){
        return id_costumer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void set(int id_costumer){
        this.id_costumer = id_costumer;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
