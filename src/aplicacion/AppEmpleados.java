package aplicacion;

import java.util.*;
import java.sql.*;
import modelo.*;

public class AppEmpleados {

    Scanner in;

    public AppEmpleados() {
        in = new Scanner(System.in);
    }

    void menuAnnadirEmpleado() {
        try (ConexionBd conn = new ConexionBd()) {
            
        } catch (SQLException ex) {
        };
    }

    void menuListarEmpleados() {
    }

    void menuBorrarEmpleados() {
       
    }

    void run() {
        int opcion;
        do {
            System.out.format(
                    "1.- Añadir Empleado.\n"
                    + "2.- Listar todos los empleados.\n"
                    + "3.- Borrar por apellido\n"
                    + "0.- Salir\n"
                    + "  -->"
            );
            opcion = Integer.parseInt(in.nextLine());
            switch (opcion) {
                case 1:
                    menuAnnadirEmpleado();
                    break;
                case 2:
                    menuListarEmpleados();
                    break;
                case 3:
                    menuBorrarEmpleados();
                    break;
            }
        } while (opcion != 0);
    }

    public static void main(String[] args){
        new AppEmpleados().run();
    }

}
