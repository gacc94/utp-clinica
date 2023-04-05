
package dao;

import dto.Categoria;
import dto.Productos;
import dto.Subcategoria;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public interface DaoProductos {
    // SELECT (READ)
    public ArrayList<Productos> listarProductos();    
    // SELECT WHERE (READ)
    public Productos getProductosxID(int id);
    // INSERT (CREATE)
    public String ProductosIns(Productos producto);
    // UPDATE (UPDATE)
    public String ProductosUpd(Productos producto);
    // UPDATE (UPDATE)
    public String ProductosUpdSinImagen(Productos producto);
    // DELETE (DELETE)
    public String ProductosDel(int id);
    // LISTAR CATEGORIAS
    public ArrayList<Categoria> CatCbo();
    // LISTAR SUBCATEGORIAS
    public ArrayList<Subcategoria> SubCatCbo(int idcategoria);
    //Buscar codigo existente
    public String buscarCodigo(String codigo);
}
