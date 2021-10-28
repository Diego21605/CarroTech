
package Controlador;

import Vista.JFrJefePatio;
import Vista.JFrLogin;
import Vista.JFrVehiculosJefePatios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrlJefePatios implements ActionListener{
    
    private JFrJefePatio JFrJefePatio;

    public CtrlJefePatios(JFrJefePatio JFrJefePatio) {
        this.JFrJefePatio = JFrJefePatio;
        this.JFrJefePatio.BtnCerrar.addActionListener(this);
        this.JFrJefePatio.BtnVehiculos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == JFrJefePatio.BtnCerrar){
            
            JFrJefePatio.dispose();
            JFrLogin JFrLogin = new JFrLogin(); 
            JFrLogin.setVisible(true);
            CtrlLogin log= new CtrlLogin(JFrLogin);
            
        }else if (e.getSource() == JFrJefePatio.BtnVehiculos){
            
            JFrJefePatio.dispose();
            JFrVehiculosJefePatios JFrVehiculosJefePatios = new JFrVehiculosJefePatios();
            JFrVehiculosJefePatios.setVisible(true);
            CtrlVehiculosJefePatios CtrlVehiculosJefePatios = new CtrlVehiculosJefePatios(JFrVehiculosJefePatios);
            
        }

    }
    
}
