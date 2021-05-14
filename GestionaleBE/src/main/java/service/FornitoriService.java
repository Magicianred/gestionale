package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.FornitoriDTO;
import model.Fornitori;
import model.Prodotti;
import repository.FornitoriRepository;

@Service
public class FornitoriService {
	
	@Autowired
	private FornitoriRepository fr;
	
	@Transactional
	public void insert (Fornitori f) {
		try {
			fr.insert(f);
		} catch (ClassNotFoundException e) {
			System.out.println("Errore Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Errore SQL");
			e.printStackTrace();
		} catch (NamingException e) {
			System.out.println("Errore name");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Errore data");
			e.printStackTrace();
		}
	}
	
	@Transactional
	public boolean update (Fornitori f) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return fr.update(f);
	}
	
	@Transactional
	public void remove(Fornitori f) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		fr.delete(f);
	}
	
	
	public List<Fornitori> findAll(){
		return fr.findAll();
	}
	
	public Fornitori findById(int id) {
		return fr.findById(id);
	}
	
	public List<Fornitori> findByNome(String nome){
		return fr.findByNome(nome);
	}
	
	public List<Fornitori> findByPiva (String pIva){
		return fr.findByPiva(pIva);
	}
	
	public List<Fornitori> findBySede (String sede){
		return fr.findBySede(sede);
	}

}
