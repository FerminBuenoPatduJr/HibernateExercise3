package com.myproject;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

public class Runner {
	@Test
	public void crud() {
        
        try {
        	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        	
        	Session session = sessionFactory.openSession();
            
          //saveAppointmentRecord(session);
          getAppointmentRecord(session);
          
            session.close();
        	
        }
        
        catch(HibernateException exception){
            System.out.println("Problem creating session factory");
            exception.printStackTrace();
       }
    }
	
	private  void saveAppointmentRecord(Session session) {
        HibernateDemo appt = new HibernateDemo();
        appt.setDoctorNo("S101");
        appt.setDoctorName("Richard Dela Cruz");
        appt.setPatientNo("P1100");
        appt.setPatientName("Ricky Mastrano");
        appt.setOperationNo("O11");
        session.beginTransaction();
        session.save(appt);
        session.getTransaction().commit();
        System.out.println("Record saved succesfully...");
        
    }
	public static void getAppointmentRecord(Session session) {
		Query qry = session.createQuery("SELECT appt FROM HibernateDemo appt ORDER BY appt.patientNo");
        List<HibernateDemo> Appoint = qry.list();
        //Appoint.forEach(obj -> System.out.println(obj.getDoctorName()));
        System.out.println();
        System.out.println("ID\tDoctorNo\tDoctorName\t\tPatientNo\t\tPatientName\t\tOperationNo");
        for (HibernateDemo appt : Appoint) {
            System.out.println(appt.getAppointmentID()+"\t"+ appt.getDoctorNo()+ "\t\t" + appt.getDoctorName() + "\t\t" +
                    appt.getPatientNo() + "\t\t" + appt.getPatientNo() + "\t\t" + appt.getPatientName() +
                    "\t\t" + appt.getOperationNo());
        }
    }

}

