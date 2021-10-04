/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Server;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import za.ac.cput.Worker.Login;
import za.ac.cput.Worker.addClient;
import za.ac.cput.Worker.addItem;

/**
 *
 * @author Rhegan/Marvin
 */
public class OneStopServer {

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream DiS = null;/////////////Connection
    String dburl = "jdbc:derby://localhost:1527/OneStopLogin";
    String user = "root";
    String pass = "admin";
    Connection connection;

    public OneStopServer() {
        
    }

    ////////////////Login 
    public ArrayList<Login> getLogin() {
        ArrayList<Login> allLogin = new ArrayList<>();
        PreparedStatement ps = null;

        try {
            connection = DriverManager.getConnection(dburl, user, pass);
            String getAllSql = "SELECT * FROM login";
            ps = connection.prepareStatement(getAllSql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    allLogin.add(new Login(rs.getString(1), rs.getString(2), rs.getBoolean(3)));
                }
            }

            connection.close();
        } catch (SQLException sql) {
            System.out.println("Error:" + sql);
        } catch (Exception exc) {
            System.out.println("Error:" + exc);
        }

        return allLogin;
    }

    /////////////Saving Item
    public addItem saveItem(addItem item){
        try{
            connection = DriverManager.getConnection(dburl, user, pass);
            String saveSQL = "INSERT INTO item(ItemName, ItemCategory, ItemDescription, ItemQuantity, ItemPrice) VALUES (?,?,?,?,?)";

            PreparedStatement ps = this.connection.prepareStatement(saveSQL);

            ps.setString(1, item.getItemname());
            ps.setString(2, item.getItemCategory());
            ps.setString(3, item.getItemDescript());
            ps.setInt(4, (int) item.getItemQuantity());
            ps.setDouble(5, (double) item.getItemPrice());

            ps.executeUpdate();
            ps.close();
        }catch(SQLException SQLExc){
            System.out.println("Error: " + SQLExc);
        }

        return item;
    }

    //////Saving a client
    public addClient saveClient(addClient client){
        try{
            connection = DriverManager.getConnection(dburl, user, pass);
            String saveSQL = "INSERT INTO client(ClientName, ClientSurname, ClientEmail, ClientNumber, ClientID) VALUES (?,?,?,?,?)";

            PreparedStatement psc = this.connection.prepareStatement(saveSQL);

            psc.setString(1, client.getClientName());
            psc.setString(2, client.getClientSurname());
            psc.setString(3, client.getClientEmail());
            psc.setString(4, client.getClientNumber());
            psc.setString(5, client.getClientID());

            psc.executeUpdate();
            psc.close();
        }catch(SQLException SQLExc){
            System.out.println("Error: " + SQLExc);
        }
        
        return client;
    }

    /////////////Saving to user 
    public Login saveLogin(Login add){
        try{
            connection = DriverManager.getConnection(dburl, user, pass);
            String clientSQL = "INSERT INTO login(username, password, activity) VALUES (?,?,?)";

            PreparedStatement psl = this.connection.prepareStatement(clientSQL);

            psl.setString(1, add.getuserLogin());
            psl.setString(2, add.getpassLogin());
            psl.setBoolean(3, add.getActivity()); 

            psl.executeUpdate();
            psl.close();
            
            JOptionPane.showMessageDialog(null, "Added client Successful! ");
        }catch(SQLException SQLExc){
            System.out.println("Error: " + SQLExc);
            JOptionPane.showMessageDialog(null, "Failed to add client");
        }
        
        return add;
    }

    ///////////////Update
    public Login updateUser(Login update){
        try{
            connection = DriverManager.getConnection(dburl, user, pass);
            String updateSQL = "UPDATE login SET activity=? WHERE username=?";

            PreparedStatement psU = this.connection.prepareStatement(updateSQL);

            psU.setBoolean(1, update.getActivity());
            psU.setString(2,update.getuserLogin());

            psU.executeUpdate();
            psU.close();
        }catch(SQLException SQLExc){
            System.out.println("Error: " + SQLExc);
        }
        
        return update;
    }

    //start of server
    public OneStopServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The server has been started");

            System.out.println("Waiting for request from client");

            socket = serverSocket.accept();
            System.out.println("Client request accepted");

            DiS = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";
            while (!line.equals("over")) {
                try {
                    line = DiS.readUTF();
                    System.out.println(line);
                } catch (IOException IOExc) {
                    System.out.println("Error: " + IOExc);
                }
            }

            try {
                DiS.close();
                socket.close();
            } catch (IOException IOExc) {
                System.out.println("Error: " + IOExc);
            }

        } catch (IOException IOExc) {
            System.out.println("Error: " + IOExc);
        }
    }

    public static void main(String[] args) {
        new OneStopServer(1529);
    }
}
