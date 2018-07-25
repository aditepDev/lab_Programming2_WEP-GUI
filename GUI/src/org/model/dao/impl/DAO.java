/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author PoN
 */
public interface DAO<T> {
    int Add(T bean); 
    int Delete(T bean); 
    int Update(T bean); 
    ArrayList<T> FindAll();
    T FindByID(T bean);
    T FindByID(int id);
    T MappingBeans(HashMap<String, Object> map);
}
