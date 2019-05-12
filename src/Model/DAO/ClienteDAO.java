/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import java.awt.List;
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
public class ClienteDAO {
    
    
   private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public ClienteDAO() {
    }
        
    public void insert(Cliente cliente) throws SQLException, ClassNotFoundException{
           
          
       String sql="insert into cliente(nome,endereco,telefone,rg) values('"+cliente.getNome()+"','"+cliente.getEndereco()+"','"+cliente.getTelefone()+"','"+cliente.getRg()+"');";
            
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.execute();
       connection.close();
       
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param cliente
     * @return 
     */
    public boolean update(Cliente cliente){
        
        for (int i = 0; i < Banco.cliente.size(); i++) {
            if(idSaoIguais(Banco.cliente.get(i),cliente)){
                Banco.cliente.set(i, cliente);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do cliente passado
     * @param cliente
     * @return 
     */
    public boolean delete(Cliente cliente){
        for (Cliente clienteLista : Banco.cliente) {
            if(idSaoIguais(clienteLista,cliente)){
                Banco.cliente.remove(clienteLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os clientes do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Cliente> selectAll() throws SQLException, ClassNotFoundException{
        
         Connection connection = ConectaBanco.getConexao();
        String sql = "select id, nome from cliente";
      PreparedStatement statement = connection.prepareStatement(sql);
       ResultSet rs = statement.executeQuery();
       ArrayList<Cliente>clientes = new ArrayList<Cliente>();
      
     while(rs.next())
     {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
         cliente.setNome(rs.getString("nome"));
         clientes.add(cliente);
         
     }
     return clientes;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param cliente
     * @param clienteAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Cliente cliente, Cliente clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }
    
    
    
}
