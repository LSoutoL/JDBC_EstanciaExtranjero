/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.persistencia;


import extrajdbc_estanciaextranjero.entidades.Estancia;
import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public class EstanciaDAO extends DAO {
    public void guardar(Estancia estancia) throws Exception{
        try{
            if(estancia==null){
                throw new Exception("Por favor, primero ingrese los datos de la casa.");
            }
            String sql= "INSERT INTO estancias "
                    +"VALUES (" + estancia.getId_cliente() + ", " + estancia.getId_casa() + ", '" + estancia.getNombre_huesped() + "', '" + estancia.getFecha_desde().toString() + "', '" + estancia.getFecha_hasta().toString() + ");";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void modificar(Estancia estancia) throws Exception{
        try{
            if(estancia==null){
                throw new Exception("Por favor, primero ingrese los datos a modificar.");
            }
            String sql= "UPDATE estancias "
                    + "SET fecha_desde = '" + estancia.getFecha_desde().getYear() + "-" + estancia.getFecha_desde().getMonth() + "-" +  estancia.getFecha_desde().getDay() +"', fecha_hasta = '" + estancia.getFecha_hasta().getYear() + "-" + estancia.getFecha_hasta().getMonth() + "-" + estancia.getFecha_hasta().getDay()+ "' WHERE id_estancia = " + estancia.getId_estancia() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void eliminar(Estancia estancia) throws Exception{
        try{
            if(estancia==null){
                throw new Exception("Error, la estancia indicada no existe.");
            }
            String sql= "DELET FROM estancias "
                    + "WHERE codigo =" + estancia.getId_estancia()+ ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    public ArrayList <Estancia> consultaEstancia() throws Exception{
        try{
            String sql= "SELECT * FROM estancias;";
        consultarBase(sql);
        ArrayList<Estancia> estancias = new ArrayList<>();
        while(resultado.next()){
            estancias.add(new Estancia(resultado.getInt("id_estancia"),resultado.getInt("id_cliente"), resultado.getInt("id_casa"), resultado.getString("nombre_huesped"), resultado.getDate("fecha_desde"), resultado.getDate("fecha_hasta")));
        }
        desconectarBase();
        return estancias;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
}
