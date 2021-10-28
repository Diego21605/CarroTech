/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrotech;

//import Controlador.CtrlLogin;
import Controlador.CtrlCarga;
import Vista.JFrCarga;
//import Vista.JFrLogin;

/**
 *
 * @author John
 */
public class Carrotech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       /*
       CtrlLogin log= new CtrlLogin(JFrLogin);*/
       
       JFrCarga JFrCarga = new JFrCarga(); 
       JFrCarga.setVisible(true);
       CtrlCarga log= new CtrlCarga(JFrCarga);
       
    }
    
}