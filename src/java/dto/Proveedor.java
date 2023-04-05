package dto;

public class Proveedor {

    private Integer IDPROVEEDOR;
    private String RUC;
    private String NOMBREPROVEEDOR;
    private String DIRECCION;
    private String TELEFONO;
    private String EMAIL;
    private String ESTADO;

    public Proveedor() {
    }
    
    public Integer getIDPROVEEDOR() {
        return IDPROVEEDOR;
    }

    public void setIDPROVEEDOR(Integer IDPROVEEDOR) {
        this.IDPROVEEDOR = IDPROVEEDOR;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNOMBREPROVEEDOR() {
        return NOMBREPROVEEDOR;
    }

    public void setNOMBREPROVEEDOR(String NOMBREPROVEEDOR) {
        this.NOMBREPROVEEDOR = NOMBREPROVEEDOR;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

}
