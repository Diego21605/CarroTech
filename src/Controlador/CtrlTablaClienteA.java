/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.conexion;
import Vista.JFrAdmin;
import Vista.JFrTablaClienteA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John
 */
public class CtrlTablaClienteA implements ActionListener{
    private JFrTablaClienteA JFrTablaClienteA;
    
    public CtrlTablaClienteA(JFrTablaClienteA JFrTablaClienteA) {
        this.JFrTablaClienteA = JFrTablaClienteA;
        this.JFrTablaClienteA.btnBuscar.addActionListener(this);
        this.JFrTablaClienteA.btnMostrar.addActionListener(this);
        this.JFrTablaClienteA.btnCerrar.addActionListener(this);
        this.JFrTablaClienteA.btnEditar.addActionListener(this);
        this.JFrTablaClienteA.txtBuscar.getText();
        
                
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == JFrTablaClienteA.btnCerrar){
            
            JFrTablaClienteA.dispose();
            JFrAdmin JFrAdmin = new JFrAdmin();
            JFrAdmin.setVisible(true);
            CtrlAdmin CtrlAdmin = new CtrlAdmin(JFrAdmin);
            
            
        }else if (e.getSource() == JFrTablaClienteA.btnMostrar){
            
            try {
                conexion con = new conexion ();
                ResultSet res;
                String Sql = "SELECT * FROM tcliente";
                res=con.GetConsultar(Sql);
                
                if(res.next()){
                
                    DefaultTableModel model =new DefaultTableModel();
                
                        model.addColumn("Primer Nombre");
                        model.addColumn("Segundo Nombre");
                        model.addColumn("Primer Apellido");
                        model.addColumn("Segundo Apellido");
                        model.addColumn("Identificacion");
                        model.addColumn("Correo");
                        model.addColumn("Telefono");
            
                        this.JFrTablaClienteA.tablecliente.setModel(model);
                        
                        String [] info=new String[8];
                        
                        do{
                     
                            info[0]=res.getString("cPrimerNombre");
                            info[1]=res.getString("cSegundoNombre");
                            info[2]=res.getString("cPrimerApellido");
                            info[3]=res.getString("cSegundoApellido");
                            info[4]=res.getString("nIdentificacion");
                            info[5]=res.getString("cCorreo");
                            info[6]=res.getString("nTelefono");
                            model.addRow(info);
                            
                    }while(res.next());
                 
                }else{
                
                    con.Setcerrar();
                    
                    JOptionPane.showMessageDialog(null, "Datos erroneos");
                    
                }
            
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
        }else if(e.getSource() == JFrTablaClienteA.btnEditar){
            
            try {

                conexion con = new conexion();
                
                String primerNombre = JFrTablaClienteA.txtPrimerNombre.getText();
                String segundoNombre = JFrTablaClienteA.txtSegundoNombre.getText();
                String primerApellido = JFrTablaClienteA.txtPrimeApellido.getText();
                String segundoApellido = JFrTablaClienteA.txtSegundoApellido.getText();
                String identificacion = JFrTablaClienteA.txtBuscar.getText();
                String correo = JFrTablaClienteA.txtCorreo.getText();
                String telefono = JFrTablaClienteA.txtTelefono.getText();
                
                String Sql="update tcliente set cPrimerNombre='"+primerNombre+"',cSegundoNombre='"+segundoNombre+"',cPrimerApellido='"+primerApellido+"',cSegundoApellido='"+segundoApellido+"',cCorreo='"+correo+"',nTelefono='"+telefono+"' where nIdentificacion='"+identificacion+"';";
                con.dml(Sql);
                JOptionPane.showMessageDialog(null, "Actualizacion con exito " , "FELICIDADES " , JOptionPane.OK_OPTION);
                con.Setcerrar();

                JFrTablaClienteA.txtPrimerNombre.setText("");
                JFrTablaClienteA.txtSegundoNombre.setText("");
                JFrTablaClienteA.txtPrimeApellido.setText("");
                JFrTablaClienteA.txtSegundoApellido.setText("");
                JFrTablaClienteA.txtBuscar.setText("");
                JFrTablaClienteA.txtCorreo.setText("");
                JFrTablaClienteA.txtTelefono.setText("");
                
        } catch (Exception ex) {
                System.out.println(ex);
        }
            
        }else if(e.getSource() == JFrTablaClienteA.btnBuscar){
         
            try {
                conexion con = new conexion ();
                ResultSet res;
                String id=JFrTablaClienteA.txtBuscar.getText();
                String Sql="select * from tcliente where nIdentificacion = '"+id+"';";
                res=con.GetConsultar(Sql);
                if(res.next()==true){
                    JFrTablaClienteA.txtPrimerNombre.setText(res.getString("cPrimerNombre"));
                    JFrTablaClienteA.txtSegundoNombre.setText(res.getString("cSegundoNombre"));
                    JFrTablaClienteA.txtPrimeApellido.setText(res.getString("cPrimerApellido"));
                    JFrTablaClienteA.txtSegundoApellido.setText(res.getString("cSegundoApellido"));
                    JFrTablaClienteA.txtCorreo.setText(res.getString("cCorreo"));
                    JFrTablaClienteA.txtTelefono.setText(res.getString("nTelefono"));
                 
                    con.Setcerrar();
                 }else{
                    JOptionPane.showMessageDialog(null, "Datos erroneos");
                 }
            
        } catch (Exception ex) {
                System.out.println(ex);
        }
            
        }
        
    }

   
    
}
