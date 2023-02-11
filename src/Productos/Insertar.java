package Productos;
import Productos.Producto;


import java.sql.*;
import java.util.Scanner;

public class Insertar extends Producto{




    @Override
    public void ingresarProducto() {

        System.out.printf("Agregar producto\n");


        Scanner scan = new Scanner(System.in);
        System.out.printf("Producto\n");
        System.out.printf("Nombre\n");
        this.nombre = scan.nextLine();
        System.out.printf("Costo Compra\n");

        this.costoCompra = scan.nextFloat();
        System.out.printf("Costo Venta\n");

        this.costoVenta = scan.nextFloat();
        System.out.printf("Codigo de Barras\n");
        this.codigoBarras = scan.nextInt();

        Connection conexion = null;
        try {
            String dbUrl = "jdbc:sqlite:src/productos.db";
            conexion = DriverManager.getConnection(dbUrl);
        } catch (SQLException ex){
            System.err.println(ex);
        }
        try {
            String strInsertar = "INSERT INTO Producto(Nombre, costoCompra, costoVenta, codigoBarras) VALUES (?, ?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(strInsertar);
            ps.setString(1, this.nombre);
            ps.setDouble(2, this.costoCompra);
            ps.setDouble(3, this.costoVenta);
            ps.setInt(4, this.codigoBarras);
            ps.execute();
        } catch (SQLException ex){
            System.err.println(ex);
        }





    }

    @Override
    public void borrarProducto(int id) {
        System.out.printf("Borrar Producto\n");
        verProductos();
        Connection conexion = null;
        try {
            String dbUrl = "jdbc:sqlite:src/productos.db";
            conexion = DriverManager.getConnection(dbUrl);
        } catch (SQLException ex){
            System.err.println(ex);
        }
        try {
            System.out.printf("Ingrese el id a borrar\n");
            Scanner scanner = new Scanner(System.in);
            int borrar = scanner.nextInt();


            String strInsertar = "DELETE FROM Producto WHERE id=?";
            PreparedStatement ps = conexion.prepareStatement(strInsertar);
            ps.setString(1, String.valueOf(borrar));
            ps.execute();

        } catch (SQLException ex){
            System.err.println(ex);
        }

    }

    @Override
    public void editarProducto(int id) {
        Scanner scanner = new Scanner(System.in);


        System.out.printf("Editar productos\n");
        verProductos();
        System.out.printf("Ingrese el id a editar\n");
        int borrar = scanner.nextInt();

        Connection conexion = null;
        try {
            String dbUrl = "jdbc:sqlite:src/productos.db";
            conexion = DriverManager.getConnection(dbUrl);
        } catch (SQLException ex){
            System.err.println(ex);
        }
        scanner.nextLine();

        System.out.printf("Ingrese el nuevo Nombre\n");
        this.nombre = scanner.nextLine();

        System.out.printf("Costo Compra\n");
        this.costoCompra = scanner.nextFloat();
        System.out.printf("Costo Venta\n");

        this.costoVenta = scanner.nextFloat();
        System.out.printf("Codigo de Barras\n");
        this.codigoBarras = scanner.nextInt();

        try {


            String strInsertar = "UPDATE Producto SET Nombre=?,costoCompra=?,costoVenta=?,codigoBarras=? WHERE id=?";
            PreparedStatement ps = conexion.prepareStatement(strInsertar);

            ps.setString(1, this.nombre);
            ps.setInt(4, this.codigoBarras);
            ps.setFloat(2, this.costoCompra);
            ps.setFloat(3, this.costoVenta);
            ps.setInt(5, borrar);
            ps.execute();
        } catch (SQLException ex){
            System.err.println(ex);
        }
    }



    @Override
    public void verProductos() {
        Connection conexion = null;
        System.out.printf("Ver productos\n");
        try {
            String dbUrl = "jdbc:sqlite:src/productos.db";
            conexion = DriverManager.getConnection(dbUrl);
        } catch (SQLException ex){
            System.err.println(ex);
        }
        try {
            String strConsultar  = "SELECT * FROM Producto";
            PreparedStatement ps = conexion.prepareStatement(strConsultar);

            ResultSet rsResultados = ps.executeQuery();
            while (rsResultados.next()){
                System.out.printf("%s %s\n", rsResultados.getString(1), rsResultados.getString(2));
            }
        } catch (SQLException ex){
            System.err.println(ex);
        }
    }
}
