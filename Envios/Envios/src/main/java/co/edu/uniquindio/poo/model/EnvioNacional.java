package co.edu.uniquindio.poo.model;

public class EnvioNacional extends Envio{

    private String ciudadDestino;
    private boolean domicilio;

    public EnvioNacional(String codigo, String destinatario, int peso, Empresa ownedByEmpresa, String ciudadDestino, boolean domicilio) {
        super(codigo, destinatario, peso, ownedByEmpresa);
        this.ciudadDestino = ciudadDestino;
        this.domicilio = domicilio;
    }

    public String getCiudadDestino(){
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino){
        this.ciudadDestino=ciudadDestino;
    }

    public boolean getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(boolean domicilio) {
        this.domicilio = domicilio;
    }


    @Override
    public float calcularCosto() {
        float costoTotal=6000+(peso * 2000);
        return domicilio ? costoTotal+=3000 : costoTotal;
    }
}

