/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conta;
import Modelo.Pasta;
import Modelo.Servidor;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nicke
 */
public class AppTeste 
{
    
    public static void main(String[] args) 
    {
        Set<Conta> listaConta = new HashSet<>();
        Servidor servidor = new Servidor();
        for(int i=0; i<3; i++)
        {
            Conta conta = new Conta("teste@gmail.com"+i,"123");
            listaConta.add(conta);
        }
        servidor.setListaContas(listaConta);
        Empacotamento.gravarArquivoBinario(servidor, "servidor.dat");
        Servidor servidor1 = Empacotamento.lerArquivoBinario("servidor.dat");
        System.out.println(servidor1.getListaContas());
    }
}
