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
import org.model.beans.InvoiceModel;
import org.model.beans.StationeriesModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class InvoiceDetailsDAO implements DAO<InvoiceDetailsModel> {
	Database db;

	public InvoiceDetailsDAO(Database db) {
		this.db = db;
	}

	@Override
	public int Add(InvoiceDetailsModel bean) {
		String sql = "INSERT INTO INVOICE_DETAILS (INVOICE_DETAILS_ID,INVOICE_ID,GOODS_ID,QTY,AMOUNT,STATUS) "
				+ "VALUES (INVOICE_DETAILS_SEQ.NEXTVAL,'" + bean.getInvoice_id().getInvoice_id() + "','"
				+ bean.getGoods_id().getGoods_id() + "','" + bean.getQty() + "','" + bean.getAmount() + "','"
				+ bean.getStatus() + "')";
		return db.add(sql);
	}

	@Override
	public int Delete(InvoiceDetailsModel bean) {
		String sql = "DELETE FROM INVOICE_DETAILS WHERE INVOICE_DETAILS_ID =" + bean.getInvoice_deteils_id();
		return db.remove(sql);
	}

	@Override
	public int Update(InvoiceDetailsModel bean) {
		String sql = "UPDATE INVOICE_DETAILS SET INVOICE_ID = '" + bean.getInvoice_id().getInvoice_id()
				+ "',GOODS_ID = '" + bean.getGoods_id().getGoods_id() + "',QTY='" + bean.getQty() + "',AMOUNT= '"
				+ bean.getAmount() + "' ,STATUS='" + bean.getStatus() + "'WHERE INVOICE_DETAILS_ID ='"
				+ bean.getInvoice_deteils_id() + "'";
		return db.update(sql);
	}

	@Override
	public ArrayList<InvoiceDetailsModel> FindAll() {
		String sql = "SELECT * FROM INVOICE_DETAILS";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<InvoiceDetailsModel> invDList = new ArrayList<InvoiceDetailsModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			InvoiceDetailsModel invD = MappingBeans(next);
			invDList.add(invD);
		}
		return invDList;
	}

	@Override
	public InvoiceDetailsModel FindByID(InvoiceDetailsModel bean) {
		String sql = "SELECT * FROM INVOICE_DETAILS WHERE INVOICE_DETAILS_ID =" + bean.getInvoice_deteils_id();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		InvoiceDetailsModel invDModel = MappingBeans(querySingle);
		return invDModel;
	}

	@Override
	public InvoiceDetailsModel FindByID(int id) {
		String sql = "SELECT * FROM INVOICE_DETAILS WHERE INVOICE_DETAILS_ID =" + id;
		HashMap<String, Object> querySingle = db.querySingle(sql);
		InvoiceDetailsModel invDModel = MappingBeans(querySingle);
		return invDModel;
	}

	@Override
	public InvoiceDetailsModel MappingBeans(HashMap<String, Object> map) {
		InvoiceDetailsModel invDModel = new InvoiceDetailsModel();
		Database db = new Database();
		InvoiceDAO invDAO = new InvoiceDAO(db);
		InvoiceModel invModel = invDAO.FindByID(Integer.parseInt(map.get("INVOICE_ID").toString()));
		db.close();

		db = new Database();
		StationeriesDAO stnDAO = new StationeriesDAO(db);
		StationeriesModel stnModel = stnDAO.FindByID(Integer.parseInt(map.get("GOODS_ID").toString()));
		db.close();
		
		invDModel.setInvoice_deteils_id(Integer.parseInt(map.get("INVOICE_DETAILS_ID").toString()));
		invDModel.setInvoice_id(invModel);
		invDModel.setGoods_id(stnModel);
		invDModel.setQty(Integer.parseInt(map.get("QTY").toString()));
		invDModel.setAmount(Integer.parseInt(map.get("AMOUNT").toString()));
		invDModel.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		invDModel.setTime_reg(map.get("TIME_REG").toString());
		return invDModel;
		
	}

	
	public ArrayList<InvoiceDetailsModel> FindByInvDID(int id) {
		String sql = "SELECT * FROM INVOICE_DETAILS WHERE INVOICE_ID ="+id;
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<InvoiceDetailsModel> invDList = new ArrayList<InvoiceDetailsModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			InvoiceDetailsModel invD = MappingBeans(next);
			invDList.add(invD);
		}
		return invDList;
	}
	
	public int UpdateStatus(InvoiceDetailsModel bean) {
		
		String sql = "UPDATE INVOICE_DETAILS SET STATUS ='" + bean.getStatus() + "' WHERE INVOICE_DETAILS_ID = "+ bean.getInvoice_deteils_id();
		return db.update(sql);
	}
	public int UpdateStatusByInvoice(InvoiceDetailsModel bean) {
		
		String sql = "UPDATE INVOICE_DETAILS SET STATUS ='" + bean.getStatus() + "' WHERE INVOICE_ID = "+ bean.getInvoice_id().getInvoice_id();
		return db.update(sql);
	}
	
}
