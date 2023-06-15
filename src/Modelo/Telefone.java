package Modelo;

import javax.swing.JOptionPane;

public class Telefone
{
	//atributos comuns
	private String ddi;
	private String ddd;
	private String numero;
	private String tipo;
	private String operadora;
	
	//métodos de acesso
	public String getDdi()
	{	return ddi;	}
	
	public void setDdi(String ddi)
	{	this.ddi = ddi;	}
	
	public String getDdd()
	{	return ddd;	}
	
	public void setDdd(String ddd)
	{	this.ddd = ddd;	}
	
	public String getNumero()
	{	return numero;	}
	
	public void setNumero(String numero)
	{	this.numero = numero;	}
	
	public String getTipo()
	{	return tipo;	}
	
	public void setTipo(String tipo)
	{	this.tipo = tipo;	}
	
	public String getOperadora()
	{	return operadora;	}
	
	public void setOperadora(String operadora)
	{	this.operadora = operadora;	}
	
	//método construtor c/ parâmetros
	public Telefone(String ddi, String ddd, String tel, String tipo, String operadora)
	{	this.ddi = ddi;
		this.ddd = ddd;
		this.numero = tel;
		this.tipo = tipo;
		this.operadora = operadora;
	}
}