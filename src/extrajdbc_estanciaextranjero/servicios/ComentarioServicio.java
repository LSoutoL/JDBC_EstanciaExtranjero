/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.servicios;

import extrajdbc_estanciaextranjero.entidades.Casa;
import extrajdbc_estanciaextranjero.entidades.Comentario;
import extrajdbc_estanciaextranjero.persistencia.ComentarioDAO;
import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public class ComentarioServicio {
    private ComentarioDAO dao;

    public ComentarioServicio() {
        this.dao=new ComentarioDAO();
    }
    
    public void casasLimpias() throws Exception{
        String condicion = "SELECT c.id_casa, c.calle, c.numero, c.codigo_postal, c.ciudad, c.pais, c.fecha_desde, c.fecha_hasta, c.tiempo_minimo, c.tiempo_maximo, c.precio_habitacion, c.tipo_vivienda FROM casas c JOIN comentarios co ON co.id_casa=c.id_casa WHERE co.comentario LIKE '%limpia%' GROUP BY co.id_casa;";
         ArrayList<Casa> casas = dao.consultaCasa(condicion);
          System.out.println("ID   | Calle      | Numero | Codigo Postal | Ciudad     | Pais        | Desde   | Hasta   | Tiempo min | Tiempo Max | Precio | Tipo        ");
             for (Casa casa : casas) {
                System.out.println(casa.getId_casa() + " | " + casa.getCalle() + " | " + casa.getNumero() + " | " + casa.getCodigo_postal() + " | " + casa.getCiudad() + " | " + casa.getPais() + " | "+ casa.getFecha_desde().toString() + " | " + casa.getFecha_hasta().toString() + " | " + casa.getTiempo_minimo() + " | " + casa.getTiempo_maximo() + " | "+ casa.getPrecio_habitacion() + " | " + casa.getTipo_vivienda());
             }
    }  
}
