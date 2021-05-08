package dto.builder;

import dto.MovimentiDTO;
import model.Movimenti;

public class MovimentiDtoBuilder {
	
	public static MovimentiDTO MovimentiToDTO(Movimenti m) {
		MovimentiDTO myMovimenti = new MovimentiDTO(); 
		
		myMovimenti.setID_mov(m.getId());
		myMovimenti.setData(m.getData());
		myMovimenti.setPrezzo(m.getPrezzo());
		myMovimenti.setQuantita(m.getQuantita());
		myMovimenti.setTotale(m.getTotale());
		myMovimenti.setProdotti(ProdottiDtoBuilder.ProdottiToDto(m.getProdotti()));
		myMovimenti.setFornitori(FornitoriDtoBuilder.FornitoriToDTO(m.getFornitori()));
		
		return myMovimenti;
	}
	
	public static Movimenti DtoToMovimenti(MovimentiDTO m) {
		Movimenti myMovimenti = new Movimenti();
		myMovimenti.setId(m.getID_mov());
		myMovimenti.setData(m.getData());
		myMovimenti.setPrezzo(m.getPrezzo());
		myMovimenti.setQuantita(m.getQuantita());
		myMovimenti.setTotale(m.getTotale());
		myMovimenti.setProdotti(ProdottiDtoBuilder.DtoToProdotti(m.getProdotti()));
		myMovimenti.setFornitori(FornitoriDtoBuilder.DtoToFornitori(m.getFornitori()));
		
		return myMovimenti;
	}

}
