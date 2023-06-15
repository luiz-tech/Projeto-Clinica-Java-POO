package Persistencia;

import Modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMPaciente extends DMGeral
{
    String cpf = null; //anuilando a vari�vel cpf
    
    //m�todo incluir
    public void incluir(Object obj)
    {   Paciente objP = (Paciente) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String incluirSQL = "INSERT INTO pacientes (" +
                                "cpf,nome,email,dataNascimento," +
                                "rua,numero,complemento,bairro,cidade,cep,estado," +
                                "ddi,ddd,numerotel,tipo,operadora" +
                                ") VALUES ('" +
                                objP.getCpf() + "', '" +
                                objP.getNome() + "', '" +
                                objP.getDataNascimento() + "', '" +
                                objP.getEmail() + "', '" +
                                objP.getAtRefEndereco().getRua() + "', '" +
                                objP.getAtRefEndereco().getNumero() + "', '" +
                                objP.getAtRefEndereco().getComplemento() + "', '" +
                                objP.getAtRefEndereco().getBairro() + "', '" +
                                objP.getAtRefEndereco().getCidade() + "', '" +
                                objP.getAtRefEndereco().getCep() + "', '" +
                                objP.getAtRefEndereco().getEstado() + "', '" +
                                objP.getAtRefTelefone().getDdi() + "', '" +
                                objP.getAtRefTelefone().getDdd() + "', '" +
                                objP.getAtRefTelefone().getNumero() + "', '" +
                                objP.getAtRefTelefone().getTipo() + "', '" +
                                objP.getAtRefTelefone().getOperadora() + "')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Paciente cadastrado(a) corretamente !","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao cadastrar paciente !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            	objP.setCpf("");    
            	objP.setNome("");
            	objP.setDataNascimento("");
            	objP.setAtRefEndereco(null);
            	objP.setAtRefTelefone(null);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclus�o do paciente!"); }
    }

    //m�todo consultar
    public Object consultar(Object obj)
    {   
    	Paciente objP = (Paciente) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM pacientes WHERE (cpf = '"+objP.getCpf()+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Paciente j� existente !" );
                System.out.println("Paciente");
                System.out.println("Cpf.............: "+ result.getString("cpf"));
                System.out.println("Nome...............: "+ result.getString("nome"));
                System.out.println("Email..............:"+result.getString("email"));
                System.out.println("Data de Nascimento.: "+ result.getString("dataNascimento"));
                result.close();
            }
            else
            {   System.out.println( "Paciente n�o encontrado !\n" );
                objP = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta de Paciente !"); }
        return objP;
    }

    //m�todo buscar
    public Paciente buscar(String cpf)
    {   
    	Paciente objP = new Paciente();
    	try
        {   Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM pacientes WHERE (cpf = '"+cpf+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Paciente existente !" );
                System.out.println("Paciente");
                System.out.println("Cpf.............: "+ result.getString("cpf"));
                System.out.println("Nome...............: "+ result.getString("nome"));
                System.out.println("Email..............:"+result.getString("email"));
                System.out.println("Data de Nascimento.: "+ result.getString("dataNascimento"));
                objP.setCpf(cpf);
                objP.setNome(result.getString("nome"));
                //objP.setDataNascimento(result.getString("dataNascimento"));
                //objP.setAtRefEndereco((Endereco)result.getObject("atRefEndereco"));
               //objP.setAtRefTelefone((Telefone)result.getObject("atRefTelefone"));
                JOptionPane.showMessageDialog(null,objP.getNome());
                result.close();
            }
            else
            {   System.out.println( "Paciente n�o encontrada !\n" );
                objP = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta de Paciente !"); }
        return objP;
    }
    
    //m�todo excluir
    public void excluir(Object obj)
    {   
    	/*Cliente objCliente = (Cliente) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM clientes WHERE (nome = '"+objCliente.getNome()+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Cliente exclu�do corretamente !","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE); }
            else
            {   System.out.println( "\nErro ao excluir cliente !\n" );
                objCliente.setNome("");
            }
           statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de exclus�o do cliente !"); }
        */
    }

    //m�todo alterar
    public void alterar(Object obj)
    {   /*
    	Cliente objCliente = (Cliente) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String alterarSQL = "UPDATE clientes SET sexo = '"+objCliente.getSexo()+"' ,"+
                                "tipo = '"+objCliente.getTipo()+"' ,"+
                                "dtnasc = '"+objCliente.getDtNascimento()+"'"+
                                "email = '"+objCliente.getEmail()+"'"+
                                "WHERE (nome = '"+objCliente.getNome()+"')";
            int result = statement.executeUpdate(alterarSQL);
            if (result == 1)
            { System.out.println( "Cliente alterado corretamente !"); }
            else
            {   System.out.println( "\nErro ao alterar cliente !\n" );
                objCliente.setNome("");
            }
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de atualiza��o do cliente !"); }
        */
    }

    public void shutDown()
    {   try
        { getConnection().close(); }
        catch (SQLException sqlex)
        {   System.err.println("Problemas ao desconectar !");
            sqlex.printStackTrace();
        }
    }
}