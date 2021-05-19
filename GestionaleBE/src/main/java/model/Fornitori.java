package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the fornitori database table.
 * 
 */
@Entity
@NamedQuery(name="Fornitori.findAll", query="SELECT f FROM Fornitori f")
public class Fornitori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	@Column(name="p_iva")
	private String pIva;

	private String sede;

	//bi-directional many-to-one association to Movimenti
	@JsonIgnore
	@OneToMany(mappedBy="fornitori")
	private List<Movimenti> movimentis;

	public Fornitori() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPIva() {
		return this.pIva;
	}

	public void setPIva(String pIva) {
		this.pIva = pIva;
	}

	public String getSede() {
		return this.sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public List<Movimenti> getMovimentis() {
		return this.movimentis;
	}

	public void setMovimentis(List<Movimenti> movimentis) {
		this.movimentis = movimentis;
	}

	public Movimenti addMovimenti(Movimenti movimenti) {
		getMovimentis().add(movimenti);
		movimenti.setFornitori(this);

		return movimenti;
	}

	public Movimenti removeMovimenti(Movimenti movimenti) {
		getMovimentis().remove(movimenti);
		movimenti.setFornitori(null);

		return movimenti;
	}

}