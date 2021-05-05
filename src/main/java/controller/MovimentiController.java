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

import model.Movimenti;
import service.MovimentiService;

@RestController
@RequestMapping("/movimenti")
public class MovimentiController {
	
	@Autowired
	private MovimentiService ms;
	
	@PostMapping("/insert")
	@Consumes("application/json")
	public Movimenti insert(@RequestBody Movimenti m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ms.insert(m);
		return m;
	}
	
	@PutMapping("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean update(@RequestBody Movimenti m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return ms.update(m);
	}
	
	@DeleteMapping("/delete")
	@Produces("application/json")
	public void remove(@RequestBody Movimenti m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ms.remove(m);
	}
	
	@GetMapping("/findAll")
	@Produces("application/json")
	public List<Movimenti> findAll(){
		return ms.findAll();
	}
	
	
	@GetMapping("/findByID")
	@Produces("application/json")
	public Movimenti findById(@RequestParam (value = "ID_mov", required = true) int ID_mov) {
		return ms.findById(ID_mov);
	}

}
