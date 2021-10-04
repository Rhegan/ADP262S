/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Client;

import java.io.*;
import java.net.*;
import za.ac.cput.GUI.OneStopLoginGUI;

/**
 *
 * @author Rhegan/Marvin
 */
public class OneStopClient {

    private Socket socket = null;
    private DataInputStream DiS = null;
    private DataOutputStream DoS = null;
    
    public OneStopClient(String address, int port){
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");
            
            DiS = new DataInputStream(System.in);
            
            DoS = new DataOutputStream(socket.getOutputStream());
            
        }catch(UnknownHostException UHExc){
            System.out.println("Error: " + UHExc);
        }catch(IOException IOExc){
            System.out.println("Error: " + IOExc);
        }
        
        new OneStopLoginGUI().GUI();
        
        String line = "";
        System.out.println("Enter \"over\" to close client");
        while(!line.equals("over")){
            try{
                line = DiS.readLine();
                DoS.writeUTF(line);
            }catch(IOException IOExc){
                System.out.println("Error: " + IOExc);
            }
        }
        
        try{
            DiS.close();
            DoS.close();
            socket.close();
        }catch(IOException IOExc){
            System.out.println("Error: " + IOExc);
        }
    } 
    
    public static void main(String[] args) throws IOException {
        new OneStopClient("Localhost", 1529);
    }
}
