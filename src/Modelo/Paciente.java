package Modelo;

import javax.swing.JOptionPane;
import Persistencia.DMPaciente;

public class Paciente extends Pessoa
{
	//atributos comuns
	private String cpf;
	private String dataNascimento;
	private float peso;
	private float altura;
	private int idade;
	
	//atributo de referência para conexão com banco de dados
	private DMPaciente dmPaciente;
	
	//métodos de acesso
	public String getCpf()
	{	return cpf;	}
	
	public void setCpf(String cpf)
	{	this.cpf = cpf;	}
	
	public String getDataNascimento()
	{	return dataNascimento;	}
	
	public void setDataNascimento(String dataNascimento)
	{	this.dataNascimento = dataNascimento;	}
	
	public float getPeso()
	{	return peso;	}
	
	public void setPeso(float peso)
	{	this.peso = peso;	}
	
	public float getAltura()
	{	return altura;	}
	
	public void setAltura(float altura)
	{	this.altura = altura;	}
	
	public int getIdade()
	{	return idade;	}
	
	public void setIdade(int idade)
	{	this.idade = idade;	}
	
	//método construtor 
	public Paciente()
	{	}
	
	//método construtor
	public Paciente(String nome, String email,String cpf,String dataNascimento, float peso, float altura, int idade, Endereco objE, Telefone objT)
	{
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;	
		this.atRefEndereco = objE;
		this.atRefTelefone = objT;
		dmPaciente = new DMPaciente();
	   	dmPaciente.conectaDataBase("agenda","root","root");//Fazer a Conexao com o BD
	   	System.out.println("Conexão feita à tabela pacientes com sucesso!");
	    //incluir(this);
	    //this.imprimir();
	}
	
	//operações
	public double calcularIMC()
	{	return peso/Math.pow(altura,2);	}
	
	public void imprimirDados()
	{	super.imprimirDados();
		JOptionPane.showMessageDialog(null,"CPF: "+cpf
				+"\nDATA DE NASCIMENTO: "+dataNascimento
				+"\nPESO: "+peso
				+"\nALTURA: "+altura
				+"\nIDADE: "+idade);
		
		double imc = calcularIMC();
		
		if(imc<=18.5)
		{	JOptionPane.showMessageDialog(null,"Paciente está abaixo do peso! IMC = "+imc);	}
		else if(imc>18.5 && imc<=24.9)
		{	JOptionPane.showMessageDialog(null,"Paciente está com peso normal! IMC = "+imc);	}
		else if(imc>=25 && imc<=29.9)
		{	JOptionPane.showMessageDialog(null,"Paciente está com sobrepeso! IMC = "+imc);	}
		else if(imc>=30 && imc<=34.9)
		{	JOptionPane.showMessageDialog(null,"Paciente está com obesidade grau I! IMC = "+imc);	}
		else if(imc>=35 && imc<=39.9)
		{	JOptionPane.showMessageDialog(null,"Paciente está com obesidade grau II! IMC = "+imc);	}
		else
		{	JOptionPane.showMessageDialog(null,"Paciente está com obesidade grau III! IMC = "+imc);	}
	}
}