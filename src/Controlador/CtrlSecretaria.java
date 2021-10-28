
package Controlador;

import Vista.JFrLogin;
import Vista.JFrRegistrarAlquiler;
import Vista.JFrRegistrarClientes;
import Vista.JFrSecretaria;
import Vista.JFrVehiculosSecretaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrlSecretaria implements ActionListener{
    
    private JFrSecretaria JFrSecretaria;

    public CtrlSecretaria(JFrSecretaria JFrSecretaria) {
        this.JFrSecretaria = JFrSecretaria;
        this.JFrSecretaria.BtnRegistrarAlquiler.addActionListener(this);
        this.JFrSecretaria.BtnCerrar.addActionListener(this);
        this.JFrSecretaria.BtnClientes.addActionListener(this);
        this.JFrSecretaria.BtnVehiculos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == JFrSecretaria.BtnCerrar){
            
            JFrSecretaria.dispose();
            JFrLogin JFrLogin = new JFrLogin(); 
            JFrLogin.setVisible(true);
            CtrlLogin log= new CtrlLogin(JFrLogin);
            
        }else if (e.getSource() == JFrSecretaria.BtnClientes){
            
            JFrSecretaria.dispose();
            JFrRegistrarClientes JFrRegistrarClientes = new JFrRegistrarClientes();
            JFrRegistrarClientes.setVisible(true);
            CtrlRegistrarClientes MdlRegistrarClientes = new CtrlRegistrarClientes(JFrRegistrarClientes);
                        
        }else if (e.getSource() == JFrSecretaria.BtnRegistrarAlquiler){
            
            JFrSecretaria.dispose();
            JFrRegistrarAlquiler JFrRegistrarAlquiler = new JFrRegistrarAlquiler();
            JFrRegistrarAlquiler.setVisible(true);
            CtrlRegistrarAlquiler CtrlRegistrarAlquiler = new CtrlRegistrarAlquiler(JFrRegistrarAlquiler);
            
        }else if (e.getSource() == JFrSecretaria.BtnVehiculos){
            
            JFrSecretaria.dispose();
            JFrVehiculosSecretaria JFrVehiculosSecretaria = new JFrVehiculosSecretaria();
            JFrVehiculosSecretaria.setVisible(true);
            CtrlVehiculosSecretaria CtrlVehiculosSecretaria = new CtrlVehiculosSecretaria(JFrVehiculosSecretaria);
            
        }


    }
    
}
