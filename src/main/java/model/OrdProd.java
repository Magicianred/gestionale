package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the ord_prod database table.
 * 
 */

@Entity
@Table(name = "ord_prod")
@NamedQuery(name = "OrdProd.findAll", query = "SELECT o FROM OrdProd o")
public class OrdProd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Ord_Prod")
	private int id;

	private int quantita;

	// bi-directional many-to-one association to Ordini
	@ManyToOne
	@JoinColumn(name = "ID_ORD")
	private Ordini ordini;

	// bi-directional many-to-one association to Prodotti
	@ManyToOne
	@JoinColumn(name = "ID_PROD")
	private Prodotti prodotti;

	public OrdProd() {
	}

	public int getID_Ord_Prod() {
		return this.id;
	}

	public void setID_Ord_Prod(int ID_Ord_Prod) {
		this.id = ID_Ord_Prod;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result +id;
		result = prime * result + ((ordini == null) ? 0 : ordini.hashCode());
		result = prime * result + ((prodotti == null) ? 0 : prodotti.hashCode());
		result = prime * result + quantita;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdProd other = (OrdProd) obj;
		if (id != other.id)
			return false;
		if (ordini == null) {
			if (other.ordini != null)
				return false;
		} else if (!ordini.equals(other.ordini))
			return false;
		if (prodotti == null) {
			if (other.prodotti != null)
				return false;
		} else if (!prodotti.equals(other.prodotti))
			return false;
		if (quantita != other.quantita)
			return false;
		return true;
	}

	public Prodotti getProdotti() {
		return this.prodotti;
	}

	public void setProdotti(Prodotti prodotti) {
		this.prodotti = prodotti;
	}

}