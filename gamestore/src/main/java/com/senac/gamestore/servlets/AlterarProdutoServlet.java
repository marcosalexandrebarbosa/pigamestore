/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.gamestore.servlets;

import com.senac.gamestore.bll.ProdutoBLL;
import com.senac.gamestore.models.Produto;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabri
 */
@WebServlet(name = "AlterarProdutoServlet", urlPatterns = {"/AlterarProdutoServlet"})
public class AlterarProdutoServlet extends HttpServlet 
{

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
       int id = Integer.parseInt(request.getParameter("id"));
       
       
       Produto p = null;
       List<Produto> produtos = null;
       
        try 
        {
            p = ProdutoBLL.obterProduto(id);
            produtos = ProdutoBLL.listar("");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        request.setAttribute("produto", p);
        request.setAttribute("produtos", produtos);
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("produtos.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        Produto p = null;
        
        List<Produto> produtos = null;
        
        try 
        {
            p = ProdutoBLL.obterProduto(id);
            
            
            p.setNomeProduto(request.getParameter("nomeProduto"));
            p.setCategoria(Integer.parseInt(request.getParameter("categoria")));
            p.setPreco(BigDecimal.valueOf(Double.parseDouble(request.getParameter("preco"))));
            p.setFabricante(request.getParameter("fabricante"));
            p.setEstoque(Integer.parseInt(request.getParameter("estoque")));
            p.setModelo(request.getParameter("modelo"));
            p.setCodBarras(request.getParameter("codbarras"));
            
//            p.setFilial(FilialDAO.obterFilial(Integer.parseInt(request.getParameter("filial"))));

            ProdutoBLL.alterar(p);
            
            produtos = ProdutoBLL.listar("");
            request.setAttribute("produtos", produtos);

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        response.sendRedirect(request.getContextPath() + "/ProdutoServlet");
        
    }

    
    @Override
    public String getServletInfo() 
    {
        
        return "Short description";
        
    }// </editor-fold>

   
}
