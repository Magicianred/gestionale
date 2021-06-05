package repository;

import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Fornitori;
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
	
	public int delete(int id)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		Query q = em.createQuery("SELECT COUNT(*) FROM Prodotti p, Movdetail m WHERE p.id = m.prodotti AND p.id = :id");
		q.setParameter("id", id);
		long a = (Long) q.getSingleResult();
		if(a == 0) {
			em.remove(em.find(Prodotti.class, id));
			System.out.println("eliminato");
			return 0;
		}else { 
			System.out.println("errore foreign key");
			return 1;
			}
		
		
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
	
	
	@SuppressWarnings("unchecked")
	public List<Prodotti> findByNome(String nome) {
		Query q = em.createQuery(
				"SELECT p FROM Prodotti p WHERE nome LIKE :nome");
		q.setParameter("nome", "%"+nome+"%");
		List<Prodotti> res = q.getResultList();
		return res;
	}
	
}
