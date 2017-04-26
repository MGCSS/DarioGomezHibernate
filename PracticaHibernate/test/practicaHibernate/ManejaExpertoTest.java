/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaHibernate;

import java.util.Scanner;
import modelo.Experto;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dario
 */
public class ManejaExpertoTest
{
    ManejaExperto maneja = new ManejaExperto();
    
    public ManejaExpertoTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of listaResultados method, of class ManejaExperto.
     */
    @Test
    public void testListaResultados()
    {
        System.out.println("listaResultados");
        ManejaExperto instance = new ManejaExperto();
        instance.listaResultados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaIndividualResultados method, of class ManejaExperto.
     */
    @Test
    public void testListaIndividualResultados()
    {
        System.out.println("listaIndividualResultados");
        ManejaExperto instance = new ManejaExperto();
        instance.listaIndividualResultados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciaOperacion method, of class ManejaExperto.
     */
    @Test
    public void testIniciaOperacion()
    {
        System.out.println("iniciaOperacion");
        ManejaExperto instance = new ManejaExperto();
        instance.iniciaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaOperacion method, of class ManejaExperto.
     */
    @Test
    public void testFinalizaOperacion()
    {
        System.out.println("finalizaOperacion");
        ManejaExperto instance = new ManejaExperto();
        instance.finalizaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of manejaExcepcion method, of class ManejaExperto.
     */
    @Test
    public void testManejaExcepcion()
    {
        System.out.println("manejaExcepcion");
        HibernateException he = null;
        ManejaExperto instance = new ManejaExperto();
        instance.manejaExcepcion(he);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardaExperto method, of class ManejaExperto.
     */
    @Test
    public void testGuardaExperto()
    {
        System.out.println("Guardar un experto");
        Experto ex = new Experto("999", "Dario", "España", "Informatico");
        maneja.guardaExperto(ex);
        System.out.println("Fin guardar experto");
    }
    
    /**
     * Test of actualizaExperto method, of class ManejaExperto.
     */
    @Test
    public void testActualizaExperto()
    {
        System.out.println("Modifica un experto");
        Experto ex1 = new Experto("999", "DarioGomez", "España", "Informatico");
        maneja.actualizaExperto(ex1);
        System.out.println("Fin modificar experto");
    }
    
    /**
     * Test of eliminaExperto method, of class ManejaExperto.
     */
    @Test
    public void testEliminaExperto()
    {
        System.out.println("Eliminar un experto");
        Experto ex1 = new Experto("999", "DarioGomez", "España", "Informatico");
        maneja.eliminaExperto(ex1);
        System.out.println("Fin eliminar experto");
    }

    /**
     * Test of obtenExperto method, of class ManejaExperto.
     */
    @Test
    public void testObtenExperto()
    {
        System.out.println("Busca un experto");
        String id;Scanner scan = new Scanner(System.in);
        System.out.println("Indica id a buscar: ");
        id = scan.nextLine();
        Experto e = maneja.obtenExperto(id);
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("Codigo: "+ e.getCodexperto());
        System.out.println("Especialidad: " + e.getEspecialidad());
        System.out.println("Pais: " + e.getPais());
        System.out.println("Fin buscar experto");
    }

    /**
     * Test of obtenNombreYEspecialidad method, of class ManejaExperto.
     */
    @Test
    public void testObtenNombreYEspecialidad()
    {
        System.out.println("obtenNombreYEspecialidad");
        ManejaExperto instance = new ManejaExperto();
        instance.obtenNombreYEspecialidad();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaConParametro method, of class ManejaExperto.
     */
    @Test
    public void testListaConParametro()
    {
        System.out.println("listaConParametro");
        String keyword = "";
        ManejaExperto instance = new ManejaExperto();
        instance.listaConParametro(keyword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenCasos method, of class ManejaExperto.
     */
    @Test
    public void testObtenCasos()
    {
        System.out.println("obtenCasos");
        ManejaExperto instance = new ManejaExperto();
        instance.obtenCasos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
