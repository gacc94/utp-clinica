
package dto;


public class Especialidad {
    private String id_especialidad;
    private String codigo_medico;
    private String nombres_medico;
    private String apellido_paterno_medico;
    private String apellido_materno_medico;
    private String nombre_especialidad;
    private String nombre_consultorio;
    private Double precio;

    public Especialidad() {
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


    public String getNombres_medico() {
        return nombres_medico;
    }

    public void setNombres_medico(String nombres_medico) {
        this.nombres_medico = nombres_medico;
    }

    public String getApellido_paterno_medico() {
        return apellido_paterno_medico;
    }

    public void setApellido_paterno_medico(String apellido_paterno_medico) {
        this.apellido_paterno_medico = apellido_paterno_medico;
    }

    public String getApellido_materno_medico() {
        return apellido_materno_medico;
    }

    public void setApellido_materno_medico(String apellido_materno_medico) {
        this.apellido_materno_medico = apellido_materno_medico;
    }

    public String getNombre_consultorio() {
        return nombre_consultorio;
    }

    public void setNombre_consultorio(String nombre_consultorio) {
        this.nombre_consultorio = nombre_consultorio;
    }

    public String getCodigo_medico() {
        return codigo_medico;
    }

    public void setCodigo_medico(String codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    

    
}
 