
package dao;


import dto.ProductoVenta;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

public interface DaoProductoVenta {
    public ArrayList<ProductoVenta> listar();
    // LISTAR x Id
    public ProductoVenta listarxid(int id);
    
    public void listarImg(int id, HttpServletResponse response);
}
