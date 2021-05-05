package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Movimenti;
import repository.MovimentiRepository;

@Service
public class MovimentiService {

	@Autowired
	private MovimentiRepository mr;
	
	@Transactional
	public void insert(Movimenti m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		mr.insert(m);
	}
	
	@Transactional
	public boolean update(Movimenti m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return mr.update(m);
	}
	
	@Transactional
	public void remove(Movimenti m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		mr.remove(m);
	}
	
	public List<Movimenti> findAll(){
		return mr.findAll();
	}
	
	public Movimenti findById(int ID_mov) {
		return mr.findById(ID_mov);
	}
	
	
}
