package Modelo;

import javax.swing.JOptionPane;

public class Endereco
{
	//atributos comuns
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private String estado;
	
	//métodos de acesso
	public String getRua()
	{	return rua;	}
	
	public void setRua(String rua)
	{	this.rua = rua;	}
	
	public String getNumero()
	{	return numero;	}
	
	public void setNumero(String numero)
	{	this.numero = numero;	}
	
	public String getComplemento()
	{	return complemento;	}
	
	public void setComplemento(String complemento)
	{	this.complemento = complemento;	}
	
	public String getBairro()
	{	return bairro;	}
	
	public void setBairro(String bairro)
	{	this.bairro = bairro;	}
	
	public String getCidade()
	{	return cidade;	}
	
	public void setCidade(String cidade)
	{	this.cidade = cidade;	}
	
	public String getCep()
	{	return cep;	}
	
	public void setCep(String cep)
	{	this.cep = cep;	}
	
	public String getEstado()
	{	return estado;	}
	
	public void setEstado(String estado)
	{	this.estado = estado;	}
	
	//método construtor c/ parâmetros
	public Endereco(String rua,String numero, String complemento, String bairro, String cidade, String cep, String estado)
	{	this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
	}
}