/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.persistencia;


import extrajdbc_estanciaextranjero.entidades.Casa;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lucia
 */
public class CasaDAO extends DAO{
    public void guardar(Casa casa) throws Exception{
        try{
            if(casa==null){
                throw new Exception("Por favor, primero ingrese los datos de la casa.");
            }
            String sql= "INSERT INTO casas "
                    +"VALUES ('" + casa.getCalle() + "', " + casa.getNumero() + ", '" + casa.getCodigo_postal() + "', '" + casa.getCiudad() + "', '" + casa.getPais() + "', '" + casa.getFecha_desde().toString() + "', '" + casa.getFecha_hasta().toString() + "', " + casa.getTiempo_minimo() +", " + casa.getTiempo_maximo() + ", " + casa.getPrecio_habitacion() + ", '" + casa.getTipo_vivienda() + "');";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void modificarPrecio(Casa casa) throws Exception{
        try{
            if(casa==null){
                throw new Exception("Por favor, primero ingrese los datos a modificar.");
            }
            String sql= "UPDATE casas "
                    +"SET precio_habitacion " +casa.getPrecio_habitacion() + " WHERE codigo =" + casa.getId_casa() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void eliminar(Casa casa) throws Exception{
        try{
            if(casa==null){
                throw new Exception("Error, la casa indicada no existe.");
            }
            String sql= "DELET FROM casas "
                    + "WHERE codigo =" + casa.getId_casa()+ ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    public ArrayList <Casa> consultaCasa(String condicion) throws Exception{
        try{
            String sql= "SELECT * FROM casas "
                     + condicion + ";";
        consultarBase(sql);
        ArrayList<Casa> casas = new ArrayList<>();
        while(resultado.next()){
            casas.add(new Casa(resultado.getInt("id_casa"),resultado.getString("calle"),resultado.getInt("numero"),resultado.getString("codigo_postal"), resultado.getString("ciudad"),resultado.getString("pais"), resultado.getDate("fecha_desde"), resultado.getDate("fecha_hasta"), resultado.getInt("tiempo_minimo"), resultado.getInt("tiempo_maximo"), resultado.getDouble("precio_habitacion"), resultado.getString("tipo_vivienda")));
        }
        desconectarBase();
        return casas;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
    public HashMap<String, Integer> consultasCasa(String condicion) throws Exception{
        try{
        String sql= condicion;
        consultarBase(sql);
        HashMap<String, Integer> casas = new HashMap<>();
        while(resultado.next()){
            casas.put(resultado.getString("pais"), resultado.getInt("cantidad"));
        }
        desconectarBase();
        return casas;
    } catch (Exception e){
        desconectarBase();
        throw e;
    } 
    }     
}
