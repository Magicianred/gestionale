package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the prodotti database table.
 * 
 */
@Entity
@Table(name = "PRODOTTI")
public class Prodotti {
	

	@Id
	@GeneratedValue
    @Column(name = "ID")
	private int id;

	private String descrizione;

	private int giacenza;

	private String nome;
	
	private Set<Movimenti> movimentis = new HashSet<Movimenti>();

	

	//bi-directional many-to-one association to OrdProd
	
	
//	@OneToMany(mappedBy="prodotti")
//	@JsonManagedReference
//	private List<OrdProd> ordProds;
	
	@OneToMany (mappedBy = "prodotti")
	@ElementCollection
	public Set<Movimenti> getMovimentis(){
		return movimentis;
	}

	public Prodotti() {
	}
	
	
	public Prodotti(int id, String descrizione, int giacenza, String nome) {
		this.id = id;
		this.descrizione = descrizione;
		this.giacenza = giacenza;
		this.nome = nome;
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

	
	


	public void setMovimentis(Set<Movimenti> prodotti) {
		this.movimentis = prodotti;
	}
	
	public void addMovimenti(Movimenti movimenti) {
		this.movimentis.add(movimenti);
	}
	

}