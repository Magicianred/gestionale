package model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the prodotti database table.
 * 
 */
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
@Table(name = "prodotti")
@NamedQuery(name = "Prodotti.findAll", query = "SELECT p FROM Prodotti p")
public class Prodotti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	private String descrizione;

	private int giacenza;

	private String nome;

	// bi-directional many-to-one association to Movimenti
	@OneToMany(mappedBy = "prodotti")
	@JsonIgnore
	private Set<Movimenti> movimentis;

	// bi-directional many-to-one association to OrdProd
	@OneToMany(mappedBy = "prodotti")
	@JsonIgnore
	private Set<OrdProd> ordProds;

	public Prodotti() {
	}

	
	
	
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + giacenza;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Prodotti other = (Prodotti) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (giacenza != other.giacenza)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}









	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getGiacenza() {
		return this.giacenza;
	}

	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Movimenti> getMovimentis() {
		return this.movimentis;
	}

	public void setMovimentis(Set<Movimenti> movimentis) {
		this.movimentis = movimentis;
	}

	public Movimenti addMovimenti(Movimenti movimenti) {
		getMovimentis().add(movimenti);
		movimenti.setProdotti(this);

		return movimenti;
	}

	public Movimenti removeMovimenti(Movimenti movimenti) {
		getMovimentis().remove(movimenti);
		movimenti.setProdotti(null);

		return movimenti;
	}

	public Set<OrdProd> getOrdProds() {
		return this.ordProds;
	}

	public void setOrdProds(Set<OrdProd> ordProds) {
		this.ordProds = ordProds;
	}

	public OrdProd addOrdProd(OrdProd ordProd) {
		getOrdProds().add(ordProd);
		ordProd.setProdotti(this);

		return ordProd;
	}

	public OrdProd removeOrdProd(OrdProd ordProd) {
		getOrdProds().remove(ordProd);
		ordProd.setProdotti(null);

		return ordProd;
	}

}