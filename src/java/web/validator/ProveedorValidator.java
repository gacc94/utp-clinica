package web.validator;

import dao.DaoProveedor;
import dao.impl.DaoProveedorImpl;
import dto.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ProveedorValidator {

    private final HttpServletRequest request;
    DaoProveedor daoProveedor;

    public ProveedorValidator(HttpServletRequest request) {
        this.request = request;
        this.daoProveedor = new DaoProveedorImpl();
    }

    public String proveedorSel() {
        String result = null;
        List<Proveedor> list = daoProveedor.proveedorSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoProveedor.getMensaje();
        }
        return result;
    }

    public String proveedorInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer idproveedor = (request.getParameter("txtIdproveedor") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtIdproveedor"));
        String ruc = request.getParameter("txtRuc");
        String nombreProveedor = request.getParameter("txtNombre");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");
        String estado = request.getParameter("txtEstado");

//        Double precio = (request.getParameter("txtPrecio").length() == 0)
//                ? null
//                : Double.valueOf(request.getParameter("txtPrecio"));
        if (upd && idproveedor == null) {
            result.append("<li>Id requerido</li>");
        }
        if (ruc == null || ruc.trim().length() == 0) {
            result.append("<li>Ruc requerido</li>");
        } else if (ruc.trim().length() < 1 || ruc.trim().length() > 11) {
            result.append("<li>La dimensión del ruc debe estar entre")
                    .append(" 1 a 11 caracteres</li>");
        }
        if (nombreProveedor == null || nombreProveedor.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombreProveedor.trim().length() < 3 || nombreProveedor.trim().length() > 70) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append(" 3 a 70 caracteres</li>");
        }
        if (direccion == null || direccion.trim().length() == 0) {
            result.append("<li>Direccion requerida</li>");
        }
        if (telefono == null || telefono.trim().length() == 0) {
            result.append("<li>Telefono requerido</li>");
        }
        if (email == null || email.trim().length() == 0) {
            result.append("<li>Estado requerido</li>");
        }
        if (estado == null || estado.trim().length() == 0) {
            result.append("<li>Estado requerido</li>");
        }

        Proveedor proveedor = new Proveedor();
        proveedor.setIDPROVEEDOR(idproveedor);
        proveedor.setRUC(ruc);
        proveedor.setNOMBREPROVEEDOR(nombreProveedor);
        proveedor.setDIRECCION(direccion);
        proveedor.setTELEFONO(telefono);
        proveedor.setEMAIL(email);
        proveedor.setESTADO(estado);

        if (result.length() == 4) {
            String msg = upd
                    ? daoProveedor.proveedorUpd(proveedor)
                    : daoProveedor.proveedorIns(proveedor);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("proveedor", proveedor);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String proveedorGet() {
        String result = null;
        Integer id = Integer.valueOf(request.getParameter("id"));
        Proveedor proveedor = daoProveedor.proveedorGet(id);
        if (proveedor != null) {
            request.setAttribute("proveedor", proveedor);
        } else {
            result = daoProveedor.getMensaje();
        }
        return result;
    }

    public String proveedorDel() {

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
                ? daoProveedor.proveedorDel(ids)
                : "IDs incorrectos";
        return result;
    }
}
