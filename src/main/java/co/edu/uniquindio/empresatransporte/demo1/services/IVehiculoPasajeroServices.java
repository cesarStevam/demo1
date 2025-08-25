package co.edu.uniquindio.empresatransporte.demo1.services;

import co.edu.uniquindio.empresatransporte.demo1.model.VehiculoPasajero;

public interface IVehiculoPasajeroServices {

    VehiculoPasajero obtenerVehiculoPasajero(String placa);
    boolean agregarVehiculoPasajero(String placa, String modelo, String marca,String color,int numeroMaximoPasajeros);
    boolean eliminarVehiculoPasajero(String placa);
    boolean actualizarVehiculoPasajero(String placa,String modelo,String marca,String colorAntiguo,String color,int numeroMaximoPasajeros);
}
