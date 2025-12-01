/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import Forms.Cruds;
import Forms.Pacientes;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class Logic_Code {
    
    public static void ajustarMedidas(JLabel... labelsito){
        for (JLabel n: labelsito){
            if (n.getText().equals(MainP.lbl_icono_logo.getText())){
                  n.setPreferredSize(new Dimension(180,100));
                  n.setHorizontalAlignment(SwingConstants.CENTER);

                  //System.out.println(n.getText());

            } else {
            
            
        n.setPreferredSize(new Dimension(180, 50));
        //n.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        n.setOpaque(true);
        n.setBackground(new Color(25,31,81));
        n.setHorizontalAlignment(SwingConstants.LEFT);
        n.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //System.out.println(n.getText());

            }
        }
        
    }
    
     public void limpiarT(JTextField matricula,JTextField tblname,JTextField nom,JTextField ape,JTextField car){
        matricula.setText("");
        tblname.setText("");
        nom.setText("");
        ape.setText("");
        car.setText("");
    }
     
       public void limpiar2(JTextField matricula,JTextField Nombre,JTextField Apellido,JTextField correo){
        Nombre.setText("");
        Apellido.setText("");
        correo.setText("");
        matricula.setText("");
    }
     
    public void deshabilitar(JTextField curp,JTextField nombre,JTextField apellidop,JTextField apellidom,JTextField tel){
        curp.setEnabled(false);
        nombre.setEnabled(false);
        apellidop.setEnabled(false);
        apellidom.setEnabled(false);
        tel.setEnabled(false);
    }
    public void habilitar(JTextField curp,JTextField nombre,JTextField apellidop,JTextField apellidom,JTextField tel){
        curp.setEnabled(true);
        nombre.setEnabled(true);
        apellidop.setEnabled(true);
        apellidom.setEnabled(true);
        tel.setEnabled(true);
    }
    
    
    public static void resaltarLabel(JLabel labelsito){
       labelsito.setForeground(new Color(25,31,86));
       labelsito.setBackground(Color.WHITE);
    }
    
    
    public static void restaurarLabel(JLabel labelsito){
        labelsito.setForeground(Color.WHITE);
        labelsito.setBackground(new Color(25,31,86));
    }
    
    public static void mostrar(javax.swing.JTable tabla){
    Cruds s = new Cruds();

    try {
        s.getCon();
        ResultSet query = s.getSt().executeQuery("SELECT * FROM alumnos");
        
        ArrayList<Alumnos> lista = new ArrayList<>();
        
        while(query.next()){
            String nombre = query.getString("nombre");
            String apellido = query.getString("apellido");
            String correo = query.getString("correo");
            String matricula = query.getString("matricula");
            String estatus = query.getString("estatus");

            Alumnos alu = new Alumnos(nombre, apellido, correo, matricula, estatus);
            lista.add(alu);
        }

        tabla.setModel(tablita(lista));  // ← AQUÍ YA FUNCIONA

        query.close();
        s.getCon().close();
    } catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
}

                                                    
//Relleno de la tabla 
    public static DefaultTableModel tablita(ArrayList<Alumnos> lista){
    DefaultTableModel m = new DefaultTableModel();

    m.addColumn("NOMBRE");
    m.addColumn("APELLIDO");
    m.addColumn("CORREO");
    m.addColumn("MATRICULA");
    m.addColumn("ESTATUS");

    for(Alumnos a : lista){
        Object[] fila = new Object[5];
        fila[0] = a.getNombre();
        fila[1] = a.getApellido();
        fila[2] = a.getCorreo();
        fila[3] = a.getMatricula();
        fila[4] = a.getEstatus();
        m.addRow(fila);
    }

    return m;
}

}