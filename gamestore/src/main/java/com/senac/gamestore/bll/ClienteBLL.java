
package com.senac.gamestore.bll;

import com.senac.gamestore.daos.ClienteDAO;
import com.senac.gamestore.models.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteBLL 
{
    public static void inserir ( Cliente c) throws Exception
    {
        if(c.getNome().trim().length() == 0)
        {
            throw new Exception("O nome deve ser preenchido!");
        }
        if(c.getDataNascimento().toString().trim().length() == 0)
        {
            throw new Exception("A data de nascimento  deve ser preenchida!");
        }
        if(c.getCpf().trim().length() == 0)
        {
            throw new Exception("O CPF deve ser preenchido!");
        }
        if(c.getRg().trim().length() == 0)
        {
            throw new Exception(" O RG  deve ser preenchido!");
        }
         if(c.getTelefone().trim().length() == 0)
        {
            throw new Exception(" O telefone  deve ser preenchido!");
        }
        if(c.getEmail().trim().length() == 0)
        {
            throw new Exception(" O e-mail deve ser preenchido!");
        }
           if(c.getSexo()!= 'M' && c.getSexo()!= 'F' && c.getSexo()!= 'm' && c.getSexo()!= 'f')
        {
            throw new Exception(" O sexo  deve ser selecionado!");
        }
           
           ClienteDAO.inserir(c);
    }
    
    public static void alterar(Cliente c) throws Exception
    {
        if(c.getNome().trim().length() == 0)
        {
            throw new Exception("O nome deve ser preenchido!");
        }
        if(c.getDataNascimento().toString().trim().length() == 0)
        {
            throw new Exception("A data de nascimento  deve ser preenchida!");
        }
        if(c.getCpf().trim().length() == 0)
        {
            throw new Exception("O CPF deve ser preenchido!");
        }
        if(c.getRg().trim().length() == 0)
        {
            throw new Exception(" O RG  deve ser preenchido!");
        }
         if(c.getTelefone().trim().length() == 0)
        {
            throw new Exception(" O telefone  deve ser preenchido!");
        }
        if(c.getEmail().trim().length() == 0)
        {
            throw new Exception(" O e-mail deve ser preenchido!");
        }
           if(c.getSexo()!= 'M' && c.getSexo()!= 'F' && c.getSexo()!= 'm' && c.getSexo()!= 'f')
        {
            throw new Exception(" O sexo  deve ser selecionado!");
        }
           
           
         ClienteDAO.alterar(c);
    }
    
   public static void excluir(int id)throws Exception
   {
       ClienteDAO.excluir(id);
   }
   
   public static List<Cliente> listar() throws SQLException, ClassNotFoundException
   {
       return ClienteDAO.listar(false);
   }
   
   public static Cliente obterCliente(int id) throws SQLException
   {
       return ClienteDAO.obterCliente(id);
   }
}
