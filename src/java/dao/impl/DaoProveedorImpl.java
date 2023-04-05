package dao.impl;

import dao.DaoProveedor;
import dto.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoProveedorImpl implements DaoProveedor {

    ConexionBD conectaDb;
    String mensaje;

    public DaoProveedorImpl() {
        this.conectaDb = new ConexionBD();
    }

//    public DaoSubcategoriaImpl() {
//        this.conectaDb = new ConectaBD();
//    }
    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public List<Proveedor> proveedorSel() {
        List<Proveedor> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDPROVEEDOR,")
                .append("RUC,")
                .append("NOMBREPROVEEDOR,")
                .append("DIRECCION,")
                .append("TELEFONO,")
                .append("EMAIL,")
                .append("ESTADO ")
                .append(" FROM proveedor");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIDPROVEEDOR(rs.getInt(1));
                proveedor.setRUC(rs.getString(2));
                proveedor.setNOMBREPROVEEDOR(rs.getString(3));
                proveedor.setDIRECCION(rs.getString(4));
                proveedor.setTELEFONO(rs.getString(5));
                proveedor.setEMAIL(rs.getString(6));
                proveedor.setESTADO(rs.getString(7));
                list.add(proveedor);
            }
        } catch (Exception e) {
           
        }
        return list;
    }

    @Override
    public Proveedor proveedorGet(Integer id) {
        Proveedor proveedor = new Proveedor();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDPROVEEDOR,")
                .append("RUC,")
                .append("NOMBREPROVEEDOR,")
                .append("DIRECCION,")
                .append("TELEFONO,")
                .append("EMAIL,")
                .append("ESTADO ")
                .append(" FROM proveedor")
                .append(" WHERE IDPROVEEDOR = ?");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.setIDPROVEEDOR(rs.getInt(1));
                proveedor.setRUC(rs.getString(2));
                proveedor.setNOMBREPROVEEDOR(rs.getString(3));
                proveedor.setDIRECCION(rs.getString(4));
                proveedor.setTELEFONO(rs.getString(5));
                proveedor.setEMAIL(rs.getString(6));
                proveedor.setESTADO(rs.getString(7));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return proveedor;
    }

    @Override
    public String proveedorIns(Proveedor proveedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO proveedor( ")
                .append("RUC,")
                .append("NOMBREPROVEEDOR,")
                .append("DIRECCION,")
                .append("TELEFONO,")
                .append("EMAIL,")
                .append("ESTADO ")
                .append(") VALUES (?,?,?,?,?,?) ");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, proveedor.getRUC());
            ps.setString(2, proveedor.getNOMBREPROVEEDOR());
            ps.setString(3, proveedor.getDIRECCION());
            ps.setString(4, proveedor.getTELEFONO());
            ps.setString(5, proveedor.getEMAIL());
            ps.setString(6, proveedor.getESTADO());
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
    public String proveedorUpd(Proveedor proveedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE proveedor SET ")
                .append("RUC = ?,")
                .append("NOMBREPROVEEDOR = ?,")
                .append("DIRECCION = ?,")
                .append("TELEFONO = ?,")
                .append("EMAIL = ?,")
                .append("ESTADO = ? ")
                .append("WHERE IDPROVEEDOR = ? ");
        try (Connection cn = conectaDb.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, proveedor.getRUC());
            ps.setString(2, proveedor.getNOMBREPROVEEDOR());
            ps.setString(3, proveedor.getDIRECCION());
            ps.setString(4, proveedor.getTELEFONO());
            ps.setString(5, proveedor.getEMAIL());
            ps.setString(6, proveedor.getESTADO());
            ps.setInt(7, proveedor.getIDPROVEEDOR());
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
    public String proveedorDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM proveedor WHERE ")
                .append("IDPROVEEDOR = ? ");
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

//     @Override
//    public List<Subcategoria> subcategoriaSel() {
//        List<Subcategoria> list = null;
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT ")
//                .append("IDSUBCATEGORIA,")
//                .append("IDCATEGORIA,")
//                .append("NOMBRESUBCATEGORIA,")
//                .append("DESCRIPCIONSUBCATEGORIA,")
//                .append("ESTADOSUBCAT")
//                .append(" FROM subcategoria");
//        try (Connection cn = conectaDb.getConnection()) {
//            PreparedStatement ps = cn.prepareStatement(sql.toString());
//            ResultSet rs = ps.executeQuery();
//            list = new ArrayList<>();
//            while (rs.next()) {
//                Subcategoria subcategoria = new Subcategoria();
//                subcategoria.setIDSUBCATEGORIA(rs.getInt(1));
//                subcategoria.setIDCATEGORIA(rs.getInt(2));
//                subcategoria.setNOMBRESUBCATEGORIA(rs.getString(3));
//                subcategoria.setDESCRIPCIONSUBCATEGORIA(rs.getString(4));
//                subcategoria.setESTADOSUBCAT(rs.getString(5));
//                list.add(subcategoria);
//            }
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
//        return list;
//    }
//
//    @Override
//    public Subcategoria subcategoriaGet(int id) {
//        Subcategoria subcategoria = new Subcategoria();
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT ")
//                .append("IDSUBCATEGORIA,")
//                .append("IDCATEGORIA,")
//                .append("NOMBRESUBCATEGORIA,")
//                .append("DESCRIPCIONSUBCATEGORIA,")
//                .append("ESTADOSUBCAT")
//                .append(" FROM subcategoria")
//                .append(" WHERE IDSUBCATEGORIA = ?");
//        try (Connection cn = conectaDb.getConnection()) {
//            PreparedStatement ps = cn.prepareStatement(sql.toString());
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                subcategoria.setIDSUBCATEGORIA(rs.getInt(1));
//                subcategoria.setIDCATEGORIA(rs.getInt(2));
//                subcategoria.setNOMBRESUBCATEGORIA(rs.getString(3));
//                subcategoria.setDESCRIPCIONSUBCATEGORIA(rs.getString(4));
//                subcategoria.setESTADOSUBCAT(rs.getString(5));
//            }
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
//        return subcategoria;
//    }
//
//    @Override
//    public String subcategoriaIns(Subcategoria subcategoria) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("INSERT INTO subcategoria( ")
//                .append("IDCATEGORIA,")
//                .append("NOMBRESUBCATEGORIA,")
//                .append("DESCRIPCIONSUBCATEGORIA,")
//                .append("ESTADOSUBCAT")
//                .append(") VALUES (?,?,?,?) ");
//        try (Connection cn = conectaDb.getConnection()) {
//            PreparedStatement ps = cn.prepareStatement(sql.toString());
//            ps.setInt(1, subcategoria.getIDCATEGORIA());
//            ps.setString(2, subcategoria.getNOMBRESUBCATEGORIA());
//            ps.setString(3, subcategoria.getDESCRIPCIONSUBCATEGORIA());
//            ps.setString(4, subcategoria.getESTADOSUBCAT());
//            int ctos = ps.executeUpdate();
//            if (ctos == 0) {
//                mensaje = "Cero filas insertadas";
//            }
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
//        return mensaje;
//    }
//
//    @Override
//    public String subcategoriaUpd(Subcategoria subcategoria) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("UPDATE subcategoria SET ")
//                .append("IDCATEGORIA = ?,")
//                .append("NOMBRESUBCATEGORIA = ?,")
//                .append("DESCRIPCIONSUBCATEGORIA = ?,")
//                .append("ESTADOSUBCAT = ? ")
//                .append("WHERE IDSUBCATEGORIA = ? ");
//        try (Connection cn = conectaDb.getConnection()) {
//            PreparedStatement ps = cn.prepareStatement(sql.toString());
//            ps.setInt(1, subcategoria.getIDCATEGORIA());
//            ps.setString(2, subcategoria.getNOMBRESUBCATEGORIA());
//            ps.setString(3, subcategoria.getDESCRIPCIONSUBCATEGORIA());
//            ps.setString(4, subcategoria.getESTADOSUBCAT());
//            ps.setInt(5, subcategoria.getIDSUBCATEGORIA());
//            int ctos = ps.executeUpdate();
//            if (ctos == 0) {
//                mensaje = "Cero filas actualizadas";
//            }
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
//        return mensaje;
//    }
//
//    @Override
//    public String subcategoriaDel(List<Integer> ids) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("DELETE FROM subcategoria WHERE ")
//                .append("IDSUBCATEGORIA = ? ");
//        try (Connection cn = conectaDb.getConnection()) {
//            PreparedStatement ps = cn.prepareStatement(sql.toString());
//            cn.setAutoCommit(false);
//            boolean ok = true;
//            for (int i = 0; i < ids.size(); i++) {
//                ps.setInt(1, ids.get(i));
//                int ctos = ps.executeUpdate();
//                if (ctos == 0) {
//                    ok = false;
//                    mensaje = "Cero filas actualizadas";
//                }
//                if (ok) {
//                    cn.commit();
//                } else {
//                    cn.rollback();
//                }
//            }
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
//        return mensaje;
//    }
}
