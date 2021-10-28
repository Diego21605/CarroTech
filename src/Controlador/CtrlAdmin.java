
package Controlador;

import Vista.JFrAdmin;
import Vista.JFrEmpleados;
import Vista.JFrLogin;
import Vista.JFrReporteAlquiler;
import Vista.JFrTablaClienteA;
import Vista.JFrVehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author John
 */
public class CtrlAdmin implements ActionListener{
    
    private JFrAdmin JFrAdmin;
    
    public CtrlAdmin(JFrAdmin JFrAdmin) {
        
           this.JFrAdmin = JFrAdmin;
           this.JFrAdmin.btnEmpleados.addActionListener(this);
           this.JFrAdmin.btnCerrarA.addActionListener(this);
           this.JFrAdmin.btnAutos.addActionListener(this);
           this.JFrAdmin.btnCliente.addActionListener(this);
           this.JFrAdmin.btnReporte.addActionListener(this);
       }
   
  
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==JFrAdmin.btnEmpleados) {
            
            JFrAdmin.dispose();
            JFrEmpleados JFrEmpleados = new JFrEmpleados();
            JFrEmpleados.setVisible(true);
            CtrlEmpleados CtrlEmpleados = new CtrlEmpleados(JFrEmpleados);
            
        } else if (e.getSource() == JFrAdmin.btnCerrarA) {
            
            JFrAdmin.dispose();
            JFrLogin JFrLogin = new JFrLogin(); 
            JFrLogin.setVisible(true);
            CtrlLogin log= new CtrlLogin(JFrLogin);
            
        }else if (e.getSource() == JFrAdmin.btnAutos){
            
            JFrAdmin.dispose();
            JFrVehiculos JFrVehiculos = new JFrVehiculos(); 
            JFrVehiculos.setVisible(true);
            CtrlVehiculos log= new CtrlVehiculos(JFrVehiculos);
            
        }else if (e.getSource() == JFrAdmin.btnCliente){
            
            JFrAdmin.dispose();
            JFrTablaClienteA JFrTablaClienteA = new JFrTablaClienteA(); 
            JFrTablaClienteA.setVisible(true);
            CtrlTablaClienteA log= new CtrlTablaClienteA(JFrTablaClienteA);
            
        }else if(e.getSource() == JFrAdmin.btnReporte){
            
            JFrAdmin.dispose();
            JFrReporteAlquiler JFrReporteAlquiles = new JFrReporteAlquiler();
            JFrReporteAlquiles.setVisible(true);
            CtrlReporteAlquiler CtrlReporteAlquiler = new CtrlReporteAlquiler(JFrReporteAlquiles);
            
        }
        
    }

   
}
