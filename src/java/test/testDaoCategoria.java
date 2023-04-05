package test;

import dao.DaoCategoria;
import dao.impl.DaoCategoriaImpl;
import dto.Categoria;
import java.util.ArrayList;
import java.util.List;

public class testDaoCategoria {

    public static void main(String[] args) {
        
        DaoCategoriaImpl dao = new DaoCategoriaImpl();
        Categoria ob = new Categoria();
        ob = dao.categoriaGet(1);
        
            System.out.println(ob.getNOMBRE());
   
//        DaoCategoria ds = new DaoCategoriaImpl();
//        
//            List<Categoria> lista = null;
//            try {
//                lista = ds.categoriaSel();                 
//                lista.forEach(t->{
//                    System.out.println(
//                    "IDCATEGORIA: "+ t.getIDCATEGORIA()
//                            + "\nNOMBRE: "+t.getNOMBRE()
//                            + "\nDESCRIPCION: "+t.getDESCRIPCION()
//                            + "\nESTADOCAT: "+t.getESTADOCAT()
//                            + "\n*****************************************************************"
//                    );
//                });
//            } catch (Exception e) {
//                ds.getMensaje();
//            }
      

/*
            Categoria categoria = null;
            try {
                categoria = ds.categoriaGet(2);
                System.out.println("Nombre: "+categoria.getNOMBRE());
            } catch (Exception e) {
                ds.getMensaje();
            }
*/

/*
            Categoria s = new Categoria();
            s.setIDCATEGORIA(45);
            s.setNOMBRE("Hola");
            s.setDESCRIPCION("holaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            s.setESTADOCAT("Disponible");
            try {
                ds.categoriaIns(s);
                System.out.println("Fila agregada");
            } catch (Exception e) {
                ds.getMensaje();
            }
*/

/*
            Categoria s = new Categoria();
            s.setIDCATEGORIA(10);
            s.setNOMBRE("Leonardo");
            s.setDESCRIPCION("Leonardooooooooooooooooo");
            s.setESTADOCAT("Agotado");
            try {
                ds.categoriaUpd(s);
                System.out.println("Fila actualizada");
            } catch (Exception e) {
                ds.getMensaje();
            }
*/      

/*
            List<Integer> l = new ArrayList<>();
            l.add(10);
            try {
                ds.categoriaDel(l);
                System.out.println("Registros eliminados");
            } catch (Exception e) {
                ds.getMensaje();
            }
*/
    }
}
