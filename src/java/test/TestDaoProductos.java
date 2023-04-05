/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DaoProductos;
import dao.impl.DaoEspecialidadImpl;
import dao.impl.DaoProductosImpl;
import dao.impl.DaoUsuarioImpl;
import dto.Especialidad;
import dto.Productos;
import dto.Usuario;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UsuariodaoProductos
 */
public class TestDaoProductos {

    public static void main(String[] args) {
        
        DaoEspecialidadImpl dao = new DaoEspecialidadImpl();
        Especialidad ob = new Especialidad();
        
        ob = dao.medicoEspecialidadConsultorio("CARDIOLOGIA");
        System.out.println("nombre del medico" + ob.getNombres_medico());
        
        

            
            
            
           
    }
}
