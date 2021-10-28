package Controlador;

import Modelo.conexion;
import Vista.JFrAdmin;
import Vista.JFrEmpleados;
import Vista.JFrRegistrarEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class CtrlEmpleados implements ActionListener{
    
    private JFrEmpleados JFrEmpleados;
    
     public CtrlEmpleados(JFrEmpleados JFrEmpleados) {
        this.JFrEmpleados = JFrEmpleados;
        this.JFrEmpleados.btnRegistrarE.addActionListener(this);
        this.JFrEmpleados.btnRegresar.addActionListener(this);
        this.JFrEmpleados.btnMostar.addActionListener(this);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==JFrEmpleados.btnRegistrarE){
                        
            JFrEmpleados.dispose();
            JFrRegistrarEmpleados JFrRegistrarEmpleados = new JFrRegistrarEmpleados(); 
            JFrRegistrarEmpleados.setVisible(true);
            JOptionPane.showMessageDialog(null, "Para llenar el campo 'Tipo de Usuario' debes colocar  \n"
                    + "A ---> Para los usuarios de tipo Administrador \n"
                    + "B ---> Para los usuarios de tipo Secretari@ \n"
                    + "C ---> Para los usuarios de tipo Jefe de patios \n"
                    + "Se debe colocar en mayusculas.");
            CtrlRegistrarEmpleados CtrlRegistrarEmpleados = new CtrlRegistrarEmpleados(JFrRegistrarEmpleados);
            
        }else if(e.getSource()==JFrEmpleados.btnMostar){
            
            try {
                conexion con = new conexion ();
                ResultSet res;
                String Sql = "SELECT * FROM tusuario";
                res=con.GetConsultar(Sql);
                
                if(res.next()){
                
                    DefaultTableModel model =new DefaultTableModel();
                
                        model.addColumn("Nombre");
                        model.addColumn("Apellido");
                        model.addColumn("Usuario");
                        model.addColumn("Contraseña");
                        model.addColumn("Dni");
                        model.addColumn("Telefono");
                        model.addColumn("Direccion");
                        model.addColumn("Tipo de Usuarios");
            
                        this.JFrEmpleados.jTableEmpleados.setModel(model);
                        
                        String [] info=new String[8];
                        
                        do{
                     
                            info[0]=res.getString("cPrimerNombre");
                            info[1]=res.getString("cPrimerApellido");
                            info[2]=res.getString("cUsuario");
                            info[3]=res.getString("cPass");
                            info[4]=res.getString("nIdentificacion");
                            info[5]=res.getString("nTelefono");
                            info[6]=res.getString("cDireccion");
                            info[7]=res.getString("cTipoUsuario");
                            model.addRow(info);
                            
                    } while(res.next());
                 
                }else{
                
                    con.Setcerrar();
                    
                    JOptionPane.showMessageDialog(null, "Datos erroneos");
                    
                }
            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "error","ERROR",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, ex);
            }
            
        }else if(e.getSource()==JFrEmpleados.btnRegresar){
            
            JFrEmpleados.dispose();
            JFrAdmin JFrAdmin = new JFrAdmin(); 
            JFrAdmin.setVisible(true);
            CtrlAdmin log= new CtrlAdmin(JFrAdmin);
            
        }
    }
    
}
