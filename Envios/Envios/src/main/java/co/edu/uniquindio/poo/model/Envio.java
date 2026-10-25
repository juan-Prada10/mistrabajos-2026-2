package co.edu.uniquindio.poo.model;

public abstract class Envio {

    private final String codigo;
    private String destinatario;
    protected int peso;
    private Empresa ownedByEmpresa;

    public Envio(String codigo, String destinatario, int peso, Empresa ownedByEmpresa){

        this.codigo=codigo;
        this.destinatario=destinatario;
        this.peso=peso;
        this.ownedByEmpresa=ownedByEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public int getPeso() {
        return peso;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public abstract float calcularCosto();
}
