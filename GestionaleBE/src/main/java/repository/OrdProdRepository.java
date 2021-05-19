package repository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.OrdProd;

@Repository
public class OrdProdRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(OrdProd o)throws ClassNotFoundException, SQLException, NamingException, ParseException  {
		this.em.persist(o);
	}
	
	public boolean update(OrdProd o)throws ClassNotFoundException, SQLException, NamingException, ParseException  {
		try {
			this.em.merge(o);
		}catch (Exception e) {
			return false;
		}return true;
	}
	
	public void delete(OrdProd o)throws ClassNotFoundException, SQLException, NamingException, ParseException  {
		OrdProd op = em.find(OrdProd.class, o.getId());
		em.remove(op);
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdProd> findAll(){
		Query q = em.createQuery("SELECT o FROM OrdProd o");
		List<OrdProd> res =q.getResultList();
		return res;
	}
	
	public OrdProd findById(int id) {
		return em.find(OrdProd.class, id);
	}

}
