package dao.impl;

import dto.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConexionBD;

/**
 *
 * @author srf
 */
public class DaoTurnoImpl {
   
    Turno ob = null;
    ArrayList<Turno> lista = null;
    ConexionBD cn = new ConexionBD();

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private String mensaje;
    
    
    public ArrayList<Turno> listar() {
        String sql = "SELECT * FROM turnos";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                ob = new Turno();
                ob.setIdturno(rs.getInt("idTurno"));
                ob.setFecha(rs.getString("fecha"));
                ob.setHora(rs.getString("hora"));
                ob.setEspecialidad(rs.getString("especialidad"));
                ob.setMedico(rs.getString("medico")); 
                ob.setDisponible(rs.getString("disponible"));
                lista.add(ob);
            }

        } catch (Exception e) {
        }

        return lista;
    }
}
