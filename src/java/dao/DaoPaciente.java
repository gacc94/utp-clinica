
package dao;


import dto.Paciente;
import java.util.ArrayList;


public interface DaoPaciente {
     //  LISTAR
    public ArrayList<Paciente> listar();

    //  LISTAR
    public ArrayList<Paciente> listarxIdCliente(int idPaciente);

    // LISTAR x Id
    public Paciente listarxIdUsuario(int idUsuario);

    // LISTAR x Id
    public Paciente listarxpago(String estado_pago);

    //EDITAR
    public boolean editar(Paciente ob);

    //INSERTAR
    public boolean agregar(Paciente ob);

    //ELIMINAR
    public boolean eliminar(int id);
}
