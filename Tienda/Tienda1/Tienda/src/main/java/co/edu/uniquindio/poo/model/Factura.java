package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate fechaGeneracion, double total,
                      MetodoPago metodoPago, Cliente cliente, EstadoFactura estadoFactura,
                      ArrayList<DetalleFactura> listaDetalleFactura, Tienda ownedByTienda) {
}
