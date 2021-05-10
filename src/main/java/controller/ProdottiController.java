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

import model.Prodotti;
import service.ProdottiService;

@RestController
@RequestMapping("/prodotti")
public class ProdottiController {
	
	@Autowired
	private ProdottiService ps;
	
	@PostMapping("/insert")
	@Consumes("application/json")
	public Prodotti insert(@RequestBody Prodotti p) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ps.insert(p);
		return p;
	}
	
	@PutMapping("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean update(@RequestBody Prodotti p) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return ps.update(p);
	}
	
	@DeleteMapping("/delete")
	@Produces("application/json")
	public void remove(@RequestBody Prodotti p) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ps.remove(p);
	}
	
	@GetMapping("/findAll")
	@Produces("application/json")
	public List<Prodotti> findAll(){
		return ps.findAll();
	}
	
	@GetMapping("/findByID")
	@Produces("application/json")
	public Prodotti findById(@RequestParam (value = "id", required  =true ) int id) {
		return ps.findById(id);
	}
	
	@GetMapping("/FindGiacDecre")
	@Produces("application/json")
	public List<Prodotti> FindGiacDecre(){
		return ps.FindGiacDecre();
	}
	
	@GetMapping("/FindGiacCres")
	@Produces("application/json")
	public List<Prodotti> FindGiacCres(){
		return ps.FindGiacCres();
	}
}
