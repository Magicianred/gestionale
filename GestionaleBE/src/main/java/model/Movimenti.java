package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the movimenti database table.
 * 
 */
@Entity
@NamedQuery(name="Movimenti.findAll", query="SELECT m FROM Movimenti m")
public class Movimenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	//bi-directional many-to-one association to Movdetail
	@JsonIgnore
	@OneToMany(mappedBy="movimenti")
	private List<Movdetail> movdetails;

	//bi-directional many-to-one association to Fornitori
	@ManyToOne
	@JoinColumn(name="id_forn")
	private Fornitori fornitori;

	public Movimenti() {
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

	

	public List<Movdetail> getMovdetails() {
		return this.movdetails;
	}

	public void setMovdetails(List<Movdetail> movdetails) {
		this.movdetails = movdetails;
	}

	public Movdetail addMovdetail(Movdetail movdetail) {
		getMovdetails().add(movdetail);
		movdetail.setMovimenti(this);

		return movdetail;
	}

	public Movdetail removeMovdetail(Movdetail movdetail) {
		getMovdetails().remove(movdetail);
		movdetail.setMovimenti(null);

		return movdetail;
	}

	public Fornitori getFornitori() {
		return this.fornitori;
	}

	public void setFornitori(Fornitori fornitori) {
		this.fornitori = fornitori;
	}

}