package co.edu.uniquindio.poo.model;

public class DetalleFactura {

    private final int cantidadComprada;
    private final float subTotal;

    private final Factura ownedByFactura;
    private final Producto producto;
    public DetalleFactura(int cantidadComprada,float subTotal, Factura ownedByFactura,Producto producto){
        this.cantidadComprada=cantidadComprada;
        this.subTotal=subTotal;
        this.ownedByFactura=ownedByFactura;
        this.producto=producto;
    }

    public int getCantidadComprada(){
        return cantidadComprada;
    }

    public float getSubTotal(){
        return subTotal;
    }

    public Factura getOwnedByFactura(){
        return ownedByFactura;
    }

    public Producto getproducto(){
        return producto;
    }


    //Logica

    public double calcularSubTotal(Producto producto){
        return cantidadComprada* producto.getPrecio();
    }


}
