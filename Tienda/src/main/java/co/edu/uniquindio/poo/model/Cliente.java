package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private final String documento;
    private final String nombreCompleto;
    private final String telefono;
    private final String correo;
    private final String ciudadRecidencia;
    private final Tienda ownedByTienda;
    private final List<Factura>listaFacturas;

    public Cliente(String documento, String nombreCompleto,String telefono,String correo,String ciudadRecidencia,Tienda ownedByTienda){
        this.documento= documento;
        this.nombreCompleto=nombreCompleto;
        this.telefono=telefono;
        this.correo=correo;
        this.ciudadRecidencia=ciudadRecidencia;
        this.ownedByTienda=ownedByTienda;
        this.listaFacturas= new ArrayList<>();
    }

    public String getDocumento(){
        return documento;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getCorreo(){
        return correo;
    }

    public String getCiudadRecidencia(){
        return ciudadRecidencia;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public List<Factura> getListaFacturas(){
        return listaFacturas;
    }
}
