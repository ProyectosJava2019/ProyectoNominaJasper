/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author icsic
 */
public class Conexion 
{
    private static Connection conexionmysql = null;

    public static Connection obtener_conexion()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexionmysql = DriverManager.getConnection("jdbc:mysql://127.0.0.1/msc", "root", "");
            return conexionmysql;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }      
}
