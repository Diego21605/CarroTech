/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.*;
import com.mysql.jdbc.jdbc2.optional.*;


public class conexion {

    Connection conexion;
    ResultSet resul;
    Statement stm;

  public conexion () throws Exception{

    MysqlDataSource datos = new MysqlDataSource();

    datos.setServerName("localhost");
    datos.setUser("root");
    datos.setPassword("");
    datos.setDatabaseName("carrotech_bd");

    conexion = datos.getConnection();

  }

  public void dml(String instrucciones) throws SQLException{

     stm=conexion.createStatement();
     stm.execute(instrucciones);

  }

  public ResultSet GetConsultar (String sql) throws SQLException{

      stm=conexion.createStatement();
      resul=stm.executeQuery(sql);
      return resul;

  }

  public void Setcerrar() throws SQLException{

      conexion.close();

  }

}
