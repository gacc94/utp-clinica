package dao.impl;

import dao.DaoUsuario;
import dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConexionBD;

public class DaoUsuarioImpl implements DaoUsuario {

    Usuario ob = null;
    ArrayList<Usuario> lista = null;
    ConexionBD cn = new ConexionBD();

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private String mensaje;

    @Override
    public ArrayList<Usuario> listar() {
        String sql = "SELECT * FROM usuario U INNER JOIN ROL R ON U.IDROL=R.IDROL";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                ob = new Usuario();
                ob.setIdusuario(rs.getInt("IDUSUARIO"));
                ob.setNombrerol(rs.getString("NOMBREROL"));
                ob.setNombre(rs.getString("NOMBRE"));
                ob.setApellido(rs.getString("APELLIDO"));
                ob.setId_paciente(rs.getString("ID_PACIENTE")); //NO ESTABA IMPLMENTADO, PERO SE REPITE EN tbl paciente
                ob.setDni(rs.getString("NUM_DOCUMENTO"));
                ob.setEmail(rs.getString("EMAIL"));
                ob.setTelefono(rs.getString("TELEFONO"));
                ob.setFecha_creacion(rs.getDate("Fecha_CREACION"));
                ob.setEstado(rs.getString("ESTADO"));
                lista.add(ob);
            }

        } catch (Exception e) {
        }

        return lista;
    }

    @Override
    public Usuario listarxid(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT IDUSUARIO, R.IDROL,R.NOMBREROL, NOMBRE, APELLIDO, TIPO_DOCUMENTO, NUM_DOCUMENTO, TELEFONO, EMAIL, cast(aes_decrypt(CONTRASENA, 'clave') as char) as PASS , FECHA_CREACION, ESTADO, DIRECCION FROM usuario U INNER JOIN ROL R ON U.IDROL=R.IDROL WHERE IDUSUARIO =" + id);
       
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                ob = new Usuario();
                ob.setIdusuario(rs.getInt("IDUSUARIO"));
                ob.setIdrol(rs.getInt("IDROL"));
                ob.setNombrerol(rs.getString("NOMBREROL"));
                ob.setNombre(rs.getString("NOMBRE"));
                ob.setApellido(rs.getString("APELLIDO"));
                ob.setTipo_documento(rs.getString("TIPO_DOCUMENTO"));
                ob.setDni(rs.getString("NUM_DOCUMENTO"));
                ob.setEmail(rs.getString("EMAIL"));
                ob.setTelefono(rs.getString("TELEFONO"));
                ob.setDireccion(rs.getString("DIRECCION"));
                ob.setPassword(rs.getString("PASS"));
                ob.setEstado(rs.getString("ESTADO"));
            }

        } catch (Exception e) {
        }
        return ob;
    }

    @Override
    public boolean editar(Usuario ob) {
        
        String sql = "UPDATE USUARIO SET IDROL=?, NOMBRE=?, APELLIDO=?, TIPO_DOCUMENTO=?, NUM_DOCUMENTO=?, TELEFONO=?, EMAIL=?, CONTRASENA = AES_ENCRYPT(?,'clave'), ESTADO=?, DIRECCION=? WHERE IDUSUARIO=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ob.getIdrol());
            ps.setString(2, ob.getNombre());
            ps.setString(3, ob.getApellido());
            ps.setString(4, ob.getTipo_documento());
            ps.setString(5, ob.getDni());
            ps.setString(6, ob.getTelefono());
            ps.setString(7, ob.getEmail());
            ps.setString(8, ob.getPassword());
            ps.setString(9, ob.getEstado());
            ps.setString(10, ob.getDireccion());
            ps.setInt(11, ob.getIdusuario());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en el Script o no recibe todos los parametros");
        }
        return false;
    }

    @Override
    public boolean agregar(Usuario ob) {
       StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USUARIO ")
                .append("(IDROL, NOMBRE, APELLIDO, TIPO_DOCUMENTO, NUM_DOCUMENTO, TELEFONO, EMAIL, CONTRASENA, FECHA_CREACION, ESTADO, DIRECCION, ID_PACIENTE) ")
                .append("VALUES(?,?,?,?,?,?,?,AES_ENCRYPT(?,'clave'),now(),?,?,?)");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, ob.getIdrol());
            ps.setString(2, ob.getNombre());
            ps.setString(3, ob.getApellido());
            ps.setString(4, ob.getTipo_documento());
            ps.setString(5, ob.getDni());
            ps.setString(6, ob.getTelefono());
            ps.setString(7, ob.getEmail());
            ps.setString(8, ob.getPassword());
            ps.setString(9, ob.getEstado());
            ps.setString(10, ob.getDireccion());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public String getMensaje() {
        return mensaje;
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
