/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoPaciente;
import dto.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConexionBD;

/**
 *
 * @author Jonathan
 */
public class DaoPacienteImpl implements DaoPaciente {

    Paciente ob = null;
    ArrayList<Paciente> lista = null;
    ConexionBD cn = new ConexionBD();

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public ArrayList<Paciente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Paciente> listarxIdCliente(int idPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente listarxIdUsuario(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente listarxpago(String estado_pago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Paciente ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(Paciente ob) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PACIENTE ")
                .append("(id_paciente, dni, nombre, ape_paterno, email, telefono, fec_creacion) ")
                .append("VALUES(?,?,?,?,?,?,now())");

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, ob.getId_paciente());
            ps.setString(2, ob.getDni());
            ps.setString(3, ob.getNombre());
            ps.setString(4, ob.getApe_paterno());
            ps.setString(5, ob.getEmail());
            ps.setString(6, ob.getTelefono());
            ps.executeUpdate();
            System.out.println("Agregado con exito!");
        } catch (Exception e) {
            System.out.println("Error en el Script agregar Paciente!");
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
