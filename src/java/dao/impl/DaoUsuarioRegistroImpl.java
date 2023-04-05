package dao.impl;

import dao.DaoUsuarioRegistro;
import dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConexionBD;

public class DaoUsuarioRegistroImpl implements DaoUsuarioRegistro {

    ConexionBD cn = new ConexionBD();

    Connection con = null; //import java.sql.Connection
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public boolean agregarUsuarioRegistro(Usuario ob) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USUARIO ")
                .append("(IDROL, NOMBRE, APELLIDO, TIPO_DOCUMENTO, NUM_DOCUMENTO, TELEFONO, EMAIL, CONTRASENA, FECHA_CREACION, ESTADO, ID_PACIENTE) ")
                .append("VALUES(2,?,?,?,?,?,?,AES_ENCRYPT(?,'clave'),now(),'Activo',?)");

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, ob.getNombre());
            ps.setString(2, ob.getApellido());
            ps.setString(3, ob.getTipo_documento());
            ps.setString(4, ob.getDni());
            ps.setString(5, ob.getTelefono());
            ps.setString(6, ob.getEmail());
            ps.setString(7, ob.getPassword());
            ps.setString(8, ob.getId_paciente());
            ps.executeUpdate();
            System.out.println("Agregado con exito!");
        } catch (Exception e) {
            System.out.println("Error en el Script agregarUsuarioRegistro!");
        }
        return false;
    }

    @Override
    public Usuario usuarioLogin(String correo, String clave) {
        Usuario ob = new Usuario();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM USUARIO U INNER JOIN ROL R ON U.IDROL=R.IDROL WHERE EMAIL = ? AND CONTRASENA = AES_ENCRYPT(?,'clave')");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString()); //Evitamos la Inyección SQL
            ps.setString(1, correo);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                ob.setIdusuario(rs.getInt("IDUSUARIO"));
                ob.setNombrerol(rs.getString("NOMBREROL"));
                ob.setNombre(rs.getString("NOMBRE"));
                ob.setApellido(rs.getString("APELLIDO"));
                ob.setTipo_documento(rs.getString("TIPO_DOCUMENTO"));
                ob.setDni(rs.getString("NUM_DOCUMENTO"));
                ob.setEmail(rs.getString("EMAIL"));
                ob.setPassword(rs.getString("CONTRASENA"));
                ob.setTelefono(rs.getString("TELEFONO"));
                ob.setEstado(rs.getString("ESTADO"));
                ob.setId_paciente(rs.getString("ID_PACIENTE"));
            }
            System.out.println("login con exito!");
        } catch (Exception e) {
            System.out.println("Error en Script Login");
        }
        return ob;
    }

    public boolean buscardni(String dni) {
        boolean estado = true;
        String sql = "SELECT * FROM USUARIO WHERE NUM_DOCUMENTO = '" + dni + "'";
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                estado = false;//encontró
            } else {
                estado = true; // no encontró
            }

        } catch (Exception e) {
            System.out.println("error de script");
        }

        return estado;
    }
        public boolean buscarCorreo(String correo) {
        boolean estado = true;
        String sql = "SELECT * FROM USUARIO WHERE EMAIL = '" + correo + "'";
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                estado = false;//encontró
            } else {
                estado = true; // no encontró
            }

        } catch (Exception e) {
            System.out.println("error de script");
        }

        return estado;
    }

}
