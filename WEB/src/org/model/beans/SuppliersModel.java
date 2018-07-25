/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.beans;

/**
 *
 * @author Aditep
 */
public class SuppliersModel {

    private int suppliers_id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String time_reg;

    /**
     * @return the suppliers_id
     */
    public int getSuppliers_id() {
        return suppliers_id;
    }

    /**
     * @param suppliers_id the suppliers_id to set
     */
    public void setSuppliers_id(int suppliers_id) {
        this.suppliers_id = suppliers_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the time_reg
     */
    public String getTime_reg() {
        return time_reg;
    }

    /**
     * @param time_reg the time_reg to set
     */
    public void setTime_reg(String time_reg) {
        this.time_reg = time_reg;
    }
}
