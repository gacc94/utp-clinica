
package dao;

import dto.Usuario;
import java.util.ArrayList;


public interface DaoUsuario {
    //  LISTAR
    public ArrayList<Usuario> listar();
    // LISTAR x Id
    public Usuario listarxid(int id);
    //EDITAR
    public boolean editar(Usuario ob);
    //INSERTAR
    public boolean agregar(Usuario ob);
    //ELIMINAR
    public boolean eliminar(int id);
    // UTILITARIO
    String getMensaje();
}
