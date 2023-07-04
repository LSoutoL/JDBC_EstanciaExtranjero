/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extrajdbc_estanciaextranjero;

import extrajdbc_estanciaextranjero.servicios.CasaServicio;
import extrajdbc_estanciaextranjero.servicios.ClienteServicio;
import extrajdbc_estanciaextranjero.servicios.ComentarioServicio;
import extrajdbc_estanciaextranjero.servicios.EstanciaServicio;
import extrajdbc_estanciaextranjero.servicios.FamiliaServicio;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class ExtraJDBC_EstanciaExtranjero {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) throws Exception {
       /*
        Realizar un menú en java a través del cual se permita elegir qué consulta se desea realizar.
Las consultas a realizar sobre la BD son las siguientes:
a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de
2020 y el 31 de agosto de 2020 en Reino Unido.
c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada
y un número de días específico.
e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la
descripción de la casa donde la realizaron.
f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y
ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a
la anterior
g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el
precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios
actualizados.
h) Obtener el número de casas que existen para cada uno de los países diferentes.
i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios)
que están ‘limpias’.
j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
        */
       
       Scanner leer = new Scanner(System.in).useDelimiter("\n");
        FamiliaServicio fs = new FamiliaServicio();
        CasaServicio cs = new CasaServicio();
        ClienteServicio cls = new ClienteServicio();
        ComentarioServicio cos = new ComentarioServicio();
        EstanciaServicio es = new EstanciaServicio();
        int opc;
        do{
            System.out.println("Indica la accion que queres realizar:");
            System.out.println("1. Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.");
            System.out.println("""
                               2. Casas disponibles para el periodo comprendido entre el 1 de agosto de
                               2020 y el 31 de agosto de 2020 en Reino Unido.""");
            System.out.println("3. Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.");
            System.out.println("4. Casas disponibles a partir de una fecha dada y un numero de dias especifico.");
            System.out.println("""
                               5. Listar los datos de todos los clientes que en algun momento realizaron una estancia y la
                               descripcion de la casa donde la realizaron.""");
            System.out.println("""
                               6. Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, pais y
                               ciudad del cliente y ademas la informacion de la casa que reservo. La que reemplazara a
                               la anterior.""");
            System.out.println("7. Mostar los precios actualizados de Reino Unido.");
            System.out.println("8. Obtener el número de casas que existen para cada uno de los países diferentes.");
            System.out.println("""
                               9. Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios)
                               que estan 'limpias'.""");
            System.out.println("10. Reservar una estancia");
            System.out.println("11. Salir");
            opc=leer.nextInt();
            switch (opc){
                case 1 -> {fs.tresHijosMenoresDeDiez();}
                case 2 -> {cs.agostoEnUK();}
                case 3 -> {fs.correoHotmail();}
                case 4 -> {cs.periodoConDias();}
                case 5 -> {cls.clienteXcasa();}
                case 6 -> {cls.clienteXcasaRserva();}
                case 7 -> {cs.preciosActualizados();}
                case 8 -> {cs.casasPorPais();}
                case 9 -> {cos.casasLimpias();}
                case 10 -> {es.reservarEstancia();}
            }
        } while (opc!=11);
      
    }  
}
