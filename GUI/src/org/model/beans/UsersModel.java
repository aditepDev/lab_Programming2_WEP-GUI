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
public class UsersModel {
    private int U_ID;
    private String NAME;
    private String SURNAME;
    private String USERNAME;
    private String PASSWORD;
    private String TIME_REG;
    private int	STATUS;
    public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	/**
     * @return the U_ID
     */
    public int getU_ID() {
        return U_ID;
    }

    /**
     * @param U_ID the U_ID to set
     */
    public void setU_ID(int U_ID) {
        this.U_ID = U_ID;
    }

    /**
     * @return the NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * @param NAME the NAME to set
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * @return the SURNAME
     */
    public String getSURNAME() {
        return SURNAME;
    }

    /**
     * @param SURNAME the SURNAME to set
     */
    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    /**
     * @return the USERNAME
     */
    public String getUSERNAME() {
        return USERNAME;
    }

    /**
     * @param USERNAME the USERNAME to set
     */
    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param PASSWORD the PASSWORD to set
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
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
