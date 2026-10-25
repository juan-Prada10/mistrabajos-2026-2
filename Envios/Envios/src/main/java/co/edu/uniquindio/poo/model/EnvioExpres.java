package co.edu.uniquindio.poo.model;

import java.time.LocalTime;

public class EnvioExpres extends EnvioNacional{

    private int horaMaxima;

    public EnvioExpres(String codigo, String destinatario, int peso,Empresa ownedByEmpresa,String ciudadDestino,boolean domicilio, int horaMaxima){
        super(codigo,destinatario,peso,ownedByEmpresa,ciudadDestino,domicilio);
        this.horaMaxima=horaMaxima;
    }

    public int getHoraMaxima() {
        return horaMaxima;
    }

    public void setHoraMaxima(byte horaMaxima) {
        this.horaMaxima = horaMaxima;
    }

    @Override
    public float calcularCosto() {
        float costoTotal=(super.calcularCosto() * 1.30f);
        if(horaMaxima<=24){
            return costoTotal+=5000;
        }
        return costoTotal;
    }


}
