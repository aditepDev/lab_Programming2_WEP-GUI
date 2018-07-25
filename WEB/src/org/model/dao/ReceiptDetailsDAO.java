/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.model.beans.InvoiceDetailsModel;
import org.model.beans.ReceiptDetailsModel;
import org.model.beans.ReceiptModel;
import org.model.beans.StationeriesModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class ReceiptDetailsDAO implements DAO<ReceiptDetailsModel> {

	Database db;

	public ReceiptDetailsDAO(Database db) {
		this.db = db;
	}

	@Override
	public int Add(ReceiptDetailsModel bean) {
		String sql = "INSERT INTO RECEIPT_DETAILS (RECEIPT_DET_ID,RECEIPT_ID,GOODS_ID,QTY,AMOUNT) "
				+ "VALUES (RECEIPT_DETAILS_SEQ.NEXTVAL,'" + bean.getReceipt_id().getReceipt_id() + "','"
				+ bean.getGoods_id().getGoods_id() + "','" + bean.getQty() + "','" + bean.getAmount() + "')";
		return db.add(sql);
	}

	@Override
	public int Delete(ReceiptDetailsModel bean) {
		String sql = "DELETE FROM RECEIPT_DETAILS WHERE RECEIPT_DET_ID =" + bean.getReceipt_det_id();
		return db.remove(sql);
	}

	@Override
	public int Update(ReceiptDetailsModel bean) {
		String sql = "UPDATE RECEIPT_DETAILS SET RECEIPT_ID = '" + bean.getReceipt_id().getReceipt_id()
				+ "',GOODS_ID = '" + bean.getGoods_id().getGoods_id() + "',QTY='" + bean.getQty() + "',AMOUNT= '"
				+ bean.getAmount() + "' WHERE RECEIPT_DET_ID ='" + bean.getReceipt_det_id() + "'";
		return db.update(sql);
	}

	@Override
	public ArrayList<ReceiptDetailsModel> FindAll() {
		String sql = "SELECT * FROM RECEIPT_DETAILS";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<ReceiptDetailsModel> recDList = new ArrayList<ReceiptDetailsModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			ReceiptDetailsModel recDModel = MappingBeans(next);
			recDList.add(recDModel);
		}
		return recDList;
	}
	
	
	public ArrayList<ReceiptDetailsModel> FindByReciptID(int id) {
		
		String sql = "SELECT * FROM RECEIPT_DETAILS WHERE RECEIPT_ID = "+id;
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<ReceiptDetailsModel> recDList = new ArrayList<ReceiptDetailsModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			ReceiptDetailsModel recDModel = MappingBeans(next);
			recDList.add(recDModel);
			
		}
		return recDList;
	}
	@Override
	public ReceiptDetailsModel FindByID(ReceiptDetailsModel bean) {
		String sql = "SELECT * FROM RECEIPT_DETAILS WHERE RECEIPT_DET_ID =" + bean.getReceipt_det_id();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		ReceiptDetailsModel recDModel = MappingBeans(querySingle);
		return recDModel;
	}

	@Override
	public ReceiptDetailsModel FindByID(int id) {
		String sql = "SELECT * FROM RECEIPT_DETAILS WHERE RECEIPT_DET_ID =" + id;
		HashMap<String, Object> querySingle = db.querySingle(sql);
		ReceiptDetailsModel recDModel = MappingBeans(querySingle);
		return recDModel;
	}

	@Override
	public ReceiptDetailsModel MappingBeans(HashMap<String, Object> map) {
		
		ReceiptDetailsModel recDModel = new ReceiptDetailsModel();
		Database db = new Database();
		ReceiptDAO recDAO = new ReceiptDAO(db);
		ReceiptModel recModel = recDAO.FindByID(Integer.parseInt(map.get("RECEIPT_ID").toString()));
		db.close();
		db = new Database();
		StationeriesDAO stnDAO = new StationeriesDAO(db);
		StationeriesModel stnModel = stnDAO.FindByID(Integer.parseInt(map.get("GOODS_ID").toString()));
		db.close();
		recDModel.setReceipt_det_id(Integer.parseInt(map.get("RECEIPT_DET_ID").toString()));
		recDModel.setReceipt_id(recModel);
		recDModel.setGoods_id(stnModel);
		recDModel.setQty(Integer.parseInt(map.get("QTY").toString()));
		recDModel.setAmount(Integer.parseInt(map.get("AMOUNT").toString()));
		recDModel.setTime_reg((map.get("TIME_REG").toString()));
		
		
		return recDModel;

	}

}
