package dto;

import java.io.Serializable;

public class ProdottiDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String descrizione;

	private int giacenza;

	private String nome;
	
	public ProdottiDTO() {
		
	}

	public ProdottiDTO(int id, String descrizione, int giacenza, String nome) {
		this.id = id;
		this.descrizione = descrizione;
		this.giacenza = giacenza;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
