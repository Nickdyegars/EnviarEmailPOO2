/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Comparador.ComparadorEmailPorTamanho;
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
    
    public static List<Email> getEmailsPorEnderecoEmailDestinatario(Conta conta, String destinatario){
        
        List<Email> emailsEncontrados = new ArrayList();
        
        List<Email> todosEmails = new ArrayList();
        
        todosEmails.addAll(conta.getCaixaEntrada().getEmails());
        todosEmails.addAll(conta.getCaixaSaida().getEmails());
        
        for(Email e : todosEmails){
            
            for(Conta contaA : e.getDestinatarios()){
                
                if(Objects.equals(contaA.getEnderecoEmail(),destinatario)){
                    
                    emailsEncontrados.add(e);
                    
                }
            }
            
        }
        
        Collections.sort(emailsEncontrados, new ComparadorEmailPorTamanho());
        return emailsEncontrados;
    }
    
    public static String getEnderecoEmailDestinatarios(Conta conta){
        
        List<String> destinatarios = new ArrayList();
        
        for(Email email : conta.getCaixaSaida().getEmails()){
            
            for(Conta contaA: email.getDestinatarios()){

                if(!destinatarios.contains(contaA.getEnderecoEmail())){
                    destinatarios.add(contaA.getEnderecoEmail());
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
    
    // Falta verificar tamanho disponível
    public static void registraEmailEnviado(Conta conta, Email email){
        
        
        conta.getCaixaSaida().getEmails().add(email);
        
        
    }
    
    // Falta verificar tamanho disponível
    public static void registraEmailRecebido(Conta conta, Email email){
        
        
        conta.getCaixaEntrada().getEmails().add(email);
        
        
    }
}
