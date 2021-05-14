package repository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Fornitori;
import model.Movimenti;

@Repository
public class MovimentiRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Movimenti m)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		em.persist(m);
	}
	
	public boolean update(Movimenti m)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		try {
			this.em.merge(m);
		}catch (Exception e) {
			return false;
		}return true;
	}
	
	public void remove(Movimenti m)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		Movimenti mm = em.find(Movimenti.class, m.getID_mov());
		em.remove(mm);
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimenti> findAll(){
		Query q = em.createQuery("SELECT m FROM Movimenti m");
		List<Movimenti> res = q.getResultList();
		return res;
	}
	
	public Movimenti findById(int Id) {
		return em.find(Movimenti.class, Id);
	}
	
	public Movimenti findByIdProd(int id_prod) {
		return em.find(Movimenti.class, id_prod);
	}
}
