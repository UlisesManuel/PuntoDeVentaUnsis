/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author manugr
 */
public class Cruds {
    private static final String url = "jdbc:postgresql://yamanote.proxy.rlwy.net:30234/railway";
    private static final String usuario = "postgres";
    private static final String contra = "HmIlNCoyeXqHNsPMoHpcQurTIDbriFSU";
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
            con=DriverManager.getConnection(url, usuario, contra);
            //con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/puntov", "ulises", "manuel300805");
            st=con.createStatement();
        }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    }
    public double obtenerPrecioDB(String id, String columnaPrecio) {
        double precio = 0;
        String sql = "SELECT " + columnaPrecio + " FROM tratamientos WHERE id_tratamiento = ?";

        try {
            if (this.con == null || this.con.isClosed()) {
                getCon(); 
            }

            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                precio = rs.getDouble(1);
            }

            rs.close();
            pst.close();

        } catch (SQLException e) {
            System.out.println("Error en obtenerPrecioDB: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID no es un número válido.");
        }

        return precio;
    }
}