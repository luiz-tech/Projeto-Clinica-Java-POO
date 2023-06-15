package Apresentação;

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

@SuppressWarnings("serial")
public class TelaPaciente extends JFrame
{	
	//atributos
	private JLabel 
	lNome,lEmail, 
	lCpf,lDataNascimento,lPeso,lAltura,lIdade,
	lRua, lNumero, lComplemento, lBairro, lCidade, lCep, lEstado, 
	lDdi, lDdd, lTel, lTipo, lOperadora,
	lImc,
	lImg;
	
	private JTextField 
	tNome,tEmail, 
	tCpf,tDataNascimento,tPeso,tAltura,tIdade,
	tRua, tNumero, tComplemento, tBairro, tCidade, tCep, tEstado,
	tDdi, tDdd, tTel, tTipo, tOperadora,
	tImc;
	
	private JButton bSalvar, bLimpar, bFechar, bCalcularIMC,bImprimir;
	
	private JPanel pPaciente, pEndereco, pTelefone;
	
	private JList ufs;

	//variáveis locais para armazenar o que for digitado
	String nome,email,
	cpf,dtNascimento,
	rua,numero,complemento,bairro,cidade,cep,estado,
	ddi,ddd,tel,tipo,operadora,
	imc;
	int idade;
	float peso,altura;
	
	//atributos de referência
	Paciente paciente;	
	Endereco end;
	Telefone fone;
	
	//método construtor
	public TelaPaciente()
	{
		//configurações da janela
		this.setSize(690,600);
		this.setTitle("Ficha do Paciente");
		this.setResizable(true);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null); //centraliza a janela na abertura
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		//criando os panels para estruturar as áreas na tela 
		pPaciente = new JPanel();
		pPaciente.setSize(660,220);
		pPaciente.setLocation(10,10);
		pPaciente.setBorder(BorderFactory.createTitledBorder("DADOS DO PACIENTE:"));
		pPaciente.setLayout(null);
		
		pEndereco = new JPanel();
		pEndereco.setSize(660,120);
		pEndereco.setLocation(10,230);
		pEndereco.setBorder(BorderFactory.createTitledBorder("ENDEREÇO COMPLETO:"));
		pEndereco.setLayout(null);
		
		pTelefone = new JPanel();
		pTelefone.setSize(660,90);
		pTelefone.setLocation(10,370);	
		pTelefone.setBorder(BorderFactory.createTitledBorder("TELEFONE DE CONTATO:"));
		pTelefone.setLayout(null);
		
		//adicionando os labels	e text fields
		
		//Paciente
		lEmail = new JLabel("Email:");
		lEmail.setSize(120,30);
		lEmail.setLocation(20,50);
		
		tEmail = new JTextField();
		tEmail.setSize(250,20);
		tEmail.setLocation(70,55);
				
		lNome = new JLabel("Nome Completo: ");
		lNome.setSize(120,30);
		lNome.setLocation(20,20);
		
		tNome = new JTextField();
		tNome.setSize(510,20);
		tNome.setLocation(120,25);
	
		lCpf = new JLabel("CPF:");
		lCpf.setSize(140,20);
		lCpf.setLocation(20,80);
		
		tCpf = new JTextField();
		tCpf.setSize(110,20);
		tCpf.setLocation(70,80);
		
		lDataNascimento = new JLabel("Data de Nascimento:");
		lDataNascimento.setSize(120,20);
		lDataNascimento.setLocation(330,55);
		
		tDataNascimento = new JTextField("dd/mm/aaaa");
		tDataNascimento.setSize(100,20);
		tDataNascimento.setLocation(460,55);
		
		lPeso = new JLabel("Peso em Kg:");
		lPeso.setSize(120,20);
		lPeso.setLocation(20,110);
		
		tPeso = new JTextField();
		tPeso.setSize(70,20);
		tPeso.setLocation(100,110);
		
		lAltura = new JLabel("Altura em m:");
		lAltura.setSize(100,20);
		lAltura.setLocation(20,140);
		
		tAltura = new JTextField();
		tAltura.setSize(70,20);
		tAltura.setLocation(100,140);
		
		lIdade = new JLabel("Idade:");
		lIdade.setSize(100,20);
		lIdade.setLocation(220,80);
		
		tIdade = new JTextField();
		tIdade.setSize(100,20);
		tIdade.setLocation(270,80);
		
		lImc = new JLabel("IMC:");
		lImc.setSize(90,20);
		lImc.setLocation(20,170);
		
		tImc = new JTextField();
		tImc.setSize(110,20);
		tImc.setLocation(60,170);
		tImc.setEditable(false);
		
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
		
		lBairro = new JLabel("Bairro: ");
		lBairro.setSize(120,30);
		lBairro.setLocation(370,50);
		
		tBairro = new JTextField();
		tBairro.setSize(220,20);
		tBairro.setLocation(420,55);
		
		lCidade = new JLabel("Cidade: ");
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
		
		lTel = new JLabel("Número: ");
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
		pPaciente.add(lImg);

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
					cpf = tCpf.getText();
					dtNascimento = tDataNascimento.getText();
					peso = Float.parseFloat(tPeso.getText());
					altura = Float.parseFloat(tAltura.getText());
					idade = Integer.parseInt(tIdade.getText());
					paciente = new Paciente(nome,email,cpf,dtNascimento,peso,altura,(int) idade,end,fone);
					
					/*JOptionPane.showMessageDialog(null,"Os Dados foram salvos com sucesso !!!");
					String resp = JOptionPane.showInputDialog("Deseja cadstrar outro paciente ? (Y/N");				
					
					if(resp.equalsIgnoreCase("Y"))
					{	dispose();
						TelaPaciente winP = new TelaPaciente();
					}
					else if (resp.equalsIgnoreCase("N"))
					{	System.exit(0);	}*/
				}
					
				if (e.getSource() == bLimpar) {
					tNome.setText("");
					tEmail.setText("");
					tCpf.setText("");
					tDataNascimento.setText("");
					tPeso.setText("");
					tAltura.setText("");
					tIdade.setText("");
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
					tImc.setText("");
				}
				
				if(e.getSource() == bCalcularIMC)
				{
					double imc;
					
					peso = Float.parseFloat(tPeso.getText());
					altura = Float.parseFloat(tAltura.getText());
					
					if(tAltura.getText().equals("") || tPeso.getText().equals(""))
					JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento do Peso e Altura !!!","AVISO",JOptionPane.WARNING_MESSAGE);
						
					float peso1 = peso;
					float altura1 = altura;
					
					imc = peso1/Math.pow(altura1, 2);
					DecimalFormat df = new DecimalFormat();
					
					tImc.setText(String.valueOf(df.format(imc)));
				}
				
				if (e.getSource() == bFechar) {
					dispose();
					//System.exit(0);  
				}
				
				if(e.getSource() == bImprimir)
				{}
			}
		}
		
		//adicionando ouvinte para os botões
		BatSinal batman = new BatSinal();
				
		//adicionando os buttons
		bSalvar = new JButton("Salvar");
		bSalvar.setSize(75,30);
		bSalvar.setLocation(70,480);
		bSalvar.setForeground(Color.WHITE);
		bSalvar.setBackground(Color.GREEN);
		bSalvar.addMouseListener(batman);
		
		bCalcularIMC = new JButton("Calcular");
		bCalcularIMC.setSize(95,30);
		bCalcularIMC.setLocation(200,170);
		bCalcularIMC.setForeground(Color.WHITE);
		bCalcularIMC.setBackground(Color.blue);
		bCalcularIMC.addMouseListener(batman);
		
		bLimpar = new JButton("Limpar");
		bLimpar.setSize(75,30);
		bLimpar.setLocation(350,480);
		bLimpar.setForeground(Color.white);
		bLimpar.setBackground(Color.gray);
		bLimpar.addMouseListener(batman);
		
		bFechar = new JButton("Fechar");
		bFechar.setSize(75,30);
		bFechar.setLocation(530,480);
		bFechar.setForeground(Color.white);
		bFechar.setBackground(Color.red);
		bFechar.addMouseListener(batman);

		bImprimir = new JButton("Imprimir");
		bImprimir.setSize(90,30);
		bImprimir.setLocation(210,480);
		bImprimir.setForeground(Color.white);
		bImprimir.setBackground(Color.orange);
		bImprimir.addMouseListener(batman);
		
		//acrescentando os componentes à tela;
		this.add(pPaciente);
		pPaciente.add(lNome);
		pPaciente.add(lEmail);	
		pPaciente.add(lCpf);
		pPaciente.add(lDataNascimento);
		pPaciente.add(lPeso);
		pPaciente.add(lAltura);
		pPaciente.add(lIdade);
		pPaciente.add(lImc);
		pPaciente.add(tNome);
		pPaciente.add(tEmail);
		pPaciente.add(tCpf);
		pPaciente.add(tDataNascimento);
		pPaciente.add(tPeso);
		pPaciente.add(tAltura);
		pPaciente.add(tIdade);
		pPaciente.add(tImc);
		pPaciente.add(bCalcularIMC);
		
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