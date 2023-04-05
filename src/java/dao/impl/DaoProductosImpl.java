package dao.impl;

import dao.DaoProductos;
import dto.Categoria;
import dto.Productos;
import dto.Subcategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConexionBD;

/**
 *
 * @author Usuario
 */
public class DaoProductosImpl implements DaoProductos {

    ConexionBD cn = new ConexionBD();
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;
    ArrayList<Productos> lista = null;
    ArrayList<Categoria> listacat = null;
    Categoria cat = null;
    ArrayList<Subcategoria> listasubcat = null;
    Subcategoria subcat = null;
    Productos producto = null;
    String mensaje = null;

    @Override
    public String ProductosIns(Productos producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO producto( ")
                .append("codigo,")
                .append("idcategoria,")
                .append("idsubcategoria,")
                .append("marca,")
                .append("precio_venta,")
                .append("stock,")
                .append("descripcion,")
                .append("imagen,")
                .append("estado")
                .append(" ) VALUES (?,?,?,?,?,?,?,?,'Disponible')");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            
            ps.setString(1, producto.getCodigo());
            ps.setInt(2, producto.getIdcategoria());
           // ps.setInt(3, producto.getIdsubcategoria());
//            ps.setString(4, producto.getMarca());
            ps.setDouble(5, producto.getPrecio_venta());
//            ps.setInt(6, producto.getStock());
            ps.setString(7, producto.getDescripcion());
            ps.setString(8, producto.getImagen());
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
    public String ProductosUpd(Productos producto) {//debe recibir todos los parametros
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE producto SET ")
                .append("codigo = ?,")
                .append("idcategoria = ?,")
                .append("idsubcategoria = ?,")
                .append("marca = ?,")
                .append("precio_venta = ?,")
                .append("stock = ?,")
                .append("descripcion = ?,")
                .append("imagen = ?,")
                .append("estado = ? ")
                .append("WHERE idproducto = ? ");

        try {
//            con = cn.Conexion();
//            ps = con.prepareStatement(sql.toString());
//            ps.setString(1, producto.getCodigo());
//            ps.setInt(2, producto.getIdcategoria());
//            ps.setInt(3, producto.getIdsubcategoria());
//            ps.setString(4, producto.getMarca());
//            ps.setDouble(5, producto.getPrecio_venta());
//            ps.setInt(6, producto.getStock());
//            ps.setString(7, producto.getDescripcion());
//            ps.setString(8, producto.getImagen());
//            ps.setString(9, producto.getEstado());
//            ps.setInt(10, producto.getIdproducto());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                System.out.println("0 filas actualizadas");
            }
        } catch (Exception e) {

            System.out.println("Error en el Script");
        }
        return mensaje;
    }

    @Override
    public String ProductosUpdSinImagen(Productos producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE producto SET ")
                .append("codigo = ?,")
                .append("idcategoria = ?,")
                .append("idsubcategoria = ?,")
                .append("marca = ?,")
                .append("precio_venta = ?,")
                .append("stock = ?,")
                .append("descripcion = ?,")
                .append("estado = ? ")
                .append("WHERE idproducto = ? ");

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, producto.getCodigo());
            ps.setInt(2, producto.getIdcategoria());
//            ps.setInt(3, producto.getIdsubcategoria());
//            ps.setString(4, producto.getMarca());
//            ps.setDouble(5, producto.getPrecio_venta());
//            ps.setInt(6, producto.getStock());
            ps.setString(7, producto.getDescripcion());
            ps.setString(8, producto.getEstado());
            ps.setInt(9, producto.getIdproducto());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                System.out.println("0 filas actualizadas");
            }
        } catch (Exception e) {

            System.out.println("Error en el Script");
        }
        return mensaje;
    }

    @Override
    public String ProductosDel(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM producto WHERE ")
                .append("idproducto = ? ");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, id);
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas eliminadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;

    }

    @Override
    public ArrayList<Categoria> CatCbo() { //eliminar
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idcategoria")
                .append(" FROM categoria");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            listacat = new ArrayList<>();
            while (rs.next()) {
                cat = new Categoria();
                cat.setIDCATEGORIA(rs.getInt("idcategoria"));
                listacat.add(cat);
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return listacat;
    }

    @Override
    public ArrayList<Subcategoria> SubCatCbo(int idcategoria) {//eliminar
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT NOMBRESUBCATEGORIA FROM subcategoria s")
                .append(" INNER JOIN categoria c ON s.IDCATEGORIA=c.IDCATEGORIA")
                .append(" WHERE c.IDCATEGORIA =" + idcategoria);
        try {

            PreparedStatement ps = con.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            listasubcat = new ArrayList<>();
            while (rs.next()) {
                subcat = new Subcategoria();
                subcat.setIDSUBCATEGORIA(rs.getInt("idsubcategoria"));
                listasubcat.add(subcat);
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return listasubcat;
    }

    //Listar Productos
    @Override
    public ArrayList<Productos> listarProductos() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.idproducto, p.codigo, c.nombre,p.precio_venta,p.imagen,p.descripcion,p.destino,p.estado,p.FECHA FROM ")
                .append("producto P INNER JOIN categoria C ")
                .append("ON p.IDCATEGORIA=c.IDCATEGORIA");
                

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                producto = new Productos();
                producto.setIdproducto(rs.getInt("p.idproducto"));
                producto.setCodigo(rs.getString("p.codigo"));
                producto.setNombrecat(rs.getString("c.nombre"));
                producto.setPrecio_venta(rs.getDouble("p.precio_venta"));
                producto.setImagen(rs.getString("p.imagen"));
                producto.setDescripcion(rs.getString("p.descripcion"));
                producto.setDestino(rs.getString("p.destino"));
                producto.setEstado(rs.getString("p.estado"));
                producto.setFecha(rs.getString("p.fecha"));
                lista.add(producto);
            }
        } catch (Exception e) {

        }
        return lista;
    }

    @Override
    public Productos getProductosxID(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ")
                .append("producto P INNER JOIN categoria C ")
                .append("ON P.IDCATEGORIA=c.IDCATEGORIA ")
                .append(" WHERE idproducto = ?");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Productos();
                producto.setIdproducto(rs.getInt("p.idproducto"));
                producto.setCodigo(rs.getString("p.codigo"));
                producto.setDestino(rs.getString("p.destino"));
                producto.setIdcategoria(rs.getInt("c.idcategoria"));
                producto.setPrecio_venta(rs.getDouble("p.precio_venta"));
                producto.setImagen(rs.getString("p.imagen"));
                producto.setDescripcion(rs.getString("p.marca"));
                producto.setEstado(rs.getString("p.estado"));
            }
        } catch (Exception e) {

        }
        return producto;
    }

    @Override
    public String buscarCodigo(String codigo) {
        String mensaje = "";
        String sql = "SELECT * FROM producto WHERE codigo = '" + codigo + "'";
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) { //si rs.next() es true
                mensaje = "El codigo ya Existe";//encontró
            }
        } catch (Exception e) {
            System.out.println("error de script");
        }

        return mensaje;
    }

}
