package web.validator;

import dao.DaoCategoria;
import dao.impl.DaoCategoriaImpl;
import dto.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class CategoriaValidator {
    private final HttpServletRequest request;
    DaoCategoria daoCategoria;

    public CategoriaValidator(HttpServletRequest request) {
        this.request = request;
        this.daoCategoria = new DaoCategoriaImpl();
    }

    public String categoriaSel() {
        String result = null;
        List<Categoria> list = daoCategoria.categoriaSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoCategoria.getMensaje();
        }
        return result;
    }
    
    public String categoriaInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer idcategoria = (request.getParameter("txtIDCATEGORIA") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtIDCATEGORIA"));
        String nombre = request.getParameter("txtNOMBRE");
        String descripcion = request.getParameter("txtDESCRIPCION");
        String estado = request.getParameter("txtESTADOCAT");
        
        if (upd && idcategoria == null) {
            result.append("<li>IDSUBCATEGORIA requerido</li>");
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

        Categoria categoria = new Categoria();
        categoria.setIDCATEGORIA(idcategoria);
        categoria.setNOMBRE(nombre);
        categoria.setDESCRIPCION(descripcion);
        categoria.setESTADOCAT(estado);

        if (result.length() == 4) {
            String msg = upd
                    ? daoCategoria.categoriaUpd(categoria)
                    : daoCategoria.categoriaIns(categoria);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("categoria", categoria);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String categoriaGet() {
        String result = null;
        Integer id = Integer.valueOf(request.getParameter("id"));
        Categoria categoria = daoCategoria.categoriaGet(id);
        if (categoria != null) {
            request.setAttribute("categoria", categoria);
        } else {
            result = daoCategoria.getMensaje();
        }
        return result;
    }

    public String categoriaDel() {

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
                ? daoCategoria.categoriaDel(ids)
                : "IDs incorrectos";
        return result;
    }
}
