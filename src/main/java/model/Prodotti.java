package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prodotti database table.
 * 
 */
@Entity
@NamedQuery(name="Prodotti.findAll", query="SELECT p FROM Prodotti p")
public class Prodotti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descrizione;

	private int giacenza;

	private String nome;

	//bi-directional many-to-one association to Movimenti
	@OneToMany(mappedBy="prodotti")
	private List<Movimenti> movimentis;

	//bi-directional many-to-one association to OrdProd
	@OneToMany(mappedBy="prodotti")
	private List<OrdProd> ordProds;

	public Prodotti() {
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

	public List<Movimenti> getMovimentis() {
		return this.movimentis;
	}

	public void setMovimentis(List<Movimenti> movimentis) {
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

	public List<OrdProd> getOrdProds() {
		return this.ordProds;
	}

	public void setOrdProds(List<OrdProd> ordProds) {
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