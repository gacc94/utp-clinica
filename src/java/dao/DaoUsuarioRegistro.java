
package dao;

import dto.Usuario;


public interface DaoUsuarioRegistro {
    
    public boolean agregarUsuarioRegistro(Usuario ob);
    public Usuario usuarioLogin(String correo, String clave);
}
