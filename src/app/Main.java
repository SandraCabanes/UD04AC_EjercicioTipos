/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.AsistenciaMedica;
import model.Coberturas;
import model.Enfermedades;
import model.Nif;
import model.Seguro;
import model.Sexo;
import model.TipoAsistencia;
import org.hibernate.Query;
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
        Query query = null;

        //CREAMOS CONEXION
        //SessionFactory sessionFactory;
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // CREAMOS UN OBJETO
        Seguro seguro = new Seguro(1, new Nif("2201145Z"), "Manola", "Pérez", "Llopis", 30, Sexo.MUJER, true, 0, false, new Coberturas(true, false, true), new Enfermedades(true, true, true, true, "Polen"), Calendar.getInstance().getTime());
        Set<AsistenciaMedica> asistenciasMedicas = new HashSet<>();

        AsistenciaMedica asistencia1 = new AsistenciaMedica(seguro, "Breve descripcion", "Benigamin", "Especial", TipoAsistencia.Hospitalaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), BigDecimal.ONE);

        asistenciasMedicas.add(asistencia1);

        seguro.setAsistenciasMedicas(asistenciasMedicas);

        //CREAR UNA SESION
        Session session = factory.openSession();
        session.beginTransaction();

        //GUARDAR OBJETO
        session.saveOrUpdate(seguro);

        //CONSULTAS
        System.out.println("\tCONSULTA 1");
        query = session.createQuery("SELECT s FROM Seguro s");
        List<Seguro> listSeguros = query.list();
        for (Seguro s : listSeguros) {
            System.out.println(s.getNombre());
        }

        System.out.println("\tCONSULTA 2");
        query = session.createQuery("SELECT s.nif, s.nombre FROM Seguro s");
        List<Object[]> listSegurosNifNombre = query.list();
        for (Object[] datos : listSegurosNifNombre) {
            Nif n = (Nif) datos[0];
            System.out.println(n.getNif() + " --- " + datos[1]);
        }

        System.out.println("\tCONSULTA 3");
        query = session.createQuery("SELECT s.nif FROM Seguro s");
        List<Nif> listNif = query.list();
        for (Nif n : listNif) {
            System.out.println(n.getNif());
        }

        System.out.println("\tCONSULTA 4");
        Nif nMarcos = (Nif) session.createQuery("SELECT s.nif FROM Seguro s WHERE s.nombre='MARCOS' AND ape1='TORTOSA' AND ape2='OLTRA'").uniqueResult();
        System.out.println(nMarcos.getNif());

        System.out.println("\tCONSULTA 5");
        query = session.getNamedQuery("grandesGastos");
        List<AsistenciaMedica> listAsistencias = query.list();
        for (AsistenciaMedica a : listAsistencias) {
            System.out.println(a.getSeguro().getNombre() + " -- " + a.getTipoAsistencia() + " -- " + a.getImporte());
        }

        System.out.println("\tCONSULTA 6");
        query = session.createQuery("SELECT a.idAsistenciaMedica FROM AsistenciaMedica a WHERE a.importe>? AND a.importe<?");
        query.setString(0, "2000");
        query.setString(1, "5000");
        List<Object> listAsisImportes = query.list();
        for (Object a : listAsisImportes) {
            System.out.println(a);
        }

        System.out.println("\tCONSULTA 7");
        BigDecimal importe = (BigDecimal) session.createQuery("SELECT SUM(a.importe) FROM AsistenciaMedica a").uniqueResult();
        System.out.println(importe);

        System.out.println("\tCONSULTA 8");
        Double importeMedio = (Double) session.createQuery("SELECT AVG(a.importe) FROM AsistenciaMedica a").uniqueResult();
        System.out.println(importeMedio);
        
        System.out.println("\tCONSULTA 9");
        Long mediaSeguros = (Long) session.createQuery("SELECT COUNT(s.idSeguro) FROM Seguro s ").uniqueResult();
        System.out.println(mediaSeguros);
        
        System.out.println("\tCONSULTA 10");
        query = session.createQuery("SELECT s.idSeguro FROM Seguro s, AsistenciaMedica a WHERE s.idSeguro=a.seguro GROUP BY s.idSeguro");
        List<Object> listIdSeguros = query.list();
        for (Object datos : listIdSeguros) {
            System.out.println(datos);
        }

        //CERRAR CONEXION
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

}
