package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Ordini;
import repository.OrdiniRepository;

@Service
public class OrdiniService {
	
	@Autowired
	private OrdiniRepository or;
	
	@Transactional
	public void insert(Ordini o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		or.insert(o);
	}
	
	@Transactional
	public boolean update (Ordini o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return or.update(o);
	}
	
	@Transactional
	public void remove(Ordini o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		or.delete(o);
	}
	
	public List<Ordini> findAll(){
		return or.findAll();
	}
	
	public Ordini findById(int id) {
		return or.findById(id);
	}
}
