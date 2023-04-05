/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.impl.daoRolimpl;
import dto.Rol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class testRol {

    public static void main(String[] args) {
        daoRolimpl roles = new daoRolimpl();
      
        List<Rol> lista = null;
        try {
            lista = roles.rolSel();
            lista.forEach(t->{
               System.out.println(
               "ID: "+ t.getIDROL()+ "\nNombre: "+t.getNOMBREROL()+"\nDescripcion: "+t.getDESCRIPCION()
                 
                );
            });
        } catch (Exception e) {
            roles.getMensaje();
        }
        

 /*

 /*
        Rol r = new Rol();
        r.setNOMBREROL("prueba1");
        r.setDESCRIPCION("prueba2");
        
        try {
            roles.rolIns(r);
            System.out.println("Fila agregada");
        } catch (Exception e) {
            roles.getMensaje();
        }
       
  */
  /*
        Rol r = new Rol();
        r.setNOMBREROL("prueba1");
        r.setDESCRIPCION("prueba2");
     
        try {
            roles.rolUpd(r);
            System.out.println("Fila actualizada");
        } catch (Exception e) {
            roles.getMensaje();
        }
       
  */
    /*

        List<Integer> l = new ArrayList<>();
        l.add(2);
        try {
            roles.rolDel(l);
            System.out.println("Registros eliminados");
        } catch (Exception e) {
            roles.getMensaje();
        }
       */
    }
}
