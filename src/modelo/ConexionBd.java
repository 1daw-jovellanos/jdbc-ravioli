/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBd {

    private static String URL = "jdbc:h2:tcp://localhost/./bdravioli";
    private static String USER = "sa";
    private static String PASS = "";
    private static String CREATION_STATEMENT
            = "CREATE TABLE empleados("
            + "id int AUTO_INCREMENT PRIMARY KEY,"
            + "nombre varchar(35),"
            + "apellido1 varchar(35),"
            + "apellido2 varchar(35),"
            + "ciudad varchar(30),"
            + "salario double"
            + ")";

    static {
        System.err.println("INFO: En el bloque estático de ConexionBD");
        inicializar();
    }
    
    /**
     * 
     */
    private static void inicializar() {
        // Cargar el driver
        try {
            System.err.println("INFO: Cargando driver");
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: El Driver de h2 no está disponible");
        }

        //Comprobar si la Bd ya esta creada.
        System.err.println("INFO: Comprobando si la BD ya está creada");
        boolean bdExiste = true;
        try {
            /* H2 crea la BD si no existe al acceder por primera vez.
               Añadiendo ;ifexists=true al abrir una conexión de h2, no la crea
               si no existe y lanza una excepción.
               Intentamos conectarnos con ifexists=true y si hay excepción es que
               la BD no existe. Cerramos la conexión inmediatamente.
            */
            DriverManager.getConnection(URL + ";IFEXISTS=TRUE", USER, PASS).close();
        } catch (SQLException ex) {
            bdExiste = false;
        }

        // Si no existe la BD nos conectamos normalmente para que la cree, y lanzamos la
        // sentencia de creacion de la tabla.
        if (!bdExiste) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
                conn.prepareStatement(CREATION_STATEMENT).executeUpdate();
                System.err.println("INFO: Creando BD + tabla vacía");
            } catch (SQLException ex) {
                System.err.println("ERROR: no se pudo crear la tabla");
            }
        }
    }

    /**
     * Crea una conexion con los parámetros obtenidos de las constantes
     * de arriba
     * @return la Conexión a la DB
     * @throws SQLException 
     */
    public static Connection obtener() throws SQLException {
        return DriverManager.getConnection(
                URL, USER, PASS
        );
    }


}
