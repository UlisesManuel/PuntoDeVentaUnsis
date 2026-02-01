/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

/**
 *
 * @author manugr
 */
public class Sesion {

    public static String getNoEmpleado() {
        return noEmpleado;
    }

    public static String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public static String noEmpleado;
    public static String nombreEmpleado;

    public static void cerrarSesion() {
        noEmpleado = null;
        nombreEmpleado = null;

    }

}
