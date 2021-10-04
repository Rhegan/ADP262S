/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.GUI;

import za.ac.cput.Worker.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import za.ac.cput.Server.OneStopServer;

/**
 *
 * @author Rhegan
 */
public class OneStopLoginGUI extends JFrame implements ActionListener {

    private JFrame pnlMain = new JFrame("User Login");
    private JPanel pnlCenter = new JPanel();
    private JPanel pnlSouth = new JPanel();
    private JPanel pnlContent = new JPanel(new GridLayout(2, 1));
    private JPanel pnlButtons = new JPanel(new GridLayout(1, 1));

    private JTextField txtUser = new JTextField(16);
    private JPasswordField txtPass = new JPasswordField();
    private JButton btnLogin = new JButton("Login");

    public OneStopLoginGUI() {
        pnlMain.setPreferredSize(new Dimension(300, 200));
        pnlCenter.setBackground(new Color(173, 216, 230));
        txtUser.setBorder(BorderFactory.createTitledBorder("Username"));
        txtPass.setBorder(BorderFactory.createTitledBorder("Password"));

        pnlSouth.setBackground(new Color(173, 216, 230));
        pnlButtons.setBorder(BorderFactory.createLineBorder(black, 1, true));
    }

    public void GUI() {
        pnlMain.add(pnlCenter, BorderLayout.CENTER);
        pnlMain.add(pnlSouth, BorderLayout.SOUTH);
        pnlCenter.add(pnlContent);
        pnlSouth.add(pnlButtons);

        pnlContent.add(txtUser);
        pnlContent.add(txtPass);
        pnlButtons.add(btnLogin);
        btnLogin.addActionListener(this);

        pnlMain.pack();
        pnlMain.setLocationRelativeTo(null);
        pnlMain.setResizable(true);
        pnlMain.setVisible(true);
        pnlMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(JTextField txtUser) {
        this.txtUser = txtUser;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLogin)) {

            OneStopServer dao = new OneStopServer();
            ArrayList<Login> id = dao.getLogin();

            ArrayList<Login> gui = new ArrayList<>();
            String password = new String(txtPass.getPassword());
            Boolean activity = true;
            gui.add(new Login(txtUser.getText(), password, activity));
            gui.get(0);
            int i = 0;

            while (i < id.size()) {
                if (gui.get(0).toString().contentEquals(id.get(i).toString()) ? true : false) {
                    try {
                        JOptionPane.showMessageDialog(pnlContent, "Login Accepted");
                            pnlMain.dispose();
                        if (gui.get(0).toString().equals(id.get(0).toString())) {
                            new OneStopAdminGUI().setAdminGUI();
                        } else {
                            new OneStopUserGUI().setUserGUI();
                        }
                        break;
                    } catch (Exception exc) {
                        System.out.println("Error: " + exc);
                    }
                }
                i++;
            }
            txtUser.setText("");
            txtPass.setText("");
        }
    }
}
