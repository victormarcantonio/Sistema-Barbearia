/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cliente;
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
        
        Cliente cliente = new Cliente(1,"Victor",'M',"8986-4815","Av shozo Sakai");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(1,"Victor","vitin");
        System.out.println(usuario);
    }
    
}
