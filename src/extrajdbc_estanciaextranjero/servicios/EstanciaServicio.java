/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.servicios;

import extrajdbc_estanciaextranjero.entidades.Casa;
import extrajdbc_estanciaextranjero.entidades.Estancia;
import extrajdbc_estanciaextranjero.persistencia.CasaDAO;
import extrajdbc_estanciaextranjero.persistencia.EstanciaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class EstanciaServicio {
    private EstanciaDAO dao;
    private CasaDAO daoC;
    private Scanner leer;

    public EstanciaServicio() {
        this.dao=new EstanciaDAO();
        this.daoC=new CasaDAO();
        this.leer=  new Scanner(System.in).useDelimiter("\n");
    }
    
    public void reservarEstancia() throws Exception{
        System.out.println("Indique el codigo de estancia a modificar");
        int id_estancia=leer.nextInt();
        System.out.println("Indique una fecha incial(YYYY MM DD)");
        int anio = leer.nextInt();
        int mes = leer.nextInt();
        int dia = leer.nextInt();
        Date fecha = new Date (anio, mes, dia);
        System.out.println("Indique la cantidad de dias:");
        int dias = leer.nextInt();
        ArrayList<Estancia> estancias = dao.consultaEstancia();
        try{
        for (Estancia estancia : estancias) {
            if (estancia.getId_estancia()==id_estancia){
            if (estancia.getFecha_desde().before(fecha)){
                if (estancia.getFecha_hasta().before(fecha)){
                    estancia.setFecha_desde(fecha);
                    estancia.setFecha_hasta(new Date(anio, mes, (dia+dias)));
                    dao.modificar(estancia);
                } else throw new Exception("Error. La fecha no esta disponible.");
            } else if (estancia.getFecha_desde().after(fecha) && estancia.getFecha_desde().after(new Date(anio, mes, (dia+dias)))){
                estancia.setFecha_desde(fecha);
                System.out.println(mes);
                estancia.setFecha_hasta(new Date(anio, mes, (dia+dias)));
                dao.modificar(estancia);
            }    
        }
            
        }
        } catch (Exception e){
            throw e;
        }
    }
    
}
