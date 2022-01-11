package com.producto4.factory;


import com.producto4.impl.SedeDaoImpl;

public class SedeDaoFactory {
    public SedeDaoImpl crearUsuarioDao () {
        return new SedeDaoImpl ();
    }
}
