
package dao;

import dto.Detalle_Ventas;
import java.util.ArrayList;


public interface DaoDetalle_Ventas {
    // SELECT (READ)
    ArrayList<Detalle_Ventas> listarDetalleVentaxid(int idventa);

}
