/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

/**
 *
 * @author J0s3C
 */
public class Alumnos {
   
    private String nombre;
    private String apellido;
    private String correo;
    private String matricula;
    private String estatus;

    public Alumnos (String nombre, String apellido, String correo, String matricula, String estatus){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.matricula = matricula;
        this.estatus = estatus;
    }

    public String getNombre(){ return nombre; }
    public String getApellido(){ return apellido; }
    public String getCorreo(){ return correo; }
    public String getMatricula(){ return matricula; }
    public String getEstatus(){ return estatus; }
}


