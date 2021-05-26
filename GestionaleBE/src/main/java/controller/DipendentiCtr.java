package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Dipendenti;
import service.DipendentiService;

@RestController
@RequestMapping("/dipendente")
public class DipendentiCtr {
	
	@Autowired
	private DipendentiService ds;
	
	@PostMapping("/insert")
	@Consumes("application/json")
	public Dipendenti insert(@RequestBody Dipendenti d) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ds.insert(d);
		return d;
	}
	
	@PutMapping("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean update(@RequestBody Dipendenti d) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return ds.update(d);
	}
	
	@DeleteMapping("/delete")
	@Produces("application/json")
	public void remove(@RequestBody Dipendenti d) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ds.remove(d);
	}
	
	@GetMapping("/findAll")
	@Produces("application/json")
	public List<Dipendenti> findAll(){
		return ds.findAll();
	}
	
	@GetMapping("/findByID")
	@Produces("application/json")
	public Dipendenti findByID(@RequestParam(value = "ID_dip", required = true) int ID_dip){
		return ds.findById(ID_dip);
	}
	
	@GetMapping("/findByNome")
	@Produces("application/json")
	public List<Dipendenti> findByNome(@RequestParam(value = "nome", required = true) String nome){
		return ds.findByNome(nome);
	}
	
	@GetMapping("/findByCognome")
	@Produces("application/json")
	public List<Dipendenti> findByCognome(@RequestParam(value = "cognome", required = true) String cognome){
		return ds.findByCognome(cognome);
	}
	
	@GetMapping("/findByRuolo")
	@Produces("application/json")
	public List<Dipendenti> findByRuolo(@RequestParam(value = "ruolo", required = true) String ruolo){
		return ds.findByRuolo(ruolo);
	}
	
	
	 	
}
