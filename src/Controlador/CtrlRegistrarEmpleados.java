package Controlador;

import Modelo.conexion;
import Vista.JFrEmpleados;
import Vista.JFrRegistrarEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class CtrlRegistrarEmpleados implements ActionListener{
    
    private JFrRegistrarEmpleados JFrRegistrarEmpleados;

    public CtrlRegistrarEmpleados(JFrRegistrarEmpleados JFrRegistrarEmpleados) {
        this.JFrRegistrarEmpleados = JFrRegistrarEmpleados;
        this.JFrRegistrarEmpleados.btnCancelar.addActionListener(this);
        this.JFrRegistrarEmpleados.btnLimpiar.addActionListener(this);
        this.JFrRegistrarEmpleados.btnRegistrar.addActionListener(this);
        this.JFrRegistrarEmpleados.btnAyuda.addActionListener(this);
        this.JFrRegistrarEmpleados.btnEditar.addActionListener(this);
        this.JFrRegistrarEmpleados.btnConsultar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == JFrRegistrarEmpleados.btnCancelar){
            
            JFrRegistrarEmpleados.dispose();
            JFrEmpleados JFrEmpleados = new JFrEmpleados(); 
            JFrEmpleados.setVisible(true);
            CtrlEmpleados CtrlEmpleados = new CtrlEmpleados(JFrEmpleados);
            
        }else if (e.getSource() == JFrRegistrarEmpleados.btnLimpiar){
            
            JFrRegistrarEmpleados.txtNombre1.setText("");
            JFrRegistrarEmpleados.txtNombre2.setText("");
            JFrRegistrarEmpleados.txtApellido1.setText("");
            JFrRegistrarEmpleados.txtApellido2.setText("");
            JFrRegistrarEmpleados.txtId.setText("");
            JFrRegistrarEmpleados.txtCorreo.setText("");
            JFrRegistrarEmpleados.txtTelefono.setText("");
            JFrRegistrarEmpleados.txtUsuario.setText("");
            JFrRegistrarEmpleados.txtContraseña.setText("");
            JFrRegistrarEmpleados.txtDireccion.setText("");
            JFrRegistrarEmpleados.txtTipoUsuario.setText("");
            JFrRegistrarEmpleados.txtNombre1.requestFocus();
                    
        }else if (e.getSource() == JFrRegistrarEmpleados.btnAyuda) {
            
            JOptionPane.showMessageDialog(null, "Para llenar el campo 'Tipo de Usuario' debes colocar  \n"
                    + "A ---> Para los usuarios de tipo Administrador \n"
                    + "B ---> Para los usuarios de tipo Secretari@ \n"
                    + "C ---> Para los usuarios de tipo Jefe de patios \n"
                    + "Se debe colocar en mayusculas.");
            
        }else if (e.getSource() == JFrRegistrarEmpleados.btnRegistrar){
            
            String primerNombre="";
            String segundoNombre="";
            String primerApellido="";
            String segundoApellido ="";
            String id="";
            String correo="";
            String direccion="";
            String tipoUsuario="";
            String telefono="";
            String usuario="";
            String contraseña="";
            
            if(JFrRegistrarEmpleados.txtNombre1.getText().length()==0
                ||JFrRegistrarEmpleados.txtNombre2.getText().length()==0
                ||JFrRegistrarEmpleados.txtApellido1.getText().length()==0
                ||JFrRegistrarEmpleados.txtApellido2.getText().length()==0
                ||JFrRegistrarEmpleados.txtId.getText().length()==0
                ||JFrRegistrarEmpleados.txtCorreo.getText().length()==0
                ||JFrRegistrarEmpleados.txtTipoUsuario.getText().length()==0
                ||JFrRegistrarEmpleados.txtTelefono.getText().length()==0
                ||JFrRegistrarEmpleados.txtUsuario.getText().length()==0
                ||JFrRegistrarEmpleados.txtContraseña.getText().length()==0){
            
                JOptionPane.showMessageDialog(null, "HAY CAMPOS VACIOS ","ALERTA ",1);
        
               JFrRegistrarEmpleados.txtId.requestFocus();
                
        }else {
            int A = 1;
            int B = 2;
            int C = 2;
                if(JFrRegistrarEmpleados.txtTipoUsuario.getText().length()== A
                         ||JFrRegistrarEmpleados.txtTipoUsuario.getText().length() == B
                         ||JFrRegistrarEmpleados.txtTipoUsuario.getText().length() == C){
                
                    System.out.println("entra");
            
                    try {
                        primerNombre=JFrRegistrarEmpleados.txtNombre1.getText();
                        segundoNombre=JFrRegistrarEmpleados.txtNombre2.getText();
                        primerApellido=JFrRegistrarEmpleados.txtApellido1.getText();
                        segundoApellido=JFrRegistrarEmpleados.txtApellido2.getText();
                        id=JFrRegistrarEmpleados.txtId.getText();
                        correo=JFrRegistrarEmpleados.txtCorreo.getText();
                        direccion=JFrRegistrarEmpleados.txtDireccion.getText();
                        tipoUsuario=JFrRegistrarEmpleados.txtTipoUsuario.getText();
                        telefono=JFrRegistrarEmpleados.txtTelefono.getText();
                        usuario=JFrRegistrarEmpleados.txtUsuario.getText();
                        contraseña=JFrRegistrarEmpleados.txtContraseña.getText();        
                 
                        conexion con;
                 
                        con = new conexion();
                        String insert;
                        insert = "insert into tusuario (`cPrimerNombre`, `cSegundoNombre`, `cPrimerApellido`, `cSegundoApellido`, `nIdentificacion`, `cDireccion`, `cCorreo`, `cTipoUsuario`, `nTelefono`, `cUsuario`, `cPass`) values ('"+primerNombre+"','"+segundoNombre+"','"+primerApellido+"','"+segundoApellido+"','"+id+"','"+direccion+"','"+correo+"','"+tipoUsuario+"','"+telefono+"','"+usuario+"','"+contraseña+"')";
                 
                        con.dml(insert);
                 
                        JOptionPane.showMessageDialog(null, "Conexion exitosa");
                 
       
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
         
        }else {
                    JOptionPane.showMessageDialog(null, "Para llenar el campo 'Tipo de Usuario' debes colocar  \n"
                    + "A ---> Para los usuarios de tipo Administrador \n"
                    + "B ---> Para los usuarios de tipo Secretari@ \n"
                    + "C ---> Para los usuarios de tipo Jefe de patios \n"
                    + "Se debe colocar en mayusculas.");
                }
            
                JFrRegistrarEmpleados.txtNombre1.setText("");
                JFrRegistrarEmpleados.txtNombre2.setText("");
                JFrRegistrarEmpleados.txtApellido1.setText("");
                JFrRegistrarEmpleados.txtApellido2.setText("");
                JFrRegistrarEmpleados.txtId.setText("");
                JFrRegistrarEmpleados.txtCorreo.setText("");
                JFrRegistrarEmpleados.txtTipoUsuario.setText("");
                JFrRegistrarEmpleados.txtDireccion.setText("");
                JFrRegistrarEmpleados.txtTelefono.setText("");
                JFrRegistrarEmpleados.txtUsuario.setText("");
                JFrRegistrarEmpleados.txtContraseña.setText("");
                JFrRegistrarEmpleados.txtNombre1.requestFocus();
                
        }

    }else if (e.getSource() == JFrRegistrarEmpleados.btnEditar){
        
        try {

                conexion con = new conexion();
                
                String primerNombre = JFrRegistrarEmpleados.txtNombre1.getText();
                String segundoNombre = JFrRegistrarEmpleados.txtNombre2.getText();
                String primerApellido = JFrRegistrarEmpleados.txtApellido1.getText();
                String segundoApellido = JFrRegistrarEmpleados.txtApellido2.getText();
                String identificacion = JFrRegistrarEmpleados.txtId.getText();
                String correo = JFrRegistrarEmpleados.txtCorreo.getText();
                String tipo = JFrRegistrarEmpleados.txtTipoUsuario.getText();
                String direccion = JFrRegistrarEmpleados.txtDireccion.getText();
                String telefono = JFrRegistrarEmpleados.txtTelefono.getText();
                String usuario = JFrRegistrarEmpleados.txtUsuario.getText();
                String contraseña = JFrRegistrarEmpleados.txtContraseña.getText();
                
                String Sql="update tusuario set cPrimerNombre='"+primerNombre+"',cSegundoNombre='"+segundoNombre+"',cPrimerApellido='"+primerApellido+"',cSegundoApellido='"+segundoApellido+"',cDireccion='"+direccion+"',cCorreo='"+correo+"',cTipoUsuario='"+tipo+"',nTelefono='"+telefono+"',cUsuario='"+usuario+"',cPass='"+contraseña+"' where nIdentificacion='"+identificacion+"';";
                con.dml(Sql);
                JOptionPane.showMessageDialog(null, "Actualizacion con exito " , "FELICIDADES " , JOptionPane.OK_OPTION);
                con.Setcerrar();

                JFrRegistrarEmpleados.txtNombre1.setText("");
                JFrRegistrarEmpleados.txtNombre2.setText("");
                JFrRegistrarEmpleados.txtApellido1.setText("");
                JFrRegistrarEmpleados.txtApellido2.setText("");
                JFrRegistrarEmpleados.txtId.setText("");
                JFrRegistrarEmpleados.txtCorreo.setText("");
                JFrRegistrarEmpleados.txtTipoUsuario.setText("");
                JFrRegistrarEmpleados.txtDireccion.setText("");
                JFrRegistrarEmpleados.txtTelefono.setText("");
                JFrRegistrarEmpleados.txtUsuario.setText("");
                JFrRegistrarEmpleados.txtContraseña.setText("");
                JFrRegistrarEmpleados.txtNombre1.requestFocus();
                
        } catch (Exception ex) {
                System.out.println(ex);
        }
        
    }else if (e.getSource() == JFrRegistrarEmpleados.btnConsultar){
        
        try {
                conexion con = new conexion ();
                ResultSet res;
                String id=JFrRegistrarEmpleados.txtId.getText();
                String Sql="select * from tusuario where nIdentificacion = '"+id+"';";
                res=con.GetConsultar(Sql);
                if(res.next()==true){
                    
                    JFrRegistrarEmpleados.txtNombre1.setText(res.getString("cPrimerNombre"));
                    JFrRegistrarEmpleados.txtNombre2.setText(res.getString("cSegundoNombre"));
                    JFrRegistrarEmpleados.txtApellido1.setText(res.getString("cPrimerApellido"));
                    JFrRegistrarEmpleados.txtApellido2.setText(res.getString("cSegundoApellido"));
                    JFrRegistrarEmpleados.txtCorreo.setText(res.getString("cCorreo"));
                    JFrRegistrarEmpleados.txtTipoUsuario.setText(res.getString("cTipoUsuario"));
                    JFrRegistrarEmpleados.txtDireccion.setText(res.getString("cDireccion"));
                    JFrRegistrarEmpleados.txtTelefono.setText(res.getString("nTelefono"));
                    JFrRegistrarEmpleados.txtUsuario.setText(res.getString("cUsuario"));
                    JFrRegistrarEmpleados.txtContraseña.setText(res.getString("cPass"));
                                     
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
