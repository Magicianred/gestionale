package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the movdetails database table.
 * 
 */
@Entity
@Table(name="movdetails")
@NamedQuery(name="Movdetail.findAll", query="SELECT m FROM Movdetail m")
public class Movdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float prezzo;

	private int quantity;

	//bi-directional many-to-one association to Movimenti
	@ManyToOne
	@JoinColumn(name="id_mov")
	private Movimenti movimenti;

	//bi-directional many-to-one association to Prodotti
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Prodotti prodotti;

	public Movdetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Movimenti getMovimenti() {
		return this.movimenti;
	}

	public void setMovimenti(Movimenti movimenti) {
		this.movimenti = movimenti;
	}

	public Prodotti getProdotti() {
		return this.prodotti;
	}

	public void setProdotti(Prodotti prodotti) {
		this.prodotti = prodotti;
	}

}