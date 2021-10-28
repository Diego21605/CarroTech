package Controlador;

import Vista.JFrAdmin;
import Vista.JFrLogin;
import Vista.JFrSecretaria;
import Vista.JFrJefePatio;
import Modelo.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlLogin implements ActionListener{
    
    private JFrLogin JFrLogin;
    
    public CtrlLogin(JFrLogin JFrLogin) {
        this.JFrLogin = JFrLogin;
        this.JFrLogin.btnIngresar.addActionListener(this);
        this.JFrLogin.btnCerrar.addActionListener(this);
        this.JFrLogin.txtUsuario.getText();
        this.JFrLogin.txtContraseña.getText();
        
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == JFrLogin.btnIngresar){
            
            if(JFrLogin.txtUsuario.getText() .isEmpty() && JFrLogin.txtContraseña.getText().isEmpty()){
            
                JOptionPane.showMessageDialog(null, "HAY CAMPOS VACIOS ","ALERTA ",1);
        
                JFrLogin.txtUsuario.requestFocus();
                
        }else {
    
            try {
                conexion con = new conexion();
                ResultSet resul;
                
                String usuario= JFrLogin.txtUsuario.getText();
                String contraseña= JFrLogin.txtContraseña.getText();
                
                String Sql="select cPrimerNombre,cTipoUsuario from tusuario where cUsuario='"+usuario+"' and cPass='"+contraseña+"'";
                
                resul=con.GetConsultar(Sql);
                
                if(resul.next()==true){
                   
                    String nombre = "";
                    
                  if (resul.getString("cTipoUsuario").equals("A"))  {
                      
                      
                      nombre =resul.getString("cPrimerNombre");
                      
                      JOptionPane.showMessageDialog(null, "Bienveni@ "+nombre);
                     
                      con.Setcerrar();
                      JFrLogin.dispose();
                      
                      JFrAdmin JFrAdmin = new JFrAdmin();
                      JFrAdmin.setVisible(true);
                      CtrlAdmin Ctrladmin = new CtrlAdmin(JFrAdmin);
                      
                  }else if (resul.getString("cTipoUsuario").equals("B")) {
                      
                      nombre =resul.getString("cPrimerNombre");
                      
                       JOptionPane.showMessageDialog(null, "Bienveni@ "+nombre);
                       
                       con.Setcerrar();
                       JFrLogin.dispose();

                       JFrSecretaria JFrSecretaria = new JFrSecretaria();
                       JFrSecretaria.setVisible(true);
                       CtrlSecretaria CtrlSecretaria = new CtrlSecretaria(JFrSecretaria);
                      
                  }else if (resul.getString("cTipoUsuario").equals("C")){
                      
                      nombre =resul.getString("cPrimerNombre");
                      
                      JOptionPane.showMessageDialog(null, "Bienveni@ "+nombre);
                      
                      con.Setcerrar();
                      JFrLogin.dispose();
                      
                      JFrJefePatio JFrJefePatio = new JFrJefePatio();
                      JFrJefePatio.setVisible(true);
                      CtrlJefePatios CtrlJefePatios = new CtrlJefePatios(JFrJefePatio);
                  }
                 
                }else {
                    
                  JOptionPane.showMessageDialog(null, "Datos erroneos ");  
                  this.JFrLogin.txtUsuario.setText("");
                  this.JFrLogin.txtContraseña.setText("");
                  this.JFrLogin.txtUsuario.requestFocus();
                    
                }
              
            } catch (Exception ex) {
                Logger.getLogger(CtrlLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }else if (e.getSource() == JFrLogin.btnCerrar){
        
        this.JFrLogin.dispose();
    }
        
    }
    
}




