
package Controlador;

import Modelo.conexion;
import Vista.JFrAdmin;
import Vista.JFrRegistrarClientes;
import Vista.JFrSecretaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlRegistrarClientes implements ActionListener{
    
    private JFrRegistrarClientes JFrRegistrarClientes;

    public CtrlRegistrarClientes(JFrRegistrarClientes JFrRegistrarClientes) {
        this.JFrRegistrarClientes = JFrRegistrarClientes;
        this.JFrRegistrarClientes.BtnCancelar.addActionListener(this);
        this.JFrRegistrarClientes.BtnRegistar.addActionListener(this);
        this.JFrRegistrarClientes.BtnLimpiar.addActionListener(this);
        this.JFrRegistrarClientes.txtNombre1.addActionListener(this);
        this.JFrRegistrarClientes.txtNombre2.addActionListener(this);
        this.JFrRegistrarClientes.txtApellido1.addActionListener(this);
        this.JFrRegistrarClientes.txtApellido2.addActionListener(this);
        this.JFrRegistrarClientes.txtIdentificación.addActionListener(this);
        this.JFrRegistrarClientes.txtCorreo.addActionListener(this);
        this.JFrRegistrarClientes.txtTelefono.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == JFrRegistrarClientes.BtnCancelar){
            
            JFrRegistrarClientes.dispose();
            JFrSecretaria JFrSecretaria = new JFrSecretaria();
            JFrSecretaria.setVisible(true);
            CtrlSecretaria CtrlSecretaria = new CtrlSecretaria(JFrSecretaria);
            
        }else if (e.getSource() == JFrRegistrarClientes.BtnLimpiar){
            
            JFrRegistrarClientes.txtNombre1.setText("");
            JFrRegistrarClientes.txtNombre2.setText("");
            JFrRegistrarClientes.txtApellido1.setText("");
            JFrRegistrarClientes.txtApellido2.setText("");
            JFrRegistrarClientes.txtIdentificación.setText("");
            JFrRegistrarClientes.txtCorreo.setText("");
            JFrRegistrarClientes.txtTelefono.setText("");
            JFrRegistrarClientes.txtNombre1.requestFocus();
            
        }else if (e.getSource() == JFrRegistrarClientes.BtnRegistar){
            
            String primerNombre="";
            String segundoNombre="";
            String primerApellido="";
            String segundoApellido ="";
            String id="";
            String correo="";
            String telefono="";
                     
        if(JFrRegistrarClientes.txtNombre1.getText().length()==0
                ||JFrRegistrarClientes.txtNombre2.getText().length()==0
                ||JFrRegistrarClientes.txtApellido1.getText().length()==0
                ||JFrRegistrarClientes.txtApellido2.getText().length()==0
                ||JFrRegistrarClientes.txtIdentificación.getText().length()==0
                ||JFrRegistrarClientes.txtCorreo.getText().length()==0
                ||JFrRegistrarClientes.txtTelefono.getText().length()==0){
            
                JOptionPane.showMessageDialog(null, "HAY CAMPOS VACIOS ","ALERTA ",1);
        
               JFrRegistrarClientes.txtNombre1.requestFocus();
                
        }else {
            
            System.out.println("entra");
            
             try {
                 primerNombre=JFrRegistrarClientes.txtNombre1.getText();
                 segundoNombre=JFrRegistrarClientes.txtNombre2.getText();
                 primerApellido=JFrRegistrarClientes.txtApellido1.getText();
                 segundoApellido=JFrRegistrarClientes.txtApellido2.getText();
                 id=JFrRegistrarClientes.txtIdentificación.getText();
                 correo=JFrRegistrarClientes.txtCorreo.getText();
                 telefono=JFrRegistrarClientes.txtTelefono.getText();
                 
                 conexion con;
                 con = new conexion();
                 
                 String insert;
                 insert = "insert into tcliente (`cPrimerNombre`, `cSegundoNombre`, `cPrimerApellido`, `cSegundoApellido`, `nIdentificacion`, `cCorreo`, `nTelefono`) values ('"+primerNombre+"','"+segundoNombre+"','"+primerApellido+"','"+segundoApellido+"','"+id+"','"+correo+"','"+telefono+"')";
                 
                 con.dml(insert);
                 
                 JOptionPane.showMessageDialog(null, "Conexion exitosa");
                 
       
             } catch (Exception ex) {
                 
                 System.out.println(ex);
             }
         
            JFrRegistrarClientes.txtNombre1.setText("");
            JFrRegistrarClientes.txtNombre2.setText("");
            JFrRegistrarClientes.txtApellido1.setText("");
            JFrRegistrarClientes.txtApellido2.setText("");
            JFrRegistrarClientes.txtIdentificación.setText("");
            JFrRegistrarClientes.txtCorreo.setText("");
            JFrRegistrarClientes.txtTelefono.setText("");
            JFrRegistrarClientes.txtNombre1.requestFocus();
            
        }

        }

    }
    
}
