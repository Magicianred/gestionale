package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the ordini database table.
 * 
 */
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
@Table(name = "ordini")
@NamedQuery(name = "Ordini.findAll", query = "SELECT o FROM Ordini o")
public class Ordini implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	// bi-directional many-to-one association to OrdProd
	@OneToMany(mappedBy = "ordini")
	private List<OrdProd> ordProds;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + id;
		result = prime * result + ((ordProds == null) ? 0 : ordProds.hashCode());
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
		Ordini other = (Ordini) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (ordProds == null) {
			if (other.ordProds != null)
				return false;
		} else if (!ordProds.equals(other.ordProds))
			return false;
		return true;
	}

	public Ordini() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<OrdProd> getOrdProds() {
		return this.ordProds;
	}

	public void setOrdProds(List<OrdProd> ordProds) {
		this.ordProds = ordProds;
	}

	public OrdProd addOrdProd(OrdProd ordProd) {
		getOrdProds().add(ordProd);
		ordProd.setOrdini(this);

		return ordProd;
	}

	public OrdProd removeOrdProd(OrdProd ordProd) {
		getOrdProds().remove(ordProd);
		ordProd.setOrdini(null);

		return ordProd;
	}

}