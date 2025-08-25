package co.edu.uniquindio.empresatransporte.demo1;

import java.util.List;
import java.util.Scanner;

import co.edu.uniquindio.empresatransporte.demo1.factory.ModelFactory;
import co.edu.uniquindio.empresatransporte.demo1.model.Propietario;
import co.edu.uniquindio.empresatransporte.demo1.model.Usuario;
import co.edu.uniquindio.empresatransporte.demo1.model.VehiculoCarga;
import co.edu.uniquindio.empresatransporte.demo1.model.VehiculoPasajero;
import co.edu.uniquindio.empresatransporte.demo1.util.Constantes;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        //crudUsuario(modelFactory);
        //crudVehiculoPasajero(modelFactory);
        //crudPropietario(modelFactory);
        //crudVehiculoCarga(modelFactory);
        //buscarVehiculoCargaPlaca(modelFactory);
        //buscarPropietarioNombre(modelFactory);
        imprimirPropietariosGordis(modelFactory);
        imprimirCantidadPasajeros(modelFactory);
        imprimirCantidadViejitos(modelFactory);
    }

    //CRUD PROPIETARIO

    private static void crudPropietario(ModelFactory modelFactory) {
        agregarPropietario(modelFactory);
        obtenerPropietario(modelFactory);
        eliminarPropietario(modelFactory);
        actualizarPropietario(modelFactory);
    }

    private static void agregarPropietario(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese DNI: ");
        String numeroIdentificacion = sc.nextLine();
        System.out.print("Ingrese email: ");
        String email = sc.nextLine();
        System.out.print("Ingrese número de celular: ");
        String numeroCelular = sc.nextLine();
        System.out.println("Ingrese el peso del propietario: ");
        int peso = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese la edad del propietario: ");
        int edad = Integer.parseInt(sc.nextLine());
        boolean resultado = modelFactory.agregarPropietario(nombre, numeroIdentificacion, email, numeroCelular, peso, edad);
        if (resultado) {
            System.out.println("Propietario agregado correctamente.");
        } else {
            System.out.println("No se pudo agregar el propietario.");
        }
    }
    private static void obtenerPropietario(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el DNI del propietario a buscar: ");
        String numeroIdentificacion = sc.nextLine();
        Propietario propietario = modelFactory.obtenerPropietario(numeroIdentificacion);
        if(propietario != null){
            validarResultado(
                    propietario.toString(),
                    Constantes.PROPIETARIO_EXISTENTE+propietario.toString(),
                    Constantes.PROPIETARIO_NO_EXISTE);
        }
    }
    private static void eliminarPropietario(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el DNI del propietario a eliminar: ");
        String numeroIdentificacion = sc.nextLine();
        boolean resultado = modelFactory.eliminarPropietario(numeroIdentificacion);
        if (resultado) {
            System.out.println("Propietario eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el propietario.");
        }
    }
    private static void actualizarPropietario(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el NOMBRE del propietario: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el DNI del propietario a actualizar: ");
        String numeroIdentificacionAntiguo = sc.nextLine();
        System.out.println("Ingrese el nuevo DNI del propietario: ");
        String numeroIdentificacion = sc.nextLine();
        System.out.println("Ingrese el email del propietario: ");
        String email = sc.nextLine();
        System.out.print("Ingrese el NUMERO DEL CELULAR del propietario a actualizar: ");
        String numeroCelular = sc.nextLine();
        System.out.println("Ingrese el peso del propietario: ");
        int peso = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese la edad del propietario a actualizar: ");
        int edad = Integer.parseInt(sc.nextLine());
        boolean resultado = modelFactory.actualizarPropietario(
                nombre,
                numeroIdentificacionAntiguo,
                numeroIdentificacion,
                email,
                numeroCelular,
                peso,
                edad);
        if (resultado) {
            System.out.println("Propietario actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el propietario.");
        }
    }

    //CRUD VEHICULO CARGA

    private static void crudVehiculoCarga(ModelFactory modelFactory){
        agregarVehiculoCarga(modelFactory);
        obtenerVehiculoCarga(modelFactory);
        eliminarVehiculoCarga(modelFactory);
        actualizarVehiculoCarga(modelFactory);
    }

    private static void agregarVehiculoCarga(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la placa del vehiculo: ");
        String placa = sc.nextLine();
        System.out.print("Ingrese el modelo del vehiculo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese la marca del vehiculo: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese el color del vehiculo: ");
        String color = sc.nextLine();
        System.out.print("Ingrese la capacidad de carga del vehiculo: ");
        double capacidadCarga = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese la cantidad de ejes del vehiculo: ");
        int numeroEjes = Integer.parseInt(sc.nextLine());
        boolean resultado = modelFactory.agregarVehiculoCarga(placa,modelo,marca,color,capacidadCarga,numeroEjes);
        if (resultado) {
            System.out.println("Vehiculo creado correctamente.");
        } else {
            System.out.println("No se pudo crear el vehiculo.");
        }
    }
    private static void obtenerVehiculoCarga(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la placa del vehiculo a buscar: ");
        String placa = sc.nextLine();
        VehiculoCarga vehiculoCarga = modelFactory.obtenerVehiculoCarga(placa);
        if (vehiculoCarga != null) {
            System.out.println(vehiculoCarga.toString());
        }
    }
    private static void eliminarVehiculoCarga(ModelFactory modelFactory){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el placa del vehiculo de carga a eliminar: ");
        String placa = sc.nextLine();
        boolean resultado = modelFactory.eliminarVehiculoCarga(placa);
        if (resultado) {
            System.out.println("Vehiculo eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el vehiculo.");
        }
    }
    private static void actualizarVehiculoCarga(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la placa del vehiculo: ");
        String placa = sc.nextLine();
        System.out.print("Ingrese el modelo del vehiculo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese la marca del vehiculo: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese la color antiguo del vehiculo: ");
        String colorAntiguo = sc.nextLine();
        System.out.print("Ingrese la color nuevo del vehiculo: ");
        String color = sc.nextLine();
        System.out.print("Ingrese la capacidad de carga del vehiculo: ");
        double capacidadCarga = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese la cantidad de ejes del vehiculo: ");
        int numeroEjes = Integer.parseInt(sc.nextLine());
        boolean resultado = modelFactory.actualizarVehiculoCarga(placa,modelo,marca,colorAntiguo,color,capacidadCarga,numeroEjes);
        if (resultado) {
            System.out.println("Vehiculo actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el vehiculo.");
        }
    }

    //CRUD VEHICULO DE PASAJEROS

    private static void crudVehiculoPasajero(ModelFactory modelFactory) {
        agregarVehiculoPasajero(modelFactory);
        obtenerVehiculoPasajero(modelFactory);
        eliminarVehiculoPasajero(modelFactory);
        actualizarVehiculoPasajero(modelFactory);
    }

    private static void agregarVehiculoPasajero(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la placa del vehiculo: ");
        String placa = sc.nextLine();
        System.out.print("Ingrese el modelo del vehiculo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese la marca del vehiculo: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese el color del vehiculo: ");
        String color = sc.nextLine();
        System.out.print("Ingrese la capacidad maxima de pasajeros: ");
        int numeroMaximoPasajeros = Integer.parseInt(sc.nextLine());
        boolean resultado = modelFactory.agregarVehiculoPasajero(placa,modelo,marca,color,numeroMaximoPasajeros);
        if (resultado) {
            System.out.println("Vehiculo agregado correctamente.");
        } else {
            System.out.println("No se pudo agregar el vehiculo.");
        }
    }
    private static void obtenerVehiculoPasajero(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el placa del vehiculo: ");
        String placa = sc.nextLine();
        VehiculoPasajero vehiculoPasajero = modelFactory.obtenerVehiculoPasajero(placa);
        if (vehiculoPasajero != null) {
            System.out.println(vehiculoPasajero.toString());
        } else {
            System.out.println("No se pudo encontrar el vehiculo.");
        }
    }
    private static void eliminarVehiculoPasajero(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el placa del vehiculo: ");
        String placa = sc.nextLine();
        boolean resultado = modelFactory.eliminarVehiculoPasajero(placa);
        if (resultado) {
            System.out.println("Vehiculo eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el vehiculo.");
        }
    }
    private static void actualizarVehiculoPasajero(ModelFactory modelFactory){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la placa del vehiculo: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehiculo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la marca del vehiculo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese la color del vehiculo: ");
        String colorAntiguo = scanner.nextLine();
        System.out.print("Ingrese el color nuevo del vehiculo: ");
        String color = scanner.nextLine();
        System.out.println("Ingrese la capacidad maxima de pasajeros del vehiculo: ");
        int numeroMaximoPasajeros = Integer.parseInt(scanner.nextLine());
        boolean resultado = modelFactory.actualizarVehiculoPasajero(placa,modelo,marca,colorAntiguo,color,numeroMaximoPasajeros);
        if (resultado) {
            System.out.println("Vehiculo actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el vehiculo.");
        }
    }

    //CRUD USUARIO

    private static void crudUsuario(ModelFactory modelFactory) {
        agregarUsuario(modelFactory);
        obtenerUsuario(modelFactory);
        eliminarUsuario(modelFactory);
        actualizarUsuario(modelFactory);
    }

    private static void agregarUsuario(ModelFactory modelFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = sc.nextLine();
        boolean resultado = modelFactory.agregarUsuario(nombre);
        if (resultado) {
            System.out.println("Usuario agregado correctamente.");
        } else {
            System.out.println("No se pudo agregar el usuario.");
        }
    }
    private static void obtenerUsuario(ModelFactory modelFactory){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del usuario a buscar: ");
        String nombre = scanner.nextLine();
        Usuario usuario = modelFactory.obtenerUsuario(nombre);
        if (usuario != null) {
            System.out.println("Usuario encontrado correctamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
    private static void eliminarUsuario(ModelFactory modelFactory){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del usuario a eliminar: ");
        String nombre = sc.nextLine();
        boolean resultado = modelFactory.eliminarUsuario(nombre);
        if (resultado) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el usuario.");
        }
    }
    private static void actualizarUsuario(ModelFactory modelFactory){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del usuario a actualizar: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        boolean resultado = modelFactory.actualizarUsuario(nombre,nuevoNombre);
        if (resultado) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el usuario.");
        }
    }

    //METODOS EXTRAS

    private static void buscarPropietarioNombre(ModelFactory modelFactory) {
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        String resultado = modelFactory.buscarPropietarioNombre(nombre);
        validarResultado(
                resultado,
                Constantes.PROPIETARIO_EXISTENTE+resultado,
                Constantes.PROPIETARIO_NO_EXISTE);

    }
    private static void buscarVehiculoCargaPlaca(ModelFactory modelFactory) {
        Scanner scanner = new Scanner(System.in);
        String placa = scanner.nextLine();
        String resultado = modelFactory.buscarVehiculoCargaPlaca(placa);
        validarResultado(resultado, Constantes.VEHICULO_EXISTENTE+resultado, Constantes.VEHICULO_NO_EXISTE);
    }
    private static void imprimirCantidadPasajeros(ModelFactory modelFactory){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la placa del vehiculo a preguntar los pasajeros: ");
        String placa = sc.nextLine();
        int resultado = modelFactory.imprimirCantidadPasajeros(placa);
        if (resultado > 0){
            System.out.println("Cantidad de pasajeros: " + resultado);
        } else {
            System.out.println("No se encontro un vehiculo con esa placa");
        }
    }
    private static void imprimirPropietariosGordis(ModelFactory modelFactory){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el minimo de peso a buscar en los propietarios: ");
        int minimo = Integer.parseInt(sc.nextLine());
        List<Propietario> resultado = modelFactory.imprimirPropietarioGordis(minimo);
        if (resultado.isEmpty()){
            System.out.println("No se encontraron propietarios con peso superior a: " + minimo);
        } else {
            System.out.println("Propietarios con mayor peso a: " + minimo + ": ");
            for (Propietario propietariosGorditos : resultado){
                System.out.println(propietariosGorditos);
            }
        }
    }
    private static void imprimirCantidadViejitos(ModelFactory modelFactory){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el estandar de la edad a filtrar: ");
        int edadMinima = Integer.parseInt(sc.nextLine());
        int resultado = modelFactory.imprimirCantidadViejitos(edadMinima);
        System.out.println("Cantidad de viejitos: " + resultado);
    }
    private static void validarResultado(String resultado, String mensajeExitoso, String mensajeNoExitoso) {
        if (!resultado.equals("")) {
            System.out.println(mensajeExitoso);
        } else {
            System.out.println(mensajeNoExitoso);
        }
    }
}