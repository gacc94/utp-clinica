package dto;

public class Categoria {
    private Integer IDCATEGORIA;
    private String NOMBRE;
    private String DESCRIPCION;
    private String ESTADOCAT;
    
    public Categoria(){
    }

    public Integer getIDCATEGORIA() {
        return IDCATEGORIA;
    }

    public void setIDCATEGORIA(Integer IDCATEGORIA) {
        this.IDCATEGORIA = IDCATEGORIA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getESTADOCAT() {
        return ESTADOCAT;
    }

    public void setESTADOCAT(String ESTADOCAT) {
        this.ESTADOCAT = ESTADOCAT;
    }
   
}
