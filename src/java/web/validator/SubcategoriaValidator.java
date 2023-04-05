package web.validator;

import dao.DaoSubcategoria;
import dao.impl.DaoSubcategoriaImpl;
import dto.Subcategoria;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SubcategoriaValidator {
    private final HttpServletRequest request;
    DaoSubcategoria daoSubcategoria;

    public SubcategoriaValidator(HttpServletRequest request) {
        this.request = request;
        this.daoSubcategoria = new DaoSubcategoriaImpl();
    }

    public String subcategoriaSel() {
        String result = null;
        List<Subcategoria> lista = daoSubcategoria.subcategoriaSel();
        if (lista != null) {
            request.setAttribute("lista", lista);
        } else {
            result = daoSubcategoria.getMensaje();
        }
        return result;
    }
    
    public String subcategoriaInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer idsubcategoria = (request.getParameter("txtIDSUBCATEGORIA") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtIDSUBCATEGORIA"));
        Integer idcategoria = (request.getParameter("txtIDCATEGORIA") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtIDCATEGORIA"));
        String nombre = request.getParameter("txtNOMBRESUBCATEGORIA");
        String descripcion = request.getParameter("txtDESCRIPCIONSUBCATEGORIA");
        String estado = request.getParameter("txtESTADOSUBCAT");
        
        if (upd && idsubcategoria == null) {
            result.append("<li>IDSUBCATEGORIA requerido</li>");
        }
        if (upd && idcategoria == null) {
            result.append("<li>IDCATEGORIA requerido</li>");
        }
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append(" 3 a 50 caracteres</li>");
        }
        if (descripcion == null || descripcion.trim().length() == 0) {
            result.append("<li>Descripcion requerida</li>");
        }
        if (estado == null || estado.trim().length() == 0) {
            result.append("<li>Estado requerida</li>");
        }

        Subcategoria subcategoria = new Subcategoria();
        subcategoria.setIDSUBCATEGORIA(idsubcategoria);
        subcategoria.setIDCATEGORIA(idcategoria);
        subcategoria.setNOMBRESUBCATEGORIA(nombre);
        subcategoria.setDESCRIPCIONSUBCATEGORIA(descripcion);
        subcategoria.setESTADOSUBCAT(estado);

        if (result.length() == 4) {
            String msg = upd
                    ? daoSubcategoria.subcategoriaUpd(subcategoria)
                    : daoSubcategoria.subcategoriaIns(subcategoria);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("subcategoria", subcategoria);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String subcategoriaGet() {
        String result = null;
        Integer id = Integer.valueOf(request.getParameter("id"));
        Subcategoria subcategoria = daoSubcategoria.subcategoriaGet(id);
        if (subcategoria != null) {
            request.setAttribute("subcategoria", subcategoria);
        } else {
            result = daoSubcategoria.getMensaje();
        }
        return result;
    }

    public String subcategoriaDel() {

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
                ? daoSubcategoria.subcategoriaDel(ids)
                : "IDs incorrectos";
        return result;
    }
}
