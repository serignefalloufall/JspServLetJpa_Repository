package sn.simplon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.simplon.entities.Client;
import sn.simplon.entities.Village;

public class ClientImpl implements IClient{

	 private EntityManager em;

	public ClientImpl() {
		
		//Cette ligne nous permet de selectionner notre UP qu'on a creer dans le fichier persistance.xml
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("SenForageVersionPU");
        em = emf.createEntityManager();	
        }

	@Override
	public int add(Client client) {
		 try {
	            em.getTransaction().begin();
	            em.persist(client);
	            em.getTransaction().commit();
	            return 1;
	        }catch (Exception ex){
	            ex.printStackTrace();
	            return 0;
	        }
	}

	@Override
	public int update(Client client) {
		try {
			em.getTransaction().begin();
			em.merge(client);
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
	public Client get(int id) {
		return (Client)em.createQuery("SELECT client FROM Client client WHERE client.id=:idC")
			     .setParameter("idC",id)
			     .getSingleResult();
	}

	@Override
	public List<Client> getAll() {
		return(List<Client>)em.createQuery("SELECT client FROM Client client").getResultList();

	}
	
	

}
