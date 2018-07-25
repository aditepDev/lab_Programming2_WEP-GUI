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
public class ReceiptDetailsModel {
    private int receipt_det_id;
    private ReceiptModel receipt_id;
    private StationeriesModel goods_id;
    private int qty;
    private int amount;
    private String time_reg;

    /**
     * @return the receipt_det_id
     */
    public int getReceipt_det_id() {
        return receipt_det_id;
    }

    /**
     * @param receipt_det_id the receipt_det_id to set
     */
    public void setReceipt_det_id(int receipt_det_id) {
        this.receipt_det_id = receipt_det_id;
    }

    /**
     * @return the receipt_id
     */
    public ReceiptModel getReceipt_id() {
        return receipt_id;
    }

    /**
     * @param receipt_id the receipt_id to set
     */
    public void setReceipt_id(ReceiptModel receipt_id) {
        this.receipt_id = receipt_id;
    }

    /**
     * @return the goods_id
     */
    public StationeriesModel getGoods_id() {
        return goods_id;
    }

    /**
     * @param goods_id the goods_id to set
     */
    public void setGoods_id(StationeriesModel goods_id) {
        this.goods_id = goods_id;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
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
