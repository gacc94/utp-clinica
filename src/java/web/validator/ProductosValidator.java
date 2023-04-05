package web.validator;

public class ProductosValidator {

    String excodigo = "^.{4,100}$";
    String exmarca = "^[a-zA-ZÀ-ÿ\\s]{1,100}$";
    String exprecio = "^[0-9]+(?:\\.[0-9][0-9])?$";
    String exstock = "^[0-9]{1,15}$";
    String exdescripcion = "^.{4,255}$";
    String eximagen = "^.{1,100}$";

    public String validarCodigo(String codigo) { //validado
        String mensaje = "";
        boolean resultado = codigo.matches(excodigo);
        if (!resultado) {
            mensaje = "El codigo debe ser de minimo 4 dígitos.";
        }
        return mensaje;
    }

    public String validarMarca(String marca) { //validado
        String mensaje = "";
        boolean resultado = marca.matches(exmarca);
        if (!resultado) {
            mensaje = "Ingrese solo letras.";
        }
        return mensaje;
    }

    public String validarPrecio(String precio) {//validado
        String mensaje = "";
        boolean resultado = precio.matches(exprecio);
        if (!resultado) {
            mensaje = "Ingrese un dato valido. Ejm: 3.50";
        }
        return mensaje;
    }

    public String validarStock(String stock) { //validado
        String stockcad = String.valueOf(stock);
        String mensaje = "";
        boolean resultado = stockcad.matches(exstock);
        if (!resultado) {
            mensaje = "Ingrese una cantidad que sea mayor a 0";
        }
        return mensaje;
    }

    public String validarDescripcion(String descripcion) {//validado
        String mensaje = "";
        boolean resultado = descripcion.matches(exdescripcion);
        if (!resultado) {
            mensaje = "Debe ingresar una descripción";
        }
        return mensaje;
    }

    public String validarImagen(String imagen) {//validado
        String mensaje = "";
        boolean resultado = imagen.matches(eximagen);
        if (!resultado) {
            mensaje = "Debe elegir una imagen";
        }
        return mensaje;
    }

    public static void main(String[] args) {
        ProductosValidator pro = new ProductosValidator();
        String resul = pro.validarImagen("");
        System.out.println(resul);
    }
}
