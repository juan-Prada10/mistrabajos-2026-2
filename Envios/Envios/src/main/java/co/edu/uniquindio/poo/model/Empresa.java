package co.edu.uniquindio.poo.model;

import java.util.*;

public class Empresa {

    private final String nombre;
    private final String nit;
    private String telefono;

    private ArrayList<Envio> listaEnvios = new ArrayList<>();

    public Empresa(String nombre, String nit, String telefono){
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Envio> getListaEnvios() {
        return Collections.unmodifiableList(listaEnvios);
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setListaEnvios(ArrayList<Envio> listaEnvios) {
        this.listaEnvios = listaEnvios;
    }

    //CRUD

    public String registrarEnvio(Envio envio){
        Optional<Envio> envioEncontrado = buscarEnvio(envio.getCodigo());
        if (envioEncontrado.isPresent()){
            return "El envio ya existe";
        }else{
            listaEnvios.add(envio);
            return "Envio realizado con exito";
        }
    }

    public String eliminarEnvio(String codigo){
        Optional<Envio> envioEncontrado= buscarEnvio(codigo);
        if(envioEncontrado.isPresent()){
            listaEnvios.remove(envioEncontrado.get());
            return "El envio a sido eliminado con exito";
        }return "El envio no a sido registrado";
    }

    public String actualizarEnvioNacional(String codigo, String destino){
        Optional<Envio> envioEncontrado=buscarEnvio(codigo);
        if (envioEncontrado.isPresent()){
            if (envioEncontrado.get() instanceof EnvioNacional){
                ((EnvioNacional) envioEncontrado.get()).setCiudadDestino(destino);
                return "Envio actualizado con exito";
            }return "El envio a actualizar no es de tipo Nacional";
        }return "El envio no existe";
    }

    //Logica
    public Optional<Envio> buscarEnvio(String codigo){
        return listaEnvios.stream().filter(envio -> envio.getCodigo().equals(codigo)).findFirst();

    }

    public Boolean sepuedeActualizarEnvio(String codigo){
        Optional<Envio> envioEncontrado= buscarEnvio(codigo);
        if(envioEncontrado.isPresent()){
            return true;
        }return false;
    }

    public void mostrarListaEnvios(){
        if(listaEnvios.isEmpty()){
            System.out.println("No hay envios registrados");
        }else{
            for (Envio envio: listaEnvios){
                System.out.println(envio);
            }
        }
    }


}
