/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.servicios;

import extrajdbc_estanciaextranjero.entidades.Familia;
import extrajdbc_estanciaextranjero.persistencia.FamiliaDAO;
import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public class FamiliaServicio {
    private FamiliaDAO dao;

    public FamiliaServicio() {
        this.dao= new FamiliaDAO();
    }
    
    public void tresHijosMenoresDeDiez() throws Exception{
         String condicion = "WHERE num_hijos>=3 AND edad_maxima<=10";
         ArrayList<Familia> familias = dao.consultaFamilia(condicion);
         System.out.println("ID   | Nombre    | Edad Minma | Edad Maxima | Hijos | Email          | ID Casa   ");
         for (Familia familia : familias) {
             System.out.println(familia.getId_familia() + " | " + familia.getNombre() + " | " + familia.getEdad_minima() + " | " + familia.getEdad_maxima() + " | " + familia.getNum_hijos() + " | " + familia.getEmail() + " | "+ familia.getId_casa_familia());
        }
    }
    
    public void correoHotmail() throws Exception{
         String condicion = "WHERE email LIKE '%hotmail%'";
         ArrayList<Familia> familias = dao.consultaFamilia(condicion);
         System.out.println("ID   | Nombre    | Edad Minma | Edad Maxima | Hijos | Email          | ID Casa   ");
         for (Familia familia : familias) {
             System.out.println(familia.getId_familia() + " | " + familia.getNombre() + " | " + familia.getEdad_minima() + " | " + familia.getEdad_maxima() + " | " + familia.getNum_hijos() + " | " + familia.getEmail() + " | "+ familia.getId_casa_familia());
        }
    }
}
