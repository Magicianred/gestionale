package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Dipendenti;
import repository.DipendentiRepository;

@Service
public class DipendentiService {

	@Autowired
	private DipendentiRepository dr;
	
	@Transactional
	public void insert(Dipendenti d) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		dr.insert(d);
	}
	
	@Transactional
	public boolean update(Dipendenti d) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return dr.update(d);
	}
	
	@Transactional
	public void remove(Dipendenti d) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		dr.delete(d);
	}
	
	public List<Dipendenti> findAll(){
		return dr.findAll();
	}
	
	public Dipendenti findById(int ID_dip){
		return dr.findByid(ID_dip);
	}
	
	public List<Dipendenti> findByNome(String nome){
		return dr.findByNome(nome);
	}
	
	public List<Dipendenti> findByCognome(String cognome){
		return dr.findByCognome(cognome);
	}
	
	public List<Dipendenti> findByRuolo(String ruolo){
		return dr.findByRuolo(ruolo);
	}
	
	
	
	
}
