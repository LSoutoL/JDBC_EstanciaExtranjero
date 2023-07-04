/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.persistencia;

import extrajdbc_estanciaextranjero.entidades.Familia;
import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public class FamiliaDAO extends DAO{
    public void guardar(Familia familia) throws Exception{
        try{
            if(familia==null){
                throw new Exception("Por favor, primero ingrese los datos de la familia.");
            }
            String sql= "INSERT INTO familias "
                    +"VALUES ('" + familia.getNombre() + "', " + familia.getEdad_minima() + ", " + familia.getEdad_maxima() + ", " + familia.getNum_hijos() + ", '" + familia.getEmail() + "'," + familia.getId_casa_familia()+ ");";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void modificar(Familia familia) throws Exception{
        try{
            if(familia==null){
                throw new Exception("Por favor, primero ingrese los datos a modificar.");
            }
            String sql= "UPDATE familias "
                    +"SET nombre '" + familia.getNombre() + "' WHERE codigo =" + familia.getId_familia() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void eliminar(Familia familia) throws Exception{
        try{
            if(familia==null){
                throw new Exception("Error, la familia indicada no existe.");
            }
            String sql= "DELET FROM familias "
                    + "WHERE codigo =" + familia.getId_familia()+ ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    public ArrayList <Familia> consultaFamilia(String condicion) throws Exception{
        try{
            String sql= "SELECT * FROM familias "
                     + condicion + ";";
        consultarBase(sql);
        ArrayList<Familia> familias = new ArrayList<>();
        while(resultado.next()){
            familias.add(new Familia(resultado.getString("nombre"), resultado.getInt("edad_minima"), resultado.getInt("edad_maxima"), resultado.getInt("num_hijos"), resultado.getString("email"), resultado.getInt("id_casa_familia")));
        }
        desconectarBase();
        return familias;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
}
