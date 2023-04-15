/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Conta;
import Modelo.Email;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author Herbert
 */
public class ControleConta {

    public ControleConta() {
    }
    
    public static List<Email> getEmailsRecebidosPorTamanho(Conta conta,double tamanho){
        
        List<Email> emailsEncontrados = new ArrayList();
        
        for(Email e : conta.getCaixaEntrada().getEmails()){
            
            if(e.getTamanho() >= tamanho){
                emailsEncontrados.add(e);
            }
        }
         return emailsEncontrados;  
    }
    
    public List<Email> getEmailsPorEnderecoEmailDestinatario(String destinatario){
        
        List<Email> emailsEncontrados = new ArrayList();
        
        List<Email> todosEmails = new ArrayList();
        
        todosEmails.addAll(this.caixaEntrada.getEmails());
        todosEmails.addAll(this.caixaSaida.getEmails());
        
        for(Email e : todosEmails){
            
            for(ContaEmail conta : e.getDestinatarios()){
                
                if(Objects.equals(conta.enderecoEmail,destinatario)){
                    
                    emailsEncontrados.add(e);
                    
                }
            }
            
        }
        
        Collections.sort(emailsEncontrados, new ComparadorEmailPorTamanho());
        return emailsEncontrados;
    }
    
    public String getEnderecoEmailDestinatarios(){
        
        List<String> destinatarios = new ArrayList();
        
        for(Email email : this.caixaSaida.getEmails()){
            
            for(ContaEmail conta: email.getDestinatarios()){

                if(!destinatarios.contains(conta.getEnderecoEmail())){
                    destinatarios.add(conta.getEnderecoEmail());
                }
            }
        }
        
        Collections.sort(destinatarios);
        
        String stringDestinatarios ="";
        
        for(String s: destinatarios){
            stringDestinatarios += s +"\n";
        }
        
        
        return stringDestinatarios;
        
    }
}
