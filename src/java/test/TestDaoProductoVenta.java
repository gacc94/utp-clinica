package test;

import dao.impl.DaoProductoVentaImpl;
import dto.ProductoVenta;
import java.util.ArrayList;
import java.util.Iterator;

public class TestDaoProductoVenta {

    public static void main(String[] args) {
        DaoProductoVentaImpl pvdao = new DaoProductoVentaImpl();
        ArrayList<ProductoVenta> lista = new ArrayList<>();
        lista = pvdao.listar();
        // Declaramos el Iterador e imprimimos los Elementos del ArrayList
        Iterator<ProductoVenta> nombreIterator = lista.iterator();
        while (nombreIterator.hasNext()) {
            ProductoVenta elemento = nombreIterator.next();
            System.out.print(elemento.getDescripcion() + " / ");
        }
    }
}
