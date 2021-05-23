package repository;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Movdetail;

@Repository
public class MovdetailsRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Movdetail m)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		em.persist(m);
	}
	
	public boolean update(Movdetail m)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		try {
			this.em.merge(m);
		}catch (Exception e) {
			return false;
		}return true;
	}
	
	public void remove(Movdetail m)throws ClassNotFoundException, SQLException, NamingException, ParseException {
		Movdetail mm = em.find(Movdetail.class, m.getId());
		em.remove(mm);
	}
	
	@SuppressWarnings("unchecked")
	public List<Movdetail> findAll(){
		Query q = em.createQuery("SELECT m FROM Movdetail m");
		List<Movdetail> res = q.getResultList();
		return res;
	}
	
	public Movdetail findById(int Id) {
		return em.find(Movdetail.class, Id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Movdetail> findByIdProd(int id_prod) {
		Query q = em.createQuery("SELECT m FROM Movdetail m WHERE id_prod = :id_prod");
		q.setParameter("id_prod", id_prod);
		List<Movdetail> res = q.getResultList();
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movdetail> findByNomeProd(String nome){
		Query q = em.createQuery("SELECT m FROM Movdetail m, Prodotti p WHERE m.prodotti = p.id AND p.nome LIKE :nome");
		q.setParameter("nome", "%"+nome+"%");
		List<Movdetail> res = q.getResultList();
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movdetail> findByNomeForn(String nome){
		Query q = em.createQuery("SELECT m FROM Movdetail m, Movimenti mm, Fornitori f WHERE m.movimenti = mm.id AND mm.fornitori = f.id AND f.nome LIKE :nome");
		q.setParameter("nome", "%"+nome+"%");
		List<Movdetail> res = q.getResultList();
		return res;
	}
}


