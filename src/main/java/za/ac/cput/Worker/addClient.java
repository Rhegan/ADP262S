/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Worker;

/**
 *
 * @author Rhegan
 */
public class addClient {

    private String ClientName, ClientSurname, ClientEmail, ClientNumber, ClientID;

    public addClient(String ClientName, String ClientSurname, String ClientEmail, String ClientNumber, String ClientID) {
        this.ClientName = ClientName;
        this.ClientSurname = ClientSurname;
        this.ClientEmail = ClientEmail;
        this.ClientNumber = ClientNumber;
        this.ClientID = ClientID;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getClientSurname() {
        return ClientSurname;
    }

    public void setClientSurname(String ClientSurname) {
        this.ClientSurname = ClientSurname;
    }

    public String getClientEmail() {
        return ClientEmail;
    }

    public void setClientEmail(String ClientEmail) {
        this.ClientEmail = ClientEmail;
    }

    public String getClientNumber() {
        return ClientNumber;
    }

    public void setClientNumber(String ClientNumber) {
        this.ClientNumber = ClientNumber;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

    @Override
    public String toString() {
        return "addClient{" + "ClientName=" + ClientName + ", ClientSurname=" + ClientSurname + ", ClientEmail=" + ClientEmail + ", ClientNumber=" + ClientNumber + ", ClientID=" + ClientID + '}';
    }
}
