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
public class StationeriesModel {

    public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTime_reg() {
		return time_reg;
	}
	public void setTime_reg(String time_reg) {
		this.time_reg = time_reg;
	}
	private int goods_id;
    private String goods_name;
    private String descript;
    private String color;
    private String time_reg;

    

}
