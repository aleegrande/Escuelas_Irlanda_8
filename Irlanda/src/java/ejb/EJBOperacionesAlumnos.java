/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Alumnodos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leo
 */
@Stateless
public class EJBOperacionesAlumnos {

   @PersistenceContext
EntityManager em; //objeto que controla el CRUD
    
    public String nuevoAlumno(String nombrealumno, String nombreusuario, String fechanacimiento,String nacionalidad, String telefono, String correo)
{
   // em.merge(r);
    Alumnodos a=new Alumnodos();
    a.setNombrealumno(nombrealumno);
    a.setNombreusuario(nombreusuario);
    a.setFechanacimiento(fechanacimiento);
    a.setNacionalidad(nacionalidad);
    a.setTelefono(telefono);
    a.setCorreo(correo);
    
    String msj;
    try{
        em.persist(a); //tratando de grabar el error // el persist es como si tuvieras un insert
        msj="{\"code\":200, \"msj\"La operacion se realizo correctamente\"}";
    }
    catch(Exception e)
            {
                 msj="{\"code\":400, \"msj\"Error en los tipos de parametros\"}";
            }
    return msj;
      
}
    
    public String consultaAlumno()
{
    try{
        Query q;
        List<Alumnodos> listaAlumnos;
        q=em.createNamedQuery("Alumnos.findAll");
        listaAlumnos=q.getResultList(); // Ejecutar consulta
        
        //Convertir la lista a objetos JSON 
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        return gson.toJson(listaAlumnos);
        
    }catch(Exception e)
    {
      return"{msg:'Error'}";  
    }
    
} //Fin consultaRol
    
    public String actualizaAlumno(int idAlumno, String nombreAlumno, String nombreUsuario, String fechaNacimiento,String nacionalidad, String telefono, String correo) //rolid y nombrerol tal y como lo tenemos en la tabla roldos
{
   GsonBuilder builder=new GsonBuilder();
   Gson gson=builder.create(); 
   String msj;
   Alumnodos a=new Alumnodos();
   try{
      
       a=em.find(Alumnodos.class, idAlumno);//Buscar por rolid
       a.setNombrealumno(nombreAlumno);
    a.setNombreusuario(nombreUsuario);
    a.setFechanacimiento(fechaNacimiento);
    a.setNacionalidad(nacionalidad);
    a.setTelefono(telefono);
    a.setCorreo(correo);
       em.merge(a);
       
       msj="{codigo:200 msj-La operacion se realizo correctamente}";
       
   } catch(NumberFormatException e)
   {
        msj="{codigo:400 msj-Error en los tipos de parametros}";
       
   }//Fin catch
    
   return msj;
} //Fin actualiza Rol
    
public String eliminarAlumno (int idAlumno){
        Alumnodos alumno=new Alumnodos();
        String msj;
        
        try{
            alumno = (Alumnodos) em.createNamedQuery("Alumnos.findByIdAlumno").setParameter("idAlumno",idAlumno).getSingleResult();
            em.remove(em.merge(alumno));
            
            msj = "{\"code\":200, \"msj\"La operacion se realizo correctamente\"}";
        } catch (NumberFormatException e){
            
            msj = "{\"code\":400, \"msj\"Error en los tipos de parametros\"}";            
        }
        return msj;
    }
}
