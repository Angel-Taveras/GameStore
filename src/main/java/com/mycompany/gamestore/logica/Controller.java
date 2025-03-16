package com.mycompany.gamestore.logica;

import com.mycompany.gamestore.persistence.ControllerPersistence;

public class Controller {

    ControllerPersistence controllPersis = new ControllerPersistence();

    public void save(String firstName, String lastName, String emailAddress, String phoneNumber, String isueDescription, String consoleModel, String serviceType) {

        Costumer costumer = new Costumer();
        costumer.setFirstName(firstName);
        costumer.setLastName(lastName);
        costumer.setEmailAddress(emailAddress);
        costumer.setPhoneNumber(phoneNumber);

        Console console = new Console();
        console.setIssueDescription(isueDescription);
        console.setConsoleModel(consoleModel);
        console.setServiceType(serviceType);
        console.setaCostumer(costumer);
        
        controllPersis.save(costumer, console);

    }

}
