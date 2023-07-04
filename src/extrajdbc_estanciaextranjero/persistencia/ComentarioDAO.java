/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.persistencia;

import extrajdbc_estanciaextranjero.entidades.Casa;
import extrajdbc_estanciaextranjero.entidades.Comentario;
import java.util.ArrayList;


/**
 *
 * @author lucia
 */
public class ComentarioDAO extends DAO {
    public void guardar(Comentario comentario) throws Exception{
        try{
            if(comentario==null){
                throw new Exception("Por favor, primero ingrese los datos del comentario.");
            }
            String sql= "INSERT INTO comentarios "
                    +"VALUES (" + comentario.getId_casa() + ", '" + comentario.getCometario() + "');";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void modificar(Comentario comentario) throws Exception{
        try{
            if(comentario==null){
                throw new Exception("Por favor, primero ingrese los datos a modificar.");
            }
            String sql= "UPDATE comentarios "
                    +"SET nombre '" + "' WHERE codigo =" + comentario.getId_comentario() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void eliminar(Comentario comentario) throws Exception{
        try{
            if(comentario==null){
                throw new Exception("Error, el comentario indicado no existe.");
            }
            String sql= "DELET FROM comentarios "
                    + "WHERE codigo =" + comentario.getId_comentario()+ ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    public ArrayList <Comentario> consulta(String condicion) throws Exception{
        try{
            String sql= condicion;
        consultarBase(sql);
        ArrayList<Comentario> comentarios = new ArrayList<>();
        while(resultado.next()){
            comentarios.add(new Comentario(resultado.getInt("id_casa"),resultado.getString("comentario")));
        }
        desconectarBase();
        return comentarios;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
    public ArrayList<Casa> consultaCasa(String condicion) throws Exception{
        try{
        String sql= condicion;
        consultarBase(sql);
        ArrayList<Casa> casas = new ArrayList<>();
        while(resultado.next()){
          casas.add(new Casa(resultado.getInt("id_casa"), resultado.getString("calle"),resultado.getInt("numero"),resultado.getString("codigo_postal"), resultado.getString("ciudad"),resultado.getString("pais"), resultado.getDate("fecha_desde"), resultado.getDate("fecha_hasta"), resultado.getInt("tiempo_minimo"), resultado.getInt("tiempo_maximo"), resultado.getDouble("precio_habitacion"), resultado.getString("tipo_vivienda")));
        }
        desconectarBase();
        return casas;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
    }      
}
