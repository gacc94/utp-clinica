package web.validator;

public class UsuarioValidator {

    String exnombre = "^[a-zA-ZÀ-ÿ\\s]{1,100}$";
    String exapellido = "^[a-zA-ZÀ-ÿ\\s]{1,100}$";
    String expassword = "^.{4,100}$";
    String extelefono = "^[0-9]{7,14}$";
    String exemail = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String exdni = "^[0-9]{8,11}$";
    String exrol = "^[1-9]{1,15}$";
    String exdireccion = "^.{1,250}$";
    String extipo = "^[a-zA-ZÀ-ÿ\\s]{1,100}$";


    public String validarrol(String idrol) {
        String mensaje = "";
        boolean resultado = idrol.matches(exrol); //true
        if (!resultado) { //si me da falso
            mensaje = "Debe elegir un Rol";
        }
        return mensaje;
    }


    public String validarnombre(String texto) {
        String mensaje = "";
        boolean resultado = texto.matches(exnombre); //true
        if (!resultado) { //si me da falso
            mensaje = "El nombre solo debe contener letras y puede contener tildes.";
        }
        return mensaje;

    }

    public String validarapellido(String texto) { //validado apellido
        String mensaje = "";
        boolean resultado = texto.matches(exapellido); //true
        if (!resultado) { //si me da falso
            mensaje = "El apellido solo debe contener letras y puede contener tildes.";
        }
        return mensaje;

    }

    public String validarDni(String dni) { //valida DNI
        String mensaje = "";
        boolean resultado = dni.matches(exdni); //true
        if (!resultado) { //si me da falso
            mensaje = "El DNI o CE tiene que tener de 8 dígitos a 11 digitos y solo puede contener numeros.";
        }
        return mensaje;
    }

    public String validartelefono(String tel) { //validado telefono
        String mensaje = "";
        boolean resultado = tel.matches(extelefono); //true
        if (!resultado) { //si me da falso
            mensaje = "El telefono solo puede contener numeros y el maximo son 14 dígitos.";
        }
        return mensaje;
    }

    public String validarEmail(String correo) { //validado correo
        String mensaje = "";
        boolean resultado = correo.matches(exemail); //true
        if (!resultado) { //si me da falso
            mensaje = "El correo solo puede contener letras, numeros, puntos, guiones y guion bajo.";
        }
        return mensaje;
    }

    public String validarPass(String pass) { //validado Password
        String mensaje = "";
        boolean resultado = pass.matches(expassword); //true
        if (!resultado) { //si me da falso
            mensaje = "La clave ingresada tiene que ser de 4 a 12 dígitos.";
        }
        return mensaje;

    }

    public String validarDireccion(String direccion) {
        String mensaje = "";
        boolean resultado = direccion.matches(exdireccion); //true
        if (!resultado) { //si me da falso
            mensaje = "Ejemplo: Jr. Daniel Garcés 506 - San Juan De Miraflores";
        }
        return mensaje;

    }

    public String validarTipo(String tipo) {
        String mensaje = "";
        boolean resultado = tipo.matches(extipo); //true
        if (!resultado) { //si me da falso
            mensaje = "Debe Seleccionar DNI O CE";
        }
        return mensaje;

    }
    public String validarEstado(String estado){
        String mensaje = "";
        boolean resultado = estado.matches(exnombre); //true
        if (!resultado) { //si me da falso
            mensaje = "Debe Seleccionar un Estado";
        }
        return mensaje;
    }
    
    public static void main(String[] args) {
        UsuarioValidator usu = new UsuarioValidator();
         String resul = usu.validarDni("88888888");
        System.out.println(resul);
    }

}
