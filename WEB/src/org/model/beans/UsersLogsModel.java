/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.beans;

/**
 *
 * @author PoN
 */
public class UsersLogsModel {
    private int UL_ID;
    private UsersModel USERS;
    private String TIME_REG;

    /**
     * @return the UL_ID
     */
    public int getUL_ID() {
        return UL_ID;
    }

    /**
     * @param UL_ID the UL_ID to set
     */
    public void setUL_ID(int UL_ID) {
        this.UL_ID = UL_ID;
    }

    /**
     * @return the USERS
     */
    public UsersModel getUSERS() {
        return USERS;
    }

    /**
     * @param USERS the USERS to set
     */
    public void setUSERS(UsersModel USERS) {
        this.USERS = USERS;
    }

    /**
     * @return the TIME_REG
     */
    public String getTIME_REG() {
        return TIME_REG;
    }

    /**
     * @param TIME_REG the TIME_REG to set
     */
    public void setTIME_REG(String TIME_REG) {
        this.TIME_REG = TIME_REG;
    }
}
