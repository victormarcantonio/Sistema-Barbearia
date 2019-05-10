/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.CadUsuario;
import View.Login;
import View.MenuPrincipal;
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
public class LoginController {

    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view)
    {
        this.view = view;
        this.helper = new LoginHelper(view);
        
    }
    
  
            
    
//    public void entrarNoSistema()
//    {
//      
//         //Pegar o um Usuario da View
//         
//       
//        //Pesquisar o Usuario no banco
////        UsuarioDAO usuarioDAO = new UsuarioDAO();
////       Usuario usuarioAutenticado= usuarioDAO.selectPorNomeESenha(usuario);
//        //Se o Usuario da view tiver o mesmo usuario e senha do usuario do banco direcionar para o menu
//         //Senão mostrar uma mensagem ao usuário "Usuário ou senha inválidos"
////        if(usuarioAutenticado!=null)
////        {
////            MenuPrincipal menu = new MenuPrincipal();
////            menu.setVisible(true);
////            this.view.dispose();
////            //navegar para menu principal
////        }else{
////            view.exibeMensagem("Usuário ou senha inválidos");
////        }
////       
//    }
    
//    public void fizTarefa()
//    {
//        System.out.println("Busquei algo do banco de dados");
//        
//        this.view.exibeMensagem("Executei o fiz tarefa");
//    }

    public void autenticar() throws ClassNotFoundException, SQLException {
           
        Usuario usuario =  helper.obterModelo();
      
        
        Connection conexao = new ConectaBanco().getConexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDAO.existePorUsuarioESenha(usuario);
        
        //Se existir direciona para menu
        if(existe)
        {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            JOptionPane.showMessageDialog(view,"Usuário ou senha inválidos");
        }
            
    }
}
