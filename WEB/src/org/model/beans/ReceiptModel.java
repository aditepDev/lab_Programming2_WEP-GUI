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
public class ReceiptModel {
    private int receipt_id;
    private String rec_date;
    private CustomerModel customer_id;
    private int total;
    private String time_reg;

    /**
     * @return the receipt_id
     */
    public int getReceipt_id() {
        return receipt_id;
    }

    /**
     * @param receipt_id the receipt_id to set
     */
    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    /**
     * @return the rec_date
     */
    public String getRec_date() {
        return rec_date;
    }

    /**
     * @param rec_date the rec_date to set
     */
    public void setRec_date(String rec_date) {
        this.rec_date = rec_date;
    }

    /**
     * @return the customer_id
     */
    public CustomerModel getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(CustomerModel customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
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
