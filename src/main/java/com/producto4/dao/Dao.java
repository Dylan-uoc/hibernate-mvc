/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.producto4.dao;

/**
 *
 * @author rojaw
 */

import java.util.List;

public interface Dao <T> {
	
	public boolean registrar(T obj) throws Exception;
	public void leer();
	public boolean actualizar(T obj);
	public boolean eliminar(T obj);
	
}
