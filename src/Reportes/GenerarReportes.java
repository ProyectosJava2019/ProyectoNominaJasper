/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import ventanas.principal;

/**
 *
 * @author icsic
 */
public class GenerarReportes 
{
    public void ReporteEmpleados(int idempleado)
    {
        try
        {
            JasperReport reporte= (JasperReport) JRLoader.loadObject("Empleados.jasper");
            Map parametro = new HashMap();

            parametro.put("idempleado", idempleado);

            JasperPrint j;
            j = JasperFillManager.fillReport(reporte, parametro, principal.hc);
            JasperViewer jv= new JasperViewer(j, false);
            jv.setTitle("Reporte");
            jv.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error reporte: "+e.getMessage());
        }
    }
}
