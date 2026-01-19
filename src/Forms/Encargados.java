/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

/**
 *
 * @author J0s3C
 */
public class Encargados {
    private String noEmpleado;
    private String nombre;
    private String apellidos;
    private String usuario;

    public Encargados(String noEmpleado, String nombre, String apellidos, String usuario) {
        this.noEmpleado = noEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
    }

    public String getNoEmpleado() { return noEmpleado; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getUsuario() { return usuario; }
}
