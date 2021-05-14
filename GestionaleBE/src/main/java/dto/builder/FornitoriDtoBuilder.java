package dto.builder;

import java.util.ArrayList;
import java.util.List;

import dto.FornitoriDTO;
import model.Fornitori;
import model.Movimenti;

public class FornitoriDtoBuilder {
	
	public static Fornitori DtoToFornitori(FornitoriDTO f) {
		Fornitori myFornitori = new Fornitori();
		
		myFornitori.setId(f.getId());
		myFornitori.setNome(f.getSede());
		myFornitori.setPIva(f.getpIva());
		myFornitori.setSede(f.getSede());
		
		return myFornitori;
	}
	
	public static FornitoriDTO FornitoriToDTO(Fornitori f) {
		FornitoriDTO myFornitori = new FornitoriDTO();
		
		myFornitori.setId(f.getId());
		myFornitori.setNome(f.getSede());
		myFornitori.setpIva(f.getPIva());
		myFornitori.setSede(f.getSede());
		
		return myFornitori;
		
	}
	
	public static List<FornitoriDTO> ListaFornitoriToDTO(List<Fornitori> f){
		List<FornitoriDTO> fd = new ArrayList<FornitoriDTO>();
		for(Fornitori ff : f) {
			fd.add(new FornitoriDTO(ff.getId(), ff.getNome(),ff.getPIva(),ff.getSede()));
		}return fd;
	}
	
//	public static List<Fornitori> ListaDtoToFornitori(List<FornitoriDTO> f){
//		List<Fornitori> fd = new ArrayList<Fornitori>();
//		List<Movimenti> mov = new ArrayList<Movimenti>();
//		for(FornitoriDTO ff : f) {
//			fd.add(new Fornitori(ff.getId(), ff.getNome(),ff.getpIva(),ff.getSede(), mov));
//		}
//		return fd;
//	}
	
	

}
