package Apresentação;

import javax.swing.JOptionPane;

public class Teste 
{

	public static void main(String[] args) 
	{
		String resposta = JOptionPane.showInputDialog("Paciente ou Clínica (P/C)");
		if(resposta.equalsIgnoreCase("P"))
		{	TelaPaciente winP = new TelaPaciente();	}
		
		else if(resposta.equalsIgnoreCase("C"))
		{	TelaClinica winC = new TelaClinica();	}
		else 
			JOptionPane.showInputDialog("Entrada Inválida","AVISO");

	}

}
