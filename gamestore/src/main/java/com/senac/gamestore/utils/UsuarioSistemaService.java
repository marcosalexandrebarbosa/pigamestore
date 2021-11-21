
package com.senac.gamestore.utils;

import com.senac.gamestore.daos.ClienteDAO;
import com.senac.gamestore.models.Cliente;
import java.sql.SQLException;

public class UsuarioSistemaService 
{
    public Cliente buscaPorEmail(String email) throws SQLException
    {
        return ClienteDAO.buscaPorEmail(email);
        
    }
}
