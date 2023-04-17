/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Herbert
 */
public class Email implements Comparable<Email>, Serializable
{

    private int codigo;
    private Conta remetente;
    private Set<Conta> destinatarios;
    private String assunto;
    private String corpo;
    //tamanho do email em KB
    private double tamanho;

    public Email() {
    }

    public Email(Conta remetente, Set<Conta> destinatarios, String assunto, String corpo, double tamanho) {
        this.remetente = remetente;
        this.destinatarios = destinatarios;
        this.assunto = assunto;
        this.corpo = corpo;
        this.tamanho = tamanho;
    }

    public Conta getRemetente() {
        return remetente;
    }

    public Set<Conta> getDestinatarios() {
        return destinatarios;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public double getTamanho() {
        return tamanho;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Email other = (Email) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public int compareTo(Email t) {
        
        return this.codigo - t.codigo;
        
    }
    
    
    
}