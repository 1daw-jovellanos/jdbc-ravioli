package aplicacion;

import java.util.*;
import java.sql.*;
import modelo.*;

public class AppEmpleados {

    Scanner in;

    public AppEmpleados() {
        in = new Scanner(System.in);
    }

    void menuInsertarEmpleado() {
        Empleado e = new Empleado();
        System.out.print("Nombre: ");
        e.setNombre(in.nextLine());
        System.out.print("Apellido 1: ");
        e.setApellido1(in.nextLine());
        System.out.print("Apellido 2: ");
        e.setApellido2(in.nextLine());
        System.out.print("Ciudad: ");
        e.setCiudad(in.nextLine());
        System.out.print("Salario: ");
        e.setSalario(Double.parseDouble(in.nextLine()));
        if (e.create()) {
            System.out.format("Empleado guardado. Se le asignó el id %d%n", e.getId());
        } else {
            System.out.format("No se pudo guardar el empleado.%n");
        }
    }

    void menuObtenerEmpleado() {
    }

    void menuEliminarEmpleado() {
       
    }
    
    void menuModificarEmpleado() {
       
    }
    
    void menuListarTodos() {
       
    }
    
    void menuBorrarPorRangoSueldo() {
       
    }
    
    void menuBuscarPorCiudad() {
       
    }
 
    
    

    void run() {
        int opcion;
        do {
            System.out.format(
                      "1.- Insertar un Empleado.\n"
                    + "2.- Obtener un empleado por id.\n"
                    + "3.- Borrar un empleado por id\n"
                    + "4.- Modificar un empleado por id\n"
                    + "5.- Listar todos\n"
                    + "6.- Borrar por rango de salario\n"
                    + "7.- Buscar por apellido\n"
                    + "0.- Filtrar empleados por ciudad\n"
                    + "  -->"
            );
            opcion = Integer.parseInt(in.nextLine());
            switch (opcion) {
                case 1:
                    menuInsertarEmpleado();
                    break;
                case 2:
                   
                    break;
                case 3:
                   
                    break;
            }
        } while (opcion != 0);
    }

    public static void main(String[] args){
        new AppEmpleados().run();
    }

}
