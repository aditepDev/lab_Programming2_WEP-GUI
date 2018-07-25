/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author PoN
 */
public class Database {

    public Connection conn;

    public Database() {
      //  System.out.println("------ Oracle JDBC Connection ------");
      //  System.out.println("Oracle JDBC Driver Registered!");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.30.2.50:1521:prog2", "60011270017", "60011270017");
          //  if (conn != null) {
         //       System.out.println("You made it, take control your database now!");
        //    } else {
        //.out.println("Failed to make connection!");
       //     }
      //      System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
        }
    }

    public boolean close() {
        try {
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean commit() {
        try {
            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean rollback() {
        try {
            conn.rollback();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int add(String sql) {
        int lastId = -1;
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                lastId = stmt.executeUpdate(sql);
                stmt.close();
            }
            return lastId;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lastId;
    }
    
    public int adds(String sql ,String[] param) {
        int lastId = -1;
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql, param);
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs != null && rs.next()){
                	lastId = rs.getInt(1);
                }
                rs.close();
                stmt.close();
            }
            return lastId;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lastId;
    }
    public int update(String sql) {
        int lastId = -1;
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                lastId = stmt.executeUpdate(sql);
                stmt.close();
            }
            return lastId;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lastId;
    }

    public int remove(String sql) {
        int lastId = -1;
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                lastId = stmt.executeUpdate(sql);
                stmt.close();
            }
            return lastId;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lastId;
    }

    public HashMap<String, Object> querySingle(String sql) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ResultSetMetaData rsMetaData = rs.getMetaData();
                if (rs.isBeforeFirst()) {
                    while (rs.next()) {
                        for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
                            map.put(rsMetaData.getColumnName(i + 1), rs.getString(i + 1));
                        }
                        return map;
                    }
                }
                rs.close();
                stmt.close();
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ;
        }
        return map;
    }

    public ArrayList<HashMap<String, Object>> queryList(String sql) {
        ArrayList<HashMap<String, Object>> mapList = new ArrayList<HashMap<String, Object>>();
        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ResultSetMetaData rsMetaData = rs.getMetaData();
                if (rs.isBeforeFirst()) {
                    while (rs.next()) {
                        HashMap<String, Object> map = new HashMap<String, Object>();
                        for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
                            map.put(rsMetaData.getColumnName(i + 1), rs.getString(i + 1));
                        }
                        mapList.add(map);
                    }
                    return mapList;
                }
                rs.close();
                stmt.close();               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ;
        }
        return mapList;
    }
}
