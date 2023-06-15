package Persistencia;

import Modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMClinica extends DMGeral
{
    String cnpj = null;
         
    //m�todo incluir
    public void incluir(Object obj)
    {   Clinica objC = (Clinica) obj;
        try
        {   Statement statement = getConnection().createStatement();
        //Essa String ir� incluir no banco de dados os respectivos valores afim de
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
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Cl�nica cadastrada corretamente !","Mensagem de Informa��o",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao cadastrar cl�nica !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            	objC.setCnpj("");    
            	objC.setNome("");
            	objC.setRazaoSocial("");
            	objC.setAtRefEndereco(null);
            	objC.setAtRefTelefone(null);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclus�o da cl�nica!"); }
    }

    //m�todo consultar
    public Object consultar(Object obj)
    {   
    	Clinica objC = (Clinica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            //Essa String cont�m os comandos em SQL que faram a busca da chave prim�ria CNPJ
        	String consultarSQL = "SELECT * FROM clinicas WHERE (cnpj = '"+objC.getCnpj()+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Cl�nica existente !" );
                System.out.println("Cl�nica");
                System.out.println("Cnpj............: "+ result.getString("cnpj"));
                System.out.println("Nome............: "+ result.getString("nome"));
                System.out.println("Raz�o Social....: "+ result.getString("razaoSocial"));
                result.close();
            }
            else
            {   System.out.println( "Cl�nica n�o encontrada !\n" );
                objC = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta da cl�nica !"); }
        return objC;
    }

    //m�todo buscar
    public Clinica buscar(String cnpj)
    {  
    	Clinica objC = new Clinica();
    	try
        {   Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM clinicas WHERE (cnpj = '"+cnpj+"')";
            System.out.println("Enviando c�digo SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Cl�nica existente !" );
                System.out.println("Cl�nica");
                System.out.println("Cnpj........: "+ result.getString("cnpj"));
                System.out.println("Nome........: "+ result.getString("nome"));
                System.out.println("Raz�o Social: "+ result.getString("razaoSocial"));
                objC.setCnpj(cnpj);
                objC.setNome(result.getString("nome"));
                JOptionPane.showMessageDialog(null,objC.getNome());
                result.close();
            }
            else
            {   System.out.println( "Cl�nica n�o encontrada !\n" );
            objC = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta da cl�nica !"); }
        return objC;
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