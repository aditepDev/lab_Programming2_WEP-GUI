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
import org.model.beans.SuppliersModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author Aditep
 */
public class StationeriesDAO implements DAO<StationeriesModel> {

	Database db;

	public StationeriesDAO(Database db) {
		this.db = db;
	}

	@Override
	public int Add(StationeriesModel bean) {
		String sql = "INSERT INTO STATIONERIES (GOODS_ID,GOODS_NAME,DESCRIPT,COLOR) VALUES (GOODS_SEQ.NEXTVAL,'" + bean.getGoods_name() + "','" + bean.getDescript() + "','" + bean.getColor() + "')";
		System.out.println(sql);
		return db.adds(sql, new String[]{"GOODS_ID"});
	}

	@Override
	public int Delete(StationeriesModel bean) {
		String sql = "DELETE FROM STATIONERIES WHERE GOODS_ID =" + bean.getGoods_id();
		return db.remove(sql);
	}

	@Override
	public int Update(StationeriesModel bean) {
		String sql = "UPDATE STATIONERIES SET GOODS_NAME = '" + bean.getGoods_name() + "',DESCRIPT = '"
				+ bean.getDescript() + "',COLOR ='" + bean.getColor() + "' WHERE GOODS_ID ='" + bean.getGoods_id()
				+ "'";
		return db.update(sql);
	}

	@Override
	public ArrayList<StationeriesModel> FindAll() {
		String sql = "SELECT * FROM STATIONERIES ORDER BY GOODS_ID";
		ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
		ArrayList<StationeriesModel> StationeriesList = new ArrayList<StationeriesModel>();
		for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
			HashMap<String, Object> next = iterator.next();
			StationeriesModel stationeriesModel = MappingBeans(next);
			StationeriesList.add(stationeriesModel);
		}
		return StationeriesList;
	}

	@Override
	public StationeriesModel FindByID(StationeriesModel bean) {
		String sql = "SELECT * FROM STATIONERIES WHERE GOODS_ID =" + bean.getGoods_id();
		HashMap<String, Object> querySingle = db.querySingle(sql);
		StationeriesModel stationeriesModel = MappingBeans(querySingle);
		return stationeriesModel;
	}

	@Override
	public StationeriesModel FindByID(int id) {
		String sql = "SELECT * FROM STATIONERIES WHERE GOODS_ID =" + id;
		HashMap<String, Object> querySingle = db.querySingle(sql);
		StationeriesModel stationeriesModel = MappingBeans(querySingle);
		return stationeriesModel;
	}

	@Override
	public StationeriesModel MappingBeans(HashMap<String, Object> map) {
		StationeriesModel stnModel = new StationeriesModel();

		stnModel.setGoods_id(Integer.parseInt(map.get("GOODS_ID").toString()));
		stnModel.setGoods_name(map.get("GOODS_NAME").toString());
		stnModel.setDescript(map.get("DESCRIPT").toString());
		stnModel.setColor(map.get("COLOR").toString());
		stnModel.setTime_reg(map.get("TIME_REG").toString());
		return stnModel;
	}

}
