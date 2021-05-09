package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.OrdProd;
import repository.OrdProdRepository;

@Service
public class OrdProdService {
	
	@Autowired
	private OrdProdRepository or;
	
	@Transactional
	public void insert(OrdProd o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		or.insert(o);
	}
	
	@Transactional
	public boolean update(OrdProd o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return or.update(o);
	}
	
	@Transactional
	public void remove (OrdProd o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		or.delete(o);
	}
	
	public List<OrdProd> findAll(){
		return or.findAll();	
	}
	
	public OrdProd findById(int id) {
		return or.findById(id);
	}
	
	

}
