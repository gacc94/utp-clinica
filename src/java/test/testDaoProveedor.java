package test;

import dao.DaoProveedor;
import dao.impl.DaoProveedorImpl;
import dto.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class testDaoProveedor {

    public static void main(String[] args) {
        /*
        DaoProveedor ds = new DaoProveedorImpl();
        
            List<Proveedor> lista = null;
            try {
                lista = ds.proveedorSel();                 
                lista.forEach(t->{
                    System.out.println(
                    "IDSUBCATEGORIA: "+ t.getIDPROVEEDOR()
                            + "\nRuc: "+t.getRUC()
                            + "\nNombre: "+t.getNOMBREPROVEEDOR()
                            + "\nDireccion: "+t.getDIRECCION()
                            + "\nEmail: "+t.getEMAIL()
                            + "\n*****************************************************************"
                    );
                });
            } catch (Exception e) {
                ds.getMensaje();
            }
         


            Proveedor proveedor = null;
            try {
                proveedor = ds.proveedorGet(1);
                System.out.println("Nombre: "+proveedor.getNOMBREPROVEEDOR());
            } catch (Exception e) {
                ds.getMensaje();
            }

/*
            Proveedor p = new Proveedor();
            p.setRUC("10720139141");
            p.setEMAIL("nino_2509@hotmail.com");
            p.setNOMBREPROVEEDOR("Soluzioni");
            p.setTELEFONO("12389123");
            p.setESTADO("Disponible");
            try {
                ds.proveedorIns(p);
                System.out.println("Fila agregada");
            } catch (Exception e) {
                ds.getMensaje();
            }
*/

/*
            Proveedor p = new Proveedor();
          p.setRUC("10720139141");
            p.setEMAIL("nino_2509@hotmail.com");
            p.setNOMBREPROVEEDOR("Soluzioni");
            p.setTELEFONO("12389123");
            p.setESTADO("Disponible");
            try {
                ds.proveedorUpd(p);
                System.out.println("Fila actualizada");
            } catch (Exception e) {
                ds.getMensaje();
            }
*/      

 
//            List<Integer> l = new ArrayList<>();
//            l.add(3);
//            try {
//                ds.proveedorDel(l);
//                System.out.println("Registros eliminados");
//            } catch (Exception e) {
//                ds.getMensaje();
//            }
//         
    }
}
