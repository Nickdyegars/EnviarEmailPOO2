/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle.Comparador;

import Modelo.Email;

/**
 *
 * @author Okami
 */
public class ComparadorEmailPorTamanho extends Email implements Comparable<Email>{

    @Override
    public int compareTo(Email e) {
        if(this.getTamanho() < e.getTamanho()){
            return -1;
        }
        if(this.getTamanho() > e.getTamanho()){
            return 1;
        }
        return 0;
    }
    
}
