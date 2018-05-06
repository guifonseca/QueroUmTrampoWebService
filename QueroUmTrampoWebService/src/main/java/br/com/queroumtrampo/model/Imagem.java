package br.com.queroumtrampo.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name="Imagens" )
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Imagem implements Serializable
{
	private static final long serialVersionUID = 1421582774615129235L;

	@Id
	@GeneratedValue
	private int id;
	
	@Temporal( TemporalType.TIMESTAMP )
	private Date dataCriacao;
	
	@Column(nullable=false)
	private String nome;
	
	@Lob
	private byte[] bytesImagem;
	
	public Imagem( ){ }
	
	public int getId( ) 
	{
		return id;
	}
	
	public void setId( int id ) 
	{
		this.id = id;
	}
	
	public Date getDataCriacao( ) 
	{
		return dataCriacao;
	}
	
	public void setDataCriacao( Date dataCriacao ) 
	{
		this.dataCriacao = dataCriacao;
	}
	
	public String getNome( ) 
	{
		return nome;
	}
	
	public void setNome( String nome ) 
	{
		this.nome = nome;
	}

	public byte[] getBytesImagem( ) 
	{
		return bytesImagem;
	}

	public void setBytesImagem( byte[] bytesImage ) 
	{
		this.bytesImagem = bytesImage;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Imagem [id=" + id + ", dataCriacao=" + dataCriacao + ", nome=" + nome + ", bytesImage="
				+ Arrays.toString(bytesImagem) + "]";
	}
}
