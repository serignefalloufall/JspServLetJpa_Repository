package sn.simplon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.simplon.entities.Village;

public class VillageImpl implements IVillage{

	 private EntityManager em;

	public VillageImpl() {
		
		//Cette ligne nous permet de selectionner notre UP qu'on a creer dans le fichier persistance.xml
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("SenForageVersionPU");
        em = emf.createEntityManager();	
        }
	
	@Override
	public int add(Village village) {
		 try {
	            em.getTransaction().begin();
	            em.persist(village);
	            em.getTransaction().commit();
	            return 1;
	        }catch (Exception ex){
	            ex.printStackTrace();
	            return 0;
	        }
	}

	@Override
	public int update(Village village) {
		try {
			em.getTransaction().begin();
			em.merge(village);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Village.class,id));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Village get(int id) {
		return (Village)em.createQuery("SELECT v FROM Village v WHERE v.id=:idV")
			     .setParameter("idV",id)
			     .getSingleResult();
	}

	@Override
	public List<Village> getAll() {
		return(List<Village>)em.createQuery("SELECT v FROM Village v").getResultList();

	}

}
