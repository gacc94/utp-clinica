package dao;

import dto.Especialidad;
import java.util.ArrayList;

public interface DaoEspecialidad {
    
    //  LISTAR
    public ArrayList<Especialidad> listar();

    // LISTAR x Id
    public Especialidad listarxid(int id);

    //EDITAR
    public boolean editar(Especialidad ob);

    //INSERTAR
    public boolean agregar(Especialidad ob);

    //ELIMINAR
    public boolean eliminar(int id);
    
    //Buscar Medico por especialidad
    public Especialidad medicoEspecialidadConsultorio(String especialidad);

    // UTILITARIO
    String getMensaje();
}
