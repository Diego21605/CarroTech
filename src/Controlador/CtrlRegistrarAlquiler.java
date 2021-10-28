
package Controlador;

import Vista.JFrRegistrarAlquiler;
import Vista.JFrSecretaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author John
 */
public class CtrlRegistrarAlquiler implements ActionListener{
    private JFrRegistrarAlquiler JFrRegistrarAlquiler;

    public CtrlRegistrarAlquiler(JFrRegistrarAlquiler JFrRegistrarAlquiler) {
        this.JFrRegistrarAlquiler=JFrRegistrarAlquiler;
        this.JFrRegistrarAlquiler.Enviar.addActionListener(this);
        this.JFrRegistrarAlquiler.btnRegresar.addActionListener(this);
        this.JFrRegistrarAlquiler.btnImprimir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == JFrRegistrarAlquiler.Enviar){
            
            
            
        }else if (e.getSource() == JFrRegistrarAlquiler.btnImprimir){
            
            
        }else if(e.getSource() == JFrRegistrarAlquiler.btnRegresar){
            
            JFrRegistrarAlquiler.dispose();
            JFrSecretaria JFrSecretaria = new JFrSecretaria();
            JFrSecretaria.setVisible(true);
            CtrlSecretaria CtrlSecretaria = new CtrlSecretaria(JFrSecretaria);
            
        }
        
    }
    
}
