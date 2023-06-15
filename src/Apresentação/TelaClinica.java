package Apresentação;

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class TelaClinica extends JFrame
{	
	//atributos
	private JLabel 
	lNome,lEmail,
	lCnpj, lRazaoSocial, 
	lRua, lNumero, lComplemento, lBairro, lCidade, lCep, lEstado,
	lDdi, lDdd, lTel, lTipo, lOperadora,
	lImg;

	
	private JTextField 
	tNome,tEmail, 
	tCnpj, tRazaoSocial, 
	tRua, tNumero, tComplemento, tBairro, tCidade, tCep, tEstado,
	tDdi, tDdd, tTel, tTipo, tOperadora;
	
	private JButton bSalvar, bLimpar, bFechar,bImprimir;
	
	private JPanel pClinica, pEndereco, pTelefone;

	private JList ufs;
	
	//variáveis locais para armazenar o que for digitado
	String cnpj,nome,email,razaosocial,rua,numero,complemento,bairro,cidade,cep,estado,ddi,ddd,tel,tipo,operadora;
	
	//atributos de referência
	Clinica clin;	
	Endereco end;
	Telefone fone;
		
	//método construtor
	public TelaClinica()
	{
		//configurações da janela
		this.setSize(690,550);
		this.setTitle("Cadastro da Clínica");
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null); //centraliza a janela na abertura
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
			
		//criando os panels para estruturar as áreas na tela 
		pClinica = new JPanel();
		pClinica.setSize(660,170);
		pClinica.setLocation(10,10);
		pClinica.setBorder(BorderFactory.createTitledBorder("DADOS DA CLÍNICA:"));
		pClinica.setLayout(null);
		
		pEndereco = new JPanel();
		pEndereco.setSize(660,120);
		pEndereco.setLocation(10,190);
		pEndereco.setBorder(BorderFactory.createTitledBorder("ENDEREÇO COMPLETO:"));
		pEndereco.setLayout(null);
		
		pTelefone = new JPanel();
		pTelefone.setSize(660,90);
		pTelefone.setLocation(10,320);	
		pTelefone.setBorder(BorderFactory.createTitledBorder("TELEFONE DE CONTATO:"));
		pTelefone.setLayout(null);
		
		//adicionando os labels	e text fields
		
		//pessoal
		lCnpj = new JLabel("Número do Cadastro da Clínica (CNPJ): ");
		lCnpj.setSize(260,30);
		lCnpj.setLocation(20,20);
		
		tCnpj = new JTextField();
		tCnpj.setSize(120,20);
		tCnpj.setLocation(245,25);
		
		lNome = new JLabel("Nome do Estabelecimento: ");
		lNome.setSize(170,30);
		lNome.setLocation(20,50);
		
		tNome = new JTextField();
		tNome.setSize(450,20);
		tNome.setLocation(180,55);
		
		lEmail = new JLabel("Email:");
		lEmail.setSize(100,20);
		lEmail.setLocation(20,85);
		
		tEmail = new JTextField();
		tEmail.setSize(290,20);
		tEmail.setLocation(65,85);

		lRazaoSocial = new JLabel("Razão Social:");
		lRazaoSocial.setSize(120,30);
		lRazaoSocial.setLocation(370,20);
		
		tRazaoSocial = new JTextField();
		tRazaoSocial.setSize(170,20);
		tRazaoSocial.setLocation(460,25);
				
		//endereço
		lRua = new JLabel("Logradouro:");
		lRua.setSize(120,30);
		lRua.setLocation(20,20);
		
		tRua = new JTextField();
		tRua.setSize(540,20);
		tRua.setLocation(100,25);
		
		lNumero = new JLabel("Número:");
		lNumero.setSize(120,30);
		lNumero.setLocation(20,50);
		
		tNumero = new JTextField();
		tNumero.setSize(70,20);
		tNumero.setLocation(80,55);
		
		lComplemento = new JLabel("Complemento:");
		lComplemento.setSize(120,30);
		lComplemento.setLocation(160,50);
		
		tComplemento = new JTextField();
		tComplemento.setSize(100,20);
		tComplemento.setLocation(250,55);
		
		lBairro = new JLabel("Bairro:");
		lBairro.setSize(120,30);
		lBairro.setLocation(370,50);
		
		tBairro = new JTextField();
		tBairro.setSize(220,20);
		tBairro.setLocation(420,55);
		
		lCidade = new JLabel("Cidade:");
		lCidade.setSize(120,30);
		lCidade.setLocation(20,80);
		
		tCidade = new JTextField();
		tCidade.setSize(270,20);
		tCidade.setLocation(80,85);
		
		lCep = new JLabel("CEP:");
		lCep.setSize(60,30);
		lCep.setLocation(370,80);
		
		tCep = new JTextField();
		tCep.setSize(70,20);
		tCep.setText("00000-000");
		tCep.setLocation(410,85);
		
		lEstado = new JLabel("Estado:");
		lEstado.setSize(120,30);
		lEstado.setLocation(500,80);
		
		String[] list = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
		JComboBox ufs = new JComboBox (list);
		ufs.setSize(60,20);
		ufs.setLocation(560,85);
		
		
		//telefone
		lDdi = new JLabel("Código Internacional DDI:");
		lDdi.setSize(160,30);
		lDdi.setLocation(20,20);
		
		tDdi = new JTextField();
		tDdi.setSize(30,20);
		tDdi.setText("+55");
		tDdi.setLocation(180,25);
		
		lDdd = new JLabel("Código Local DDD:");
		lDdd.setSize(120,30);
		lDdd.setLocation(250,20);
		
		tDdd = new JTextField();
		tDdd.setSize(30,20);
		tDdd.setText("22");
		tDdd.setLocation(370,25);
		
		lTel = new JLabel("Número:");
		lTel.setSize(80,30);
		lTel.setLocation(435,20);
		
		tTel = new JTextField();
		tTel.setSize(140,20);
		tTel.setLocation(500,25);
		
		lTipo = new JLabel("Tipo do Telefone:");
		lTipo.setSize(100,30);
		lTipo.setLocation(20,50);
		
		tTipo = new JTextField();
		tTipo.setSize(180,20);
		tTipo.setLocation(130,55);
		
		lOperadora = new JLabel("Operadora de Telefonia: ");
		lOperadora.setSize(150,30);
		lOperadora.setLocation(350,50);
				
		tOperadora = new JTextField();
		tOperadora.setSize(140,20);
		tOperadora.setLocation(500,55);

		lImg = new JLabel();
		lImg.setSize(100,100);
		ImageIcon img = new ImageIcon(getClass().getResource("homem.png"));
		lImg.setIcon(img);
		lImg.setLocation(500,80);
		pClinica.add(lImg);
		
		//criando classe interna para funcionar como ouvinte dos eventos de mouse
				class BatSinal extends MouseAdapter {
					public void mouseClicked(MouseEvent e) {
						if (e.getSource() == bSalvar) {
								
							//endereco
							rua = tRua.getText();
							numero = tNumero.getText();
							complemento = tComplemento.getText();
							bairro = tBairro.getText();
							cidade = tCidade.getText();
							cep = tCep.getText();
							estado = ufs.getName(); 
							end = new Endereco(rua,numero,complemento,bairro,cidade,cep,estado); 

							//telefone
							ddi = tDdi.getText();
							ddd = tDdd.getText();
							tel = tTel.getText();
							tipo = tTipo.getText();
							operadora = tOperadora.getText();
							fone = new Telefone(ddi,ddd,tel,tipo,operadora);									
							
							//Aluno
							nome = tNome.getText();
							email = tEmail.getText();
							razaosocial = tRazaoSocial.getText();
							cnpj = tCnpj.getText();
							clin = new Clinica(nome,email,cnpj,razaosocial,end,fone); 
							
							/*JOptionPane.showMessageDialog(null,"Os Dados foram salvos com sucesso !!!");
							String resp = JOptionPane.showInputDialog("Deseja cadstrar outro paciente ? (Y/N)");				
							
							if(resp.equalsIgnoreCase("Y"))
							{	dispose();
								TelaClinica winC = new TelaClinica();
							}
							else if (resp.equalsIgnoreCase("N"))
							{	System.exit(0);	}*/
						}
							
						if (e.getSource() == bLimpar) {
							tNome.setText("");
							tEmail.setText("");
							tCnpj.setText("");
							tRazaoSocial.setText("");
							tRua.setText("");
							tNumero.setText("");
							tComplemento.setText("");
							tBairro.setText("");
							tCidade.setText("");
							tCep.setText("");
							tDdi.setText("");
							tDdd.setText("");
							tTel.setText("");
							tTipo.setText("");
							tOperadora.setText("");
						}
						
						if (e.getSource() == bFechar) {
							dispose();
							//System.exit(0);  
						}
						
						if(e.getSource() == "bImprimir")
						{		JOptionPane.showMessageDialog(null,
								"DADOS PESSOAIS\n "
								+"NOME: "+nome
								+"EMAIL:\n"+email
								+"CNPJ:\n"+cnpj
								+"RAZÃO SOCIAL:\n"+razaosocial
								+"\nENDEEÇO COMPLETO\n"
								+"RUA: "+rua+","
								+"NÚMERO: "+numero+","
								+"COMPLEMENTO: " +complemento+"-"
								+"BAIRRO"+bairro+"-"
								+"CIDADE"+cidade+";"
								+"CEP"+cep+"-"
								+"ESTADO"+estado+"-"
								+"\nTELEFONE DE CONTATO\n"
								+ddi+" ( "+ddd+" )"+tel+"\n"
								+operadora+"-"+tipo);
						}
					}
				}
				
				//adicionando ouvinte para os botões
				BatSinal batman = new BatSinal();
						
				//adicionando os buttons
				bSalvar = new JButton("Salvar");
				bSalvar.setSize(75,30);
				bSalvar.setLocation(70,450);
				bSalvar.setForeground(Color.WHITE);
				bSalvar.setBackground(Color.GREEN);
				bSalvar.addMouseListener(batman);
				
				bLimpar = new JButton("Limpar");
				bLimpar.setSize(75,30);
				bLimpar.setLocation(240,450);
				bLimpar.setForeground(Color.white);
				bLimpar.setBackground(Color.gray);
				bLimpar.addMouseListener(batman);
				
				bImprimir = new JButton("Imprimir");
				bImprimir.setLocation(380, 450);
				bImprimir.setSize(100,30);
				bImprimir.setBackground(Color.blue);
				bImprimir.setForeground(Color.white);
				
				bFechar = new JButton("Fechar");
				bFechar.setSize(75,30);
				bFechar.setLocation(530,450);
				bFechar.setForeground(Color.white);
				bFechar.setBackground(Color.red);
				bFechar.addMouseListener(batman);
				
		//acrescentando os componentes à tela
		this.add(pClinica);
		pClinica.add(lNome);
		pClinica.add(lEmail);
		pClinica.add(lCnpj);
		pClinica.add(lRazaoSocial);	
		pClinica.add(tNome);
		pClinica.add(tEmail);
		pClinica.add(tCnpj);
		pClinica.add(tRazaoSocial);
		
		this.add(pEndereco);
		pEndereco.add(lRua);
		pEndereco.add(lNumero);
		pEndereco.add(lComplemento);
		pEndereco.add(lBairro);
		pEndereco.add(lCidade);
		pEndereco.add(lCep);
		pEndereco.add(lEstado);
		pEndereco.add(tRua);
		pEndereco.add(tNumero);
		pEndereco.add(tComplemento);
		pEndereco.add(tBairro);
		pEndereco.add(tCidade);		
		pEndereco.add(tCep);
		pEndereco.add(ufs);
		
		this.add(pTelefone);
		pTelefone.add(lDdi);
		pTelefone.add(lDdd);
		pTelefone.add(lTel);
		pTelefone.add(lTipo);
		pTelefone.add(lOperadora);
		pTelefone.add(tDdi);
		pTelefone.add(tDdd);
		pTelefone.add(tTel);
		pTelefone.add(tTipo);
		pTelefone.add(tOperadora);
		
		this.add(bSalvar);
		this.add(bLimpar);
		this.add(bFechar);
		this.add(bImprimir);
		this.repaint();					
	}	
}