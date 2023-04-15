/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Herbert
 */
public class Servidor {
    
    private Set<Conta> listaContas = new HashSet();
    private Conta contaLogada;
    
    public Servidor(){
        
    }

    public Set<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(Set<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public Conta getContaLogada() {
        return contaLogada;
    }

    public void setContaLogada(Conta contaLogada) {
        this.contaLogada = contaLogada;
    }
    
    
}
