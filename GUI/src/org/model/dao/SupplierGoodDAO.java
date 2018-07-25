/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.model.beans.StationeriesModel;
import org.model.beans.SupplierGoodModel;
import org.model.beans.SuppliersModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class SupplierGoodDAO implements DAO<SupplierGoodModel>{
	
	Database db;
	public SupplierGoodDAO(Database db) {
		this.db = db;	
		}
    @Override
    public int Add(SupplierGoodModel bean) {
    	String sql = "INSERT INTO SUPPLIER_GOOD (SUPPLIER_GOOD_ID,SUPPLIERS_ID,GOODS_ID,PRICE, STOCK_QTY) "
				+ "VALUES (SUPPLIER_GOOD_SEQ.NEXTVAL,'" + bean.getSupplier_id().getSuppliers_id()+ "','" + bean.getGoods_id().getGoods_id() +"','"
				+ bean.getPrice()+ "','"+bean.getStockOty()+"')";
		return db.adds(sql,new String[]{"SUPPLIER_GOOD_ID"});    }    

    @Override
    public int Delete(SupplierGoodModel bean) {
    	String sql = "DELETE FROM SUPPLIER_GOOD WHERE SUPPLIER_GOOD_ID =" + bean.getSupplire_good_id();
		return db.remove(sql);      }

    @Override
    public int Update(SupplierGoodModel bean) {
    	String sql = "UPDATE SUPPLIER_GOOD SET SUPPLIERS_ID = '" + bean.getSupplier_id().getSuppliers_id() + "',GOODS_ID = '" + bean.getGoods_id().getGoods_id()
		+ "',PRICE='" + bean.getPrice() + "', STOCK_QTY = '"+bean.getStockOty()+"' WHERE SUPPLIER_GOOD_ID = '"+bean.getSupplire_good_id()+"'";
return db.update(sql);     }

    @Override
    public ArrayList<SupplierGoodModel> FindAll() {
    	String sql = "SELECT * FROM SUPPLIER_GOOD";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<SupplierGoodModel> sppgList = new ArrayList<SupplierGoodModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			SupplierGoodModel spgModel = MappingBeans(next);
			sppgList.add(spgModel);
		}
		return sppgList;      }

    @Override
    public SupplierGoodModel FindByID(SupplierGoodModel bean) {
    	String sql = "SELECT * FROM SUPPLIER_GOOD WHERE SUPPLIER_GOOD_ID =" + bean.getSupplire_good_id();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		SupplierGoodModel spgModel = MappingBeans(querySingle);
		return spgModel;      }

    @Override
    public SupplierGoodModel FindByID(int id) {
    	String sql = "SELECT * FROM SUPPLIER_GOOD WHERE SUPPLIER_GOOD_ID =" + id;
		HashMap<String, Object> querySingle = db.querySingle(sql);
		SupplierGoodModel spgModel = MappingBeans(querySingle);
		return spgModel;       }

    @Override
    public SupplierGoodModel MappingBeans(HashMap<String, Object> map) {
    	SupplierGoodModel sppgModel = new SupplierGoodModel();
    	
    	Database db = new Database();
    	SuppliersDAO sppDAO = new SuppliersDAO(db);  	
    	SuppliersModel sppModal = sppDAO.FindByID(Integer.parseInt(map.get("SUPPLIERS_ID").toString()));
    	db.close();
    	
    	db = new Database();
    	StationeriesDAO stnDAO = new StationeriesDAO(db);
    	StationeriesModel stnModel = stnDAO.FindByID(Integer.parseInt(map.get("GOODS_ID").toString()));
    	db.close();
    	
    	sppgModel.setSupplire_good_id(Integer.parseInt(map.get("SUPPLIER_GOOD_ID").toString()));
    	sppgModel.setSupplier_id(sppModal);
    	sppgModel.setGoods_id(stnModel);
    	sppgModel.setPrice(Integer.parseInt(map.get("PRICE").toString()));
    	sppgModel.setStockOty(Integer.parseInt(map.get("STOCK_QTY").toString()));
    	sppgModel.setTime_reg(map.get("TIME_REG").toString());
    	
    	return sppgModel;
 }
    
    public int UpdateQty(SupplierGoodModel bean) {
    	String sql = "UPDATE SUPPLIER_GOOD SET  STOCK_QTY = '"+bean.getStockOty()+"' WHERE SUPPLIER_GOOD_ID = " + bean.getSupplire_good_id() ;
    	return db.update(sql);     }
}
