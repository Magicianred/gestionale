package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the dipendenti database table.
 * 
 */
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
@Table(name="dipendenti")
@NamedQuery(name="Dipendenti.findAll", query="SELECT d FROM Dipendenti d")
public class Dipendenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_dip;

	private String cognome;

	private String nome;

	private int numero;

	private String ruolo;

	private int stipendio;

	public Dipendenti() {
	}

	public int getID_dip() {
		return this.ID_dip;
	}

	public void setID_dip(int ID_dip) {
		this.ID_dip = ID_dip;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getStipendio() {
		return this.stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_dip;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero;
		result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
		result = prime * result + stipendio;
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
		Dipendenti other = (Dipendenti) obj;
		if (ID_dip != other.ID_dip)
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero != other.numero)
			return false;
		if (ruolo == null) {
			if (other.ruolo != null)
				return false;
		} else if (!ruolo.equals(other.ruolo))
			return false;
		if (stipendio != other.stipendio)
			return false;
		return true;
	}

}