/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.CadServico;
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
public class ServicoController {
    
    private final CadServico view;

    public ServicoController(CadServico view) {
        this.view = view;
    }
    
    public void salvaServico()
    {
        String descricao = view.getTextServico().getText();
        String valorString =view.getTextValor().getText();
        float valor = Float.parseFloat(valorString);
        
        Servico servicos = new Servico(descricao,valor);
        
        
           try {
               Connection conexao = new ConectaBanco().getConexao();
               ServicoDAO servicoDAO = new ServicoDAO(conexao);
               servicoDAO.insert(servicos);

               JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
              
          } catch (SQLException ex) {
              Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
