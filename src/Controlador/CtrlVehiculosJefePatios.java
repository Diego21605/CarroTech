package Controlador;

import Modelo.conexion;
import Vista.JFrJefePatio;
import Vista.JFrVehiculosJefePatios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class CtrlVehiculosJefePatios implements ActionListener{
    
    private JFrVehiculosJefePatios JFrVehiculosJefePatios;

    public CtrlVehiculosJefePatios(JFrVehiculosJefePatios JFrVehiculosJefePatios) {
        this.JFrVehiculosJefePatios = JFrVehiculosJefePatios;
        this.JFrVehiculosJefePatios.btnEditar.addActionListener(this);
        this.JFrVehiculosJefePatios.btnMostrar.addActionListener(this);
        this.JFrVehiculosJefePatios.btnRegresar.addActionListener(this);
        this.JFrVehiculosJefePatios.btnConsultar.addActionListener(this);
        this.JFrVehiculosJefePatios.txtPlaca.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == JFrVehiculosJefePatios.btnEditar){
            
            try {

                conexion con = new conexion();
                
                String placa = JFrVehiculosJefePatios.txtPlaca.getText();
                String marca = JFrVehiculosJefePatios.txtMarca.getText();
                String modelo = JFrVehiculosJefePatios.txtModelo.getText();
                String color = JFrVehiculosJefePatios.txtColor.getText();
                String tipo = JFrVehiculosJefePatios.txtTipo.getText();
                
                String Sql="update tvehiculo set cMarca='"+marca+"',cModelo='"+modelo+"',cColor='"+color+"',cTipoVehiculo='"+tipo+"' where cPlaca='"+placa+"';";
                con.dml(Sql);
                JOptionPane.showMessageDialog(null, "Actualizacion con exito " , "FELICIDADES " , JOptionPane.OK_OPTION);
                con.Setcerrar();

                JFrVehiculosJefePatios.txtPlaca.setText("");
                JFrVehiculosJefePatios.txtMarca.setText("");
                JFrVehiculosJefePatios.txtModelo.setText("");
                JFrVehiculosJefePatios.txtColor.setText("");
                JFrVehiculosJefePatios.txtTipo.setText("");
                
        } catch (Exception ex) {
                System.out.println(ex);
        }
            
        }else if (e.getSource() == JFrVehiculosJefePatios.btnMostrar){
            
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
            
                        this.JFrVehiculosJefePatios.tableVehiculos.setModel(model);
                        
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
            
        }else if (e.getSource() == JFrVehiculosJefePatios.btnRegresar){
            
            this.JFrVehiculosJefePatios.dispose();
            JFrJefePatio JFrJefePatio = new JFrJefePatio();
            JFrJefePatio.setVisible(true);
            CtrlJefePatios CtrlJefePatios = new CtrlJefePatios(JFrJefePatio);
            
        }else if (e.getSource() == JFrVehiculosJefePatios.btnConsultar){
            
            try {
            conexion con = new conexion ();
            ResultSet res;
            String placa = JFrVehiculosJefePatios.txtPlaca.getText();
            String Sql="select * from tvehiculo where cPlaca = '"+placa+"';";
            
            res=con.GetConsultar(Sql);
            if(res.next()==true){
                 JFrVehiculosJefePatios.txtMarca.setText(res.getString("cMarca"));
                 JFrVehiculosJefePatios.txtModelo.setText(res.getString("cModelo"));
                 JFrVehiculosJefePatios.txtColor.setText(res.getString("cColor"));
                 JFrVehiculosJefePatios.txtTipo.setText(res.getString("cTipoVehiculo"));
                 
                     con.Setcerrar();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "Datos erroneos");
                 }
            
        } catch (Exception ex) {
                System.out.println(ex);
        }
            
        }
        
    }
    
    
    
    
}
