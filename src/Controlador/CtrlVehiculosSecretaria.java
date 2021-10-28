
package Controlador;

import Modelo.conexion;
import Vista.JFrSecretaria;
import Vista.JFrVehiculosSecretaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John
 */
public class CtrlVehiculosSecretaria implements ActionListener{
    
    private JFrVehiculosSecretaria JfrVehiculosSecretaria;

    public CtrlVehiculosSecretaria(JFrVehiculosSecretaria JfrVehiculosSecretaria) {
        this.JfrVehiculosSecretaria = JfrVehiculosSecretaria;
        this.JfrVehiculosSecretaria.btnMostrar.addActionListener(this);
        this.JfrVehiculosSecretaria.btnEditar.addActionListener(this);
        this.JfrVehiculosSecretaria.btnRegresar.addActionListener(this);
        this.JfrVehiculosSecretaria.btnConsultar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == JfrVehiculosSecretaria.btnMostrar){
            
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
            
                        this.JfrVehiculosSecretaria.tableVehiculos.setModel(model);
                        
                        String [] info=new String[5];
                        
                        do{
                     
                            info[0]=res.getString("cPlaca");
                            info[1]=res.getString("CMarca");
                            info[2]=res.getString("CModelo");
                            info[3]=res.getString("cColor");
                            info[4]=res.getString("cTipoVehiculo");
                            model.addRow(info);
                            
                    }while(res.next());
                 
                }else{
                
                    con.Setcerrar();
                    
                    JOptionPane.showMessageDialog(null, "Datos erroneos");
                    
                }
            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "error","ERROR",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, ex);
            }
            
        }else if (e.getSource() == JfrVehiculosSecretaria.btnEditar){
            
            try {

                conexion con = new conexion();
                
                String placa = JfrVehiculosSecretaria.txtPlaca.getText();
                String marca = JfrVehiculosSecretaria.txtMarca.getText();
                String modelo = JfrVehiculosSecretaria.txtModelo.getText();
                String color = JfrVehiculosSecretaria.txtColor.getText();
                String tipo = JfrVehiculosSecretaria.txtTipo.getText();
                
                String Sql="update tvehiculo set cMarca='"+marca+"',cModelo='"+modelo+"',cColor='"+color+"',cTipoVehiculo='"+tipo+"' where cPlaca='"+placa+"';";
                con.dml(Sql);
                JOptionPane.showMessageDialog(null, "Actualizacion con exito " , "FELICIDADES " , JOptionPane.OK_OPTION);
                con.Setcerrar();

                JfrVehiculosSecretaria.txtPlaca.setText("");
                JfrVehiculosSecretaria.txtMarca.setText("");
                JfrVehiculosSecretaria.txtModelo.setText("");
                JfrVehiculosSecretaria.txtColor.setText("");
                JfrVehiculosSecretaria.txtTipo.setText("");
                
        } catch (Exception ex) {
                System.out.println(ex);
        }
            
        }else if (e.getSource() == JfrVehiculosSecretaria.btnRegresar){
            
            JfrVehiculosSecretaria.dispose();
            JFrSecretaria JFrSecretaria = new JFrSecretaria();
            JFrSecretaria.setVisible(true);
            CtrlSecretaria CtrlSecretaria = new CtrlSecretaria(JFrSecretaria);
            
        }else if (e.getSource() == JfrVehiculosSecretaria.btnConsultar){
            
            try {
                conexion con = new conexion ();
                ResultSet res;
                String placa = JfrVehiculosSecretaria.txtPlaca.getText();
                String Sql="select * from tvehiculo where cPlaca = '"+placa+"';";
            
                res=con.GetConsultar(Sql);
            
                if(res.next()==true){
                    JfrVehiculosSecretaria.txtMarca.setText(res.getString("cMarca"));
                    JfrVehiculosSecretaria.txtModelo.setText(res.getString("cModelo"));
                    JfrVehiculosSecretaria.txtColor.setText(res.getString("cColor"));
                    JfrVehiculosSecretaria.txtTipo.setText(res.getString("cTipoVehiculo"));
                 
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
