import Productos.Producto;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import Productos.Insertar;

public class Main {
    public static void main(String[] args) {


        Scanner scaner = new Scanner(System.in);


        Producto product = new Insertar();

        int aaa = 0;
        do {
            System.out.printf("1.Agregar Productos\n2.Ver Productos\n3.Editar Productos\n4.Borrar Productos\n");
            int count = scaner.nextInt();
            int buff = 0;

            switch (count) {
                case 1:
                    product.ingresarProducto();
                    break;
                case 2:
                    product.verProductos();
                    break;
                case 3:
                    product.editarProducto(buff);
                    break;
                case 4:
                    product.borrarProducto(buff);
                    break;
            }
        }while (aaa < 9999);



    }
}