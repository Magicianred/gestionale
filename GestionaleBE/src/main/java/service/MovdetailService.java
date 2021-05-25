package service;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Movdetail;
import repository.MovdetailsRepository;

@Service
public class MovdetailService {
	
	@Autowired
	private MovdetailsRepository mr;
	
	@Transactional
	public void insert(Movdetail m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		mr.insert(m);
	}
	
	@Transactional
	public boolean update(Movdetail m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return mr.update(m);
	}
	
	@Transactional
	public void remove(Movdetail m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		mr.remove(m);
	}
	
	public List<Movdetail> findAll(){
		return mr.findAll();
	}
	
	public Movdetail findById(int ID_mov) {
		return mr.findById(ID_mov);
	}
	
	public List<Movdetail> findByIdProd(int id_prod) {
		return mr.findByIdProd(id_prod);
	}
	
	public List<Movdetail> findByNomeProd(String nome){
		return mr.findByNomeProd(nome);
	}
	
	public List<Movdetail> findByNomeForn(String nome){
		return mr.findByNomeForn(nome);
	}
	
	public List<Movdetail> findByDate (Date data){
		return mr.findByDate(data);
	}
	
	public List<Movdetail> findByDataRange (Date data1, Date data2){
		return mr.findByDataRange(data1, data2);
	}
	
}
