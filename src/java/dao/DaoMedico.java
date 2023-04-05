
package dao;

import dto.Medico;
import java.util.ArrayList;

public interface DaoMedico {
        // Listar
    public ArrayList<Medico> listarPorEspecialidad(String nombre_especialidad);
}
