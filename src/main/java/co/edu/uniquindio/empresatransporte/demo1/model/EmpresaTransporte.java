package co.edu.uniquindio.empresatransporte.demo1.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.empresatransporte.demo1.services.IEmpresaTransportServices;

public class EmpresaTransporte implements IEmpresaTransportServices {

    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietario = new ArrayList<>();
    private List<Usuario> listaUsuario = new ArrayList<>();

    public EmpresaTransporte() {
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }
    public void setListaVehiculosCarga(List<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }
    public List<VehiculoPasajero> getListaVehiculosPasajeros() {
        return listaVehiculosPasajeros;
    }
    public void setListaVehiculosPasajeros(List<VehiculoPasajero> listaVehiculosPasajeros) {
        this.listaVehiculosPasajeros = listaVehiculosPasajeros;
    }
    public List<Propietario> getListaPropietarios() {
        return listaPropietario;
    }
    public void setlistaPropietario(List<Propietario> listaPropietario) {
        this.listaPropietario = listaPropietario;
    }
    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }
    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    //METODOS EXTRAS

    public void mostrarVehiculosCargaMayorEje(int numeroEjes) {
        for (Propietario propietario: getListaPropietarios()) {
            for (VehiculoCarga vehiculo: propietario.getListaVehiculosAsociados()) {
                if(vehiculo.getNumeroEjes() >= numeroEjes){
                    System.out.println(vehiculo.toString());
                }
            }
        }
    }
    public String buscarVehiculoCargaPlaca(String placa) {
        String resultado = "";
        for (VehiculoCarga vehiculo: getListaVehiculosCarga()) {
            if(vehiculo.getPlaca().equalsIgnoreCase(placa)){
                resultado = vehiculo.toString();
                break;
            }
        }

        return resultado;
    }
    public String buscarPropietarioNombre(String nombre) {
        String resultado = "";
        for (Propietario propietario: getListaPropietarios()) {
            if(propietario.getNombre().equalsIgnoreCase(nombre)){
                resultado = propietario.toString();
                break;
            }
        }

        return resultado;
    }
    public int imprimirCantidadPasajeros(String placa){
        int resultado = 0;
        for (VehiculoPasajero bus : listaVehiculosPasajeros) {
            if (bus.getPlaca().equalsIgnoreCase(placa)) {
                resultado = bus.getNumeroMaximoPasajeros();
                return resultado;
            }
        }
        return resultado;
    }
    public List<Propietario> imprimirPropietarioGordis(int minimo){
        List<Propietario> propietariosGordis = new ArrayList<>();
        for (Propietario propietario: getListaPropietarios()) {
            if (propietario.getPeso() > minimo){
                propietariosGordis.add(propietario);
            }
        }
        return propietariosGordis;
    }
    public int imprimirCantidadViejitos(int edadMinima){
        int resultado = 0;
        for (Propietario propietario: getListaPropietarios()) {
            if (propietario.getEdad() > edadMinima){
                resultado += 1;
            }
        }
        return resultado;
    }

    //CRUD PROPIETARIO

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int peso, int edad) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if(propietario == null){
            propietario = new Propietario();
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);
            propietario.setPeso(peso);
            propietario.setEdad(edad);
            getListaPropietarios().add(propietario);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        Propietario propietarioEncontrado = null;
        for (Propietario propietario: getListaPropietarios()) {
            if(propietario.getNumeroIdentificacion().equalsIgnoreCase(numeroIdentificacion)){
                propietarioEncontrado = propietario;
                break;
            }
        }
        return propietarioEncontrado;
    }
    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if(propietario != null){
            getListaPropietarios().remove(propietario);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionAntiguo, String numeroIdentificacion, String email, String numeroCelular, int peso, int edad) {
        Propietario propietario = obtenerPropietario(numeroIdentificacionAntiguo);
        if(propietario != null){
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);
            propietario.setPeso(peso);
            propietario.setEdad(edad);
            return true;
        }else{
            return false;
        }
    }

    //CRUD VEHICULO DE CARGA

    @Override
    public boolean agregarVehiculoCarga(String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes){
        VehiculoCarga vehiculoCarga = obtenerVehiculoCarga(placa);
        if (vehiculoCarga == null){
            vehiculoCarga = new VehiculoCarga();
            vehiculoCarga.setPlaca(placa);
            vehiculoCarga.setModelo(modelo);
            vehiculoCarga.setMarca(marca);
            vehiculoCarga.setColor(color);
            vehiculoCarga.setCapacidadCarga(capacidadCarga);
            vehiculoCarga.setNumeroEjes(numeroEjes);
            getListaVehiculosCarga().add(vehiculoCarga);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public VehiculoCarga obtenerVehiculoCarga(String placa){
        VehiculoCarga vehiculoCargaEncontrado = null;
        for (VehiculoCarga vehiculoCarga: getListaVehiculosCarga()){
            if(vehiculoCarga.getPlaca().equalsIgnoreCase(placa)){
                vehiculoCargaEncontrado = vehiculoCarga;
                break;
            }
        }
        return vehiculoCargaEncontrado;
    }
    @Override
    public boolean eliminarVehiculoCarga(String placa){
        VehiculoCarga vehiculoCargaEncontrado = obtenerVehiculoCarga(placa);
        if(vehiculoCargaEncontrado != null){
            getListaVehiculosCarga().remove(vehiculoCargaEncontrado);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean actualizarVehiculoCarga(String placa,String modelo,String marca, String colorAntiguo,String color,double capacidadCarga,int numeroEjes){
        VehiculoCarga vehiculoCarga = obtenerVehiculoCarga(placa);
        if (vehiculoCarga != null){
            vehiculoCarga.setPlaca(placa);
            vehiculoCarga.setModelo(modelo);
            vehiculoCarga.setMarca(marca);
            vehiculoCarga.setColor(color);
            vehiculoCarga.setCapacidadCarga(capacidadCarga);
            vehiculoCarga.setNumeroEjes(numeroEjes);
            return true;
        } else {
            return false;
        }
    }

    //CRUD VEHICULO DE PASAJEROS

    @Override
    public boolean agregarVehiculoPasajero(String placa,String modelo,String marca, String color,int numeroMaximoPasajeros){
        VehiculoPasajero vehiculoPasajero = obtenerVehiculoPasajero(placa);
        if (vehiculoPasajero == null){
            vehiculoPasajero = new VehiculoPasajero();
            vehiculoPasajero.setPlaca(placa);
            vehiculoPasajero.setModelo(modelo);
            vehiculoPasajero.setMarca(marca);
            vehiculoPasajero.setColor(color);
            vehiculoPasajero.setNumeroMaximoPasajeros(numeroMaximoPasajeros);
            getListaVehiculosPasajeros().add(vehiculoPasajero);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public VehiculoPasajero obtenerVehiculoPasajero(String placa){
        VehiculoPasajero vehiculoPasajeroEncontrado = null;
        for (VehiculoPasajero vehiculoPasajero: getListaVehiculosPasajeros()){
            if(vehiculoPasajero.getPlaca().equalsIgnoreCase(placa)){
                vehiculoPasajeroEncontrado = vehiculoPasajero;
                break;
            }
        }
        return vehiculoPasajeroEncontrado;
    }
    @Override
    public boolean eliminarVehiculoPasajero(String placa){
        VehiculoPasajero vehiculoPasajero = obtenerVehiculoPasajero(placa);
        if (vehiculoPasajero != null){
            getListaVehiculosPasajeros().remove(vehiculoPasajero);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean actualizarVehiculoPasajero(String placa,String modelo,String marca,String colorAntiguo,String color,int numeroMaximoPasajeros){
        VehiculoPasajero vehiculoPasajero = obtenerVehiculoPasajero(placa);
        if (vehiculoPasajero != null){
            vehiculoPasajero.setPlaca(placa);
            vehiculoPasajero.setModelo(modelo);
            vehiculoPasajero.setMarca(marca);
            vehiculoPasajero.setColor(color);
            vehiculoPasajero.setNumeroMaximoPasajeros(numeroMaximoPasajeros);
            return true;
        } else {
            return false;
        }
    }

    //CRUD USUARIO

    @Override
    public boolean agregarUsuario(String nombre){
        Usuario usuario = obtenerUsuario(nombre);
        if (usuario == null){
            usuario = new Usuario();
            usuario.setNombre(nombre);
            getListaUsuario().add(usuario);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Usuario obtenerUsuario(String nombre){
        Usuario usuarioEncontrado = null;
        for (Usuario usuario: getListaUsuario()){
            if (usuario.getNombre().equalsIgnoreCase(nombre)){
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }
    @Override
    public boolean eliminarUsuario(String nombre){
        Usuario usuario = obtenerUsuario(nombre);
        if (usuario == null){
            getListaUsuario().remove(usuario);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean actualizarUsuario(String nombre,String nuevoNombre){
        Usuario usuario = obtenerUsuario(nombre);
        if (usuario != null){
            usuario.setNombre(nuevoNombre);
            return true;
        } else {
            return false;
        }
    }
}