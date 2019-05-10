/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.CadUsuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.ConectaBanco;

/**
 *
 * @author victor
 */
public class UsuarioController {
    private final CadUsuario view;

    public UsuarioController(CadUsuario view) {
        this.view = view;
    }
      public void salvaUsuario()
    {
         
        String usuario = view.getTextNome().getText();
        String senha = view.getTextSenha().getText();
        Usuario usuarios = new Usuario(usuario, senha);
        
        
        
        try {
            Connection conexao = new ConectaBanco().getConexao();
            UsuarioDAO usuarioDAO= new UsuarioDAO(conexao);
              usuarioDAO.insert(usuarios);
              
              JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!");
              
          } catch (SQLException ex) {
              Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
