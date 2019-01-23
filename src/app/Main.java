/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import model.AsistenciaMedica;
import model.Coberturas;
import model.Enfermedades;
import model.Nif;
import model.Seguro;
import model.Sexo;
import model.TipoAsistencia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sandra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CREAMOS CONEXION
        //SessionFactory sessionFactory;
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // CREAMOS UN OBJETO
        Seguro seguro = new Seguro(1, new Nif("2201145Z"), "Pepe", "Vidal", "Vidal", 30, Sexo.HOMBRE, true, 0, false, new Coberturas(true, false, true), new Enfermedades(true, true, true, true, "Polen"), Calendar.getInstance().getTime());
        Set<AsistenciaMedica> asistenciasMedicas = new HashSet<>();

        AsistenciaMedica asistencia1 = new AsistenciaMedica(seguro, "Breve descripcion", "Benigamin", "Especial", TipoAsistencia.HOSPITARLIA, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), BigDecimal.ONE);

        asistenciasMedicas.add(asistencia1);

        seguro.setAsistenciasMedicas(asistenciasMedicas);

        //CREAR UNA SESION
        Session session = factory.openSession();
        session.beginTransaction();

        //GUARDAR OBJETO
        session.save(seguro);

        //CERRAR CONEXION
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

}
