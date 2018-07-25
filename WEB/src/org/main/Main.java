/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.main;

import java.util.ArrayList;
import java.util.Iterator;
import org.model.beans.UsersLogsModel;
import org.model.beans.UsersModel;
import org.model.dao.UsersDAO;
import org.model.dao.UsersLogsDAO;
import org.model.db.Database;

/**
 *
 * @author PoN
 */
public class Main {

    public static void main(String[] args) {

        /*
        -Please uncomment function
        -Test fucntion
        -You can add menu to any function
         */
        Main m = new Main();
        
        //insert
        m.InsertEx();
        
        //select all
        m.SelectEx0();
        
        //select by ID (int)
        m.SelectEx1();
        
        //select by ID (bean)
        m.SelectEx2();
        
        //update
        m.UpdateEx();
        
        //delete
        m.DeleteEx();
        
        //select USERS_LOGS table none join in this table, but we use DAO concept.
        m.SelectNonJoinTable();
    }

    public void InsertEx() {
        Database db = new Database();
        try {
            UsersDAO uDAO = new UsersDAO(db);
            UsersModel uModel = new UsersModel();
            uModel.setNAME("Panich");
            uModel.setSURNAME("Sudkhot");
            uModel.setUSERNAME("panichpon");
            uModel.setPASSWORD("1234");

            uDAO.Add(uModel);
            db.commit();
            db.close();
        } catch (Exception e) {
            db.rollback();
            db.close();
        }
    }

    public void SelectEx0() {
        Database db = new Database();
        try {
            UsersDAO uDAO = new UsersDAO(db);
            ArrayList<UsersModel> usersList = uDAO.FindAll();
            db.close();
            for (Iterator<UsersModel> iterator = usersList.iterator(); iterator.hasNext();) {
                UsersModel next = iterator.next();
                System.out.println(next.getU_ID() + ", " + next.getNAME() + ", " + next.getSURNAME() + ", " + next.getUSERNAME() + ", " + next.getPASSWORD() + ", " + next.getTIME_REG());
            }
        } catch (Exception e) {
            //db.rollback();
            db.close();
        }
    }

    public void SelectEx1() {
        Database db = new Database();
        try {
            UsersDAO uDAO = new UsersDAO(db);
            UsersModel uModel = new UsersModel();
            //set id data
            uModel.setU_ID(1);
            UsersModel user1 = uDAO.FindByID(uModel);
            System.out.println(user1.getU_ID() + ", " + user1.getNAME() + ", " + user1.getSURNAME() + ", " + user1.getUSERNAME() + ", " + user1.getPASSWORD() + ", " + user1.getTIME_REG());
            db.close();
        } catch (Exception e) {
            //db.rollback();
            db.close();
        }
    }

    public void SelectEx2() {
        Database db = new Database();
        try {
            UsersDAO uDAO = new UsersDAO(db);
            //set id data
            UsersModel user2 = uDAO.FindByID(1);
            System.out.println(user2.getU_ID() + ", " + user2.getNAME() + ", " + user2.getSURNAME() + ", " + user2.getUSERNAME() + ", " + user2.getPASSWORD() + ", " + user2.getTIME_REG());
            db.close();
        } catch (Exception e) {
            //db.rollback();
            db.close();
        }
    }

    public void UpdateEx() {
        Database db = new Database();
        try {
            UsersDAO uDAO = new UsersDAO(db);
            UsersModel uModelUpdate = new UsersModel();
            uModelUpdate.setU_ID(1);
            uModelUpdate.setNAME("Panich1");
            uModelUpdate.setSURNAME("Sudkhot2");
            uModelUpdate.setUSERNAME("panichpon");
            uModelUpdate.setPASSWORD("12345");

            uDAO.Update(uModelUpdate);
            db.commit();
            db.close();
        } catch (Exception e) {
            db.rollback();
            db.close();
        }
    }

    public void DeleteEx() {
        Database db = new Database();
        try {
            UsersDAO uDAO = new UsersDAO(db);
            UsersModel uModelDelete = new UsersModel();
            uModelDelete.setU_ID(10);
            uDAO.Delete(uModelDelete);
            db.commit();
            db.close();
        } catch (Exception e) {
            db.rollback();
            db.close();
        }
    }

    public void SelectNonJoinTable() {
        Database db = new Database();
        try {
            UsersLogsDAO uLDAO = new UsersLogsDAO(db);
            ArrayList<UsersLogsModel> usersLogsList = uLDAO.FindAll();
            db.close();
            for (Iterator<UsersLogsModel> iterator = usersLogsList.iterator(); iterator.hasNext();) {
                UsersLogsModel next = iterator.next();
                System.out.println(next.getUL_ID() + ", " + next.getUSERS().getU_ID() + ", " + next.getUSERS().getNAME() + ", " + next.getUSERS().getSURNAME() + ", " + next.getUSERS().getUSERNAME() + ", " + next.getUSERS().getPASSWORD() + ", " + next.getUSERS().getTIME_REG());
            }
        } catch (Exception e) {
            //db.rollback();
            db.close();
        }
    }

}
