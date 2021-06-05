package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Fornitori;
import model.Prodotti;
import repository.ProdottiRepository;



@Service
public class ProdottiService {
	
	@Autowired
	private ProdottiRepository pr;
	
	@Transactional
	public void insert(Prodotti p) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		pr.insert(p);
	}
	
	@Transactional
	public boolean update(Prodotti p) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return pr.update(p);
	}
	
	@Transactional
	public int remove(int id) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return pr.delete(id);
	}
	
	public List<Prodotti> findAll(){
		return pr.findAll();
	}
	
	public Prodotti findById(int id) {
		return pr.findById(id);
	}
	
	public List<Prodotti> FindGiacDecre(){
		return pr.FindGiacDecre();
	}
	
	public List<Prodotti> FindGiacCres(){
		return pr.FindGiacCres();
	}

	public List<Prodotti> findByNome(String nome){
		return pr.findByNome(nome);
	}
}
