/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.DAO.UsuarioDAO;
import View.CadCliente;
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
public class ClienteController {
    private final CadCliente view;

    public ClienteController(CadCliente view) {
        this.view = view;
    }

    public void salvaCliente() {
       String nome = view.getTextNome().getText();
       String endereco = view.getTextEndereco().getText();
       String telefone = view.getTextTelefone().getText();
       String rg = view.getTextRG().getText();
       
       Cliente clientes = new Cliente(nome,endereco,telefone,rg);
       
           try {
            Connection conexao = new ConectaBanco().getConexao();
            ClienteDAO clienteDAO= new ClienteDAO(conexao);
              clienteDAO.insert(clientes);
              
              JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
              
          } catch (SQLException ex) {
              Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
}
