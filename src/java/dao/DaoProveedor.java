package dao;

import dto.Proveedor;
import java.util.List;

public interface DaoProveedor{
    // SELECT (READ)
    List<Proveedor> proveedorSel();    
    // SELECT WHERE (READ)
    Proveedor proveedorGet(Integer id);    
    // INSERT (CREATE)
    String proveedorIns(Proveedor proveedor);    
    // UPDATE (UPDATE)
    String proveedorUpd(Proveedor proveedor);    
    // DELETE (DELETE)
    String proveedorDel(List<Integer> ids);    
    // UTILITARIO
    String getMensaje();
}


