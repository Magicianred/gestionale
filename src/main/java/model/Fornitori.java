package model;

import java.io.Serializable;
import java.util.List;

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
 * The persistent class for the fornitori database table.
 * 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "fornitori")
@NamedQuery(name = "Fornitori.findAll", query = "SELECT f FROM Fornitori f")
public class Fornitori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	private String nome;

	@Column(name = "p_iva")
	private String pIva;

	private String sede;

	// bi-directional many-to-one association to Movimenti
	@OneToMany(mappedBy = "fornitori")
	@JsonIgnore
	private List<Movimenti> movimentis;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((movimentis == null) ? 0 : movimentis.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pIva == null) ? 0 : pIva.hashCode());
		result = prime * result + ((sede == null) ? 0 : sede.hashCode());
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
		Fornitori other = (Fornitori) obj;
		if (id != other.id)
			return false;
		if (movimentis == null) {
			if (other.movimentis != null)
				return false;
		} else if (!movimentis.equals(other.movimentis))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pIva == null) {
			if (other.pIva != null)
				return false;
		} else if (!pIva.equals(other.pIva))
			return false;
		if (sede == null) {
			if (other.sede != null)
				return false;
		} else if (!sede.equals(other.sede))
			return false;
		return true;
	}

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