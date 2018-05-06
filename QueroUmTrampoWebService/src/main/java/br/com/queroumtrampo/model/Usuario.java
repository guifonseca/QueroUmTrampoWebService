package br.com.queroumtrampo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name = "usuario.buscaPorEmail", query = "select u from Usuario u where u.email = :email")
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 5766147695203453263L;

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, length = 60)
	private String nome;

	@Column(nullable = false, length = 10)
	private String apelido;

	@Column(nullable = false)
	private int tipoCadastro;

	@Column(unique = true, nullable = false)
	private double cpfCnpj;

	@Column(nullable = false)
	private int sexo;

	@Column(unique = true, nullable = false, length = 60)
	private String email;

	@Column(nullable = false, length = 20)
	private String senha;

	@Column(unique = true, nullable = false, length = 15)
	private String celular;

	@Column(nullable = false, length = 60)
	private String cep;

	@Column(nullable = false, length = 100)
	private String endereco;

	@Column(nullable = true)
	private int numero;

	@Column(nullable = true, length = 100)
	private String complemento;

	@Column(nullable = false, length = 20)
	private String estado;

	@Column(nullable = false, length = 20)
	private String regiao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idImagem", nullable = false)
	private Imagem imagem;

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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public int getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(int tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	public double getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(double cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", tipoCadastro=" + tipoCadastro
				+ ", cpfCnpj=" + cpfCnpj + ", sexo=" + sexo + ", email=" + email + ", senha=" + senha + ", celular="
				+ celular + ", cep=" + cep + ", endereco=" + endereco + ", numero=" + numero + ", complemento="
				+ complemento + ", estado=" + estado + ", regiao=" + regiao + ", dataCriacao=" + dataCriacao
				+ ", imagem=" + imagem + "]";
	}
}
