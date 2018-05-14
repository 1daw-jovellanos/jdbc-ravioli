/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBd implements AutoCloseable {

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
    private Connection conn;

    static {
        System.err.println("En el bloque estaático de ConexionBD");
        inicializar();
    }

    private static void inicializar() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error grave: El Driver de h2 no está disponible");
        }

        boolean bdExiste = true;
        try {
            DriverManager.getConnection(URL + ";IFEXISTS=TRUE", USER, PASS).close();
        } catch (SQLException ex) {
            bdExiste = false;
        }

        if (!bdExiste) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
                conn.prepareStatement(CREATION_STATEMENT).executeUpdate();
                System.err.println("INFO: Creando BD + tabla");
            } catch (SQLException ex) {
                System.err.println("Error grave: no se pudo crear la tabla");
            }
        }
    }

    public ConexionBd() throws SQLException {
        conn = DriverManager.getConnection(
                URL, USER, PASS
        );
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception ex) {
        };
    }
}
