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

import model.Fornitori;
import service.FornitoriService;

@RestController
@RequestMapping("/fornitore")
public class FornitoriController 	 {
	
	@Autowired
	private FornitoriService fs;
	
	@PostMapping("/insert")
	@Consumes("application/json")
	public Fornitori insert(@RequestBody Fornitori f) {
		fs.insert(f);
		return f;
	}
	
	@PutMapping("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean update(@RequestBody Fornitori f) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return fs.update(f);
	}
	
	@DeleteMapping("/delete")
	@Produces("application/json")
	public void remove(@RequestBody Fornitori f) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		fs.remove(f);
	}
	
	@GetMapping("/findAll")
	@Produces("application/json")
	public List<Fornitori> findAll(){
		return fs.findAll();
	}
	
	@GetMapping("/findByID")
	@Produces("application/json")
	public Fornitori findByID(@RequestParam(value ="id", required = true) int id) {
		return fs.findById(id);
	}

}
