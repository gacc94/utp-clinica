/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoDetalle_Ventas;
import dto.Detalle_Ventas;
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
public class DaoDetalle_VentasImpl implements DaoDetalle_Ventas {

    ConexionBD cn = new ConexionBD();
    ArrayList<Detalle_Ventas> lista = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = null;
    

    @Override
    public ArrayList<Detalle_Ventas> listarDetalleVentaxid(int idventa) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *")
                .append(" FROM detalle_venta dv INNER JOIN producto p on dv.IDPRODUCTO=p.IDPRODUCTO where IDVENTA  = " + idventa);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Detalle_Ventas detventas = new Detalle_Ventas();
                detventas.setIdDetalleVenta(rs.getInt("IDDETALLE_VENTA"));
                detventas.setIdVenta(rs.getInt("IDVENTA"));
                detventas.setIdProducto(rs.getInt("IDPRODUCTO"));
                detventas.setCantidad(rs.getInt("CANTIDAD"));
                detventas.setPrecio_venta(rs.getDouble("PRECIO"));
                detventas.setDescuento(rs.getDouble("DESCUENTO"));
                detventas.setDescripcion(rs.getString("DESCRIPCION"));
                detventas.setImagen(rs.getString("p.imagen"));
                
                lista.add(detventas);
            }
        } catch (Exception e) {
         
        }
        return lista;
    }

}
