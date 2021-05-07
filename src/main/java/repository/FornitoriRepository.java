package repository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dto.FornitoriDTO;
import model.Fornitori;

@Repository
public class FornitoriRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Fornitori f)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		this.em.persist(f);
	}
	
	public boolean update(Fornitori f)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		try {
			this.em.merge(f);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void delete(Fornitori f)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		Fornitori ff= em.find(Fornitori.class, f.getId());
		em.remove(ff);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornitori> findAll(){
		Query q = em.createQuery("SELECT f FROM Fornitori f");
		List<Fornitori> res = q.getResultList();
		return res;
	}
	
	public Fornitori findById(int id) {
		return em.find(Fornitori.class, id);
	}
	

}
