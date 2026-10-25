package co.edu.uniquindio.poo.model;

public class EnvioInternacional extends Envio{

    private String paisDestino;
    private boolean seguro;

    public EnvioInternacional(String codigo, String destinatario, int peso,Empresa ownedByEmpresa, String paisDestino, boolean seguro){
        super(codigo,destinatario,peso,ownedByEmpresa);
        this.paisDestino=paisDestino;
        this.seguro=seguro;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    @Override
    public float calcularCosto() {
        float costobase = 15000;
        float costoTotal=costobase+(9000*getPeso());
        return seguro ? costoTotal+=20000 : costoTotal;
    }
}
