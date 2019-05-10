/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import View.Agenda;
import View.CadCliente;
import View.CadServico;
import View.MenuPrincipal;
import View.CadUsuario;
import java.sql.SQLException;

/**
 *
 * @author victor
 */
public class MenuPrincipalController {
    private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    public void navegarParaAgenda() throws SQLException, ClassNotFoundException
    {
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }

  public void navegarParaUsuario() {
      CadUsuario usuario = new CadUsuario();
      usuario.setVisible(true);
    }
  
  public void navegarParaCliente()
  {
      CadCliente cliente = new CadCliente();
      cliente.setVisible(true);
  }
  public void navegarParaServico()
  {
      CadServico servico = new CadServico();
      servico.setVisible(true);
  }
   
    
}
