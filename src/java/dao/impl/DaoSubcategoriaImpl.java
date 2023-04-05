package dao.impl;

import dao.DaoSubcategoria;
import dto.Subcategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoSubcategoriaImpl implements DaoSubcategoria{
    
    ConexionBD conectaDb;
    String mensaje;
    Connection con= null;
    PreparedStatement ps= null;
    ResultSet rs = null;
    ConexionBD cn = new ConexionBD();
    ArrayList<Subcategoria> listasubcat = null;
    Subcategoria subcat = null;
    
    public DaoSubcategoriaImpl() {
        this.conectaDb = new ConexionBD();
    }
    
    @Override
    public List<Subcategoria> subcategoriaSel() {
        List<Subcategoria> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDSUBCATEGORIA,")
                .append("IDCATEGORIA,")
                .append("NOMBRESUBCATEGORIA,")
                .append("DESCRIPCIONSUBCATEGORIA,")
                .append("ESTADOSUBCAT")
                .append(" FROM subcategoria");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Subcategoria subcategoria = new Subcategoria();
                subcategoria.setIDSUBCATEGORIA(rs.getInt(1));
                subcategoria.setIDCATEGORIA(rs.getInt(2));
                subcategoria.setNOMBRESUBCATEGORIA(rs.getString(3));
                subcategoria.setDESCRIPCIONSUBCATEGORIA(rs.getString(4));
                subcategoria.setESTADOSUBCAT(rs.getString(5));
                list.add(subcategoria);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Subcategoria subcategoriaGet(int id) {
        Subcategoria subcategoria = new Subcategoria();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDSUBCATEGORIA,")
                .append("IDCATEGORIA,")
                .append("NOMBRESUBCATEGORIA,")
                .append("DESCRIPCIONSUBCATEGORIA,")
                .append("ESTADOSUBCAT")
                .append(" FROM subcategoria")
                .append(" WHERE IDSUBCATEGORIA = ?");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                subcategoria.setIDSUBCATEGORIA(rs.getInt(1));
                subcategoria.setIDCATEGORIA(rs.getInt(2));
                subcategoria.setNOMBRESUBCATEGORIA(rs.getString(3));
                subcategoria.setDESCRIPCIONSUBCATEGORIA(rs.getString(4));
                subcategoria.setESTADOSUBCAT(rs.getString(5));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return subcategoria;
    }

    @Override
    public String subcategoriaIns(Subcategoria subcategoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO subcategoria( ")
                .append("IDCATEGORIA,")
                .append("NOMBRESUBCATEGORIA,")
                .append("DESCRIPCIONSUBCATEGORIA,")
                .append("ESTADOSUBCAT")
                .append(") VALUES (?,?,?,?) ");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, subcategoria.getIDCATEGORIA());
            ps.setString(2, subcategoria.getNOMBRESUBCATEGORIA());
            ps.setString(3, subcategoria.getDESCRIPCIONSUBCATEGORIA());
            ps.setString(4, subcategoria.getESTADOSUBCAT());
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
    public String subcategoriaUpd(Subcategoria subcategoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE subcategoria SET ")
                .append("IDCATEGORIA = ?,")
                .append("NOMBRESUBCATEGORIA = ?,")
                .append("DESCRIPCIONSUBCATEGORIA = ?,")
                .append("ESTADOSUBCAT = ? ")
                .append("WHERE IDSUBCATEGORIA = ? ");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, subcategoria.getIDCATEGORIA());
            ps.setString(2, subcategoria.getNOMBRESUBCATEGORIA());
            ps.setString(3, subcategoria.getDESCRIPCIONSUBCATEGORIA());
            ps.setString(4, subcategoria.getESTADOSUBCAT());
            ps.setInt(5, subcategoria.getIDSUBCATEGORIA());
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
    public String subcategoriaDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM subcategoria WHERE ")
                .append("IDSUBCATEGORIA = ? ");
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
    public ArrayList<Subcategoria> getNomSubCatxIdCat(int idcategoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT s.IDSUBCATEGORIA, s.NOMBRESUBCATEGORIA FROM subcategoria s" )
                .append(" INNER JOIN categoria c ON s.IDCATEGORIA=c.IDCATEGORIA")
                .append(" WHERE c.IDCATEGORIA =" + idcategoria);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            listasubcat = new ArrayList<>();
            while (rs.next()) {
                subcat = new Subcategoria();
                subcat.setIDSUBCATEGORIA(rs.getInt("s.IDSUBCATEGORIA"));
                subcat.setNOMBRESUBCATEGORIA(rs.getString("s.NOMBRESUBCATEGORIA"));
                listasubcat.add(subcat);
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return listasubcat;
    }

    
}
