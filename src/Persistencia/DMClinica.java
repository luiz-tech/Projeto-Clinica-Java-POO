package Persistencia;

import Modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMClinica extends DMGeral
{
    String cnpj = null;
         
    //método incluir
    public void incluir(Object obj)
    {   Clinica objC = (Clinica) obj;
        try
        {   Statement statement = getConnection().createStatement();
        //Essa String irá incluir no banco de dados os respectivos valores afim de
        //formar uma linha na tabela Clinica
        String incluirSQL = "INSERT INTO clinicas (" +
                                "cnpj,nome,email,razaoSocial," +
                                "rua,numero,complemento,bairro,cidade,cep,estado," +
                                "ddi,ddd,numerotel,tipo,operadora" +
                                ") VALUES ('" +
                                objC.getCnpj() + "', '" +
                                objC.getNome() + "', '" +
                                objC.getRazaoSocial() + "', '" +
                                objC.getAtRefEndereco().getRua() + "', '" +
                                objC.getAtRefEndereco().getNumero() + "', '" +
                                objC.getAtRefEndereco().getComplemento() + "', '" +
                                objC.getAtRefEndereco().getBairro() + "', '" +
                                objC.getAtRefEndereco().getCidade() + "', '" +
                                objC.getAtRefEndereco().getCep() + "', '" +
                                objC.getAtRefEndereco().getEstado() + "', '" +
                                objC.getAtRefTelefone().getDdi() + "', '" +
                                objC.getAtRefTelefone().getDdd() + "', '" +
                                objC.getAtRefTelefone().getNumero() + "', '" +
                                objC.getAtRefTelefone().getTipo() + "', '" +
                                objC.getAtRefTelefone().getOperadora() + "')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Clínica cadastrada corretamente !","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao cadastrar clínica !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            	objC.setCnpj("");    
            	objC.setNome("");
            	objC.setRazaoSocial("");
            	objC.setAtRefEndereco(null);
            	objC.setAtRefTelefone(null);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclusão da clínica!"); }
    }

    //método consultar
    public Object consultar(Object obj)
    {   
    	Clinica objC = (Clinica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            //Essa String contém os comandos em SQL que faram a busca da chave primária CNPJ
        	String consultarSQL = "SELECT * FROM clinicas WHERE (cnpj = '"+objC.getCnpj()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Clínica existente !" );
                System.out.println("Clínica");
                System.out.println("Cnpj............: "+ result.getString("cnpj"));
                System.out.println("Nome............: "+ result.getString("nome"));
                System.out.println("Razão Social....: "+ result.getString("razaoSocial"));
                result.close();
            }
            else
            {   System.out.println( "Clínica não encontrada !\n" );
                objC = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta da clínica !"); }
        return objC;
    }

    //método buscar
    public Clinica buscar(String cnpj)
    {  
    	Clinica objC = new Clinica();
    	try
        {   Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM clinicas WHERE (cnpj = '"+cnpj+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Clínica existente !" );
                System.out.println("Clínica");
                System.out.println("Cnpj........: "+ result.getString("cnpj"));
                System.out.println("Nome........: "+ result.getString("nome"));
                System.out.println("Razão Social: "+ result.getString("razaoSocial"));
                objC.setCnpj(cnpj);
                objC.setNome(result.getString("nome"));
                JOptionPane.showMessageDialog(null,objC.getNome());
                result.close();
            }
            else
            {   System.out.println( "Clínica não encontrada !\n" );
            objC = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta da clínica !"); }
        return objC;
    }
    
    
    
    //método excluir
    public void excluir(Object obj)
    {   
    	/*Cliente objCliente = (Cliente) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM clientes WHERE (nome = '"+objCliente.getNome()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Cliente excluído corretamente !","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE); }
            else
            {   System.out.println( "\nErro ao excluir cliente !\n" );
                objCliente.setNome("");
            }
           statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de exclusão do cliente !"); }
        */
    }

    //método alterar
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
        { System.out.println("Problemas com o SQL de atualização do cliente !"); }
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