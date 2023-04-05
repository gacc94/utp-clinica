package dao.impl;

import dao.DaoCategoria;
import dto.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoCategoriaImpl implements DaoCategoria {

    ConexionBD conectaDb;
    String mensaje;
    ConexionBD cn = new ConexionBD();
    Connection con= null;
    PreparedStatement ps = null;
    ResultSet rs = null;
     ArrayList<Categoria> listaCat = null;
    public DaoCategoriaImpl() {
        this.conectaDb = new ConexionBD();
    }
    
    @Override
    public List<Categoria> categoriaSel() {
        List<Categoria> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDCATEGORIA,")
                .append("NOMBRE,")
                .append("DESCRIPCION,")
                .append("ESTADOCAT")
                .append(" FROM categoria");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIDCATEGORIA(rs.getInt(1));
                categoria.setNOMBRE(rs.getString(2));
                categoria.setDESCRIPCION(rs.getString(3));
                categoria.setESTADOCAT(rs.getString(4));
                list.add(categoria);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Categoria categoriaGet(int id) {
        Categoria categoria = new Categoria();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDCATEGORIA,")
                .append("NOMBRE,")
                .append("DESCRIPCION,")
                .append("ESTADOCAT")
                .append(" FROM categoria")
                .append(" WHERE IDCATEGORIA = ?");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoria.setIDCATEGORIA(rs.getInt(1));
                categoria.setNOMBRE(rs.getString(2));
                categoria.setDESCRIPCION(rs.getString(3));
                categoria.setESTADOCAT(rs.getString(4));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return categoria;
    }

    @Override
    public String categoriaIns(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO categoria( ")
                .append("NOMBRE,")
                .append("DESCRIPCION,")
                .append("ESTADOCAT")
                .append(") VALUES (?,?,?) ");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, categoria.getNOMBRE());
            ps.setString(2, categoria.getDESCRIPCION());
            ps.setString(3, categoria.getESTADOCAT());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas insertadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String categoriaUpd(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE categoria SET ")
                .append("NOMBRE = ?,")
                .append("DESCRIPCION = ?,")
                .append("ESTADOCAT = ? ")
                .append("WHERE IDCATEGORIA = ? ");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, categoria.getNOMBRE());
            ps.setString(2, categoria.getDESCRIPCION());
            ps.setString(3, categoria.getESTADOCAT());
            ps.setInt(4, categoria.getIDCATEGORIA());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String categoriaDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM categoria WHERE ")
                .append("IDCATEGORIA = ? ");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            cn.setAutoCommit(false);
            boolean ok = true;
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(1, ids.get(i));
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    mensaje = "Cero filas actualizadas";
                }
                if (ok) {
                    cn.commit();
                } else {
                    cn.rollback();
                }
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public List<Categoria> getListCatxId(int cat) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDCATEGORIA,")
                .append("NOMBRE,")
                .append(" FROM categoria")
                .append(" WHERE IDCATEGORIA = " + cat);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            listaCat = new ArrayList<>();
            while(rs.next()){
                Categoria ob = new Categoria();
                ob.setIDCATEGORIA(rs.getInt("IDCATEGORIA"));
                ob.setNOMBRE(rs.getString("NOMBRE"));
                listaCat.add(ob);
            }
        } catch (Exception e) {
             System.out.println("Error en el Script");
        }
        
        return listaCat;
    }

}
