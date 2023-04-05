package dao.impl;

import dao.DaoMedico;
import dto.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConexionBD;

public class DaoMedicoImpl implements DaoMedico {

    ConexionBD cn = new ConexionBD();
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;
    ArrayList<Medico> lista = null;
    Medico medico = null;

    @Override
    public ArrayList<Medico> listarPorEspecialidad(String nombre_especialidad) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from especialidad e INNER JOIN medico m on e.id_medico = m.id_medico ")
                .append("WHERE E.nombre_especialidad= '" + nombre_especialidad + "'");

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                medico = new Medico();
                //reserva.setNombre_usuario(rs.getString("u.NOMBRE"));
                medico.setId_medico(rs.getString("m.id_medico"));
                medico.setNombres_medico(rs.getString("m.nombres_medico"));
                medico.setApellido_paterno_medico(rs.getString("m.apellido_paterno_medico"));
                medico.setApellido_materno_medico(rs.getString("m.apellido_materno_medico"));
                lista.add(medico);

            }

        } catch (Exception e) {
            System.out.println("Error en el Script");
        }
        return lista;
    }

}
