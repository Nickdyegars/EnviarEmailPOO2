/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Herbert
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Pasta implements Serializable
{

    //nome da pasta: "inbox", "entrada", etc.
    private String nome;
    //emails armazenados na pasta
    private ArrayList<Email> emails;
    
    public Pasta(String nome){
        this.nome = nome;
        this.emails = new ArrayList();
    }
    
    public String getNome() {
        return nome;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
    
    
}
