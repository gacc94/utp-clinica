package test;

import dao.impl.DaoMedicoImpl;
import dao.impl.DaoPacienteImpl;
import dao.impl.DaoReservaImpl;
import dao.impl.DaoUsuarioRegistroImpl;
import dto.Medico;
import dto.Paciente;
import dto.Reserva;
import dto.Usuario;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {

        String nombre = "Jonathan";
        String apellido = "Paniagua";
        String tipodocumento = "dni";
        String dni = "70030602";
        String password = "70030602";
        String correo = "jpani@gmail.com";
        String telefono = "983514699";
        String id_paciente = "CODPA" + dni;

        DaoPacienteImpl dao1 = new DaoPacienteImpl();
        DaoUsuarioRegistroImpl dao2 = new DaoUsuarioRegistroImpl();

        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setTipo_documento(tipodocumento);
        user.setDni(dni);
        user.setPassword(password);
        user.setEmail(correo);
        user.setTelefono(telefono);
        user.setId_paciente(id_paciente);

        //Paciente
        Paciente paciente = new Paciente();
        paciente.setId_paciente(id_paciente);
        paciente.setNombre(nombre);
        paciente.setApe_paterno(apellido);
        paciente.setDni(dni);
        paciente.setEmail(correo);
        paciente.setTelefono(telefono);

        dao1.agregar(paciente);
        dao2.agregarUsuarioRegistro(user);

    }
}
