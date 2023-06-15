package Modelo;

import javax.swing.JOptionPane;

public abstract class Pessoa
{
	//atributos comuns
	protected String nome;
	protected String email;
	
	//atributos de refer�ncia
	protected Endereco atRefEndereco;
	protected Telefone atRefTelefone;
	
	//m�todos de acesso - atributos comuns
	public String getNome()
	{	return nome;	}
	
	public void setNome(String nome)
	{	this.nome = nome;	}
	
	public String getEmail()
	{	return email;	}
	
	public void setEmail(String email)
	{	this.email = email;	}
	
	//m�todos de acesso - atributos de refer�ncia
	public Endereco getAtRefEndereco()
	{	return atRefEndereco;	}
	
	public void setAtRefEndereco(Endereco atRefEndereco)
	{	this.atRefEndereco = atRefEndereco;	}
	
	public Telefone getAtRefTelefone()
	{	return atRefTelefone;	}
	
	public void setAtRefTelefone(Telefone atRefTelefone)
	{	this.atRefTelefone = atRefTelefone;	}
	
	//m�todo construtor
	public Pessoa()
	{	}
	
	//opera��o
	public void imprimirDados()
	{	JOptionPane.showMessageDialog(null,"ENDERE�O COMPLETO: "
			+"\nRUA: "+atRefEndereco.getRua()
			+", "+atRefEndereco.getNumero()
			+" "+atRefEndereco.getComplemento()
			+" - "+atRefEndereco.getBairro()
			+" - "+atRefEndereco.getCidade()
			+"/"+atRefEndereco.getEstado()
			+" - CEP: "+atRefEndereco.getCep()
			+"\n\nTELEFONE COMPLETO: "
			+"+"+atRefTelefone.getDdi()
			+" ("+atRefTelefone.getDdd()
			+") "+atRefTelefone.getNumero()
			+" - "+atRefTelefone.getTipo()
			+" - "+atRefTelefone.getOperadora()
			+"\n\nDADOS PESSOAIS: "
			+"\nNOME: "+nome
			+"\nEMAIL: "+email);
	}
}