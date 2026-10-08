package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.Habitacion;
import co.edu.uniquindio.poo.model.Hotel;
import co.edu.uniquindio.poo.model.Huesped;
import co.edu.uniquindio.poo.model.Reserva;
import java.util.ArrayList;
import javax.swing.*;

import model.Habitacion;
import model.Hotel;
import model.Huesped;
import model.Reserva;

public class main {

    public static void main(String[] args) {
        Hotel hotel = cargarDatos();
        int opcion = 0;

        JOptionPane.showMessageDialog(null,"======================================"+"\n"+
                "SISTEMA DE GESTIÓN HOTELERA"+"\n"+
                "======================================"+"\n"+
                "Hotel: " + hotel.getNombreComercial()+"\n"+
                "Hotel: " + hotel.getNombreComercial()+"\n"+
                "NIT: " + hotel.getNIT()+"\n"+
                "Teléfono: " + hotel.getTelefono()+"\n"+
                "======================================");


        while (opcion != 6) {
            mostrarMenu();
            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,"Seleccione una opcion: "));


            if (opcion == 1) {
                consultarHuespedPorTelefono(hotel, sc);
            } else if (opcion == 2) {
                reporteDisponibilidad(hotel);
            } else if (opcion == 3) {
                analizarMatrizOcupacion(hotel);
            } else if (opcion == 4) {
                identificarReservasCapicua(hotel);
            } else if (opcion == 5) {
                consultarIngresosPorFecha(hotel, sc);
            } else if (opcion == 6) {
                JOptionPane.showMessageDialog(null,"Sistema finalizado. Gracias por usar el sistema.");
            } else {
                JOptionPane.showMessageDialog(null,"Opción no válida. Intente de nuevo.");
            }
        }

        sc.close();
    }

    public static void mostrarMenu() {
        JOptionPane.showMessageDialog("======================================"+"\n                              "+
                "     SISTEMA DE GESTIÓN HOTELERA"+"\n"+
                "======================================"+"\n"+
                "1. Consultar huésped por teléfono"+"\n"+
                "2. Reporte de disponibilidad de habitaciones"+"\n"+
                "3. Análisis de matriz de ocupación semanal"+"\n"+
                "4. Identificar reservas especiales (Capicúa)"+"\n"+
                "5. Consultar ingresos por fecha"+"\n"+
                "6. Salir"+"\n"+
                "======================================");
    }

    public static Hotel cargarDatos() {
        Hotel hotel = new Hotel("Hotel StayPlus", "900.123.456-7", "Calle 10 # 5-40, Centro", 601234567);

        Huesped h1 = hotel.crearHuesped("123456789", "Carlos Gómez", (byte) 30, 300123456, "Bogotá");
        Huesped h2 = hotel.crearHuesped("987654321", "Ana López", (byte) 25, 300765432, "Medellín");
        Huesped h3 = hotel.crearHuesped("456789123", "Luis Pérez", (byte) 40, 310987654, "Cali");
        Huesped h4 = hotel.crearHuesped("789123456", "Marta Torres", (byte) 35, 315123987, "Barranquilla");
        Huesped h5 = hotel.crearHuesped("321654987", "Pedro Ramírez", (byte) 29, 320456789, "Cartagena");

        Habitacion ha1 = hotel.crearHabitacion(101, "Individual", "Piso 1", (byte) 2, 80000, "Disponible");
        Habitacion ha2 = hotel.crearHabitacion(102, "Doble", "Piso 1", (byte) 3, 150000, "Disponible");
        Habitacion ha3 = hotel.crearHabitacion(103, "Suite", "Piso 1", (byte) 4, 300000, "Disponible");
        Habitacion ha4 = hotel.crearHabitacion(104, "Individual", "Piso 1", (byte) 2, 90000, "Disponible");
        Habitacion ha5 = hotel.crearHabitacion(201, "Doble", "Piso 2", (byte) 3, 160000, "Disponible");
        Habitacion ha6 = hotel.crearHabitacion(202, "Individual", "Piso 2", (byte) 2, 95000, "Disponible");
        Habitacion ha7 = hotel.crearHabitacion(203, "Suite", "Piso 2", (byte) 4, 350000, "Mantenimiento");
        Habitacion ha8 = hotel.crearHabitacion(204, "Doble", "Piso 2", (byte) 3, 170000, "Disponible");
        Habitacion ha9 = hotel.crearHabitacion(205, "Doble", "Piso 2", (byte) 3, 165000, "Disponible");

        Reserva r1 = hotel.crearReserva("1221", "2026-09-20", (byte) 3, (byte) 2, "Confirmada", "Tarjeta", h1);
        r1.agregarHabitacion(ha1);

        Reserva r2 = hotel.crearReserva("2002", "2026-09-20", (byte) 2, (byte) 3, "Confirmada", "Efectivo", h2);
        r2.agregarHabitacion(ha2);
        r2.agregarHabitacion(ha5);

        Reserva r3 = hotel.crearReserva("1234", "2026-09-21", (byte) 1, (byte) 2, "Confirmada", "Tarjeta", h3);
        r3.agregarHabitacion(ha3);
        ha3.setEstadoActual("Ocupada");

        Reserva r4 = hotel.crearReserva("3456", "2026-09-21", (byte) 4, (byte) 1, "Confirmada", "Transferencia bancaria", h4);
        r4.agregarHabitacion(ha6);

        Reserva r5 = hotel.crearReserva("1001", "2026-09-22", (byte) 2, (byte) 2, "Confirmada", "Tarjeta", h5);
        r5.agregarHabitacion(ha4);

        Reserva r6 = hotel.crearReserva("5555", "2026-09-22", (byte) 1, (byte) 2, "Pendiente", "Efectivo", h1);
        r6.agregarHabitacion(ha8);

        Reserva r7 = hotel.crearReserva("4321", "2026-09-22", (byte) 2, (byte) 2, "Confirmada", "Tarjeta", h2);
        r7.agregarHabitacion(ha9);

        char[][] matriz = {
                { 'D', 'O', 'O', 'O', 'D', 'D', 'D' },
                { 'O', 'D', 'D', 'D', 'O', 'O', 'D' },
                { 'D', 'D', 'O', 'O', 'D', 'O', 'O' },
                { 'O', 'O', 'D', 'D', 'D', 'D', 'D' },
                { 'D', 'D', 'O', 'D', 'O', 'O', 'D' },
                { 'O', 'O', 'D', 'O', 'D', 'D', 'D' },
                { 'D', 'D', 'D', 'D', 'D', 'D', 'O' },
                { 'O', 'D', 'O', 'O', 'O', 'D', 'D' },
                { 'D', 'O', 'D', 'D', 'D', 'O', 'O' }
        };
        hotel.setMatrizOcupacion(matriz);

        return hotel;
    }

    public static void consultarHuespedPorTelefono(Hotel hotel, Scanner sc) {
        System.out.print("Ingrese el número de teléfono del huésped: ");
        int telefono = sc.nextInt();
        Huesped h = hotel.buscarHuespedPorTelefono(telefono);

        if (h == null) {
            System.out.println("No se encontró un huésped con el teléfono " + telefono + ".");
        } else {
            System.out.println();
            System.out.println("=== DATOS DEL HUÉSPED ===");
            System.out.println("Nombre: " + h.getNombreCompleto());
            System.out.println("Documento: " + h.getDocumentoIdentidad());
            System.out.println("Ciudad: " + h.getCiudadProcedencia());
            System.out.println();
            System.out.println("=== RESERVAS REALIZADAS ===");
            ArrayList<Reserva> reservas = hotel.obtenerReservasDeHuesped(h);
            if (reservas.size() == 0) {
                System.out.println("El huésped no tiene reservas registradas.");
            }
            for (int i = 0; i < reservas.size(); i++) {
                Reserva r = reservas.get(i);
                System.out.println("Código: " + r.getCodigoReserva()
                        + " | Fecha: " + r.getFechaReserva()
                        + " | Noches: " + r.getNumeroNoche()
                        + " | Estado: " + r.getEstadoReserva()
                        + " | Valor total: $" + (int) r.getValorTotal());
            }
        }
    }

    public static void reporteDisponibilidad(Hotel hotel) {
        System.out.println("=== REPORTE DE DISPONIBILIDAD ===");
        System.out.println("Habitaciones disponibles: " + hotel.getCantidadDisponibles());
        System.out.println("Habitaciones reservadas: " + hotel.getCantidadReservadas());
        System.out.println("Habitaciones ocupadas: " + hotel.getCantidadOcupadas());
        System.out.println("Habitaciones en mantenimiento: " + hotel.getCantidadMantenimiento());
        System.out.println();

        Habitacion mayor = hotel.getHabitacionMayorPrecio();
        Habitacion menor = hotel.getHabitacionMenorPrecio();

        System.out.println("Habitación con mayor precio por noche: " + mayor.getNumeroHabitacion()
                + " (" + mayor.getTipoHabitacion() + ") - $" + (int) mayor.getPrecioNoche());
        System.out.println("Habitación con menor precio por noche: " + menor.getNumeroHabitacion()
                + " (" + menor.getTipoHabitacion() + ") - $" + (int) menor.getPrecioNoche());
    }

    public static void analizarMatrizOcupacion(Hotel hotel) {
        char[][] matriz = hotel.getMatrizOcupacion();
        String[] dias = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

        System.out.println("=== MATRIZ DE OCUPACIÓN SEMANAL ===");
        System.out.print("            ");
        for (int j = 0; j < dias.length; j++) {
            System.out.print(dias[j] + "\t");
        }
        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Habitación " + hotel.getHabitaciones().get(i).getNumeroHabitacion() + "\t");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Día con mayor ocupación: " + dias[hotel.getDiaMayorOcupacion()]);
        System.out.println("Día con menor ocupación: " + dias[hotel.getDiaMenorOcupacion()]);
        System.out.println("Total de habitaciones ocupadas durante la semana: " + hotel.getTotalOcupadasSemana());
    }

    public static void identificarReservasCapicua(Hotel hotel) {
        System.out.println("=== RESERVAS ESPECIALES (CAPICÚA) ===");
        ArrayList<Reserva> especiales = hotel.getReservasEspeciales();

        if (especiales.size() == 0) {
            System.out.println("No se encontraron reservas con código capicúa.");
        }

        for (int i = 0; i < especiales.size(); i++) {
            Reserva r = especiales.get(i);
            System.out.println("Reserva " + r.getCodigoReserva() + " | Huésped: " + r.getHuesped().getNombreCompleto()
                    + " | Fecha: " + r.getFechaReserva()
                    + " | Valor total: $" + (int) r.getValorTotal());
        }

        if (especiales.size() > 0) {
            System.out.println();
            System.out.println("Total de reservas especiales: " + especiales.size());
        }
    }

    public static void consultarIngresosPorFecha(Hotel hotel, Scanner sc) {
        System.out.print("Ingrese la fecha a consultar (AAAA-MM-DD): ");
        String fecha = sc.next();
        System.out.println("=== INGRESOS DEL " + fecha + " ===");
        System.out.println("Reservas encontradas: " + hotel.getCantidadReservasPorFecha(fecha));
        System.out.println("Ingreso total del día: $" + (int) hotel.getIngresosPorFecha(fecha));
    }
}
