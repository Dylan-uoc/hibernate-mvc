package com.producto4.factory;

import com.producto4.impl.ProyectoDaoImpl;

public class ProyectoDaoFactory {
    public ProyectoDaoImpl crearUsuarioDao () {
        return new ProyectoDaoImpl ();
    }

}
