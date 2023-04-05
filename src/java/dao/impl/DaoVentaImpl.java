package dao.impl;

import dao.DaoVenta;
import dto.Venta;
import dto.Detalle_Ventas;
import dto.Usuario;
import dto.misCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConexionBD;

public class DaoVentaImpl implements DaoVenta {

    ArrayList<Venta> listaVentas = null;
    Venta obv = null;
    ConexionBD cn = new ConexionBD();
    ArrayList<misCompras> listaCompras = null;
    ArrayList<misCompras> listaDetalles = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    misCompras mc = null;

    @Override
    public int GenerarCompra(Venta venta) {
        int r = 0;
        String sql = "INSERT into venta(idusuario, tipo_comprobante, num_comprobante , fecha_hora, impuesto, total, estado, idPago, ruc, razon_social, domicilio_legal, direntrega) VALUES(?, ?, ? , now(), 0.18 , ?, ?, ?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getIdCliente());
            ps.setString(2, venta.getTipoComprobante());
            ps.setString(3, venta.getNumComprobante());
            ps.setDouble(4, venta.getMonto());
            ps.setString(5, venta.getEstado());
            ps.setInt(6, venta.getIdPago());
            ps.setString(7, venta.getRuc());
            ps.setString(8, venta.getRazon());
            ps.setString(9, venta.getDomlegal());
            ps.setString(10, venta.getDir_entrega());

            r = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en Script!");
        }

        return r;
    }

    @Override
    public int getIdVenta() {
        int idc = 0;
        String sql = "select max(idventa) from venta";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idc = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return idc;
    }

    @Override
    public int guardarDetalleCompra(Detalle_Ventas dv) {
        int r = 0;
        String sql = "INSERT into detalle_venta(IDVENTA, IDPRODUCTO, CANTIDAD, PRECIO, DESCUENTO)VALUES(?,?,?,?,0.0)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVenta());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecio_venta());
            r = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en el Script!");
        }

        return r;
    }

    @Override
    public ArrayList<misCompras> listarMisCompras(int idcliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("* ")
                .append("FROM USUARIO U INNER JOIN venta V ON U.IDUSUARIO=V.idusuario ")
                .append("INNER JOIN detalle_venta DV ON DV.IDVENTA=V.idventa ")
                .append("INNER JOIN producto P ON P.IDPRODUCTO= DV.IDPRODUCTO WHERE U.IDUSUARIO=" + idcliente + " GROUP BY V.idventa");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            listaCompras = new ArrayList<>();
            while (rs.next()) {
                mc = new misCompras();
                mc.setIdventa(rs.getInt("V.idventa"));
                mc.setIdproducto(rs.getInt("DV.IDPRODUCTO"));
                mc.setDescripcion(rs.getString("P.DESCRIPCION"));
                mc.setCantidad(rs.getInt("DV.CANTIDAD"));
                mc.setPrecio(rs.getDouble("DV.PRECIO"));
                mc.setTotal(rs.getDouble("V.total"));
                mc.setTipoComprobante(rs.getString("V.tipo_comprobante"));
                mc.setFecha(rs.getDate("V.fecha_hora"));
                mc.setEstado(rs.getString("V.estado"));
                listaCompras.add(mc);

            }

        } catch (Exception e) {
            System.out.println("Error en el Script");
        }
        return listaCompras;
    }

    @Override
    public misCompras getVenta(int idventa) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("* ")
                .append("FROM pago pg INNER JOIN venta V ON pg.idPago=V.idPago ")
                .append("INNER JOIN detalle_venta DV ON DV.IDVENTA=V.idventa ")
                .append("INNER JOIN producto P ON P.IDPRODUCTO= DV.IDPRODUCTO WHERE V.idventa= " + idventa + " GROUP BY V.idventa");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                mc = new misCompras();
                mc.setIdventa(rs.getInt("V.idventa"));
                mc.setIdproducto(rs.getInt("DV.IDPRODUCTO"));
                mc.setDescripcion(rs.getString("P.DESCRIPCION"));
                mc.setCantidad(rs.getInt("DV.CANTIDAD"));
                mc.setPrecio(rs.getDouble("DV.PRECIO"));
                mc.setTotal(rs.getDouble("V.total"));
                mc.setTipoComprobante(rs.getString("V.tipo_comprobante"));
                mc.setFecha(rs.getDate("V.fecha_hora"));
                mc.setEstado(rs.getString("V.estado"));
                mc.setDirEntrega(rs.getString("v.direntrega"));
                mc.setTarjeta(rs.getString("pg.tarjeta"));

            }

        } catch (Exception e) {
            System.out.println("Error en el Script");
        }
        return mc;
    }

    @Override
    public ArrayList<Venta> listarVentas() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM usuario U ")
                .append("INNER JOIN venta V ON U.IDUSUARIO=V.idusuario");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            listaVentas = new ArrayList<>();
            while (rs.next()) {
                obv = new Venta();
                obv.setIdVenta(rs.getInt("v.idventa"));
                obv.setNombreCliente(rs.getString("u.nombre"));
                obv.setFecha(rs.getDate("v.fecha_hora"));
                obv.setEstado(rs.getString("v.estado"));
                obv.setDir_entrega(rs.getString("v.direntrega"));
                obv.setTipoComprobante(rs.getString("v.tipo_comprobante"));
                obv.setMonto(rs.getDouble("v.total"));
                obv.setTelefono(rs.getString("u.telefono"));
                listaVentas.add(obv);
            }

        } catch (Exception e) {
        }
        return listaVentas;
    }

    @Override
    public Venta listarventaxid(int idventa) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM usuario U INNER JOIN venta V ON U.IDUSUARIO=V.idusuario WHERE v.idventa=" + idventa);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                obv = new Venta();
                obv.setIdVenta(rs.getInt("v.idventa"));
                obv.setEstado(rs.getString("v.estado"));
                obv.setDir_entrega(rs.getString("v.direntrega"));
                obv.setTipoComprobante(rs.getString("v.tipo_comprobante"));
                obv.setTelefono(rs.getString("u.telefono"));
                obv.setRuc(rs.getString("v.ruc"));
                obv.setRazon(rs.getString("v.razon_social"));
                obv.setDomlegal(rs.getString("v.domicilio_legal"));
                obv.setIdCliente(rs.getInt("u.idusuario"));

            }
        } catch (Exception e) {

        }
        return obv;
    }

    @Override
    public boolean ActualizarVenta(Venta venta) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE VENTA SET estado=?, tipo_comprobante=?, direntrega=?, ruc=?, razon_social=?, domicilio_legal=? ")
                .append(" WHERE IDVENTA=?");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, venta.getEstado());
            ps.setString(2, venta.getTipoComprobante());
            ps.setString(3, venta.getDir_entrega());
            ps.setString(4, venta.getRuc());
            ps.setString(5, venta.getRazon());
            ps.setString(6, venta.getDomlegal());
            ps.setInt(7, venta.getIdVenta());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean ActualizarTelefono(Usuario uid) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE USUARIO SET TELEFONO=?")
                .append(" WHERE IDUSUARIO=?");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, uid.getTelefono());
            ps.setInt(2, uid.getIdusuario());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

}
