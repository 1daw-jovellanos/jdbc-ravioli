/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

public class Empleado {

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private double salario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // ------ ORM : Mapeado objeto -relacional
    /**
     * Guarda este objeto en la tabla. Se envía un insert a la BD con todos los
     * campos, excepto el id, que es auto incrementado y lo fijará el SGBD
     *
     * @return true si la operación tuvo éxito
     */
    public boolean create() {
        boolean ok = true; // Supongo que la operación va a ir ok;
        try (Connection conn = ConexionBd.obtener()) {
 
        } catch (SQLException ex) {
            System.err.println("Método create: Error al insertar/" + ex.getMessage());
        }
        return ok;
    }
}
