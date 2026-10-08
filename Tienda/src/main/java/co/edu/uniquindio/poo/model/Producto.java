package co.edu.uniquindio.poo.model;
import java.util.ArrayList;

public class Producto {
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private final float precio;
    private int cantidadDisponible;

    private Tienda ownedByTienda;
    private Categoria categoria;

    public Producto(String codigo,String nombre,String descripcion,float precio,
                    int cantidadDisponible,Categoria categoria,Tienda ownedByTienda){
        this.codigo=codigo;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.cantidadDisponible=cantidadDisponible;
        this.ownedByTienda=ownedByTienda;
        this.categoria=categoria;

    }

    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public float getPrecio(){
        return precio;
    }

    public int getCantidadDisponible(){
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible){
        this.cantidadDisponible=cantidadDisponible;
    }
}
