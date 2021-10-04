/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Worker;

import javax.swing.JComboBox;



/**
 *
 * @author user pc
 */
public class addItem {
     
         private String Itemname,ItemCategory,ItemDescript;
         private int ItemQuantity;
         private double ItemPrice;

    public addItem(String Itemname, String ItemDescript, String ItemCategory, int ItemQuantity, double ItemPrice) {
        this.Itemname = Itemname;
        this.ItemDescript = ItemDescript;
        this.ItemCategory = ItemCategory;
        this.ItemQuantity = ItemQuantity;
        this.ItemPrice = ItemPrice;
    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String Itemname) {
        this.Itemname = Itemname;
    }

    public String getItemDescript() {
        return ItemDescript;
    }

    public void setItemDescript(String ItemDescript) {
        this.ItemDescript = ItemDescript;
    }

    public String getItemCategory() {
        return ItemCategory;
    }

    public void setItemCategory(String ItemCategory) {
        this.ItemCategory = ItemCategory;
    }

    public int getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(int ItemQuantity) {
        this.ItemQuantity = ItemQuantity;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    @Override
    public String toString() {
        return "ClientClass{" + "Itemname=" + Itemname + ", ItemDescript=" + ItemDescript + ", ItemCategory=" + ItemCategory + ", ItemQuantity=" + ItemQuantity + ", ItemPrice=" + ItemPrice + '}';
    }
  
    
}