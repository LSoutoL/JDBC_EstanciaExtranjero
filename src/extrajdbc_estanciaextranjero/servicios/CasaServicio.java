/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.servicios;


import extrajdbc_estanciaextranjero.entidades.Casa;
import extrajdbc_estanciaextranjero.persistencia.CasaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class CasaServicio {
    private CasaDAO dao;

    public CasaServicio() {
        this.dao=new CasaDAO();
    }
    
    public void agostoEnUK() throws Exception{
        String condicion = "WHERE fecha_desde ='2020-08-01' AND fecha_hasta='2020-08-31' AND pais LIKE 'Reino Unido'";
         ArrayList<Casa> casas = dao.consultaCasa(condicion);
         System.out.println("ID   | Calle      | Numero | Codigo Postal | Ciudad     | Pais        | Desde   | Hasta   | Tiempo min | Tiempo Max | Precio | Tipo        ");
         for (Casa casa : casas) {
             System.out.println(casa.getId_casa() + " | " + casa.getCalle() + " | " + casa.getNumero() + " | " + casa.getCodigo_postal() + " | " + casa.getCiudad() + " | " + casa.getPais() + " | "+ casa.getFecha_desde().toString() + " | " + casa.getFecha_hasta().toString() + " | " + casa.getTiempo_minimo() + " | " + casa.getTiempo_maximo() + " | "+ casa.getPrecio_habitacion() + " | " + casa.getTipo_vivienda());
    }
    }
    
    public void periodoConDias() throws Exception{
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Indique la fecha inicial (YYYY MM DD):");
        Integer anio=leer.nextInt();
        Integer mes=leer.nextInt();
        Integer dia=leer.nextInt();
        System.out.println(mes.toString().length());
        System.out.println("Indique la cantidad de dias:");
        int dias=leer.nextInt();
        String condicion = "WHERE fecha_desde<='" + anio + "-" + mes + "-" + dia + "' AND tiempo_minimo <= " + dias + " AND tiempo_maximo >= " + dias;
         ArrayList<Casa> casas = dao.consultaCasa(condicion);
         System.out.println("ID   | Calle      | Numero | Codigo Postal | Ciudad     | Pais        | Desde   | Hasta   | Tiempo min | Tiempo Max | Precio | Tipo        ");
         for (Casa casa : casas) {
             System.out.println(casa.getId_casa() + " | " + casa.getCalle() + " | " + casa.getNumero() + " | " + casa.getCodigo_postal() + " | " + casa.getCiudad() + " | " + casa.getPais() + " | "+ casa.getFecha_desde().toString() + " | " + casa.getFecha_hasta().toString() + " | " + casa.getTiempo_minimo() + " | " + casa.getTiempo_maximo() + " | "+ casa.getPrecio_habitacion() + " | " + casa.getTipo_vivienda());
        }
    }
    
    public void preciosActualizados() throws Exception{
        String condicion = "";
        ArrayList<Casa> casas = dao.consultaCasa(condicion);
        System.out.println("ID   | Calle      | Numero | Codigo Postal | Ciudad     | Pais        | Desde   | Hasta   | Tiempo min | Tiempo Max | Precio | Tipo        ");
        for (Casa casa : casas) {
            casa.setPrecio_habitacion(casa.getPrecio_habitacion()+(casa.getPrecio_habitacion()*0.05));
            System.out.println(casa.getId_casa() + " | " + casa.getCalle() + " | " + casa.getNumero() + " | " + casa.getCodigo_postal() + " | " + casa.getCiudad() + " | " + casa.getPais() + " | "+ casa.getFecha_desde().toString() + " | " + casa.getFecha_hasta().toString() + " | " + casa.getTiempo_minimo() + " | " + casa.getTiempo_maximo() + " | "+ casa.getPrecio_habitacion() + " | " + casa.getTipo_vivienda());
        //dao.modificarPrecio(casa);
        }
    }
    
    public void casasPorPais() throws Exception{
        String condicion = "SELECT COUNT(id_casa) as cantidad, pais FROM casas GROUP BY pais;";
        HashMap<String, Integer> casas = dao.consultasCasa(condicion);
         System.out.println("Cantidad de casas   | Pais        ");
         for (Map.Entry<String, Integer> entry : casas.entrySet()) {
             System.out.println(entry.getValue() + "             | " + entry.getKey());
            
        }
    }
    
}
