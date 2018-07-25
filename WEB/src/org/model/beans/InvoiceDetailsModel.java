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
public class InvoiceDetailsModel {

    private int invoice_deteils_id;
    private InvoiceModel invoice_id;
    private StationeriesModel goods_id;
    private int qty;
    private int amount;
    private int status;
    private String time_reg;
    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

    /**
     * @return the invoice_deteils_id
     */
    public int getInvoice_deteils_id() {
        return invoice_deteils_id;
    }

    /**
     * @param invoice_deteils_id the invoice_deteils_id to set
     */
    public void setInvoice_deteils_id(int invoice_deteils_id) {
        this.invoice_deteils_id = invoice_deteils_id;
    }

    /**
     * @return the invoice_id
     */
    public InvoiceModel getInvoice_id() {
        return invoice_id;
    }

    /**
     * @param invoice_id the invoice_id to set
     */
    public void setInvoice_id(InvoiceModel invoice_id) {
        this.invoice_id = invoice_id;
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
