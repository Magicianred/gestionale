package repository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Ordini;

@Repository
public class OrdiniRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Ordini o)throws ClassNotFoundException, SQLException, NamingException, ParseException  {
		this.em.persist(o);
	}
	
	public boolean update(Ordini o)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		try {
			this.em.merge(o);
		}catch(Exception e){
			return false;
		}return true;
	}
	
	public void delete(Ordini o)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		Ordini oo = em.find(Ordini.class, o.getId());
		em.remove(oo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordini> findAll(){
		Query q = em.createQuery(
				"SELECT o FROM Ordini o");
		List<Ordini> res = q.getResultList();
		return res;
	}
	
	public Ordini findById(int id) {
		return em.find(Ordini.class, id);
	}
	

}
