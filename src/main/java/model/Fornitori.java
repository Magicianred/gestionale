package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the fornitori database table.
 * 
 */
@Entity
@Table(name = "FORNITORI")
public class Fornitori  {
	

	@Id
	@GeneratedValue
    @Column(name = "ID")
	private int id;

	private String nome;

	@Column(name="p_iva")
	private String pIva;

	private String sede;
	
	private Set<Movimenti> movimentis = new HashSet<Movimenti>();

	@OneToMany(mappedBy = "fornitori")
	@ElementCollection
	public Set<Movimenti> getMovimentis(){
		return movimentis;
	}
	

	public Fornitori() {
	}
	
	

	public Fornitori(int id, String nome, String pIva, String sede) {
		this.id = id;
		this.nome = nome;
		this.pIva = pIva;
		this.sede = sede;
	}
	
	public void addProdotti(Movimenti prodotti) {
		this.movimentis.add(prodotti);
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


	public void setMovimentis(Set<Movimenti> movimentis) {
		this.movimentis = movimentis;
	}
	
	public void addMovimenti(Movimenti movimenti) {
		this.movimentis.add(movimenti);
	}

	

}