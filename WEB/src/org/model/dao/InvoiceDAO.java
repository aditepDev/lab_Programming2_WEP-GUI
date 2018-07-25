/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.model.beans.InvoiceModel;
import org.model.beans.SupplierGoodModel;
import org.model.beans.SuppliersModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class InvoiceDAO implements DAO<InvoiceModel> {
	Database db;

	public InvoiceDAO(Database db) {
		this.db = db;
	}

	@Override
	public int Add(InvoiceModel bean) {
		String sql = "INSERT INTO INVOICE (INVOICE_ID,SUPPLIERS_ID,INV_DATE,TOTAL,STATUS) "
				+ "VALUES (INVOICE_SEQ.NEXTVAL,'" + bean.getSuppliers_id().getSuppliers_id() + "','"
				+ bean.getInv_date() + "','" + bean.getTotal() + "','" + bean.getStatus() + "')";
		return db.add(sql);
	}

	@Override
	public int Delete(InvoiceModel bean) {
		String sql = "DELETE FROM INVOICE WHERE INVOICE_ID =" + bean.getInvoice_id();
		return db.remove(sql);
	}

	@Override
	public int Update(InvoiceModel bean) {
		String sql = "UPDATE INVOICE SET SUPPLIERS_ID = '" + bean.getSuppliers_id().getSuppliers_id() + "',INV_DATE = '"
				+ bean.getInv_date() + "',TOTAL='" + bean.getTotal() + "',STATUS= '" + bean.getStatus()
				+ "' WHERE INVOICE_ID ='" + bean.getInvoice_id() + "'";
		return db.update(sql);
	}

	@Override
	public ArrayList<InvoiceModel> FindAll() {
		String sql = "SELECT * FROM  INVOICE";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<InvoiceModel> invList = new ArrayList<InvoiceModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			InvoiceModel invModel = MappingBeans(next);
			invList.add(invModel);

		}
		return invList;
	}

	@Override
	public InvoiceModel FindByID(InvoiceModel bean) {
		String sql = "SELECT * FROM INVOICE WHERE INVOICE_ID =" + bean.getInvoice_id();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		InvoiceModel invModel = MappingBeans(querySingle);
		return invModel;
	}

	@Override
	public InvoiceModel FindByID(int id) {
		String sql = "SELECT * FROM INVOICE WHERE INVOICE_ID =" + id;
		HashMap<String, Object> querySingle = db.querySingle(sql);
		InvoiceModel invModel = MappingBeans(querySingle);
		return invModel;
	}

	@Override
	public InvoiceModel MappingBeans(HashMap<String, Object> map) {
		InvoiceModel invModel = new InvoiceModel();
		Database db = new Database();
		SuppliersDAO supDAO = new SuppliersDAO(db);
		SuppliersModel supModel = supDAO.FindByID(Integer.parseInt(map.get("SUPPLIERS_ID").toString()));
		db.close();
		invModel.setInvoice_id(Integer.parseInt(map.get("INVOICE_ID").toString()));
		invModel.setSuppliers_id(supModel);
		invModel.setInv_date(map.get("INV_DATE").toString());
		invModel.setTotal(Integer.parseInt(map.get("TOTAL").toString()));
		invModel.setStatus(Integer.parseInt(map.get("STATUS").toString()));
		invModel.setTime_reg(map.get("TIME_REG").toString());

		return invModel;

	}
	public ArrayList<InvoiceModel> FindByInvoiceID(int id) {
		String sql = "SELECT * FROM  INVOICE WHERE INVOICE_ID ="+id;
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<InvoiceModel> invList = new ArrayList<InvoiceModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			InvoiceModel invModel = MappingBeans(next);
			invList.add(invModel);

		}
		return invList;
	}
}
