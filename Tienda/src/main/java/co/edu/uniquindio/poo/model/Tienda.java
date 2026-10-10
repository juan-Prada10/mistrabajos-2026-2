package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.*;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

public class Tienda {

    private final String nombre;
    private final String nit;
    private final String telefono;

    private final ArrayList<Cliente> listaClientes= new ArrayList<>();
    private final List<Factura> listaFacturas= new LinkedList<>();
    private Map<String,Producto> listaProductos= new HashMap<>();

    public Tienda(String nombre, String nit,String telefono){
        this.nombre=nombre;
        this.nit=nit;
        this.telefono=telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNit(){
        return nit;
    }

    public String getTelefono(){
        return telefono;
    }

    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }

    public List<Factura> getListaFacturas(){
        return listaFacturas;
    }

    public Map<String, Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Map<String,Producto> listaProductos){
        this.listaProductos=listaProductos;
    }

    //CRUD
    //Registros

    public String registrarCliente(Cliente cliente){
       Optional<Cliente> clienteEncontrado=buscarCliente(cliente.getDocumento());
       if(clienteEncontrado.isPresent()){
           return "El cliente ya se encuentra registrado";
       }else{
           listaClientes.add(cliente);
           return "Cliente registrado con exito";
       }
    }

    public String registrarProducto(Producto producto){
        Optional<Producto> productoEncontrado=buscarProducto(producto.getCodigo());
        if(productoEncontrado.isPresent()){
            return "Producto ya registrado";
        }else {
            listaProductos.put(producto.getCodigo(), producto);
            return "Producto registrado con exito";
        }
    }

    public String registrarFactura(Factura factura){
        Optional<Factura> facturaEncontrada=buscarFactura(factura.codigo());
        if(facturaEncontrada.isPresent()){
            return "La factura ya fue registrada anteriormente";
        }else{
            listaFacturas.add(factura);
            return "Factura generada con exito";
        }
    }

    //Eliminaciones

    public String eliminarCliente(Cliente cliente){
        Optional<Cliente> clienteEncontrado=buscarCliente(cliente.getDocumento());
        if(clienteEncontrado.isPresent()){
            listaClientes.remove(cliente);
            return "Cliente eliminado con exito";
        }else{
            return "El cliente no se encuentra registrado";
        }
    }

    public String eliminarProducto(Producto producto) {
        Optional<Producto> productoEncontrado = buscarProducto(producto.getCodigo());
        if (productoEncontrado.isPresent()) {
            listaProductos.remove(productoEncontrado.get());
            return "Producto eliminado con exito";
        } else {
            return "El producto no esta registrado";
        }
    }

    public String eliminarFactura(Factura factura){
        Optional<Factura> facturaEncontrada=buscarFactura(factura.codigo());
        if(facturaEncontrada.isPresent()){
            listaFacturas.remove(factura);
            return "Factura eliminada con exito";
        }else{
            return "La factura que se desea eliminar no a sido registrada";
        }
    }
    //Actualizaciones

    public String actualizarProducto(Producto producto,int cantidad){
        Optional<Producto> productoEncontrado=buscarProducto(producto.getCodigo());
        if(productoEncontrado.isPresent()){
            producto=productoEncontrado.get();
            producto.setCantidadDisponible(cantidad);
            return "Actualizado con exito";
        }
        return "El producto no se encuentra registrado";
    }
    //Logica

    public Optional<Cliente> buscarCliente (String documento) {
        return listaClientes.stream().filter(cliente ->cliente.getDocumento().equals(documento)).findFirst();
    }

    public Optional<Producto> buscarProducto(String codigo){
        return listaProductos.values().stream().filter(producto -> producto.getCodigo().equals(codigo)).findFirst();
    }

    public Optional<Factura> buscarFactura(String codigo){
        return listaFacturas.stream().filter(factura -> factura.codigo().equals(codigo)).findFirst();
    }























    //punto 1. Obtener la lista de los productos con una cantidad disponible mayor igual a 10
    public List<Producto> productoMayoresDiez(){
        List<Producto> productoAdecuado = new ArrayList<>();
        for(Producto productosBuenos : listaProductos.values()){
            if(productosBuenos.getCantidadDisponible()>=10){
                productoAdecuado.add(productosBuenos);
            }
        }
        return productoAdecuado;
    }

    //punto 2. Obtener la lista de codigos de los productos con una cantidad disponible mayor igual a 10 y menor que 50
    public List<String> productosMenoresCincuenta(){
        List<String> productosMenores=new ArrayList<>();

        List<Producto> productosMayoresDiez= productoMayoresDiez();
        for(Producto productosAdecuados: productosMayoresDiez){
            if(productosAdecuados.getCantidadDisponible()<50){
                productosMenores.add(productosAdecuados.getCodigo());
            }
        }
        return productosMenores;
    }

    //3. Obtener la lista de clientes que hayan comprado el 07 de octubre de 2026
    public ArrayList<Cliente> obtenerClientesCompras(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        LocalDate fechaConsulta = LocalDate.of(2026,10,7);
        for (Factura factura : listaFacturas){
            if(factura.fechaGeneracion().isEqual(fechaConsulta)){
                listaClientes.add(factura.cliente());
            }
        }
        return listaClientes;
    }

    //punto 4:   Obtener las facturas que tenga un cliente donde su nombre empiece por R

    public ArrayList<Factura> obtenerFacturasClienteConR(){
        ArrayList<Factura> resultado = new ArrayList<>();

        for (Factura factura : listaFacturas){
            if(factura.tieneClienteConR()){
                resultado.add(factura);
            }
        }
        return resultado;

    }

    //punto 5:   Obtener las facturas donde se haya comprado un celular de marca Iphone 16 pro max
    public List<Factura> facturaTipoProducto(String tipoProducto){
        List<Factura> resultado= new ArrayList<>();
        for(Factura factura: listaFacturas){
            for(DetalleFactura detalleFactura: factura.listaDetalleFactura()){
                if(detalleFactura.getproducto().getNombre().equals(tipoProducto)){
                    resultado.add(factura);
                    break;
                }
            }
        }
        return resultado;
    }

    //punto 6:   Obtener las facturas que tenga un cliente
    // donde su nombre sea juan y haya comprado un celular de marca Iphone 16 pro max

    public List<Factura> facturaClienteYProducto(String nombre, String tipoProducto){
        List<Factura> resultado = new ArrayList<>();

        List<Factura> facturasIphone= facturaTipoProducto(tipoProducto);
        for(Factura facturasAdecuadas:facturasIphone){
            if(facturasAdecuadas.cliente().getNombreCompleto().contains(nombre)){
            resultado.add(facturasAdecuadas);
            }
        }
        return resultado;
    }

    // Punto 7: Implementar un método que reciba una categoría
    //  y retorne todos los productos registrados que pertenezcan a ella.}

    public List<Producto> productosSegunCategoria(String categoria){
        Categoria categoriaSeleccionada= Categoria.valueOf(categoria.toUpperCase());
        List<Producto> resultado = new ArrayList<>();
        for(Producto producto: listaProductos.values()){
            if(producto.getCategoria()== categoriaSeleccionada){
                resultado.add(producto);
            }
        }
        return resultado;
    }

    //punto 8 : Implementar un método que reciba un precio mínimo y un precio máximo, y retorne
    // los productos cuyo precio se encuentre dentro de ese rango, incluyendo ambos límites.

    public List<Producto> productosSegunPresio(double precioMinimo,double precioMayor){
        List<Producto> resultado=new ArrayList<>();
        for(Producto producto:listaProductos.values()){
            if(producto.getPrecio()>=precioMinimo && producto.getPrecio()<=precioMayor){
                resultado.add(producto);
            }
        }
        return resultado;
    }

    //punto 9: Implementar un método que retorne todos los productos
    // registrados en la tienda, ordenados de menor a mayor según su precio.

    public List<Producto> ordenados(){
        List<Producto> productos=new ArrayList<>(listaProductos.values());
        for (int i = 0; i < productos.size() - 1; i++) {
            for (int j = 0; j < productos.size() - 1 - i; j++) {
                if (productos.get(j).getPrecio() >
                        productos.get(j + 1).getPrecio()) {
                    Producto auxiliar = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, auxiliar);
                }
            }
        }
        return productos;
    }

    //punto 10: Implementar un método que identifique el producto con el precio más alto de la tienda.
    // Si no existen productos registrados, el método debe retornar un Optional vacío.

    public Optional<Producto> mayorPrecio(){
        if(!listaProductos.isEmpty()){
            Producto productoMayor= listaProductos.get(0);
            for(Producto producto:listaProductos.values()){
                if(producto.getPrecio()>productoMayor.getPrecio()){
                productoMayor=producto;
                }
            }
        return Optional.of(productoMayor);}
        else{return Optional.empty();}
    }

    //Punto 11: Implementar un método que reciba el nombre de una ciudad y retorne
    // todos los clientes que residan en ella.
    // La búsqueda debe realizarse sin diferenciar entre mayúsculas y minúsculas.

    public List<Cliente> clientesResidentes(String ciudad){
        List<Cliente> resultado =new ArrayList<>();
        for(Cliente cliente:listaClientes){
            if(cliente.getCiudadRecidencia().equalsIgnoreCase(ciudad)){
                resultado.add(cliente);
            }
        }
        return resultado;
    }

}
