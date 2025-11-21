/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
    
    
    
    public static void resaltarLabel(JLabel labelsito){
       labelsito.setForeground(new Color(25,31,86));
       labelsito.setBackground(Color.WHITE);
    }
    
    
    public static void restaurarLabel(JLabel labelsito){
        labelsito.setForeground(Color.WHITE);
        labelsito.setBackground(new Color(25,31,86));
    }
    
    
}
