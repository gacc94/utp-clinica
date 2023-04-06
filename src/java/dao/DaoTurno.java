package dao;

import dto.Turno;
import java.util.ArrayList;

/**
 *
 * @author srf
 */
public interface DaoTurno {
    
    //  LISTAR
    public ArrayList<Turno> listar();
    // LISTAR x Id
    public Turno listarxid(int id);
    //EDITAR
    public boolean editar(Turno ob);
    //INSERTAR
    public boolean agregar(Turno ob);
    //ELIMINAR
    public boolean eliminar(int id);
    // UTILITARIO
    String getMensaje();
    
}
