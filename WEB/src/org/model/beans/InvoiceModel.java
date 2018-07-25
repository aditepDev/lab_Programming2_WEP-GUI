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
public class InvoiceModel {
    public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public SuppliersModel getSuppliers_id() {
		return suppliers_id;
	}
	public void setSuppliers_id(SuppliersModel suppliers_id) {
		this.suppliers_id = suppliers_id;
	}
	public String getInv_date() {
		return inv_date;
	}
	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTime_reg() {
		return time_reg;
	}
	public void setTime_reg(String time_reg) {
		this.time_reg = time_reg;
	}
	private int invoice_id;
    private SuppliersModel suppliers_id;
    private String inv_date;
    private int total;
	private int status;
    private String time_reg;
    
 
}
