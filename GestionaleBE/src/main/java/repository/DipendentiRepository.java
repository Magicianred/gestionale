package repository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Dipendenti;

@Repository
public class DipendentiRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Dipendenti d)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		this.em.persist(d);
	}
	
	public boolean update(Dipendenti d)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		try {
			this.em.merge(d);
		}catch(Exception e) {
			return false;
		}
		return true;
		
	}
	
	public void delete(Dipendenti d)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		Dipendenti dd = em.find(Dipendenti.class, d.getId());
		em.remove(dd);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dipendenti> findAll(){
		Query q = em.createQuery(
				"SELECT d FROM Dipendenti d");
		List<Dipendenti> res = q.getResultList();
		return res;
	}
	
	public Dipendenti findByid(int ID_dip) {
		return em.find(Dipendenti.class, ID_dip);
	}

}
