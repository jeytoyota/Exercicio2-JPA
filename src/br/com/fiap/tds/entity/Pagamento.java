package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EXJPA_PAGAMENTO")
@SequenceGenerator(name="pagamento", sequenceName = "SQ_T_EXJPA_PAGAMENTO", allocationSize=1)
public class Pagamento {
	
	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento")
	private int codigo;
	
	@Column(name="dt_pagamento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(name="vl_pagamento", nullable = false)
	private float valor;
	
	@Column(name="ds_forma_pagamento", nullable = false)
	private String formaPagamento;
	
	

	public Pagamento() {
	}

	public Pagamento(Calendar data, float valor, String formaPagamento) {
		super();
		this.data = data;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Pagamento [codigo=" + codigo + ", data=" + data + ", valor=" + valor + ", formaPagamento="
				+ formaPagamento + "]";
	}
	
	

}
