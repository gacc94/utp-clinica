package dao.impl;

import dao.DaoEspecialidad;
import dto.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConexionBD;

public class DaoEspecialidadImpl implements DaoEspecialidad {

    Connection con;
    ConexionBD cn = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public ArrayList<Especialidad> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Especialidad listarxid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Especialidad ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(Especialidad ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Especialidad medicoEspecialidadConsultorio(String especialidad) {
        Especialidad ob = new Especialidad(); //se crea fuera del try sino no retorna pv
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT "
                + "E.nombre_especialidad, "
                + "E.id_especialidad, "
                + "E.precio, "
                + "M.id_medico, "
                + "M.nombres_medico, "
                + "M.apellido_paterno_medico, "
                + "M.apellido_materno_medico, "
                + "C.nombre_consultorio "
                + "FROM medico M INNER JOIN especialidad E ON E.id_medico=M.id_medico "
                + "INNER JOIN consultorio C ON C.id_medico = M.id_medico WHERE E.nombre_especialidad= '" + especialidad + "'");

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if(rs.next()) {
                ob.setCodigo_medico(rs.getString("id_medico"));
                ob.setId_especialidad(rs.getString("id_especialidad"));
                ob.setNombre_especialidad(rs.getString("nombre_especialidad"));
                ob.setPrecio(rs.getDouble("precio"));
                ob.setNombres_medico(rs.getString("nombres_medico"));
                ob.setApellido_paterno_medico(rs.getString("apellido_paterno_medico"));
                ob.setApellido_materno_medico(rs.getString("apellido_materno_medico"));
                ob.setNombre_consultorio(rs.getString("nombre_consultorio"));
  
            }

        } catch (Exception e) {
            System.out.println("Error en el Script o no recibe todos los parametros");
        }
        return ob;
    }

    @Override
    public String getMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
