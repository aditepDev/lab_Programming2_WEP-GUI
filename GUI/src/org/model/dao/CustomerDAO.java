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
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class CustomerDAO implements DAO<CustomerModel> {

	Database db;

	public CustomerDAO(Database db) {
		this.db = db;
	}

	@Override
	public int Add(CustomerModel bean) {
		String sql = "INSERT INTO CUSTOMER(CUSTOMER_ID,CUS_NAME,PHONE,ADDRESS,EMAIL,USERNAME,PASSWD,STATUS) "
				+ "VALUES (CUSTOMER_SEQ.NEXTVAL,'" + bean.getCusname() + "','" + bean.getPhone() + "','"
				+ bean.getAddress() + "','" + bean.getEmail() + "','" + bean.getUsername() + "','" + bean.getPasswd()
				+ "',0)";
		return db.adds(sql, new String[]{"CUSTOMER_ID"} );
	}

	@Override
	public int Delete(CustomerModel bean) {
		String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID =" + bean.getCustomerId();
		return db.remove(sql);
	}

	@Override
	public int Update(CustomerModel bean) {
		String sql = "UPDATE CUSTOMER SET CUS_NAME = '"+bean.getCusname()+"',ADDRESS = '"+bean.getAddress()+"',PHONE='"+bean.getPhone()+"',EMAIL ='"+bean.getEmail()+"',USERNAME='"+bean.getUsername()+"',PASSWD='"+bean.getPasswd()+"' WHERE CUSTOMER_ID='"+bean.getCustomerId()+"'";
		return db.update(sql);
	}

	@Override
	public ArrayList<CustomerModel> FindAll() {
		String sql = "SELECT * FROM CUSTOMER ORDER BY CUSTOMER_ID ASC";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<CustomerModel> customerList = new ArrayList<CustomerModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			CustomerModel user = MappingBeans(next);
			customerList.add(user);
		}
		return customerList;
	}

	@Override
	public CustomerModel FindByID(CustomerModel bean) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID =" + bean.getCustomerId();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		CustomerModel customerModel = MappingBeans(querySingle);
		return customerModel;
	}

	@Override
	public CustomerModel FindByID(int id) {
		
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID =" + id;
		System.out.println("FindByID 1");
		HashMap<String, Object> querySingle = db.querySingle(sql);
		System.out.println("FindByID 2");
		CustomerModel customerModel = MappingBeans(querySingle);
		System.out.println("FindByID 3");
		return customerModel;
	}

	@Override
	public CustomerModel MappingBeans(HashMap<String, Object> map) {
		
		CustomerModel cusModel = new CustomerModel();
		cusModel.setCustomerId(Integer.parseInt(map.get("CUSTOMER_ID").toString()));
		cusModel.setCusname(map.get("CUS_NAME").toString());
		cusModel.setAddress(map.get("ADDRESS").toString());
		cusModel.setPhone(map.get("PHONE").toString());
		cusModel.setEmail(map.get("EMAIL").toString());
		cusModel.setUsername(map.get("USERNAME").toString());
		cusModel.setPasswd(map.get("PASSWD").toString());
		cusModel.setTime_reg(map.get("TIME_REG").toString());
	//	cusModel.setSTATUS(Integer.parseInt(map.get("STATUS").toString()));
		return cusModel;
	}

	public CustomerModel FindLogin(String username, String password) {
		String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = '" + username + "'AND PASSWD = '" + password + "'";
		HashMap<String, Object> querySingle = db.querySingle(sql);
		CustomerModel customerModel = new CustomerModel();
		if(!querySingle.isEmpty())
		{
			customerModel = MappingBeans(querySingle);
		}
		return customerModel;
	}
}
