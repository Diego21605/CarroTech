package Controlador;

import Vista.JFrCarga;
import Vista.JFrLogin;

public class CtrlCarga extends javax.swing.JFrame implements Runnable{

    private JFrCarga JFrCarga;
    private Thread tiempo=null;

    public CtrlCarga(JFrCarga JFrCarga) {
        this.JFrCarga = JFrCarga;
        this.tiempo=new Thread(this);
        this.tiempo.start();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrCarga().setVisible(true);
            }
        });
    }

    @Override
    public void run() {

        try {

             Thread.sleep(5000);
             JFrCarga.dispose();
             JFrLogin JFrLogin = new JFrLogin();
             JFrLogin.setVisible(true);
             CtrlLogin log= new CtrlLogin(JFrLogin);
             JFrLogin.txtUsuario.requestFocus();

         } catch (InterruptedException ex) {

         }
    }



}