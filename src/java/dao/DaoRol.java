/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Rol;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface DaoRol {
    // SELECT (READ)
    List<Rol> rolSel();    
    // SELECT WHERE (READ)
    Rol rolGet(Integer id);    
    // INSERT (CREATE)
    String rolIns(Rol rol);    
    // UPDATE (UPDATE)
    String rolUpd(Rol rol);    
    // DELETE (DELETE)
    String rolDel(List<Integer> ids);    
    // UTILITARIO
    String getMensaje();
    
}
