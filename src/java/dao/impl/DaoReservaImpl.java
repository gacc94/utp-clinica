package dao.impl;

import dao.DaoReserva;
import dto.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConexionBD;

/**
 *
 * @author Jonathan
 */
public class DaoReservaImpl implements DaoReserva {

    ConexionBD cn = new ConexionBD();
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;
    ArrayList<Reserva> lista = null;
    ArrayList<Reserva> listaReservas = null;
    Reserva reserva = null;
    String mensaje = null;

    @Override
    public ArrayList<Reserva> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva listarxpago(String estado_pago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Reserva ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(Reserva ob) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO RESERVACION ")
                .append("(FECHA_CITA, HORA_CITA, ID_MEDICO, ID_ESPECIALIDAD, IDUSUARIO, PRECIO, ID_PAGO, ESTADO, ID_PACIENTE, FECHA_RESERVA) ")
                .append("VALUES(?,?,?,?,?,?,?,?,?,now())");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());

            ps.setString(1, ob.getFecha());
            ps.setString(2, ob.getHora());
            ps.setString(3, ob.getId_medico());
            ps.setString(4, ob.getId_especialidad());
            ps.setString(5, ob.getId_usuario());
            ps.setDouble(6, ob.getPrecio());
            ps.setString(7, "2");
            ps.setString(8, "Pendiente"); 
            System.out.println("id_paciente: " + ob.getId_paciente());
            ps.setString(9, ob.getId_paciente());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en el Script DaoReservaImpl - agregar ");
        }

        return false;
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Reserva> listarxIdCliente(int idCliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u.NOMBRE, u.APELLIDO, e.nombre_especialidad, m.nombres_medico, m.apellido_paterno_medico, m.apellido_materno_medico, r.FECHA_CITA, r.HORA_CITA, r.PRECIO,r.ESTADO, r.FECHA_RESERVA ")
                .append("FROM especialidad e INNER JOIN medico m on e.id_medico = m.id_medico ")
                    .append("INNER JOIN reservacion r on r.ID_MEDICO = m.id_medico ")
                .append("INNER JOIN usuario u on r.IDUSUARIO = u.IDUSUARIO WHERE u.IDUSUARIO=" + idCliente + " ORDER BY r.FECHA_RESERVA DESC");

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            listaReservas = new ArrayList<>();
            while (rs.next()) {
                reserva = new Reserva();
                reserva.setNombre_usuario(rs.getString("u.NOMBRE"));
                reserva.setApellido_usuario(rs.getString("u.APELLIDO"));
                reserva.setNombre_especialidad(rs.getString("e.nombre_especialidad"));
                reserva.setNombre_medico(rs.getString("m.nombres_medico"));
                reserva.setApellidopat_medico(rs.getString("m.apellido_paterno_medico"));
                reserva.setApellidomat_medico(rs.getString("m.apellido_materno_medico"));
                reserva.setFecha(rs.getString("r.FECHA_CITA"));
                reserva.setHora(rs.getString("r.HORA_CITA"));
                reserva.setPrecio(rs.getDouble("r.PRECIO"));
                reserva.setEstado_cita(rs.getString("r.ESTADO"));
                reserva.setFecha_reserva(rs.getDate("r.FECHA_RESERVA"));
                listaReservas.add(reserva);

            }

        } catch (Exception e) {
            System.out.println("Error en el Script");
        }
        return listaReservas;
    }

    @Override
    public Reserva listarxIdUsuario(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
