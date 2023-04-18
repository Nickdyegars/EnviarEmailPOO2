/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Excecoes.ContaExistenteException;
import Controle.Excecoes.ContaNaoEncontradaException;
import Controle.Excecoes.SenhaIncorretaException;
import Modelo.Conta;
import Modelo.Servidor;
import Persistencia.Empacotamento;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Herbert
 */
public class ControleServidor {
    
    
    
    public static void logarConta(Servidor servidor, String senha, String enderecoEmail) throws ContaNaoEncontradaException, SenhaIncorretaException{
        
        Conta contaEncontrada = ControleServidor.buscarConta(servidor, enderecoEmail);
        
        if(contaEncontrada == null){
            throw new ContaNaoEncontradaException("Não encontramos uma conta com esse endereço de e-mail");
        }
        
        if(!contaEncontrada.validaSenha(senha)){
            throw new SenhaIncorretaException("Senha incorreta");
        }
        
        servidor.setContaLogada(contaEncontrada);
        Empacotamento.gravarArquivoBinario(servidor, "servidor.dat");
        
    }
    
    public static void deslogarConta(Servidor servidor){
        servidor.setContaLogada(null);
        Empacotamento.gravarArquivoBinario(servidor, "servidor.dat");
    }
    
    public static void cadastrarConta(Servidor servidor, String enderecoEmail, String senha) throws ContaExistenteException{
        
        if(ControleServidor.buscarConta(servidor, enderecoEmail) != null){
            throw new ContaExistenteException("Já existe uma conta com esse endereço de email");
        }
        
        Conta conta = new Conta(enderecoEmail, senha);
        
        servidor.getListaContas().add(conta);
        Empacotamento.gravarArquivoBinario(servidor, "servidor.dat");
        
        
    }
    
    public static Conta buscarConta(Servidor servidor, String enderecoEmail){
        
        Set<Conta> listaContas = servidor.getListaContas();
        
        
        for(Conta conta: listaContas){
            
            if(Objects.equals(conta.getEnderecoEmail(), enderecoEmail)){
                return conta;
            }
            
        }
        
        return null;
        
    }
    
    public static boolean isLogado(Servidor servidor)
    {
        return servidor.getContaLogada() != null;
    }
    
    
}


