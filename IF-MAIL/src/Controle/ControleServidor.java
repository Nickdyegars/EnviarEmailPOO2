/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Controle.Excecoes.ContaExistenteException;
import Controle.Excecoes.ContaNaoEncontradaException;
import Controle.Excecoes.EnderecoInvalidoException;
import Controle.Excecoes.SenhaIncorretaException;
import Modelo.Conta;
import Modelo.Email;
import Modelo.Servidor;
import Persistencia.Empacotamento;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import Controle.ControleConta;

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
    
    public static boolean enviarEmail(Servidor servidor, String[] enderecos_destinatarios, String assunto, String corpo, int codigo) throws EnderecoInvalidoException{
        
        Set<Conta> contas_destinatarios = new HashSet(enderecos_destinatarios.length); // Instancia o objeto ArrayList que irá guardar as contas dos destinarários
        
        for(String endereco: enderecos_destinatarios){
            
            Conta conta = ControleServidor.buscarConta(servidor, endereco); // Busca uma conta com o endereço de email da vez
            
            // Se o retorno do método buscaConta não for vazio, adiciona a conta na lista de destinatários
            if( conta != null){
                
                contas_destinatarios.add(conta);
            }else{
                throw new EnderecoInvalidoException("Erro: O endereço "+ endereco + " é inválido!");
            }
        }
        
        // Definindo o tamanho em KB do email com base na quantidade de letras do assunto + corpo
        double tamanho;
        tamanho = corpo.length()* 8;
        tamanho += assunto.length()* 8;
        tamanho = tamanho/1000;
        
        
        
        Email email = new Email(servidor.getContaLogada(), contas_destinatarios, assunto, corpo, tamanho);
        
        // Registra o email na caixa de saida do remetente ( conta que está logada no momento)
        ControleConta.registraEmailEnviado(servidor.getContaLogada(), email);
        
        // Registra o email na caixa de entrada de todos os destinatários;
        for(Conta c : contas_destinatarios){
            
            ControleConta.registraEmailRecebido(c, email);
            
        }
        
        // Salva o estado do servidor no arquivo servidor.dat
        Empacotamento.gravarArquivoBinario(servidor, "servidor.dat");
     
        return true;
        
    }
}


