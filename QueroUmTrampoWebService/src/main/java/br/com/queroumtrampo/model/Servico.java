package br.com.queroumtrampo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Servicos")
public class Servico implements Serializable {

	private static final long serialVersionUID = 4375726132569272012L;

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, length = 60)
	private String titulo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "idImagem", nullable = false)
//	private Imagem imagem;

	@Column(precision = 15, scale = 2, nullable = false)
	private BigDecimal valor;

	@Column(length = 2000)
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

//	public Imagem getImagem() {
//		return imagem;
//	}
//
//	public void setImagem(Imagem imagem) {
//		this.imagem = imagem;
//	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
