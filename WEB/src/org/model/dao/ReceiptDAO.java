/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.model.beans.CustomerModel;
import org.model.beans.InvoiceDetailsModel;
import org.model.beans.ReceiptModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class ReceiptDAO implements DAO<ReceiptModel> {
	Database db;

	public ReceiptDAO(Database db) {
		this.db = db;
	}

	@Override
	public int Add(ReceiptModel bean) {
		String sql = "INSERT INTO RECEIPT (RECEIPT_ID,REC_DATE,CUSTOMER_ID,TOTAL) VALUES (RECEIPT_SEQ.NEXTVAL,TO_DATE('" + bean.getRec_date() + "','DD-MM-YYYY'),'" + bean.getCustomer_id().getCustomerId()+ "','" + bean.getTotal() + "')";
		//TO_DATE('DD-MM-YYYY')
		//	return db.add(sql);

		return db.adds(sql, new String[]{"RECEIPT_ID"});
	
	}
 
	@Override
	public int Delete(ReceiptModel bean) {
		String sql = "DELETE FROM RECEIPT WHERE RECEIPT_ID =" + bean.getReceipt_id();
		return db.remove(sql);
	}

	@Override
	public int Update(ReceiptModel bean) {
		String sql = "UPDATE RECEIPT SET REC_DATE = '" + bean.getRec_date() + "',CUSTOMER_ID = '"
				+ bean.getCustomer_id().getCustomerId() + "',TOTAL='" + bean.getTotal() + "' WHERE RECEIPT_ID ='"
				+ bean.getReceipt_id() + "'";
		return db.update(sql);
	}

	@Override
	public ArrayList<ReceiptModel> FindAll() {
		String sql = "SELECT * FROM RECEIPT";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<ReceiptModel> recList = new ArrayList<ReceiptModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			ReceiptModel recModel = MappingBeans(next);
			recList.add(recModel);
		}
		return recList;
	}

	@Override
	public ReceiptModel FindByID(ReceiptModel bean) {
		String sql = "SELECT * FROM RECEIPT WHERE RECEIPT_ID =" + bean.getReceipt_id();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		ReceiptModel recModel = MappingBeans(querySingle);
		return recModel;
	}

	@Override
	public ReceiptModel FindByID(int id) {
		String sql = "SELECT * FROM RECEIPT WHERE RECEIPT_ID =" + id;
		HashMap<String, Object> querySingle = db.querySingle(sql);
		ReceiptModel recModel = MappingBeans(querySingle);
		return recModel;
	}

	@Override
	public ReceiptModel MappingBeans(HashMap<String, Object> map) {
		ReceiptModel recModel = new ReceiptModel();

		Database db = new Database();
		CustomerDAO cusDAO = new CustomerDAO(db);
		CustomerModel cusModel = cusDAO.FindByID(Integer.parseInt(map.get("CUSTOMER_ID").toString()));

		db.close();
		recModel.setReceipt_id(Integer.parseInt(map.get("RECEIPT_ID").toString()));
		recModel.setRec_date(map.get("REC_DATE").toString());
		recModel.setCustomer_id(cusModel);
		recModel.setTotal(Integer.parseInt(map.get("TOTAL").toString()));
		recModel.setTime_reg(map.get("TIME_REG").toString());

		return recModel;
	}
	public int UpdateTotal(ReceiptModel bean) {
		String sql = "UPDATE RECEIPT SET TOTAL ='" + bean.getTotal() + "' WHERE RECEIPT_ID = " + bean.getReceipt_id() ;
		return db.update(sql);
	}

}
