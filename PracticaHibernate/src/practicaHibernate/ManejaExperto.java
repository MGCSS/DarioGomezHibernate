/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.*;
import modelo.*;
/**
 *
 * @author usuario
 */
public class ManejaExperto 
{
    private Session sesion;
    private Transaction tx;

    public ManejaExperto() 
    {
        
    }
    
    public void listaResultados()
    {
        Query query = sesion.createQuery("SELECT e.nombre FROM Experto as e");

        List <String> listaResultados = query.list();

        for(int i=0;i<listaResultados.size();i++)
        {
               System.out.println("Nombre "+ i +": "+listaResultados.get(i));
        }
    }
    
    public void listaIndividualResultados()
    {
        Query query = sesion.createQuery("SELECT e.nombre, e.especialidad FROM Experto as e");

        List <Object[]> listaResultados = query.list();

        for(int i=0;i<listaResultados.size();i++)
        {
               System.out.println("Nombre "+ i +": "+listaResultados.get(i)[0]+" Especialidad "+ i +": "+listaResultados.get(i)[1]);
        }
    }
    
    public void iniciaOperacion() throws HibernateException
    {
        System.out.println("Comenzando Hibernate");
        
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    public void finalizaOperacion() throws HibernateException
    {
        System.out.println("Finalizando Hibernate");
        
        tx.commit();
        sesion.close();
    }
    
    public void manejaExcepcion(HibernateException he) throws HibernateException
    {
        tx.rollback();
        System.out.println("Ocurrio un error en la capa de acceso a datos" + he.getMessage());
        System.exit(0);
    }
    
    public void guardaExperto(Experto experto)
    {
        try
        {
            iniciaOperacion();
            sesion.save(experto);
            System.out.println("Experto insertado correctamente");
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }
        finally
        {
            finalizaOperacion();
        }
    }
    
    public void eliminaExperto(Experto experto)
    {
        try
        {
            iniciaOperacion();
            sesion.delete(experto);
            System.out.println("Experto eliminado correctamente");
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }
        finally
        {
            finalizaOperacion();
        }
    }
    
    public void actualizaExperto(Experto experto)
    {
        try
        {
            iniciaOperacion();
            sesion.update(experto);
            System.out.println("Experto modificado correctamente");
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }
        finally
        {
            finalizaOperacion();
        }
    }
    
    public Experto obtenExperto(String idexperto)
    {
        try
        {
            iniciaOperacion();
        
            Query query = sesion.createQuery("SELECT e FROM Experto e WHERE codExperto=:idExperto");
            query.setParameter("idexperto", idexperto);
            List<Experto> expertos = query.list();

            return expertos.get(0);
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }
        finally
        {
            finalizaOperacion();
        }
    }
    
    public void obtenNombreYEspecialidad()
    {   
        try
        {
            iniciaOperacion();
        
            Query query = sesion.createQuery("SELECT e.nombre, e.especialidad FROM Experto as e");
            List<Experto> expertos = query.list();

            for (int i = 0; i < expertos.size(); i++)
            {
                System.out.println("Nombre: " + expertos.get(i).getNombre() + " Especialidad: " + expertos.get(i).getEspecialidad());
            }
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }
        finally
        {
            finalizaOperacion();
        }
    }
    
    public void listaConParametro(String keyword)
    {
        try
        {
            iniciaOperacion();
        
            Query query = sesion.createQuery("FROM Experto e WHERE e.especialidad=:esp");
            query.setParameter("esp", keyword);
            List<Experto> expertos = query.list();

            for (int i = 0; i < expertos.size(); i++)
            {
                System.out.println("Nombre: " + expertos.get(i).getNombre());
            }
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }
        finally
        {
            finalizaOperacion();
        }
    }
    
    public void obtenCasos()
    {
        try
        {
            iniciaOperacion();
        
            String queryText = "SELECT DISTINCT e.nombre, cp.nombre FROM Experto as e, CasoPolicial as cp "
                            + "INNER JOIN e.colaboras inner join cp.colaboras";
            Query query = sesion.createQuery(queryText);
            List<Object[]> result = query.list();

            for(int i = 0; i < result.size(); i++)
            {
                System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
            }
        }
        catch (HibernateException he)
        {
            manejaExcepcion(he);
            throw he;
        }
        finally
        {
            finalizaOperacion();
        }
    }
}