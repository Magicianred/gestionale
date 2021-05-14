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

import model.OrdProd;
import service.OrdProdService;

@RestController
@RequestMapping("/ordProd")
public class OrdProdController {
	
	@Autowired
	private OrdProdService os;
	
	@PostMapping("/insert")
	@Consumes("application/json")
	public OrdProd insert (@RequestBody OrdProd o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		os.insert(o);
		return o;	
	}
	
	@PutMapping("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean update(@RequestBody OrdProd o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		return os.update(o);
	}
	
	@DeleteMapping("/delete")
	@Produces("application/json")
	public void remove(@RequestBody OrdProd o) throws ClassNotFoundException, SQLException, NamingException, ParseException {
		os.remove(o);
	}
	
	@GetMapping("/findAll")
	@Produces("application/json")
	public List<OrdProd> findAll(){
		return os.findAll();	
	}

	
	@GetMapping("/findByID")
	@Produces("application/json")
	public OrdProd findById(@RequestParam (value = "id", required =true)int id) {
		return os.findById(id);
	}
}
