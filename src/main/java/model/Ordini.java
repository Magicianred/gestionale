package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordini database table.
 * 
 */
@Entity
@NamedQuery(name="Ordini.findAll", query="SELECT o FROM Ordini o")
public class Ordini implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	//bi-directional many-to-one association to OrdProd
	@OneToMany(mappedBy="ordini")
	private List<OrdProd> ordProds;

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