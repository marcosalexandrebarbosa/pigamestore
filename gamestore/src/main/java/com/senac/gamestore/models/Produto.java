/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.gamestore.models;

import java.math.BigDecimal;

/**
 *
 * @author Gabriela Oliveira
 */
public class Produto 
{
    
    private int idProduto;
    private String nomeProduto;
    private int categoria;
    private BigDecimal preco;
    private String fabricante;
    private int estoque;
    private String modelo;
    private String codBarras;
    //private Filial filal;
    
    public Produto()
    {
        
    }
   
    public Produto(String nomeProduto, int categoria,BigDecimal preco, String fabricante, int estoque, String modelo, String codBarras)
    {
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.preco = preco;
        this.fabricante = fabricante;
        this.estoque = estoque;
        this.modelo = modelo;
        this.codBarras = codBarras; 
    }  
    
    
    public int getIdProduto() 
    {
        return idProduto;
    }

    public void setIdProduto(int idProduto) 
    {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() 
    {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) 
    {
        this.nomeProduto = nomeProduto;
    }
    public int getCategoria() 
    {
        return categoria;
    }

    public void setCategoria(int categoria) 
    {
        this.categoria = categoria;
    }
    public BigDecimal getPreco() 
    {
        return preco;
    }

    public void setPreco(BigDecimal preco) 
    {
        this.preco = preco;
    }

    public String getFabricante() 
    {
        return fabricante;
    }

    public void setFabricante(String fabricante) 
    {
        this.fabricante = fabricante;
    }

    public int getEstoque() 
    {
        return estoque;
    }

    public void setEstoque(int quantidade) 
    {
        this.estoque = quantidade;
    }

    public String getModelo() 
    {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    public String getCodBarras() 
    {
        return codBarras;
    }

    public void setCodBarras(String codBarras) 
    {
        this.codBarras = codBarras;
    }
}
