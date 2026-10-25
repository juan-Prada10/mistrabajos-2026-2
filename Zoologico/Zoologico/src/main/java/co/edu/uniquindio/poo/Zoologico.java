package co.edu.uniquindio.poo;

public class Zoologico {

    private String nombre;

    private  final String direccion;

    public Zoologico(String nombre, String direccion){
        this.nombre=nombre;
        this.direccion=direccion;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;}
    public String getDireccion() {
        return direccion;
    }}
