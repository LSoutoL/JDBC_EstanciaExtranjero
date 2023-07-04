/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrajdbc_estanciaextranjero.persistencia;

import extrajdbc_estanciaextranjero.entidades.Casa;
import extrajdbc_estanciaextranjero.entidades.Cliente;
import extrajdbc_estanciaextranjero.entidades.Estancia;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lucia
 */
public class ClienteDAO extends DAO {
    public void guardar(Cliente cliente) throws Exception{
        try{
            if(cliente==null){
                throw new Exception("Por favor, primero ingrese los datos del cliente.");
            }
            String sql= "INSERT INTO clientes "
                    +"VALUES ('" + cliente.getNombre() + "', '" + cliente.getCalle() + "', " + cliente.getNumero() + ", '" + cliente.getCodigo_postal() + "', '" + cliente.getCiudad() + "'," + cliente.getPais() + "', '" + cliente.getEmail() + ");";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void modificar(Cliente cliente) throws Exception{
        try{
            if(cliente==null){
                throw new Exception("Por favor, primero ingrese los datos a modificar.");
            }
            String sql= "UPDATE clientes "
                    +"SET nombre '" +  "' WHERE codigo =" + cliente.getId_cliente() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void eliminar(Cliente cliente) throws Exception{
        try{
            if(cliente==null){
                throw new Exception("Error, el cliente indicado no existe.");
            }
            String sql= "DELET FROM clientes "
                    + "WHERE codigo =" + cliente.getId_cliente()+ ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    public ArrayList<Cliente> consulta(String condicion) throws Exception{
        try{
            String sql= "SELECT * FROM clientes cl"
                     + condicion + ";";
        consultarBase(sql);
        ArrayList<Cliente> clientes = new ArrayList<>();
        while(resultado.next()){
           clientes.add(new Cliente(resultado.getInt("cl.id_cliente"), resultado.getString("cl.nombre"),resultado.getString("cl.calle"), resultado.getInt("cl.numero"), resultado.getString("cl.codigo_postal"), resultado.getString("cl.ciudad"), resultado.getString("cl.pais"), resultado.getString("cl.email")));
        }
        desconectarBase();
        return clientes;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
    public ArrayList<Casa> consultaCasa(String condicion) throws Exception{
        try{
        String sql= "SELECT * FROM clientes cl "
                     + condicion + ";";
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
    public ArrayList<Estancia> consultaEstancia(String condicion) throws Exception{
        try{
       String sql= "SELECT * FROM clientes cl "
                     + condicion + ";";
        consultarBase(sql);
        ArrayList<Estancia> estancias= new ArrayList<>();
        while(resultado.next()){
           estancias.add(new Estancia(resultado.getInt("id_estancia"),resultado.getInt("id_cliente"), resultado.getInt("id_casa"), resultado.getString("nombre_huesped"), resultado.getDate("fecha_desde"), resultado.getDate("fecha_hasta")));
        }
        return estancias;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
}
