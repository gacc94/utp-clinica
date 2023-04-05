
package dto;

import java.sql.Date;




public class Reserva {
    
    private String fecha;
    private String hora;
    private String id_paciente;
    private String id_medico;
    private String nombre_medico;
    private String apellidopat_medico;
    private String apellidomat_medico;
    private String id_especialidad;
    private String nombre_especialidad;
    private String id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String id_pago;
    private String estado_pago;
    private String estado_cita;
    private Double precio;
    private Date fecha_reserva;
    

    public Reserva() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(String id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getId_pago() {
        return id_pago;
    }

    public void setId_pago(String id_pago) {
        this.id_pago = id_pago;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getApellidopat_medico() {
        return apellidopat_medico;
    }

    public void setApellidopat_medico(String apellidopat_medico) {
        this.apellidopat_medico = apellidopat_medico;
    }

    public String getApellidomat_medico() {
        return apellidomat_medico;
    }

    public void setApellidomat_medico(String apellidomat_medico) {
        this.apellidomat_medico = apellidomat_medico;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }
    
    
    
    
}
