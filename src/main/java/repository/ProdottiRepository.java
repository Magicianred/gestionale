package repository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Prodotti;

@Repository
public class ProdottiRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Prodotti p)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		em.persist(p);
	}
	
	public boolean update(Prodotti p)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		try {
			em.merge(p);
		}catch (Exception e) {
			return false;
		}return true;
	}
	
	public void delete(Prodotti p)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		Prodotti pp = em.find(Prodotti.class, p.getId());
		em.remove(pp);
	}
	
	@SuppressWarnings("unchecked")
	public List<Prodotti> findAll(){
		Query q = em.createQuery("SELECT p FROM Prodotti p");
		List<Prodotti> res = q.getResultList();
		return res;
	}
	
	public Prodotti findById(int id) {
		return em.find(Prodotti.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Prodotti> FindGiacDecre (){
		Query q = em.createQuery ("SELECT p FROM Prodotti p ORDER BY p.giacenza DESC" );
		List<Prodotti> res = q.getResultList();
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prodotti> FindGiacCres (){
		Query q = em.createQuery ("SELECT p FROM Prodotti p ORDER BY p.giacenza ASC" );
		List<Prodotti> res = q.getResultList();
		return res;
	}
	
	
}
