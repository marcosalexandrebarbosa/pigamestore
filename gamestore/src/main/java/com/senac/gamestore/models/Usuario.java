/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.gamestore.models;

import java.util.Date;


public class Usuario extends Cliente
{
    public Usuario()
    {
        
    }
     public Usuario(int id, String nome, Date dataNascimento, String cpf, String rg, char sexo, String telefone, String email, String endereco, String senha)
    {
         super(id, nome, dataNascimento, cpf, rg, sexo, telefone,email,endereco,senha);
    }
}

