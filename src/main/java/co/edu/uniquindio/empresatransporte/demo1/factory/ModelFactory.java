package co.edu.uniquindio.empresatransporte.demo1.factory;

import co.edu.uniquindio.empresatransporte.demo1.model.*;
import co.edu.uniquindio.empresatransporte.demo1.services.*;

import java.util.List;

public class ModelFactory implements IPropietarioServices, IModelFactoryServices, IVehiculoCargaServices, IVehiculoPasajeroServices, IUsuarioServices {

    private static ModelFactory modelFactory;
    private EmpresaTransporte empresaTransporte;

    private ModelFactory(){
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }

        return modelFactory;
    }


    private void inicializarDatos() {
        empresaTransporte = new EmpresaTransporte();
        Propietario propietario1 = new Propietario();
        propietario1.setNombre("Pedro");
        propietario1.setPeso(57);
        propietario1.setEdad(45);
        propietario1.setNumeroIdentificacion("978978798");
        Propietario propietario2 = new Propietario();
        propietario2.setNombre("Ana");
        propietario2.setPeso(85);
        propietario2.setEdad(49);
        propietario2.setNumeroIdentificacion("234242323");
        VehiculoCarga vehiculoCarga1 = new VehiculoCarga();
        vehiculoCarga1.setPlaca("RRD098");
        vehiculoCarga1.setNumeroEjes(5);
        VehiculoCarga vehiculoCarga2 = new VehiculoCarga();
        vehiculoCarga2.setPlaca("XXX096");
        vehiculoCarga2.setNumeroEjes(3);
        VehiculoCarga vehiculoCarga3 = new VehiculoCarga();
        vehiculoCarga3.setPlaca("77X096");
        vehiculoCarga3.setNumeroEjes(5);
        VehiculoPasajero vehiculoPasajero1 = new VehiculoPasajero();
        vehiculoPasajero1.setPlaca("WER098");
        vehiculoPasajero1.setNumeroMaximoPasajeros(25);
        propietario1.setVehiculo(vehiculoCarga1);
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga2);
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga3);
        propietario2.setVehiculo(vehiculoCarga2);
        empresaTransporte.getListaPropietarios().add(propietario1);
        empresaTransporte.getListaPropietarios().add(propietario2);
        empresaTransporte.getListaVehiculosCarga().add(vehiculoCarga1);
        empresaTransporte.getListaVehiculosCarga().add(vehiculoCarga2);
        empresaTransporte.getListaVehiculosCarga().add(vehiculoCarga3);
        empresaTransporte.getListaVehiculosPasajeros().add(vehiculoPasajero1);
    }

    //METODOS EXTRAS

    @Override
    public String buscarVehiculoCargaPlaca(String placa) {
        return empresaTransporte.buscarVehiculoCargaPlaca(placa);
    }
    @Override
    public String buscarPropietarioNombre(String nombre) {
        return empresaTransporte.buscarPropietarioNombre(nombre);
    }
    public int imprimirCantidadPasajeros(String placa){
        return empresaTransporte.imprimirCantidadPasajeros(placa);
    }
    public List<Propietario> imprimirPropietarioGordis(int minimo){
        return empresaTransporte.imprimirPropietarioGordis(minimo);
    }
    public int imprimirCantidadViejitos(int edadMinima){
        return empresaTransporte.imprimirCantidadViejitos(edadMinima);
    }

    //CRUD PROPIETARIO

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int peso, int edad) {
        return empresaTransporte.agregarPropietario(nombre, numeroIdentificacion, email, numeroCelular, peso, edad);
    }
    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        return empresaTransporte.obtenerPropietario(numeroIdentificacion);
    }
    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        return empresaTransporte.eliminarPropietario(numeroIdentificacion);
    }
    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionAntiguo, String numeroIdentificacion, String email, String numeroCelular, int peso, int edad) {
        return empresaTransporte.actualizarPropietario(nombre,numeroIdentificacionAntiguo,numeroIdentificacion,email,numeroCelular,peso,edad);
    }

    //CRUD VEHICULO DE CARGA

    @Override
    public boolean agregarVehiculoCarga(String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes){
        return empresaTransporte.agregarVehiculoCarga(placa,modelo,marca,color,capacidadCarga,numeroEjes);
    }
    @Override
    public VehiculoCarga obtenerVehiculoCarga(String placa){
        return empresaTransporte.obtenerVehiculoCarga(placa);
    }
    @Override
    public boolean eliminarVehiculoCarga(String placa){
        return empresaTransporte.eliminarVehiculoCarga(placa);
    }
    @Override
    public boolean actualizarVehiculoCarga(String placa,String modelo,String marca, String colorAntiguo,String color,double capacidadCarga,int numeroEjes){
        return empresaTransporte.actualizarVehiculoCarga(placa,modelo,marca,colorAntiguo,color,capacidadCarga,numeroEjes);
    }

    //CRUD VEHICULO DE PASAJEROS

    @Override
    public boolean agregarVehiculoPasajero(String placa, String modelo, String marca,String color,int numeroMaximoPasajeros){
        return empresaTransporte.agregarVehiculoPasajero(placa,modelo,marca,color,numeroMaximoPasajeros);
    }
    @Override
    public VehiculoPasajero obtenerVehiculoPasajero(String placa){
        return empresaTransporte.obtenerVehiculoPasajero(placa);
    }
    @Override
    public boolean eliminarVehiculoPasajero(String placa){
        return empresaTransporte.eliminarVehiculoPasajero(placa);
    }
    @Override
    public boolean actualizarVehiculoPasajero(String placa,String modelo,String marca,String colorAntiguo,String color,int numeroMaximoPasajeros){
        return empresaTransporte.actualizarVehiculoPasajero(placa,modelo,marca,colorAntiguo,color,numeroMaximoPasajeros);
    }

    //CRUD USUARIO

    @Override
    public boolean agregarUsuario(String nombre){
        return empresaTransporte.agregarUsuario(nombre);
    }
    @Override
    public Usuario obtenerUsuario(String nombre) {
        return empresaTransporte.obtenerUsuario(nombre);
    }
    @Override
    public boolean eliminarUsuario(String nombre){
        return empresaTransporte.eliminarUsuario(nombre);
    }
    @Override
    public boolean actualizarUsuario(String nombre,String nuevoNombre){
        return empresaTransporte.actualizarUsuario(nombre, nuevoNombre);
    }
}