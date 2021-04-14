package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EXJPA_PASSAGEIRO")
@SequenceGenerator(name="passageiro", sequenceName = "SQ_T_EXJPA_PASSAGEIRO", allocationSize=1)
public class Passageiro {
	
	@Id
	@Column(name="cd_passageiro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passageiro")
	private int codigo;
	
	@Column(name="nm_passageiro", nullable = false, length = 100)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(name="ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	

	public Passageiro(String nome, Calendar data, Genero genero) {
		super();
		this.nome = nome;
		this.data = data;
		this.genero = genero;
	}
	

	public Passageiro() {
	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Passageiro [codigo=" + codigo + ", nome=" + nome + ", data=" + data + ", genero=" + genero + "]";
	}
	
	

}
