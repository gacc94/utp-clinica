
package test;

import dao.impl.DaoUsuarioImpl;
import dao.impl.DaoUsuarioRegistroImpl;
import dto.Usuario;

public class TestLogin {
    
    public static void main(String[] args) {
        //validamos el registro
        DaoUsuarioRegistroImpl du = new DaoUsuarioRegistroImpl();
        DaoUsuarioImpl da = new DaoUsuarioImpl();
        Usuario user= new Usuario();
        
//        
//        user.setNombre("Alberto");
//        user.setApellido("Perez");
//        user.setDni("78675690");
//        user.setTipo_documento("dni");
//        user.setEmail("aperez@gmail.com");
//        user.setTelefono("978567456");
//        user.setPassword("78675690");
//        System.out.println("");
//        System.out.println(du.agregarUsuarioRegistro(user));
//         Validamos el Login
         String correo = "";
         String pass = "";
         user = du.usuarioLogin(correo, pass);
         System.out.println(user.getNombre());
         System.out.println(user.getPassword());
         System.out.println(user.getEstado());

         //Validamos la desencriptación de la contraseña
//         int id = 28;
//         user = da.listarxid(id);
//         System.out.println(user.getNombre());
//         System.out.println(user.getPassword());
         

    }
}
