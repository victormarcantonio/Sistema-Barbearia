/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConectaBanco;

/**
 *
 * @author tiago
 */
public class AgendamentoDAO {
    
    
    
   private Connection connection;

    public AgendamentoDAO(Connection connection) {
        this.connection = connection;
    }

    public AgendamentoDAO() {
    }

   
    /**
     * Insere um agendamento dentro do banco de dados
     * @param  exige que seja passado um objeto do tipo agendamento
     */
    public void insert(Agendamento agendamento) throws SQLException{
          
        String sql = "insert into agendamento(id_cliente,id_servico,valor,data,observacao)values('" + agendamento.getCliente().getId() + "','" + agendamento.getServico().getId() + "','" + agendamento.getValor() + "','" + agendamento.getData() + "','" + agendamento.getObservacao() + "')";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        connection.close();
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param agendamento
     * @return 
     */
    public boolean update(Agendamento agendamento){
        
        for (int i = 0; i < Banco.agendamento.size(); i++) {
            if(idSaoIguais(Banco.agendamento.get(i),agendamento)){
                Banco.agendamento.set(i, agendamento);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param agendamento
     * @return 
     */
    public boolean delete(Agendamento agendamento){
        for (Agendamento agendamentoLista : Banco.agendamento) {
            if(idSaoIguais(agendamentoLista,agendamento)){
                Banco.agendamento.remove(agendamentoLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Agendamento> selectAll() throws ClassNotFoundException, SQLException{
         
        Connection connection = ConectaBanco.getConexao();
        String sql = "select a.id,c.nome,s.descricao,a.valor,a.data,a.observacao from agendamento a , cliente c, servico s where a.id_cliente =c.id and a.id_servico=s.id ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
       
          
     while(rs.next())
     {
        Agendamento agendamento = new Agendamento();
         agendamento.setId(rs.getInt("id"));
         
         Cliente cliente = new Cliente();
         cliente.setId(rs.getInt("id"));
         cliente.setNome(rs.getString("nome"));
         agendamento.setCliente(cliente);
         
         Servico servico = new Servico();
         servico.setId(rs.getInt("id"));
         servico.setDescricao(rs.getString("descricao"));
         agendamento.setServico(servico);
         
         agendamento.setValor(rs.getFloat("valor"));
         agendamento.setData(rs.getTimestamp("data"));
         agendamento.setObservacao(rs.getString("observacao"));
       
         agendamentos.add(agendamento);
         
     }
     return agendamentos;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param agendamento
     * @param agendamentoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Agendamento agendamento, Agendamento agendamentoAComparar) {
        return agendamento.getId() ==  agendamentoAComparar.getId();
    }
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Agendamento agendamento : Banco.agendamento) {           
           int id = agendamento.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
            
        }
        
        return maiorId + 1;
    }
    
}
