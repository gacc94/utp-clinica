/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Usuario
 */
public class Rol {
    private Integer IDROL;
    private String NOMBREROL;
    private String DESCRIPCION;


    public Rol() {
    }

    public Integer getIDROL() {
        return IDROL;
    }

    public void setIDROL(Integer IDROL) {
        this.IDROL = IDROL;
    }

    public String getNOMBREROL() {
        return NOMBREROL;
    }

    public void setNOMBREROL(String NOMBREROL) {
        this.NOMBREROL = NOMBREROL;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    
    
}
