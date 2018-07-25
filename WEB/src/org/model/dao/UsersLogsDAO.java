/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.model.beans.UsersLogsModel;
import org.model.beans.UsersModel;
import org.model.dao.impl.DAO;
import org.model.db.Database;

/**
 *
 * @author PoN
 */
public class UsersLogsDAO implements DAO<UsersLogsModel> {

    public Database db;

    public UsersLogsDAO(Database db) {
        this.db = db;
    }

    @Override
    public int Add(UsersLogsModel bean) {
        String sql = "INSERT INTO USERS_LOGS (UL_ID, U_ID) VALUES(USERS_LOGS_SEQ.NEXTVAL , " + bean.getUSERS().getU_ID() + ")";
        return db.add(sql);
    }

    @Override
    public int Delete(UsersLogsModel bean) {
        String sql = "DELETE FROM USERS_LOGS WHERE UL_ID = " + bean.getUL_ID();
        return db.remove(sql);
    }

    @Override
    public int Update(UsersLogsModel bean) {
        String sql = "UPDATE USERS_LOGS SET U_ID = " + bean.getUSERS().getU_ID() + " WHERE UL_ID = " + bean.getUL_ID();
        return db.update(sql);
    }

    @Override
    public ArrayList<UsersLogsModel> FindAll() {
        String sql = "SELECT * FROM USERS_LOGS ORDER BY UL_ID ASC";
        ArrayList<HashMap<String, Object>> queryList = db.queryList(sql);
        ArrayList<UsersLogsModel> usersLogsList = new ArrayList<UsersLogsModel>();
        for (Iterator<HashMap<String, Object>> iterator = queryList.iterator(); iterator.hasNext();) {
            HashMap<String, Object> next = iterator.next();
            UsersLogsModel user = MappingBeans(next);
            usersLogsList.add(user);
        }
        return usersLogsList;
    }

    @Override
    public UsersLogsModel FindByID(UsersLogsModel bean) {
        String sql = "SELECT * FROM USERS_LOGS WHERE UL_ID = " + bean.getUL_ID();
        HashMap<String, Object> querySingle = db.querySingle(sql);
        UsersLogsModel uModel = MappingBeans(querySingle);
        return uModel;
    }

    @Override
    public UsersLogsModel FindByID(int id) {
        String sql = "SELECT * FROM USERS_LOGS WHERE UL_ID = " + id;
        HashMap<String, Object> querySingle = db.querySingle(sql);
        UsersLogsModel uModel = MappingBeans(querySingle);
        return uModel;
    }

    @Override
    public UsersLogsModel MappingBeans(HashMap<String, Object> map) {
        Database db = new Database();
        UsersDAO uDAO = new UsersDAO(db);
        UsersModel uModel = uDAO.FindByID(Integer.parseInt(map.get("U_ID").toString()));
        db.close();
        
        UsersLogsModel uULModel = new UsersLogsModel();
        uULModel.setUL_ID(Integer.parseInt(map.get("UL_ID").toString()));
        uULModel.setUSERS(uModel);
        uULModel.setTIME_REG(map.get("TIME_REG").toString());
        
        return uULModel;
    }

}
