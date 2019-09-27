/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import clases.Conexion;
import clases.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author icsic
 */
public class Q_empleado 
{
    public List get_todos()
    {
        List lista = new ArrayList<>();
        String query = "select * from empleados";
        
        try{ 
            Connection conexion= Conexion.obtener_conexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(query);
            ResultSet filas = consulta.executeQuery();
            while(filas.next())
            {
                Empleado emp = new Empleado(
                        filas.getInt("clave"),
                        filas.getString("name"),
                        filas.getDouble("sd"),
                        filas.getDouble("dt"),
                        filas.getDouble("total")
                );
                lista.add(emp);
            }
        }catch(Exception ex){}
        return lista;
    }
    
    public List get_especifico(int clave)
    {
        List lista = new ArrayList<>();
        String query = "select * from empleados where clave="+clave;
        
        try{ 
            Connection conexion= Conexion.obtener_conexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(query);
            ResultSet filas = consulta.executeQuery();
            while(filas.next())
            {
                Empleado emp = new Empleado(
                        filas.getInt("clave"),
                        filas.getString("name"),
                        filas.getDouble("sd"),
                        filas.getDouble("dt"),
                        filas.getDouble("total")
                );
                lista.add(emp);
            }
        }catch(Exception ex){}
        return lista;
    }
    
    public int borrar(int id)
    {
        try{
            Connection conexion= Conexion.obtener_conexion();
            String query = "delete from empleados where clave = ?";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt(1,id);
            preparedStmt.execute();

            conexion.close();
            return 1;
        }
        catch(Exception ex)
        {
            return 0;
        }
    }
    
    public int existeclave(int clave)
    {
        String query = "select * from empleados where clave="+clave;
        int existe=0;
        try{ 
            Connection conexion= Conexion.obtener_conexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(query);
            ResultSet filas = consulta.executeQuery();
            
            while(filas.next())
            {
                existe=1;
            }
        }catch(Exception ex){}
        return existe;
    }
    
    public int insertar(int clave, String nombr, double sueld, double diast, double total)
    {
        try
        {
            Connection conexion= Conexion.obtener_conexion();
            // the mysql insert statement
            String query = " insert into empleados (clave, name, sd, dt, total) "
                    + "values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt (1, clave);
            preparedStmt.setString (2, nombr);
            preparedStmt.setDouble (3, sueld);
            preparedStmt.setDouble (4, diast);
            preparedStmt.setDouble (5, total);
            // execute the preparedstatement
            preparedStmt.execute();

            conexion.close();
            return 1;
        }
        catch (Exception e){return 0;}
    }
    
    public int actualizar(int clave, String nombr, double sueld, double diast, double total)
    {
        try
        {
            Connection conexion= Conexion.obtener_conexion();
            // the mysql insert statement
            String query = "update empleados set name=?, sd=?, dt=?, total=? where clave = ?";

            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString (1, nombr);
            preparedStmt.setDouble (2, sueld);
            preparedStmt.setDouble (3, diast);
            preparedStmt.setDouble (4, total);
            preparedStmt.setInt (5, clave);
            // execute the preparedstatement
            preparedStmt.execute();

            conexion.close();
            return 1;
        }
        catch (Exception e){return 0;}
    }
}
