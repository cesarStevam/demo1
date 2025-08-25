package co.edu.uniquindio.empresatransporte.demo1.services;

public interface IModelFactoryServices extends IPropietarioServices{

    String buscarVehiculoCargaPlaca(String placa);
    String buscarPropietarioNombre(String nombre);
    int imprimirCantidadPasajeros(String placa);
}