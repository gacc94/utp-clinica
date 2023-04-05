package test;

import dao.DaoSubcategoria;
import dao.impl.DaoSubcategoriaImpl;
import dto.Subcategoria;
import java.util.ArrayList;
import java.util.List;

public class testDaoSubcategoria {

    public static void main(String[] args) {
        DaoSubcategoria ds = new DaoSubcategoriaImpl();
        /*
            List<Subcategoria> lista = null;
            try {
                lista = ds.subcategoriaSel();                 
                lista.forEach(t->{
                    System.out.println(
                    "IDSUBCATEGORIA: "+ t.getIDSUBCATEGORIA()
                            + "\nIDCATEGORIA: "+t.getIDCATEGORIA()
                            + "\nNOMBRESUBCATEGORIA: "+t.getNOMBRESUBCATEGORIA()
                            + "\nDESCRIPCIONSUBCATEGORIA: "+t.getDESCRIPCIONSUBCATEGORIA()
                            + "\nESTADOSUBCAT: "+t.getESTADOSUBCAT()
                            + "\n*****************************************************************"
                    );
                });
            } catch (Exception e) {
                ds.getMensaje();
            }
         */

/*
            Subcategoria subcategoria = null;
            try {
                subcategoria = ds.subcategoriaGet(1);
                System.out.println("Nombre: "+subcategoria.getNOMBRESUBCATEGORIA());
            } catch (Exception e) {
                ds.getMensaje();
            }
*/
/*
            Subcategoria s = new Subcategoria();
            s.setIDSUBCATEGORIA(3);
            s.setIDCATEGORIA(1);
            s.setNOMBRESUBCATEGORIA("Hola");
            s.setDESCRIPCIONSUBCATEGORIA("holaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            s.setESTADOSUBCAT("Disponible");
            try {
                ds.subcategoriaIns(s);
                System.out.println("Fila agregada");
            } catch (Exception e) {
                ds.getMensaje();
            }
*/

/*
            Subcategoria s = new Subcategoria();
            s.setIDSUBCATEGORIA(3);
            s.setIDCATEGORIA(2);
            s.setNOMBRESUBCATEGORIA("Leonardo");
            s.setDESCRIPCIONSUBCATEGORIA("Leonardooooooooooooooooo");
            s.setESTADOSUBCAT("Agotado");
            try {
                ds.subcategoriaUpd(s);
                System.out.println("Fila actualizada");
            } catch (Exception e) {
                ds.getMensaje();
            }
*/      

 
            List<Integer> l = new ArrayList<>();
            l.add(3);
            try {
                ds.subcategoriaDel(l);
                System.out.println("Registros eliminados");
            } catch (Exception e) {
                ds.getMensaje();
            }
         
    }
}
