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
import org.model.beans.SuppliersModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class SuppliersDAO implements DAO<SuppliersModel> {

	Database db;

	public SuppliersDAO(Database db) {
		this.db = db;
	}

	@Override
	public int Add(SuppliersModel bean) {
		String sql = "INSERT INTO SUPPLIERS (SUPPLIERS_ID,NAME,ADDRESS,PHONE,EMAIL) "
				+ "VALUES (SUPPLIERS_SEQ.NEXTVAL,'" + bean.getName() + "','" + bean.getAddress() + "','"
				+ bean.getPhone() + "','" + bean.getEmail() + "')";
		return db.adds(sql, new String[]{"SUPPLIERS_ID"});
	}

	@Override
	public int Delete(SuppliersModel bean) {
		String sql = "DELETE FROM SUPPLIERS WHERE SUPPLIERS_ID =" + bean.getSuppliers_id();
		return db.remove(sql);
	}

	@Override
	public int Update(SuppliersModel bean) {
		String sql = "UPDATE SUPPLIERS SET NAME = '" + bean.getName() + "',ADDRESS = '" + bean.getAddress()
				+ "',PHONE='" + bean.getPhone() + "',EMAIL ='" + bean.getEmail() + "' WHERE SUPPLIERS_ID = '"
				+ bean.getSuppliers_id() + "'";
		return db.update(sql);
	}

	@Override
	public ArrayList<SuppliersModel> FindAll() {
		String sql = "SELECT * FROM SUPPLIERS";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<SuppliersModel> suppList = new ArrayList<SuppliersModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			SuppliersModel spModel = MappingBeans(next);
			suppList.add(spModel);
		}
		return suppList;
	}

	@Override
	public SuppliersModel FindByID(SuppliersModel bean) {
		String sql = "SELECT * FROM SUPPLIERS WHERE SUPPLIERS_ID =" + bean.getSuppliers_id();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		SuppliersModel spModel = MappingBeans(querySingle);
		return spModel;
	}

	@Override
	public SuppliersModel FindByID(int id) {
		String sql = "SELECT * FROM SUPPLIERS WHERE SUPPLIERS_ID =" + id;
		HashMap<String, Object> querySingle = db.querySingle(sql);
		SuppliersModel spModel = MappingBeans(querySingle);
		return spModel;
	}

	@Override
	public SuppliersModel MappingBeans(HashMap<String, Object> map) {
		SuppliersModel supModel = new SuppliersModel();

		supModel.setSuppliers_id(Integer.parseInt(map.get("SUPPLIERS_ID").toString()));
		supModel.setName(map.get("NAME").toString());
		supModel.setAddress(map.get("ADDRESS").toString());
		supModel.setPhone(map.get("PHONE").toString());
		supModel.setEmail(map.get("EMAIL").toString());
		supModel.setTime_reg(map.get("TIME_REG").toString());
		return supModel;
	}

}
