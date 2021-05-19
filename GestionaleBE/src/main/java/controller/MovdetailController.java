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

import model.Movdetail;
import service.MovdetailService;

@RestController
@RequestMapping("/movdetail")
public class MovdetailController {
	
	@Autowired
	private MovdetailService ms;
	
	@PostMapping("/insert")
	@Consumes("application/json")
	public Movdetail insert(@RequestBody Movdetail m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ms.insert(m);
		return m;
	}
	
	@PutMapping("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean update(@RequestBody Movdetail m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return ms.update(m);
	}
	
	@DeleteMapping("/delete")
	@Produces("application/json")
	public void remove(@RequestBody Movdetail m) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		ms.remove(m);
	}
	
	@GetMapping("/findAll")
	@Produces("application/json")
	public List<Movdetail> findAll(){
		return ms.findAll();
	}
	
	
	@GetMapping("/findByID")
	@Produces("application/json")
	public Movdetail findById(@RequestParam (value = "id", required = true) int id) {
		return ms.findById(id);
	}
	
	@GetMapping("/findByIdProd")
	@Produces("application/json")
	public Movdetail findByIdProd(@RequestParam (value = "id_prod", required = true) int id_prod) {
		return ms.findByIdProd(id_prod);
	}

}
