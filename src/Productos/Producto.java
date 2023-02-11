package Productos;
import Productos.Insertar;
public abstract class Producto {


    public String nombre;
    protected float costoCompra;
    protected float costoVenta;
    protected int codigoBarras;

    public  abstract void ingresarProducto();

    public abstract void borrarProducto(int id);

    public abstract void editarProducto(int id);

    public abstract void verProductos();




}
