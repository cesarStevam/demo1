package co.edu.uniquindio.empresatransporte.demo1.services;

import co.edu.uniquindio.empresatransporte.demo1.model.Usuario;

public interface IUsuarioServices {
    boolean agregarUsuario(String nombre);
    Usuario obtenerUsuario(String nombre);
    boolean eliminarUsuario(String nombre);
    boolean actualizarUsuario(String nombre,String nuevoNombre);
}
