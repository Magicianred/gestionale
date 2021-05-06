package dto;

import java.io.Serializable;
import java.util.Date;

public class MovimentiDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID_mov;
	
	private Date data;

	private float prezzo;

	private int quantita;

	private float totale;
	
	private FornitoriDTO fornitori;
	
	private ProdottiDTO prodotti;

	public MovimentiDTO() {
	}

	public int getID_mov() {
		return ID_mov;
	}

	public void setID_mov(int iD_mov) {
		ID_mov = iD_mov;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public float getTotale() {
		return totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}

	public FornitoriDTO getFornitori() {
		return fornitori;
	}

	public void setFornitori(FornitoriDTO fornitori) {
		this.fornitori = fornitori;
	}

	public ProdottiDTO getProdotti() {
		return prodotti;
	}

	public void setProdotti(ProdottiDTO prodotti) {
		this.prodotti = prodotti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
