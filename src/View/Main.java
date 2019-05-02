/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Pessoa;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author victor
 */
public class Main {
    
    public static void main(String[] args)
    {
        String nome = "Victor";
        System.out.println(nome);
        
        Servico servico = new Servico(1,"Barba",30);
        
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
        
        Cliente cliente = new Cliente(1,"Victor","Av Shozo Sakai","08743-010");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(1,"Victor","12345678");
        System.out.println(usuario.getNome());
        
       Agendamento agendamento = new Agendamento(1,cliente,servico,30,"12/04/2019 12:35");
        System.out.println(agendamento.getCliente().getNome());
    }
    
}
