/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import View.CadUsuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.ConectaBanco;

/**
 *
 * @author victor
 */
public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela() throws ClassNotFoundException, SQLException
   {
       //buscar lista de agendamentos do banco
       AgendamentoDAO agendamentoDAO= new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        //Exibir lista na view
       helper.preencherTabela(agendamentos);
   }
   
    public void atualizaCliente() throws SQLException, ClassNotFoundException
    {
        //buscar cliente do banco de dados 
       ClienteDAO clienteDAO= new ClienteDAO();
      ArrayList<Cliente>clientes = clienteDAO.selectAll();
       //exibir clientes na combobox cliente
          helper.preencherClientes(clientes);
   }
    
    
   public void atualizaServico() throws SQLException, ClassNotFoundException
    {
        ServicoDAO servicoDAO = new ServicoDAO();
       ArrayList<Servico> servicos = servicoDAO.selectAll();
       
      helper.preencherServicos(servicos);
       
   }
   
    public void atualizaValor()
    {
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void atualizaId()
    {
        Cliente cliente = helper.obterCliente();
        helper.setarId(cliente.getId());
    }

    public void agendar() throws SQLException, ClassNotFoundException {
        //Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        
         try {
            Connection conexao = new ConectaBanco().getConexao();
            AgendamentoDAO agendamentoDAO= new AgendamentoDAO(conexao);
              agendamentoDAO.insert(agendamento);
              
              JOptionPane.showMessageDialog(null,"Agendamento cadastrado com sucesso!");
              
          } catch (SQLException ex) {
              Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        //Salva objeto no banco de dados
        atualizaTabela();
        helper.limparTela();
        
        
    }
}