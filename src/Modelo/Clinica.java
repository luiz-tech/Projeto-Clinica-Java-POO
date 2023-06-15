package Modelo;

import javax.swing.JOptionPane;

import Persistencia.DMClinica;

public class Clinica extends Pessoa
{
	//atributos comuns
	private String cnpj;
	private String razaoSocial;
	
	//atributo de refer�ncia para conex�o
	private DMClinica dmClinica;
	
	//m�todos de acesso
	public String getCnpj()
	{	return cnpj;	}
	
	public void setCnpj(String cnpj)
	{	this.cnpj = cnpj;	}
	
	public String getRazaoSocial()
	{	return razaoSocial;	}
	
	public void setRazaoSocial(String razaoSocial)
	{	this.razaoSocial = razaoSocial;	}
	
	//m�toso construtor 
	public Clinica()
	{	}
	
	//m�todo cosntrutor
	public Clinica(String nome,String email, String cnpj, String razaoSocial, Endereco objE, Telefone objT)
	{ 	this.nome = nome;
		this.email = email;
		this.cnpj = cnpj;		
		this.razaoSocial = razaoSocial;
		this.atRefEndereco = objE;
		this.atRefTelefone = objT;
		dmClinica = new DMClinica();
	   	dmClinica.conectaDataBase("agenda","root","root");//Fazer a Conexao com o BD
	   	System.out.println("Conex�o feita � tabela Pjuridicas com sucesso!");
	   	//incluir(this);
	   	//this.imprimir;
	}
	
	//opera��o
	public void imprimirDados()
	{	super.imprimirDados();
		JOptionPane.showMessageDialog(null,"CNPJ: "+cnpj
				+"\nRAZ�O SOCIAL: "+razaoSocial);
	}
}