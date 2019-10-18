/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Alumnodos;
import entidades.Cursos;
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
public class EJBOperacionesCursos {
    @PersistenceContext
EntityManager em; //objeto que controla el CRUD
    
    public String nuevoCurso(String nombreCurso, String nivel, int numeroAlumnos,String periodo, String profesor, String horario)
{
   // em.merge(r);
    Cursos c=new Cursos();
    c.setNombreCurso(nombreCurso);
    c.setNivel(nivel);
    c.setNumeroAlumnos(numeroAlumnos);
    c.setPeriodo(periodo);
    c.setProfesor(profesor);
    c.setHorario(horario);
    
    String msj;
    try{
        em.persist(c); //tratando de grabar el error // el persist es como si tuvieras un insert
        msj="{\"code\":200, \"msj\"La operacion se realizo correctamente\"}";
    }
    catch(Exception e)
            {
                 msj="{\"code\":400, \"msj\"Error en los tipos de parametros\"}";
            }
    return msj;
      
}
    
    public String consultaCurso()
{
    try{
        Query q;
        List<Cursos> listaCursos;
        q=em.createNamedQuery("Cursos.findAll");
        listaCursos=q.getResultList(); // Ejecutar consulta
        
        //Convertir la lista a objetos JSON 
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        return gson.toJson(listaCursos);
        
    }catch(Exception e)
    {
      return"{msg:'Error'}";  
    }
    
} //Fin consultaRol
    
    public String actualizaCurso(int idCurso, String nombreCurso, String Nivel, int numeroAlumnos,String periodo, String profesor, String horario) //rolid y nombrerol tal y como lo tenemos en la tabla roldos
{
   GsonBuilder builder=new GsonBuilder();
   Gson gson=builder.create(); 
   String msj;
   Cursos c=new Cursos();
   try{
      
       c=em.find(Cursos.class, idCurso);//Buscar por rolid
       c.setNombreCurso(nombreCurso);
    c.setNivel(Nivel);
    c.setNumeroAlumnos(numeroAlumnos);
    c.setPeriodo(periodo);
    c.setProfesor(profesor);
    c.setHorario(horario);
       em.merge(c);
       
       msj="{codigo:200 msj-La operacion se realizo correctamente}";
       
   } catch(NumberFormatException e)
   {
        msj="{codigo:400 msj-Error en los tipos de parametros}";
       
   }//Fin catch
    
   return msj;
} //Fin actualiza Rol
    
    public String eliminarCurso (int idCurso){
        Cursos curso=new Cursos();
        String msj;
        
        try{
            curso = (Cursos) em.createNamedQuery("Cursos.findByidCurso").setParameter("idCurso",idCurso).getSingleResult();
            em.remove(em.merge(curso));
            
            msj = "{\"code\":200, \"msj\"La operacion se realizo correctamente\"}";
        } catch (NumberFormatException e){
            
            msj = "{\"code\":400, \"msj\"Error en los tipos de parametros\"}";            
        }
        return msj;
    }
}
