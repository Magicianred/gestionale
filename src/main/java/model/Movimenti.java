package model;

import java.io.Serializable;
import javax.persistence.*;



import java.util.Date;


/**
 * The persistent class for the movimenti database table.
 * 
 */
@Entity
@Table (name = "MOVIMENTI")
public class Movimenti  {
	

	@Id
	@GeneratedValue
    @Column(name = "ID_mov")
	private int ID_mov;

	@Temporal(TemporalType.DATE)
	private Date data;

	private float prezzo;

	private int quantita;

	private float totale;
	
	private Prodotti prodotti; 
	
	private Fornitori fornitori;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@ElementCollection
	@JoinColumn(name="id_prod")
	public Prodotti getProdotti() {
		return prodotti;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@ElementCollection
	@JoinColumn(name="id_forn")
	public Fornitori getFornitori() {
		return fornitori;
	}

	
	public int getID_mov() {
		return this.ID_mov;
	}

	public void setID_mov(int ID_mov) {
		this.ID_mov = ID_mov;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public float getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public float getTotale() {
		return this.totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}


	public void setFornitori (Fornitori fornitori) {
		this.fornitori = fornitori;
	}


	public void setProdotti(Prodotti prodotti) {
		this.prodotti = prodotti;
	}

}