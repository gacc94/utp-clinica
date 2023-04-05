/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoRol;
import dto.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

/**
 *
 * @author Usuario
 */
public class daoRolimpl implements DaoRol {

    private ConexionBD conectaBd;
    private String mensaje;

    public daoRolimpl() {
        this.conectaBd = new ConexionBD();
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public List<Rol> rolSel() {
        List<Rol> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDROL,")
                .append("NOMBREROL,")
                .append("DESCRIPCION ")
                .append(" FROM rol ");
        try (Connection cn = conectaBd.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIDROL(rs.getInt(1));
                rol.setNOMBREROL(rs.getString(2));
                rol.setDESCRIPCION(rs.getString(3));
             
                list.add(rol);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Rol rolGet(Integer id) {
         Rol rol = new Rol();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IDROL,")
                .append("NOMBREROL,")
                .append("DESCRIPCION ")
                .append(" FROM rol ")
                .append(" WHERE IDROL = ?");
        try (Connection cn = conectaBd.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rol.setIDROL(rs.getInt(1));
                rol.setNOMBREROL(rs.getString(2));
                rol.setDESCRIPCION(rs.getString(3));
                
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return rol;
    }

    @Override
    public String rolIns(Rol rol) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO rol( ")
                .append("NOMBREROL,")
                .append("DESCRIPCION ")
                .append(") VALUES (?,?) ");
        try (Connection cn = conectaBd.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, rol.getNOMBREROL());
            ps.setString(2, rol.getDESCRIPCION());
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
    public String rolUpd(Rol rol) {
         StringBuilder sql = new StringBuilder();
        sql.append("UPDATE rol SET ")
                .append("NOMBREROL = ?,")
                .append("DESCRIPCION = ? ")
                .append("WHERE IDROL = ? ");
        
        try (Connection cn = conectaBd.Conexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, rol.getNOMBREROL());
            ps.setString(2, rol.getDESCRIPCION());
            ps.setInt(3, rol.getIDROL());
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
    public String rolDel(List<Integer> ids) {
          StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM rol WHERE ")
                .append("IDROL = ? ");
        try (Connection cn = conectaBd.Conexion()) {
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

}
