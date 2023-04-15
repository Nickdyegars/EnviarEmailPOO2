/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controle.Excecoes.EspacoInsuficienteException;

/**
 *
 * @author Herbert
 */
public class Conta {

    //exemplo de endereco de email: ana@gmail.com
    private String enderecoEmail;
    //armazena os emails recebidos
    private Pasta caixaEntrada;
    //armazena os emails enviados
    private Pasta caixaSaida;
    //espaco em GB da conta email
    private double capacidadeTotalEmGB;

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public Pasta getCaixaEntrada() {
        return caixaEntrada;
    }

    public Pasta getCaixaSaida() {
        return caixaSaida;
    }

    public double getCapacidadeTotalEmGB() {
        return capacidadeTotalEmGB;
    }
    
    public int getTotalEmails(){
          
        return this.caixaEntrada.getEmails().size() + this.caixaSaida.getEmails().size();
        
    }
    
    public double getEspacoDisponivel() throws EspacoInsuficienteException{
        
        Double espacoOcupado = 0.0;
        
        for(Email e : this.caixaEntrada.getEmails()){
            espacoOcupado += e.getTamanho();
        }
        
        for(Email e : this.caixaSaida.getEmails()){
            espacoOcupado += e.getTamanho();
        }
        
        Double espacoRestante = this.capacidadeTotalEmGB - espacoOcupado;
        
        if(espacoRestante <= 0){
            throw new EspacoInsuficienteException("Sua conta esgotou a capacidade total em GB");
        }
        
        return espacoRestante;
        
    }
    

    
    
    
}