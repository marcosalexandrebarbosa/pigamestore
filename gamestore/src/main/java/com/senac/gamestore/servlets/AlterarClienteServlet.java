
package com.senac.gamestore.servlets;

import com.senac.gamestore.bll.ClienteBLL;
import com.senac.gamestore.models.Cliente;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarClienteServlet" , urlPatterns = {"/AlterarClienteServlet"})
public class AlterarClienteServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest  request, HttpServletResponse response)throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        
        boolean manutencao = false;
        
        Cliente c = null;
        List<Cliente> clientes = null;
        
        try 
        {
            c = ClienteBLL.obterCliente(id);
            clientes = ClienteBLL.listar();
            
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        request.setAttribute("cliente", c);
        request.setAttribute("manutencao", manutencao);
        request.setAttribute("clientes", clientes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("cliente.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente c = null;
        List<Cliente> clientes = null;
        
           try
           {
            c = ClienteBLL.obterCliente(id); //Com isso, obtemos novamente o cliente para que seja realizado de fato a alteração de seu cadastro
            
            //É feito o armazenamento dos dados que foram preenchidos no formulário, da mesma forma que foi feito no servlet ClienteServlet
            c.setNome(request.getParameter("nome"));
            
            //Criando um formatador de Data para que seja aceita somente data inserida no padrão utilizado por nós.
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try 
            {
                //Para armazenar a data, foi necessário realizar um parse() pois tudo que é pego pelo método request.getParameter() é uma String.
                c.setDataNascimento(sdf.parse(request.getParameter("dtnascimento")));
            } catch (ParseException ex) 
            {

            }
            
            c.setCpf(request.getParameter("cpf"));
            c.setSexo(request.getParameter("sexo").charAt(0));
            c.setRg(request.getParameter("rg"));
            c.setTelefone(request.getParameter("telefone"));
            c.setEmail(request.getParameter("email"));
            c.setEndereco(request.getParameter("endereco"));
            c.setSenha(request.getParameter("senha"));
            //c.setTipoAcesso(Integer.parseInt(request.getParameter("tipoacesso")));
            
//            Filial f = new Filial();
//            try {
//                f = FilialDAO.obterFilial(Integer.parseInt(request.getParameter("filial")));
//            } catch (SQLException ex) {
//                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            c.setFilial(f);
        
        
            ClienteBLL.alterar(c);
        
            
            
            response.sendRedirect(request.getContextPath() + "/ClienteServlet");
    }catch (Exception e) 
    {
      e.printStackTrace();
    }
   }
}
