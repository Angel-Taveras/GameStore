package com.mycompany.gamestore.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Console implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int consoleId;
    private String issueDescription;
    private String consoleModel;
    private String serviceType;
    @OneToOne
    private Costumer aCostumer;

    public Console() {
    }

    public Console(String issueDescription, String consoleModel, String serviceType, int consoleId) {
        this.issueDescription = issueDescription;
        this.consoleModel = consoleModel;
        this.serviceType = serviceType;
        this.consoleId = consoleId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public String getConsoleModel() {
        return consoleModel;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getConsoleId() {
        return consoleId;
    }

    public Costumer getaCostumer() {
        return aCostumer;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public void setConsoleModel(String consoleModel) {
        this.consoleModel = consoleModel;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;

    }

    public void setaCostumer(Costumer aCostumer) {
        this.aCostumer = aCostumer;
    }

}
