package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Empresa empresa = new Empresa("Mensajería Express S.A.S", "900123456-7", "3001234567");

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = ingresarNumeroEntero("Seleccione una opción: ");
            System.out.println();
            switch (opcion) {
                case 1 -> registrarNacional();
                case 2 -> registrarInternacional();
                case 3 -> registrarExpres();
                case 4 -> listarEnvios();
                case 5 -> buscarEnvio();
                case 6 -> eliminarEnvio();
                case 0 -> System.out.println("Hasta pronto.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }


    private static void mostrarMenu() {
        System.out.println("\n===== " + empresa.getNombre() + " =====");
        System.out.println("1. Registrar envío nacional");
        System.out.println("2. Registrar envío internacional");
        System.out.println("3. Registrar envío exprés");
        System.out.println("4. Listar envíos");
        System.out.println("5. Buscar envío por código");
        System.out.println("6. Eliminar envío");
        System.out.println("0. Salir");
    }




    public static void registrarInternacional() {
        String codigo = ingresarTexto("Ingrese el codigo");
        if (codigo == null) return;
        String destinatario = ingresarTexto("Destinatario: ");
        int peso = ingresarNumeroEntero("Ingrese el peso");
        String pais = ingresarTexto("País de destino: ");
        boolean seguro = ingresarBooleano("¿Incluye seguro? (s/n): ");

        Envio envio = new EnvioInternacional(codigo, destinatario, peso, empresa, pais, seguro);
        System.out.println(empresa.registrarEnvio(envio));
        System.out.printf("Costo: $%,.0f%n", envio.calcularCosto());
    }

    public static void registrarExpres() {
        String codigo = ingresarTexto("Ingrese el codigo");
        if (codigo == null) return;
        String destinatario = ingresarTexto("Destinatario: ");
        int peso = ingresarNumeroEntero("Ingrese el peso");
        String ciudad = ingresarTexto("Ciudad de destino: ");
        boolean domicilio = ingresarBooleano("¿Requiere domicilio? (s/n): ");
        int horas = ingresarNumeroEntero("Horas máximas de entrega: ");

        Envio envio = new EnvioExpres(codigo, destinatario, peso, empresa, ciudad, domicilio, horas);
        System.out.println(empresa.registrarEnvio(envio));
        System.out.printf("Costo: $%,.0f%n", envio.calcularCosto());
    }

    public static void registrarNacional(){
        String codigo= ingresarTexto("Ingrese el codigo");
        if (codigo==null)return;
        String destinatario=ingresarTexto("Ingrese el destinatario");
        int peso=ingresarNumeroEntero("Ingrese el peso");
        String ciudad = ingresarTexto("Ingrese la ciudad de destino");
        boolean domicilio= ingresarBooleano("Requiere domicilio?");

        Envio envio= new EnvioNacional(codigo,destinatario,peso, empresa,ciudad,domicilio);
        empresa.registrarEnvio(envio);
        System.out.printf("costo: $%,.0f%n", envio.calcularCosto() );
    }

    public static int ingresarNumeroEntero(String mensaje){
        Scanner scanner= new Scanner(System.in);
        System.out.println(mensaje);
        int numero = scanner.nextInt();
        return numero;
    }

    public static String ingresarTexto(String mensaje){
        Scanner scanner= new Scanner(System.in);
        System.out.println(mensaje);
        String texto= scanner.nextLine();
        return texto;
    }

    public static Boolean ingresarBooleano(String mensaje){
        Scanner scanner= new Scanner(System.in);
        System.out.println(mensaje);
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("si")){
            return true;
        }return false;
    }

    public static void listarEnvios(){
        empresa.mostrarListaEnvios();
    }

    public static void buscarEnvio(){
        String codigo= ingresarTexto("Ingrese el codigo del envio");
        Optional<Envio> envio=empresa.buscarEnvio(codigo);
        if(envio.isPresent()) {
            System.out.print(envio.get());
        }else{System.out.println("El envio no existe");}
    }

    public static void eliminarEnvio(){
        String codigo=ingresarTexto("Ingrese el codigo del envio a eliminar");
        Optional<Envio> envio= empresa.buscarEnvio(codigo);
        if(envio.isEmpty()){
            System.out.println("El envio no existe");
        }else{empresa.eliminarEnvio(codigo);
        System.out.println("El envio fue eliminado con exito");}
        }
}



