package com.mycompany.gamestore.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Uso de auto-incremento en lugar de secuencia
    private int idCostumer;  // Nombre de campo corregido (seguimos las convenciones de nombres en Java)
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    // Constructor sin el parámetro idCostumer (generado automáticamente por JPA)
    public Costumer(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    Costumer() {
       
    }

    // Getters y Setters
    public int getIdCostumer() {
        return idCostumer;
    }

    public void setIdCostumer(int idCostumer) {
        this.idCostumer = idCostumer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId_costumer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}