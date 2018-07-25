/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.model.beans.UsersModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author PoN
 */
public class UsersDAO implements DAO<UsersModel> {

    Database db;

    public UsersDAO(Database db) {
        this.db = db;
    }

    @Override
    public int Add(UsersModel bean) {
        String sql = "INSERT INTO USERS (U_ID, NAME, SURNAME, USERNAME, PASSWORD, STATUS) VALUES(USERS_SEQ.NEXTVAL , '" + bean.getNAME() + "', '" + bean.getSURNAME() + "', '" + bean.getUSERNAME() + "', '" + bean.getPASSWORD() + "',0)";
        return db.add(sql);
    }

    @Override
    public int Delete(UsersModel bean) {
        String sql = "DELETE FROM USERS WHERE U_ID = " + bean.getU_ID();
        return db.remove(sql);
    }

    @Override
    public int Update(UsersModel bean) {
        String sql = "UPDATE USERS SET NAME = '" + bean.getNAME() + "', SURNAME = '" + bean.getSURNAME() + "', USERNAME = '" + bean.getUSERNAME() + "', PASSWORD = '" + bean.getPASSWORD() + "' WHERE U_ID = " + bean.getU_ID();
        return db.update(sql);
    }

    @Override
    public ArrayList<UsersModel> FindAll() {
        String sql = "SELECT * FROM USERS ORDER BY U_ID ASC";
        ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
        ArrayList<UsersModel> usersList = new ArrayList<UsersModel>();
        for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
            HashMap<String, Object> next = iterator.next();
            UsersModel user = MappingBeans(next);
            usersList.add(user);
        }
        return usersList;
    }

    @Override
    public UsersModel FindByID(UsersModel bean) {
        String sql = "SELECT * FROM USERS WHERE U_ID = " + bean.getU_ID();
        HashMap<String, Object> querySingle = db.querySingle(sql);
        UsersModel uModel = MappingBeans(querySingle);
        return uModel;
    }

    @Override
    public UsersModel FindByID(int id) {
        String sql = "SELECT * FROM USERS WHERE U_ID = " + id;
        HashMap<String, Object> querySingle = db.querySingle(sql);
        UsersModel uModel = MappingBeans(querySingle);
        return uModel;
    }

    @Override
    public UsersModel MappingBeans(HashMap<String, Object> map) {
        UsersModel uModel = new UsersModel();
        uModel.setU_ID(Integer.parseInt(map.get("U_ID").toString()));
        uModel.setNAME(map.get("NAME").toString());
        uModel.setSURNAME(map.get("SURNAME").toString());
        uModel.setUSERNAME(map.get("USERNAME").toString());
        uModel.setPASSWORD(map.get("PASSWORD").toString());
        uModel.setTIME_REG(map.get("TIME_REG").toString());
        return uModel;
    }

}
