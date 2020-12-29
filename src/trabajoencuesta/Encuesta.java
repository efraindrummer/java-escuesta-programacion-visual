/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoencuesta;

/**
 *
 * @author javier
 */
public class Encuesta {
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private int peso;
    private double estatura;
    private double imc;
    private String fecha;
    private String estado;

    public Encuesta(String rut, String nombre, String apellido, int edad, int peso, double estatura, double imc, String fecha, String estado) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.imc = imc;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
