/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.servicios;

import extrajdbc_estanciaextranjero.entidades.Casa;
import extrajdbc_estanciaextranjero.entidades.Cliente;
import extrajdbc_estanciaextranjero.entidades.Estancia;
import extrajdbc_estanciaextranjero.persistencia.CasaDAO;
import extrajdbc_estanciaextranjero.persistencia.ClienteDAO;
import extrajdbc_estanciaextranjero.persistencia.EstanciaDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucia
 */
public class ClienteServicio {
    private ClienteDAO dao;
    

    public ClienteServicio() {
        this.dao=new ClienteDAO();
    }
    
   public void clienteXcasa() throws Exception{
        String condicion = " INNER JOIN estancias e ON cl.id_cliente = e.id_cliente INNER JOIN casas c ON c.id_casa=e.id_casa";
         ArrayList<Cliente> clientes = dao.consulta(condicion);
         ArrayList<Estancia> estancias = dao.consultaEstancia(condicion);
         ArrayList<Casa> casas = dao.consultaCasa(condicion);
         System.out.println("ID Cliente   | Nombre    | Calle   | Numero | Codigo Postal | Ciudad     | Pais        | Email   |  ID Casa | Calle    | Numero    | Codigo Postal | Ciudad     | Pais       | Tipo de vivienda");
         for (Cliente cliente : clientes) {
             for (Casa casa : casas) {
                 for (Estancia estancia : estancias) {
                     if (estancia.getId_cliente()==cliente.getId_cliente() && estancia.getId_casa()==casa.getId_casa()){
                         System.out.println(cliente.getNombre() + " | " + cliente.getCalle() + " | " + cliente.getNumero() + " | " + cliente.getCodigo_postal() + " | " + cliente.getCiudad() + " | " + cliente.getPais() + " | " + cliente.getEmail() +" | "+ casa.getId_casa() + " | " + casa.getCalle() + " | " + casa.getNumero() + " | " + casa.getCodigo_postal() + " | " + casa.getCiudad() + " | " + casa.getPais() + " | " + casa.getTipo_vivienda());
                     }
                 }
             }
       }
    }
   public void clienteXcasaRserva() throws Exception{
       String condicion = " INNER JOIN estancias e ON cl.id_cliente=e.id_cliente INNER JOIN casas c ON c.id_casa=e.id_casa";
        ArrayList<Cliente> clientes = dao.consulta(condicion);
         ArrayList<Estancia> estancias = dao.consultaEstancia(condicion);
         ArrayList<Casa> casas = dao.consultaCasa(condicion);
         System.out.println("ID Estancia| ID Cliente| ID Casa| Nombre huesped | Desde | Hasta  | Nombre cliente    | Ciudad    |  Pais | Calle    | Numero    | Codigo Postal | Ciudad     | Pais       | Tipo de vivienda");
         for (Cliente cliente : clientes) {
             for (Casa casa : casas) {
                 for (Estancia estancia : estancias) {
                     if (estancia.getId_cliente()==cliente.getId_cliente() && estancia.getId_casa()==casa.getId_casa()){
                         System.out.println(estancia.getId_estancia() + " | " + estancia.getId_cliente() + " | " + estancia.getId_casa() + " | " + estancia.getNombre_huesped() + " | " +  estancia.getFecha_desde() + " | " + estancia.getFecha_hasta() + " | " + cliente.getNombre() + " | " + cliente.getCiudad() + " | " + cliente.getPais() + " | "  + casa.getCalle() + " | " + casa.getNumero() + " | " + casa.getCodigo_postal() + " | " + casa.getCiudad() + " | " + casa.getPais() + " | " + casa.getTipo_vivienda());
                     }
                 }
             }
       }
   }
}
