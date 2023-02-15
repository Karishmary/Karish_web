package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence; 

import dto.Patientdto;

public class Patientdao {
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("xyz");
   EntityManager em = emf.createEntityManager();
   EntityTransaction et= em.getTransaction();
   
   public void insert(Patientdto p2){
	   et.begin();
	   em.persist(p2);
	   et.commit();
   }
   
  public void update(String s1, String s2){
    	Patientdto p1=em.find(Patientdto.class, s1);
    	System.out.println(p1);
    	p1.setBg(s2);
    	et.begin();
    	em.merge(p1);
    	et.commit();
    }
		public void remove(String s1){
			Patientdto p2= em.find(Patientdto.class, s1);
			et.begin();
			em.remove(p2);
			et.commit();
		}
	}
