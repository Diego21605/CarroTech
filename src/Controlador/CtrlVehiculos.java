
package Controlador;

import Modelo.conexion;
import Vista.JFrAdmin;
import Vista.JFrVehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CtrlVehiculos implements ActionListener{
    
    private JFrVehiculos JFrVehiculos;

    public CtrlVehiculos(JFrVehiculos JFrVehiculos) {
        this.JFrVehiculos = JFrVehiculos;
        this.JFrVehiculos.btnRegresar.addActionListener(this);
        this.JFrVehiculos.btnEditar.addActionListener(this);
        this.JFrVehiculos.btnConsultar.addActionListener(this);
        this.JFrVehiculos.btnMostrar.addActionListener(this);
        this.JFrVehiculos.btnRegistrar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == JFrVehiculos.btnRegresar){
            
            JFrVehiculos.dispose();
            JFrAdmin JFrAdmin = new JFrAdmin();
            JFrAdmin.setVisible(true);
            CtrlAdmin Ctrladmin = new CtrlAdmin(JFrAdmin);
            
        }else if (e.getSource() == JFrVehiculos.btnEditar){
            
            try {

                conexion con = new conexion();
                
                String placa = JFrVehiculos.txtPlaca.getText();
                String marca = JFrVehiculos.txtMarca.getText();
                String modelo = JFrVehiculos.txtModelo.getText();
                String color = JFrVehiculos.txtColor.getText();
                String tipo = JFrVehiculos.txtTipo.getText();
                
                String Sql="update tvehiculo set cMarca='"+marca+"',cModelo='"+modelo+"',cColor='"+color+"',cTipoVehiculo='"+tipo+"' where cPlaca='"+placa+"';";
                con.dml(Sql);
                JOptionPane.showMessageDialog(null, "Actualizacion con exito " , "FELICIDADES " , JOptionPane.OK_OPTION);
                con.Setcerrar();

                JFrVehiculos.txtPlaca.setText("");
                JFrVehiculos.txtMarca.setText("");
                JFrVehiculos.txtModelo.setText("");
                JFrVehiculos.txtColor.setText("");
                JFrVehiculos.txtTipo.setText("");
                
        } catch (Exception ex) {
                System.out.println(ex);
        }
            
        }else if (e.getSource() == JFrVehiculos.btnConsultar){
            
            try {
            conexion con = new conexion ();
            ResultSet res;
            String placa = JFrVehiculos.txtPlaca.getText();
            String Sql="select * from tvehiculo where cPlaca = '"+placa+"';";
            
            res=con.GetConsultar(Sql);
            if(res.next()==true){
                 JFrVehiculos.txtMarca.setText(res.getString("cMarca"));
                 JFrVehiculos.txtModelo.setText(res.getString("cModelo"));
                 JFrVehiculos.txtColor.setText(res.getString("cColor"));
                 JFrVehiculos.txtTipo.setText(res.getString("cTipoVehiculo"));
                 
                     con.Setcerrar();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "Datos erroneos");
                 }
            
        } catch (Exception ex) {
                System.out.println(ex);
        }
            
        }else if (e.getSource() == JFrVehiculos.btnMostrar){
            
            try {
                conexion con = new conexion ();
                ResultSet res;
                String Sql = "SELECT * FROM tvehiculo";
                res=con.GetConsultar(Sql);
                
                if(res.next()){
                
                    DefaultTableModel model =new DefaultTableModel();
                
                        model.addColumn("Placa");
                        model.addColumn("Marca");
                        model.addColumn("Modelo");
                        model.addColumn("Color");
                        model.addColumn("Tipo");
            
                        this.JFrVehiculos.tableVehiculos.setModel(model);
                        
                        String [] info=new String[5];
                        
                        while(res.next()){
                     
                            info[0]=res.getString("cPlaca");
                            info[1]=res.getString("CMarca");
                            info[2]=res.getString("CModelo");
                            info[3]=res.getString("cColor");
                            info[4]=res.getString("cTipoVehiculo");
                            model.addRow(info);
                            
                    } 
                 
                }else{
                
                    con.Setcerrar();
                    
                    JOptionPane.showMessageDialog(null, "Datos erroneos");
                    
                }
            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "error","ERROR",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, ex);
            }
            
        }else if (e.getSource() == JFrVehiculos.btnRegistrar){
         
            String primerNombre="";
            String segundoNombre="";
            String primerApellido="";
            String segundoApellido ="";
            String id="";
            String correo="";
            String telefono="";
                     
        if(JFrVehiculos.txtPlaca.getText().length()==0
                ||JFrVehiculos.txtColor.getText().length()==0
                ||JFrVehiculos.txtMarca.getText().length()==0
                ||JFrVehiculos.txtModelo.getText().length()==0
                ||JFrVehiculos.txtTipo.getText().length()==0){
            
                JOptionPane.showMessageDialog(null, "HAY CAMPOS VACIOS ","ALERTA ",1);
        
               JFrVehiculos.txtPlaca.requestFocus();
                
        }else {
            
            System.out.println("entra");
            
             try {
                String placa = JFrVehiculos.txtPlaca.getText();
                String marca = JFrVehiculos.txtMarca.getText();
                String modelo = JFrVehiculos.txtModelo.getText();
                String color = JFrVehiculos.txtColor.getText();
                String tipo = JFrVehiculos.txtTipo.getText();
                 
                 conexion con;
                 con = new conexion();
                 
                 String insert;
                 insert = "insert into tvehiculo (`cMarca`, `cModelo`, `cColor`, `cPlaca`, `cTipoVehiculo`) values ('"+marca+"','"+modelo+"','"+color+"','"+placa+"','"+tipo+"')";
                 
                 con.dml(insert);
                 
                 JOptionPane.showMessageDialog(null, "Conexion exitosa");
                 
       
             } catch (Exception ex) {
                 
                 System.out.println(ex);
             }
         
            JFrVehiculos.txtPlaca.setText("");
            JFrVehiculos.txtMarca.setText("");
            JFrVehiculos.txtModelo.setText("");
            JFrVehiculos.txtColor.setText("");
            JFrVehiculos.txtTipo.setText("");
            JFrVehiculos.txtPlaca.requestFocus();
            
        }
            
        }

    }
    
}
