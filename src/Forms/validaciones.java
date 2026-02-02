/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author manugr
 */
public class validaciones {
    public boolean campos(JTextField curp,JTextField nombre,JTextField apellidop,JTextField apellidom,JTextField tel){
        
        if(curp.getText().isEmpty() || nombre.getText().isEmpty() || apellidop.getText().isEmpty() || apellidom.getText().isEmpty() || tel.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Rellenar todos los campos","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(curp.getText().length()!=18 & tel.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "CURP o Telefono no validos","Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }
        return true;
    }
    public static boolean   soloNumeros(String texto) {
        return texto.matches("\\d+");
    }
    public static boolean soloLetras(String texto) {
    return texto.matches("[a-zA-Z\\s]+");
    }

    public boolean campos2(JTextField Nombre,JTextField Apellido,JTextField correo,JTextField matricula){
        if(correo.getText().isEmpty() || Nombre.getText().isEmpty() || Apellido.getText().isEmpty() || correo.getText().isEmpty() || matricula.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Rellenar todos los campos","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(correo.getText().length()!=18 & matricula.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Matricula no valida","Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }
        return true;
    }
}

