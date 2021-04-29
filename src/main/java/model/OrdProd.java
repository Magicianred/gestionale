package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ord_prod database table.
 * 
 */
@Entity
@Table(name="ord_prod")
@NamedQuery(name="OrdProd.findAll", query="SELECT o FROM OrdProd o")
public class OrdProd implements Serializable {
	private static final long serialVersionUID = 1L;

	private int quantita;

	//bi-directional many-to-one association to Ordini
	@ManyToOne
	@JoinColumn(name="ID_ORD")
	private Ordini ordini;

	//bi-directional many-to-one association to Prodotti
	@ManyToOne
	@JoinColumn(name="ID_PROD")
	private Prodotti prodotti;

	public OrdProd() {
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Ordini getOrdini() {
		return this.ordini;
	}

	public void setOrdini(Ordini ordini) {
		this.ordini = ordini;
	}

	public Prodotti getProdotti() {
		return this.prodotti;
	}

	public void setProdotti(Prodotti prodotti) {
		this.prodotti = prodotti;
	}

}