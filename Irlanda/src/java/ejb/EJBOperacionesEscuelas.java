/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Alumnodos;
import entidades.Escuelas;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leo
 */
@Stateless
@LocalBean
public class EJBOperacionesEscuelas {
    @PersistenceContext
EntityManager em; //objeto que controla el CRUD

     public String nuevaEscuela(String nombreEscuela, String domicilio, String telefono ,int numeroAlumnos, int Fundacion)
{
   // em.merge(r);
    Escuelas e=new Escuelas();
    e.setNombreEscuela(nombreEscuela);
    e.setDomicilio(domicilio);
    e.setTelefono(telefono);
    e.setNumeroAlumnos(numeroAlumnos);
    e.setFundacion(telefono);
    
    String msj;
    try{
        em.persist(e); //tratando de grabar el error // el persist es como si tuvieras un insert
        msj="{\"code\":200, \"msj\"La operacion se realizo correctamente\"}";
    }
    catch(Exception a)
            {
                 msj="{\"code\":400, \"msj\"Error en los tipos de parametros\"}";
            }
    return msj;
      
}
      public String consultaEscuela()
{
    try{
        Query q;
        List<Escuelas> listaEscuelas;
        q=em.createNamedQuery("Escuelas.findAll");
        listaEscuelas=q.getResultList(); // Ejecutar consulta
        
        //Convertir la lista a objetos JSON 
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        return gson.toJson(listaEscuelas);
        
    }catch(Exception a)
    {
      return"{msg:'Error'}";  
    }
    
} //Fin consultaRol
      
       public String actualizaEscuela(int idEscuela, String nombreEscuela, String domicilio, String telefono, int numeroAlumnos, int Fundacion) //rolid y nombrerol tal y como lo tenemos en la tabla roldos
{
   GsonBuilder builder=new GsonBuilder();
   Gson gson=builder.create(); 
   String msj;
   Escuelas e=new Escuelas();
   try{
      
       e=em.find(Escuelas.class, idEscuela);//Buscar por rolid
       e.setNombreEscuela(nombreEscuela);
    e.setDomicilio(domicilio);
    e.setTelefono(telefono);
    e.setNumeroAlumnos(numeroAlumnos);
    e.setFundacion(telefono);
       em.merge(e);
       
       msj="{codigo:200 msj-La operacion se realizo correctamente}";
       
   } catch(NumberFormatException a)
   {
        msj="{codigo:400 msj-Error en los tipos de parametros}";
       
   }//Fin catch
    
   return msj;
} //Fin actualiza Rol
       public String eliminarEscuela (int idEscuela){
        Escuelas escuela=new Escuelas();
        String msj;
        
        try{
            escuela = (Escuelas) em.createNamedQuery("Escuelas.findByidEscuela").setParameter("idEscuela",idEscuela).getSingleResult();
            em.remove(em.merge(escuela));
            
            msj = "{\"code\":200, \"msj\"La operacion se realizo correctamente\"}";
        } catch (NumberFormatException e){
            
            msj = "{\"code\":400, \"msj\"Error en los tipos de parametros\"}";            
        }
        return msj;
    }
}
