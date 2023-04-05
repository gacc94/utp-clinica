
package dao;

import dto.Detalle_Ventas;
import dto.Usuario;
import dto.Venta;
import dto.misCompras;
import java.util.ArrayList;


public interface DaoVenta {
    //Compra
    public int GenerarCompra(Venta obj);
    public int getIdVenta();
    public int guardarDetalleCompra(Detalle_Ventas dv);
    public ArrayList<misCompras> listarMisCompras(int idcliente);
    public misCompras getVenta(int idventa);
    
    //Admnistrador
    public ArrayList<Venta> listarVentas();
    public boolean ActualizarVenta(Venta venta);
    public Venta listarventaxid(int idventa);
    public boolean ActualizarTelefono(Usuario uid);
    
}
