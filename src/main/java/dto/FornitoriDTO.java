package dto;

import java.io.Serializable;

public class FornitoriDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;
	
	private String pIva;

	private String sede;

	public FornitoriDTO(int id, String nome, String pIva, String sede) {
		this.id = id;
		this.nome = nome;
		this.pIva = pIva;
		this.sede = sede;
	}

	public FornitoriDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	
	
}
