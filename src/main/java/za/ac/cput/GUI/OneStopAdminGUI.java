/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.GUI;

import za.ac.cput.Worker.addItem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import za.ac.cput.Server.OneStopServer;
import za.ac.cput.Worker.Login;

/**
 *
 * @author Rhegan
 */
public class OneStopAdminGUI extends JFrame implements ActionListener {

    private JFrame mainFrame;
    private JPanel panelNorth;
    private JPanel panelCenter;
    private JPanel panelSouth;

    //North, Center and South split into West, Center and East
    //NorthWest panel has item labels
    private JPanel panelNorthWest;
    private JLabel lblItemName;
    private JLabel lblItemDescription;
    private JLabel lblItemCategory;
    private JLabel lblItemQuantity;
    private JLabel lblItemPrice;

    //CenterWest panel has user labels
    private JPanel panelCenterWest;
    private JLabel lblUsername;
    private JLabel lblUserPassword;
    private JLabel lblActivity;

    //SouthWest panel has user update labels
    private JButton btnLogout;

    private JPanel panelSouthWest;
    private JLabel lblUpdateUser;
    private JLabel lblStatus;

    //NorthCenter panel has item textfields
    private JPanel panelNorthCenter;
    private JTextField txtItemName;
    private JTextArea txtaItemDescription;
    private JComboBox cboItemCategory;
    private String category[] = {"Business", "Filing", "Writing"};
    private JTextField txtItemQuantity;
    private JTextField txtItemPrice;

    //CenterCenter panel has user textfields
    private JPanel panelCenterCenter;
    private JTextField txtUsername;
    private JPasswordField txtUserPassword;
    private JCheckBox chkActivity;

    //SouthCenter panel has user update textfields
    private JPanel panelSouthCenter;
    private JTextField txtUpdateUser;
    private JCheckBox chkActivityUpdate;

    //NorthEast panel has iterm button
    private JPanel panelNorthEast;
    private JButton btnAddProduct;

    //CenterEast panel has user button
    private JPanel panelCenterEast;
    private JButton btnAddUser;

    //SouthEast panel has user update button
    private JPanel panelSouthEast;
    private JButton btnUpdateUser;

    private JTextField blank1;
    private JTextField blank2;
    private JTextField blank3;
    private JTextField blank4;
    private JTextField blank5;
    private JTextField blank6;
    private JTextField blank7;
    private JTextField blank8;

    public OneStopAdminGUI() {
        mainFrame = new JFrame("Admin");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        panelNorthWest = new JPanel();
        lblItemName = new JLabel("Item Name:");
        lblItemDescription = new JLabel("Iterm Description:");
        lblItemCategory = new JLabel("Item Category:");
        lblItemQuantity = new JLabel("Item Quantity:");
        lblItemPrice = new JLabel("Iterm Price:");

        panelCenterWest = new JPanel();
        lblUsername = new JLabel("Username:");
        lblUserPassword = new JLabel("Password:");
        lblActivity = new JLabel("User Activity: Status");

        panelSouthWest = new JPanel();
        lblUpdateUser = new JLabel("Update User:");
        lblStatus = new JLabel("Status:");

        btnLogout = new JButton("Logout");

        panelNorthCenter = new JPanel();
        txtItemName = new JTextField();
        txtaItemDescription = new JTextArea();
        cboItemCategory = new JComboBox(category);
        txtItemQuantity = new JTextField();
        txtItemPrice = new JTextField();

        panelCenterCenter = new JPanel();
        txtUsername = new JTextField();
        txtUserPassword = new JPasswordField();
        chkActivity = new JCheckBox("Active");

        panelSouthCenter = new JPanel();
        txtUpdateUser = new JTextField();
        chkActivityUpdate = new JCheckBox("User Activity Status: ");

        panelNorthEast = new JPanel();
        btnAddProduct = new JButton("Add Item");

        panelCenterEast = new JPanel();
        btnAddUser = new JButton("Add User");

        panelSouthEast = new JPanel();
        btnUpdateUser = new JButton("Update User Status");

        blank1 = new JTextField();
        blank2 = new JTextField();
        blank3 = new JTextField();
        blank4 = new JTextField();
        blank5 = new JTextField();
        blank6 = new JTextField();
        blank7 = new JTextField();
        blank8 = new JTextField();
    }

    public void setAdminGUI() {
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
        mainFrame.add(panelSouth, BorderLayout.SOUTH);

        panelNorth.setLayout(new GridLayout(1, 3));
        panelNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelNorth.add(panelNorthWest, BorderLayout.WEST);
        panelNorthWest.setLayout(new GridLayout(5, 1));
        panelNorthWest.add(lblItemName);
        panelNorthWest.add(lblItemDescription);
        panelNorthWest.add(lblItemCategory);
        panelNorthWest.add(lblItemQuantity);
        panelNorthWest.add(lblItemPrice);

        panelNorth.add(panelNorthCenter, BorderLayout.CENTER);
        panelNorthCenter.setLayout(new GridLayout(5, 1));
        panelNorthCenter.add(txtItemName);
        panelNorthCenter.add(txtaItemDescription);
        panelNorthCenter.add(cboItemCategory);
        panelNorthCenter.add(txtItemQuantity);
        panelNorthCenter.add(txtItemPrice);

        panelNorth.add(panelNorthEast, BorderLayout.EAST);
        panelNorthEast.setLayout(new GridLayout(5, 1));
        panelNorthEast.add(blank1).setVisible(false);
        panelNorthEast.add(blank2).setVisible(false);
        panelNorthEast.add(blank3).setVisible(false);
        panelNorthEast.add(blank4).setVisible(false);
        panelNorthEast.add(btnAddProduct);

        panelCenter.setLayout(new GridLayout(1, 3));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCenter.add(panelCenterWest, BorderLayout.WEST);
        panelCenterWest.setLayout(new GridLayout(3, 1));
        panelCenterWest.add(lblUsername);
        panelCenterWest.add(lblUserPassword);
        panelCenterWest.add(lblActivity);

        panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
        panelCenterCenter.setLayout(new GridLayout(3, 1));
        panelCenterCenter.add(txtUsername);
        panelCenterCenter.add(txtUserPassword);
        panelCenterCenter.add(chkActivity);
        chkActivity.setSelected(true);

        panelCenter.add(panelCenterEast, BorderLayout.EAST);
        panelCenterEast.setLayout(new GridLayout(3, 1));
        panelCenterEast.add(blank5).setVisible(false);
        panelCenterEast.add(blank8).setVisible(false);
        panelCenterEast.add(btnAddUser);

        panelSouth.setLayout(new GridLayout(1, 3));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSouth.add(panelSouthWest, BorderLayout.WEST);
        panelSouthWest.setLayout(new GridLayout(3, 1));
        panelSouthWest.add(lblUpdateUser);
        panelSouthWest.add(lblStatus);
        panelSouthWest.add(btnLogout);
        btnLogout.addActionListener(this);

        panelSouth.add(panelSouthCenter, BorderLayout.CENTER);
        panelSouthCenter.setLayout(new GridLayout(3, 1));
        panelSouthCenter.add(txtUpdateUser);
        panelSouthCenter.add(chkActivityUpdate);
        panelSouthCenter.add(blank6).setVisible(false);

        panelSouth.add(panelSouthEast, BorderLayout.EAST);
        panelSouthEast.setLayout(new GridLayout(3, 1));
        panelSouthEast.add(blank6).setVisible(false);
        panelSouthEast.add(btnUpdateUser);
        panelSouthEast.add(blank7).setVisible(false);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        btnAddProduct.addActionListener(this);
        btnAddUser.addActionListener(this);
        btnUpdateUser.addActionListener(this);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ///////////Adds product
        if (e.getSource() == btnAddProduct) {

            String ItemName = txtItemName.getText();
            String ItemCategory = cboItemCategory.getSelectedItem().toString();
            String ItemDescription = txtaItemDescription.getText();
            int ItemQuantity = Integer.parseInt(txtItemQuantity.getText());
            double ItemPrice = Double.parseDouble(txtItemPrice.getText());

            addItem c = new addItem(ItemName, ItemCategory, ItemDescription, ItemQuantity, ItemPrice);

            try {
                new OneStopServer();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "Added item Successful! ");
            }

        }
        /////////Add user
        if (e.getSource() == btnAddUser) {

            String userLogin = txtUsername.getText();
            String passLogin = txtUserPassword.getText();
            boolean activity = chkActivity.isSelected();
            System.out.println(activity);

            Login login = new Login(userLogin, passLogin, activity);

            try {
                new OneStopServer().saveLogin(login);

            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Added Client Successful! ");
                System.out.println(ex);
            }
        }

        ////////Update user
        if (e.getSource() == btnUpdateUser) {

            String userLogin = txtUsername.getText();
            String passLogin = txtUserPassword.getText();
            boolean activity = chkActivity.isSelected();

            Login login = new Login(userLogin, passLogin, activity);
            
            new OneStopServer().updateUser(login);
            
        }

        //////Returns to the login
        if (btnLogout.equals(e.getSource())) {
            mainFrame.dispose();
            new OneStopLoginGUI().GUI();
        }
    }

}
