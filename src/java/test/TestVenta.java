package test;

import dao.impl.DaoDetalle_VentasImpl;
import dao.impl.DaoVentaImpl;
import dto.*;
import java.util.ArrayList;

public class TestVenta {

    public static void main(String[] args) {
        DaoVentaImpl dao = new DaoVentaImpl();
//        Venta v = new Venta();
//        v.setIdCliente(31);
//        v.setMonto(35.5);
//        v.setTipoComprobante("Factura");
//        v.setEstado("Entregado");
//        v.setIdPago(1);
//        int r = dao.GenerarCompra(v);
//        if (r==1) {
//            System.out.println("Exito");
//        }else{
//            System.out.println("Error");
//        }

        //DETALLE VENTA
//        Detalle_Ventas dv = new Detalle_Ventas();
//        dv.setIdVenta(10002);
//        dv.setIdProducto(1);
//        dv.setCantidad(3);
//        dv.setPrecio_venta(34.5);
//        
//        int r = dao.guardarDetalleCompra(dv);
//        if (r==1) {
//            System.out.println("Exito");
//        }else{
//            System.out.println("Error");
//        }
//        ArrayList<misCompras> lista = new ArrayList<>();
//        lista = dao.listarMisCompras(30);
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i).getIdventa());
//        }


        misCompras ob = new misCompras();
        DaoVentaImpl dvdao = new DaoVentaImpl();
        ob = dvdao.getVenta(10001);
   
            System.out.println(ob.getIdventa());


    }

}
