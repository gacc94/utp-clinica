package dao.impl;

import dao.DaoProductoVenta;
import dto.ProductoVenta;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import util.ConexionBD;

public class DaoProductoVentaImpl implements DaoProductoVenta {

    Connection con;
    ConexionBD cn = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public ArrayList<ProductoVenta> listar() {
        ArrayList<ProductoVenta> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT "
                + "IDPRODUCTO, "
                + "CODIGO, "
                + "IDCATEGORIA, "
                + "IDSUBCATEGORIA, "
                + "MARCA, "
                + "PRECIO_VENTA, "
                + "STOCK, "
                + "DESCRIPCION, "
                + "IMAGEN, "
                + "ESTADO "
                + "FROM PRODUCTO");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoVenta pv = new ProductoVenta(); //se crea dentro
                pv.setIdproducto(rs.getInt("IDPRODUCTO"));
                pv.setCodigo(rs.getString("CODIGO"));
                pv.setIdcategoria(rs.getInt("IDCATEGORIA"));
                pv.setIdsubcategoria(rs.getInt("IDSUBCATEGORIA"));
                pv.setMarca(rs.getString("MARCA"));
                pv.setPrecio_venta(rs.getDouble("PRECIO_VENTA"));
                pv.setStock(rs.getInt("STOCK"));
                pv.setDescripcion(rs.getString("DESCRIPCION"));
                pv.setImagen(rs.getBinaryStream("IMAGEN"));
                pv.setEstado(rs.getString("ESTADO"));
                lista.add(pv);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public ProductoVenta listarxid(int id) {
        ProductoVenta pv = new ProductoVenta(); //se crea fuera del try sino no retorna pv
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT "
                + "IDPRODUCTO, "
                + "CODIGO, "
                + "IDCATEGORIA, "
                + "IDSUBCATEGORIA, "
                + "MARCA, "
                + "PRECIO_VENTA, "
                + "STOCK, "
                + "DESCRIPCION, "
                + "IMAGEN, "
                + "ESTADO "
                + "FROM PRODUCTO WHERE IDPRODUCTO = " + id);

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                
                pv.setIdproducto(rs.getInt("IDPRODUCTO"));
                pv.setCodigo(rs.getString("CODIGO"));
                pv.setIdcategoria(rs.getInt("IDCATEGORIA"));
                pv.setIdsubcategoria(rs.getInt("IDSUBCATEGORIA"));
                pv.setMarca(rs.getString("MARCA"));
                pv.setPrecio_venta(rs.getDouble("PRECIO_VENTA"));
                pv.setStock(rs.getInt("STOCK"));
                pv.setDescripcion(rs.getString("DESCRIPCION"));
                pv.setImagen(rs.getBinaryStream("IMAGEN"));
                pv.setEstado(rs.getString("ESTADO"));
                
            }

        } catch (Exception e) {
        }
        return pv;
    }



    @Override
    public void listarImg(int id, HttpServletResponse response) {
        StringBuilder sql = new StringBuilder();
        sql.append(("SELECT * FROM PRODUCTO WHERE IDPRODUCTO = " + id));
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            os = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();

            if (rs.next()) {
                is = rs.getBinaryStream("IMAGEN");
            }
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            int i = 0;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
        } catch (Exception e) {
        }
    }

}
