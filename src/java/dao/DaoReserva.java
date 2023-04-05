package dao;

import dto.Reserva;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public interface DaoReserva {

    //  LISTAR
    public ArrayList<Reserva> listar();

    //  LISTAR
    public ArrayList<Reserva> listarxIdCliente(int idCliente);

    // LISTAR x Id
    public Reserva listarxIdUsuario(int idUsuario);

    // LISTAR x Id
    public Reserva listarxpago(String estado_pago);

    //EDITAR
    public boolean editar(Reserva ob);

    //INSERTAR
    public boolean agregar(Reserva ob);

    //ELIMINAR
    public boolean eliminar(int id);

    // UTILITARIO
    String getMensaje();

}
