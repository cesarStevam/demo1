package co.edu.uniquindio.empresatransporte.demo1.services;

import co.edu.uniquindio.empresatransporte.demo1.model.Propietario;

public interface IPropietarioServices {

    boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int peso, int edad);
    Propietario obtenerPropietario(String numeroIdentificacion);
    boolean eliminarPropietario(String numeroIdentificacion);
    boolean actualizarPropietario(String nombre, String numeroIdentificacionAntiguo, String numeroIdentificacion, String email, String numeroCelular, int peso, int edad);
}