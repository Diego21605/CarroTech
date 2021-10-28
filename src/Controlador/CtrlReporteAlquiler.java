package Controlador;

import Vista.JFrAdmin;
import Vista.JFrReporteAlquiler;
import Vista.JFrSecretaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LENOVO
 */
public class CtrlReporteAlquiler implements ActionListener{
    
    private JFrReporteAlquiler JFrReporteAlquiler;

    public CtrlReporteAlquiler(JFrReporteAlquiler JFrReporteAlquiler) {
        this.JFrReporteAlquiler = JFrReporteAlquiler;
        this.JFrReporteAlquiler.btnMostrar.addActionListener(this);
        this.JFrReporteAlquiler.btnRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == JFrReporteAlquiler.btnMostrar){
            
        }else if (e.getSource() == JFrReporteAlquiler.btnRegresar){
            
            JFrReporteAlquiler.dispose();
            JFrAdmin JFrAdmin = new JFrAdmin();
            JFrAdmin.setVisible(true);
            CtrlAdmin CtrlAdmin = new CtrlAdmin(JFrAdmin);
            
        }
        
    }
    
}
