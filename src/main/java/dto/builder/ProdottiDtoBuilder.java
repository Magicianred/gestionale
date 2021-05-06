package dto.builder;

import java.util.ArrayList;
import java.util.List;

import dto.ProdottiDTO;
import model.Movimenti;
import model.OrdProd;
import model.Prodotti;

public class ProdottiDtoBuilder {
	
	public static Prodotti DtoToProdotti(ProdottiDTO p) {
		Prodotti myProdotti = new Prodotti();
		
		myProdotti.setId(p.getId());
		myProdotti.setDescrizione(p.getDescrizione());
		myProdotti.setGiacenza(p.getGiacenza());
		myProdotti.setNome(p.getNome());
		
		
		
		return myProdotti;
	}
	
	public static ProdottiDTO ProdottiToDto (Prodotti p) {
		ProdottiDTO myProdotti = new ProdottiDTO();
		
		myProdotti.setId(p.getId());
		myProdotti.setDescrizione(p.getDescrizione());
		myProdotti.setGiacenza(p.getGiacenza());
		myProdotti.setNome(p.getNome());
		
		
		
		return myProdotti;
	}
	
	public static List<ProdottiDTO> ListaProdottiToDto(List<Prodotti> p){
		List<ProdottiDTO> pd = new ArrayList<ProdottiDTO>();
		for(Prodotti pp : p) {
			pd.add(new ProdottiDTO(pp.getId(),pp.getDescrizione(), pp.getGiacenza(), pp.getNome()));
		}
		return pd;
	}
	
	public static List<Prodotti> ListaDtotoProdotti(List<ProdottiDTO> p){
		List<Prodotti> pd = new ArrayList<Prodotti>();
		List<Movimenti> mov = new ArrayList<Movimenti>();
		List<OrdProd> op = new ArrayList<OrdProd>();
		for(ProdottiDTO pp: p) {
			pd.add(new Prodotti(pp.getId(),pp.getDescrizione(),pp.getGiacenza(),pp.getNome(), mov, op));
		}
		return pd;
	}

}
