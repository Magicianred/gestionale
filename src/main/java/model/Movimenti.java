package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The persistent class for the movimenti database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "movimenti")
@NamedQuery(name = "Movimenti.findAll", query = "SELECT m FROM Movimenti m")
public class Movimenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_mov")
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private float prezzo;

	private int quantita;

	private float totale;

	// bi-directional many-to-one association to Fornitori
	@ManyToOne
	@JoinColumn(name = "id_forn")
	private Fornitori fornitori;

	// bi-directional many-to-one association to Prodotti
	@ManyToOne
	@JoinColumn(name = "id_prod")
	private Prodotti prodotti;

	public Movimenti() {
	}

	public int getId() {
		return id;
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