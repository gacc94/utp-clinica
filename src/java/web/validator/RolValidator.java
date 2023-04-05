/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.validator;

import dao.DaoRol;
import dao.impl.daoRolimpl;
import dto.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Usuario
 */
public class RolValidator {

    private final HttpServletRequest request;
    DaoRol daoRol;

    public RolValidator(HttpServletRequest request) {
        this.request = request;
        this.daoRol = new daoRolimpl();
    }

    public String rolSel() {
        String result = null;
        List<Rol> list = daoRol.rolSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoRol.getMensaje();
        }
        return result;
    }

    public String rolInsUpd(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");

        Integer IDROL = (request.getParameter("txtIDROL") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtIDROL"));

        String NOMBREROL = (request.getParameter("txtNOMBREROL") == null)
                ? null
                : String.valueOf(request.getParameter("txtNOMBREROL"));

        String DESCRIPCION = (request.getParameter("txtDESCRIPCION") == null)
                ? null
                : String.valueOf(request.getParameter("txtDESCRIPCION"));

       

       
        
        if (upd && NOMBREROL == null) {
            result.append("<li>Nombre de rol requerido</li>");
        }
        
        if (upd && DESCRIPCION == null) {
            result.append("<li>Descripcion requerido</li>");
        }

        
        Rol rol= new Rol();
        rol.setIDROL(IDROL);
        rol.setNOMBREROL(NOMBREROL);
        rol.setDESCRIPCION(DESCRIPCION);
       
        
        if (result.length() == 4) {
            String msg = upd
                    ? daoRol.rolUpd(rol)
                    : daoRol.rolIns(rol);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("rol", rol);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
        

    }
    
    public String rolGet() {
        String result = null;
        Integer id = Integer.valueOf(request.getParameter("id"));
        Rol rol = daoRol.rolGet(id);
        if (rol != null) {
            request.setAttribute("rol", rol);
        } else {
            result = daoRol.getMensaje();
        }
        return result;
    }
    
     public String rolDel() {

        List<Integer> ids = new ArrayList<>();
        String _ids = request.getParameter("ids");
        if (_ids != null) {
            String[] v_ids = _ids.split(",");
            for (String v_id : v_ids) {
                Integer id = Integer.valueOf(v_id);
                if (id != null) {
                    ids.add(id);
                } else {
                    ids = null;
                    break;
                }
            }
        }
        String result = (ids != null)
                ? daoRol.rolDel(ids)
                : "IDs incorrectos";
        return result;
    }

}
