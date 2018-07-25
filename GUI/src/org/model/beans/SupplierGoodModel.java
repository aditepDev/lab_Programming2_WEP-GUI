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
public class SupplierGoodModel {

    /**
     * @return the supplire_good_id
     */
    public int getSupplire_good_id() {
        return supplire_good_id;
    }

    /**
     * @param supplire_good_id the supplire_good_id to set
     */
    public void setSupplire_good_id(int supplire_good_id) {
        this.supplire_good_id = supplire_good_id;
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
     * @return the supplier_id
     */
    public SuppliersModel getSupplier_id() {
        return supplier_id;
    }

    /**
     * @param supplier_id the supplier_id to set
     */
    public void setSupplier_id(SuppliersModel supplier_id) {
        this.supplier_id = supplier_id;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the tome_reg
     */
    public String getTime_reg() {
        return time_reg;
    }

    /**
     * @param tome_reg the tome_reg to set
     */
    public void setTime_reg(String time_reg) {
        this.time_reg = time_reg;
    }
   private int supplire_good_id;
   private StationeriesModel goods_id;
   private SuppliersModel supplier_id;
   private int price;
   public int getStockOty() {
	return stockOty;
}

public void setStockOty(int stockOty) {
	this.stockOty = stockOty;
}
private int stockOty;
   private String time_reg;
}
