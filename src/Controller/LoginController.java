/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.Usuario;
import View.Login;

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
    
    public void entrarNoSistema()
    {
      
         //Pegar o um Usuario da View
          Usuario usuario =  helper.obterModelo();
       
        //Pesquisar o Usuario no banco
        //Se o Usuario da view tiver o mesmo usuario e senha do usuario do banco direcionar para o menu
        //Senão mostrar uma mensagem ao usuário "Usuário ou senha inválidos"
    }
    
    public void fizTarefa()
    {
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
}
