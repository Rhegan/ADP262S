/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.*;
import za.ac.cput.Server.OneStopServer;
import za.ac.cput.Worker.addClient;

/**
 *
 * @author Rhegan
 */
public class OneStopUserGUI extends JFrame implements ActionListener {

    //main frame split into North, Center and South
    private JFrame mainFrame;
    private JPanel panelCenter;

    //North, Center and South split into West, Center and East
    //CenterWest panel has user labels
    private JPanel panelCenterWest;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblEmail;
    private JLabel lblClientNumber;
    private JLabel lblClientID;

    //CenterCenter panel has user textfields
    private JPanel panelCenterCenter;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtEmail;

    private JTextField txtClientNumber;
    private JTextField txtClientID;

    //CenterEast panel has user button
    private JPanel panelCenterEast;
    private JButton btnAddUser;

    private JButton btnLogout = new JButton("Logout");
    private JTextField blank1 = new JTextField();
    private JTextField blank2 = new JTextField();
    private JTextField blank3 = new JTextField();
    private JTextField blank4 = new JTextField();
    private JTextField blank5 = new JTextField();
    private JTextField blank6 = new JTextField();

    public OneStopUserGUI() {
        mainFrame = new JFrame("User");
        panelCenter = new JPanel();

        panelCenterWest = new JPanel();
        lblName = new JLabel("Client Name:");
        lblSurname = new JLabel("Client Surname:");
        lblEmail = new JLabel("Client Email:");
        lblClientNumber = new JLabel("Client Phone Number");
        lblClientID = new JLabel("Client ID Number:");

        panelCenterCenter = new JPanel();
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtEmail = new JTextField();
        txtClientNumber = new JTextField();
        txtClientID = new JTextField();

        panelCenterEast = new JPanel();
        btnAddUser = new JButton("Add Customer");

    }

    public void setUserGUI() {
        mainFrame.add(panelCenter, BorderLayout.CENTER);

        panelCenter.setLayout(new GridLayout(1, 3));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCenter.add(panelCenterWest, BorderLayout.WEST);
        panelCenterWest.setLayout(new GridLayout(6, 1));
        panelCenterWest.add(lblName);
        panelCenterWest.add(lblSurname);
        panelCenterWest.add(lblEmail);
        panelCenterWest.add(lblClientNumber);
        panelCenterWest.add(lblClientID);
        panelCenterWest.add(btnLogout);

        panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
        panelCenterCenter.setLayout(new GridLayout(6, 1));
        panelCenterCenter.add(txtName);
        panelCenterCenter.add(txtSurname);
        panelCenterCenter.add(txtEmail);
        panelCenterCenter.add(txtClientNumber);
        panelCenterCenter.add(txtClientID);
        panelCenterCenter.add(blank1).setVisible(false);

        panelCenter.add(panelCenterEast, BorderLayout.EAST);
        panelCenterEast.setLayout(new GridLayout(6, 1));
        panelCenterEast.add(blank2).setVisible(false);
        panelCenterEast.add(blank3).setVisible(false);
        panelCenterEast.add(blank4).setVisible(false);
        panelCenterEast.add(blank5).setVisible(false);
        panelCenterEast.add(btnAddUser);
        panelCenterEast.add(blank6).setVisible(false);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnAddUser.addActionListener(this);
        btnLogout.addActionListener(this);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddUser) {

            String ClientName = txtName.getText();
            String ClientSurname = txtSurname.getText();
            String ClientEmail = txtEmail.getText();
            String ClientNumber = txtClientNumber.getText();
            String ClientID = txtClientID.getText();

            addClient ad = new addClient(ClientName, ClientSurname, ClientEmail, ClientNumber, ClientID);

            new OneStopServer().saveClient(ad);

        }
        if (btnLogout.equals(e.getSource())) {
            mainFrame.dispose();
            new OneStopLoginGUI().GUI();
        }
    }
}
