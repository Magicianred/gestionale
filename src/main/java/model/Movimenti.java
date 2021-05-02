package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the movimenti database table.
 * 
 */
@Entity
@NamedQuery(name="Movimenti.findAll", query="SELECT m FROM Movimenti m")
public class Movimenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_mov;

	@Temporal(TemporalType.DATE)
	private Date data;

	private float prezzo;

	private int quantita;

	private float totale;

	//bi-directional many-to-one association to Fornitori
	@ManyToOne
	@JoinColumn(name="id_forn")
	private Fornitori fornitori;

	//bi-directional many-to-one association to Prodotti
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Prodotti prodotti;

	public Movimenti() {
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

	public Fornitori getFornitori() {
		return this.fornitori;
	}

	public void setFornitori(Fornitori fornitori) {
		this.fornitori = fornitori;
	}

	public Prodotti getProdotti() {
		return this.prodotti;
	}

	public void setProdotti(Prodotti prodotti) {
		this.prodotti = prodotti;
	}

}