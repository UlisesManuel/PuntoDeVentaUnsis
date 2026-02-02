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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class Logic_Code {
    //Ajusta medidas de los labesl de la barra latera
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
        //Limpia los textfield 
     public void limpiarT(JTextField matricula,JTextField tblname,JTextField nom,JTextField ape,JTextField car){
        matricula.setText("");
        tblname.setText("");
        nom.setText("");
        ape.setText("");
        car.setText("");
    }
        //Limpia los textfield se sobreescribe el codigo ya que se necesita para paneles con jtextfiel menores
       public void limpiar2(JTextField matricula,JTextField Nombre,JTextField Apellido,JTextField correo){
        Nombre.setText("");
        Apellido.setText("");
        correo.setText("");
        matricula.setText("");
    }
     //Deshabilita la edicion de los Jtextfiel
    public void deshabilitar(JTextField curp,JTextField nombre,JTextField apellidop,JTextField apellidom,JTextField tel){
        curp.setEnabled(false);
        nombre.setEnabled(false);
        apellidop.setEnabled(false);
        apellidom.setEnabled(false);
        tel.setEnabled(false);
    }
     //Habilita la edicion de los Jtextfiel
    public void habilitar(JTextField curp,JTextField nombre,JTextField apellidop,JTextField apellidom,JTextField tel){
        curp.setEnabled(true);
        nombre.setEnabled(true);
        apellidop.setEnabled(true);
        apellidom.setEnabled(true);
        tel.setEnabled(true);
    }
    
    //Los siguientes metedos funcionan exclusivamente para diseño e iterfaz 
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
           // String estatus = query.getString("estatus");

            Alumnos alu = new Alumnos(nombre, apellido, correo, matricula);
            lista.add(alu);
        }

        tabla.setModel(tablita(lista)); 

        query.close();
        s.getCon().close();
    } catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }

    //moldea la tabla y inserta los datos de esta
    public static DefaultTableModel tablita(ArrayList<Alumnos> lista){
    DefaultTableModel m = new DefaultTableModel();

    m.addColumn("NOMBRE");
    m.addColumn("APELLIDO");
    m.addColumn("CORREO");
    m.addColumn("MATRICULA");
  //  m.addColumn("ESTATUS");

    for(Alumnos a : lista){
        Object[] fila = new Object[5];
        fila[0] = a.getNombre();
        fila[1] = a.getApellido();
        fila[2] = a.getCorreo();
        fila[3] = a.getMatricula();
   //     fila[4] = a.getEstatus();
        m.addRow(fila);
    }

    return m;
}   //Muestra los datos en la tabla
    public static void mostrarEncargados(javax.swing.JTable tabla){
    Cruds s = new Cruds();

    try {
        s.getCon();
        ResultSet query = s.getSt().executeQuery(
            "SELECT no_empleado, nombre, apellido_paterno, apellido_materno, usuario FROM encargados"
        );

        ArrayList<Encargados> lista = new ArrayList<>();

        while(query.next()){
            String noEmpleado = query.getString("no_empleado");
            String nombre = query.getString("nombre");
            String apellidos = query.getString("apellido_paterno") + " " +
                               query.getString("apellido_materno");
            String usuario = query.getString("usuario");

            Encargados enc = new Encargados(noEmpleado, nombre, apellidos, usuario);
            lista.add(enc);
        }

        tabla.setModel(tblEncargados(lista));

        query.close();
        s.getCon().close();

    } catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
}
    //Llenado de la tabla Encargados
    public static DefaultTableModel tblEncargados(ArrayList<Encargados> lista){
    DefaultTableModel m = new DefaultTableModel();

    m.addColumn("NUM. EMPLEADO");
    m.addColumn("NOMBRE");
    m.addColumn("APELLIDOS");
    m.addColumn("USUARIO");

    for(Encargados e : lista){
        Object[] fila = new Object[4];
        fila[0] = e.getNoEmpleado();
        fila[1] = e.getNombre();
        fila[2] = e.getApellidos();
        fila[3] = e.getUsuario();
        m.addRow(fila);
    }

    return m;
    }
    //busqueda dinamica para los tratamiento
    public void buscarTratamiento(String valor, JTable tabla) {
        String[] columnas = {"ID_Producto", "Nombre", "Precio", "Agregar"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM tratamientos WHERE nombre LIKE ? OR id_tratamiento LIKE ?";

        Cruds s = new Cruds();
        PreparedStatement pst;
        try{
            s.getCon();
            pst=s.con.prepareStatement(sql);
            pst.executeQuery(sql);
            pst.setString(1, "%" + valor + "%");
            pst.setString(2, "%" + valor + "%");

            ResultSet rs = pst.executeQuery();
            String[] registro = new String[4];

            while (rs.next()) {
                registro[0] = rs.getString("ID_Producto");
                registro[1] = rs.getString("Nombre");
                registro[2] = rs.getString("Precio");
                registro[3] = rs.getString("Agregar");
                modelo.addRow(registro);
            }
            tabla.setModel(modelo);

        } catch (SQLException e) {
            System.err.println("Error al filtrar: " + e.getMessage());
        }
    }
    //busca dinamica para los clientes en la iterfaz del punto de cobro
    public void buscarClientePV(String valor, JTable tabla) {
        Cruds s = new Cruds();
        String sql = "SELECT nombre FROM clientes WHERE nombre LIKE ?";
        try {
            s.getCon();
            PreparedStatement pst = s.con.prepareStatement(sql);
            pst.setString(1, "%" + valor + "%"); 

            ResultSet query = pst.executeQuery();
            ArrayList<Pacientes> listaPaciente = new ArrayList<>();

            while (query.next()) {
                Pacientes pas = new Pacientes(null,valor,null,null,null);
                pas.setNombre(query.getString("nombre"));
                listaPaciente.add(pas);
            }

            tabla.setModel(tablitaPass(listaPaciente));

            query.close();
            pst.close();
            s.con.close();

        } catch (SQLException ex) {
            System.out.println("Error en búsqueda dinámica: " + ex.getMessage());
        }
    }
    public DefaultTableModel tablitaPass(ArrayList<Pacientes> listaPacientes) {
        DefaultTableModel m = new DefaultTableModel();
        m.addColumn("curp");
        m.addColumn("Nombre");

        for    
(Pacientes a : listaPacientes){
            Object[] fila = new Object[2];
            fila[0] = a.getCurp();
            fila[1] = a.getNombre();
            m.addRow(fila);
        }

        return m;
    }
    //Muestra los tratamientos en la interfas del punto de cobro 
    public void mostrarTrat(JTable tbl) {
        String sql = "SELECT codigo, nombre FROM productos;";
        Cruds s = new Cruds();

        try {
            s.getCon(); 
            PreparedStatement pst = s.con.prepareStatement(sql);
            ResultSet query = pst.executeQuery();

            ArrayList<Producto> listaProductos = new ArrayList<>();

            while (query.next()) {
                String codigo = query.getString("codigo");
                String nombre = query.getString("nombre");
                Producto p = new Producto(codigo, nombre, 0, 0.0);
                listaProductos.add(p);
            }

            tbl.setModel(tablitaProductos(listaProductos));

            // Cerrar recursos en orden inverso a su apertura
            query.close();
            pst.close();
            if (s.con != null && !s.con.isClosed()) {
                s.con.close();
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
    }

    public DefaultTableModel tablitaProductos(ArrayList<Producto> listaProductos) {
        
    String[] columnas={"ID","Nombre","Cantidad","Seleccionar"};
    DefaultTableModel m = new DefaultTableModel(null, columnas) {
           public Class<?> getColumnClass(int columna) {
               if (columna == 2) return Integer.class; 
               if (columna == 3) return Boolean.class; 
               return String.class;
           }

           @Override
           public boolean isCellEditable(int row, int columna) {
               // Solo permitimos editar Cantidad (2) y Selección (3)
               return columna == 2 || columna == 3;
           }
       };
        for (Producto p : listaProductos) {
            Object[] fila = new Object[4];
            fila[0] = p.getCodigo();
            fila[1] = p.getNombre();
            fila[2] =0;
            fila[3]=false;
            m.addRow(fila);
        }
        return m;
    }
    public void buscarPacienteDinamico(String valor, JTable tbl) {
        Cruds s = new Cruds();
        String sql = "SELECT * FROM clientes WHERE nombre ILIKE ? OR curp ILIKE ?";

        try {
            s.getCon();
            PreparedStatement pst = s.con.prepareStatement(sql);
            String filtro = "%" + valor + "%";
            pst.setString(1, filtro);
            pst.setString(2, filtro);

            ResultSet query = pst.executeQuery();
            ArrayList<Pacientes> listaPaciente = new ArrayList<>();

            while(query.next()){
                Pacientes pas = new Pacientes(
                    query.getString("curp"),
                    query.getString("nombre"),
                    query.getString("apellido_paterno"),
                    query.getString("apellido_materno"),
                    query.getString("telefono")
                );
                listaPaciente.add(pas);
            }
            tbl.setModel(tablitaPas(listaPaciente));

            query.close();
            pst.close();
            s.getCon().close();
        } catch (SQLException ex) {
            System.out.println("Error en búsqueda dinámica: " + ex.getMessage());
        }
    }
                                                   
    public DefaultTableModel tablitaPas(ArrayList<Pacientes> listaPacientes) {
        DefaultTableModel m = new DefaultTableModel();

        m.addColumn("Curp");
        m.addColumn("Nombre");
        m.addColumn("Apellido Paterno");
        m.addColumn("Apellido Materno");
        m.addColumn("Telefono");

        for(Pacientes a : listaPacientes){
            Object[] fila = new Object[5];
            fila[0] = a.getCurp();
            fila[1] = a.getNombre();
            fila[2] = a.getApellidoPaterno();
            fila[3] = a.getApellidoMaterno();
            fila[4] = a.getTelefono();
            m.addRow(fila);
        }

        return m;
    }
    public void SoloTratamientos(JTable tbl) {
        // Cambiamos la consulta a la tabla tratamientos
        String sql = "SELECT id_tratamiento, nombre FROM tratamientos ORDER BY nombre ASC;";
        Cruds s = new Cruds();

        try {
            s.getCon(); 
            PreparedStatement pst = s.con.prepareStatement(sql);
            ResultSet query = pst.executeQuery();

            DefaultTableModel m = modeloSimpleTratamientos();

            while (query.next()) {
                Object[] fila = new Object[2];
                fila[0] = query.getString("id_tratamiento");
                fila[1] = query.getString("nombre");
                m.addRow(fila);
            }

            tbl.setModel(m);
            query.close();
            pst.close();
            if (s.con != null) s.con.close();

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
    }
    public DefaultTableModel modeloSimpleTratamientos() {
    String[] columnas = {"ID", "Nombre"};
    
        return new DefaultTableModel(null, columnas) {
        };
    }
}
 
