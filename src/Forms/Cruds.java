/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author manugr
 */
public class Cruds {

    public Statement getSt() {
        return st;
    }



    public Connection getCon() {
        return con;
    }

    
    public Statement st;
    public Connection con;
    public Cruds(){
        try{
            
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/puntov", "ulises", "manuel300805");
            st=con.createStatement();
            System.out.println("Conexion exitosa");
        }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    }
}