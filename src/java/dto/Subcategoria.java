package dto;

public class Subcategoria {
    private Integer IDSUBCATEGORIA;
    private Integer IDCATEGORIA;
    private String NOMBRESUBCATEGORIA;
    private String DESCRIPCIONSUBCATEGORIA;
    private String ESTADOSUBCAT;
    
    public Subcategoria(){
    }

    public Integer getIDSUBCATEGORIA() {
        return IDSUBCATEGORIA;
    }

    public void setIDSUBCATEGORIA(Integer IDSUBCATEGORIA) {
        this.IDSUBCATEGORIA = IDSUBCATEGORIA;
    }

    public Integer getIDCATEGORIA() {
        return IDCATEGORIA;
    }

    public void setIDCATEGORIA(Integer IDCATEGORIA) {
        this.IDCATEGORIA = IDCATEGORIA;
    }

    public String getNOMBRESUBCATEGORIA() {
        return NOMBRESUBCATEGORIA;
    }

    public void setNOMBRESUBCATEGORIA(String NOMBRESUBCATEGORIA) {
        this.NOMBRESUBCATEGORIA = NOMBRESUBCATEGORIA;
    }

    public String getDESCRIPCIONSUBCATEGORIA() {
        return DESCRIPCIONSUBCATEGORIA;
    }

    public void setDESCRIPCIONSUBCATEGORIA(String DESCRIPCIONSUBCATEGORIA) {
        this.DESCRIPCIONSUBCATEGORIA = DESCRIPCIONSUBCATEGORIA;
    }

    public String getESTADOSUBCAT() {
        return ESTADOSUBCAT;
    }

    public void setESTADOSUBCAT(String ESTADOSUBCAT) {
        this.ESTADOSUBCAT = ESTADOSUBCAT;
    }    
}
