package web.validator;

public class pagoValidator {

    String exTipoEntrega = "^.{1,255}$";
    String exdireccion = "^.{1,255}$";
    String exTipoCom = "^.{1,25}$";
    String exTipoTarjeta = "^.{1,25}$";
    String exRuc = "^[0-9]{11}$";
    String exRazon = "^.{1,255}$";
    String exDomLegal = "^.{1,255}$";
    String extitular = "^.{1,255}$";
    String exNumTarjeta = "^[0-9]{16}$";
    String exMes = "^[1-9]{1,2}$";
    String exYear = "^[0-9]{4}$";
    String exTipoDoc = "^.{1,255}$";
    String exCVV = "^[0-9]{3}$";
    String exDni = "^[0-9]{8,11}$";
    
    public String validarTipoEntrega(String te) {
        String mensaje = "";
        boolean resultado = te.matches(exTipoEntrega);
        if (!resultado) {
            mensaje = "Seleccione un Tipo de Entrega";
        }
        return mensaje;
    }

    public String validarDireccion(String dir) {
        String mensaje = "";
        boolean resultado = dir.matches(exdireccion);
        if (!resultado) {
            mensaje = "Ingrese la dirección";
        }
        return mensaje;
    }

    public String validarTipoCom(String tc) {
        String mensaje = "";
        boolean resultado = tc.matches(exTipoCom);
        if (!resultado) {
            mensaje = "Seleccione el tipo de comprobante";
        }
        return mensaje;
    }

    public String validarTipoTarjeta(String tt) {
        String mensaje = "";
        boolean resultado = tt.matches(exTipoTarjeta);
        if (!resultado) {
            mensaje = "Seleccione un tipo de tarjeta";
        }
        return mensaje;
    }

    public String validarRuc(String ruc) {
        String mensaje = "";
        boolean resultado = ruc.matches(exRuc);
        if (!resultado) {
            mensaje = "Ingrese el RUC";
        }
        return mensaje;
    }

    public String validarRazon(String razon) {
        String mensaje = "";
        boolean resultado = razon.matches(exRazon);
        if (!resultado) {
            mensaje = "Ingrese la Razón Social";
        }
        return mensaje;
    }

    public String validarDomLegal(String dir) {
        String mensaje = "";
        boolean resultado = dir.matches(exDomLegal);
        if (!resultado) {
            mensaje = "Ingrese la dirección";
        }
        return mensaje;
    }

    public String validarTitular(String tit) {
        String mensaje = "";
        boolean resultado = tit.matches(extitular);
        if (!resultado) {
            mensaje = "Ingrese el nombre del Titular";
        }
        return mensaje;
    }

    public String validarNumTarje(String numt) {
        String mensaje = "";
        boolean resultado = numt.matches(exNumTarjeta);
        if (!resultado) {
            mensaje = "Ingrese num. de tarjeta";
        }
        return mensaje;
    }

    public String validarMes(String mes) {
        String mensaje = "";
        boolean resultado = mes.matches(exMes);
        if (!resultado) {
            mensaje = "Selecciona el mes";
        }
        return mensaje;
    }

    public String validarYear(String year) {
        String mensaje = "";
        boolean resultado = year.matches(exYear);
        if (!resultado) {
            mensaje = "Selecciona el año";
        }
        return mensaje;
    }

    public String validarTipoDoc(String td) {
        String mensaje = "";
        boolean resultado = td.matches(exTipoDoc);
        if (!resultado) {
            mensaje = "Selecciona el tipo de documento";
        }
        return mensaje;
    }

    public String validarCvv(String cvv) {
        String mensaje = "";
        boolean resultado = cvv.matches(exCVV);
        if (!resultado) {
            mensaje = "Ingrese el código cvv";
        }
        return mensaje;
    }

    public String validarDni(String dni) {
        String mensaje = "";
        boolean resultado = dni.matches(exDni);
        if (!resultado) {
            mensaje = "Ingrese el DNI";
        }
        return mensaje;
    }

}
