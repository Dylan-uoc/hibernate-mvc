/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.producto4.factory;

import com.producto4.impl.UsuarioDaoImpl;

/**
 *
 * @author rojaw
*/

public class UsuarioDaoFactory {
	
	public UsuarioDaoImpl crearUsuarioDao () {
		return new UsuarioDaoImpl ();
	}

}
