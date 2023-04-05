package dto;

public class Medico {

    private String id_medico;
    private String nombres_medico;
    private String apellido_paterno_medico;
    private String apellido_materno_medico;

    public Medico() {
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
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

    @Override
    public String toString() {
        return "Medico{" + "id_medico=" + id_medico + ", nombres_medico=" + nombres_medico + ", apellido_paterno_medico=" + apellido_paterno_medico + ", apellido_materno_medico=" + apellido_materno_medico + '}';
    }
    
    
}
